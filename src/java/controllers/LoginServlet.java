package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Validates login credentials against the init-params in web.xml.
 * Success -> success.jsp ; Failure -> error.jsp (request attribute "errorMessage").
 */
public class LoginServlet extends HttpServlet {

    private String validUsername;
    private String validPassword;

    @Override
    public void init() throws ServletException {
        validUsername = getInitParameter("username");
        validPassword = getInitParameter("password");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean userEmpty = (username == null || username.trim().length() == 0);
        boolean passEmpty = (password == null || password.trim().length() == 0);

        // 1. both empty -> "Username and password are required."
        if (userEmpty && passEmpty) {
            request.setAttribute("errorMessage", "Username and password are required.");
            forward(request, response, "/error.jsp");
            return;
        }

        // 2. username empty -> "Username is required."
        if (userEmpty) {
            request.setAttribute("errorMessage", "Username is required.");
            forward(request, response, "/error.jsp");
            return;
        }

        // 3. password empty -> "Password is required."
        if (passEmpty) {
            request.setAttribute("errorMessage", "Password is required.");
            forward(request, response, "/error.jsp");
            return;
        }

        // 4. username != validUsername -> "Incorrect username."
        if (!username.equals(validUsername)) {
            request.setAttribute("errorMessage", "Incorrect username.");
            forward(request, response, "/error.jsp");
            return;
        }

        // 5. password != validPassword -> "Incorrect password."
        if (!password.equals(validPassword)) {
            request.setAttribute("errorMessage", "Incorrect password.");
            forward(request, response, "/error.jsp");
            return;
        }

        // If all pass: set session or attribute if needed and forward to success.jsp
        request.setAttribute("username", username);
        forward(request, response, "/success.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }
}