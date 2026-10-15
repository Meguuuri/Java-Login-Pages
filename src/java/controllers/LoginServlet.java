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

        // TODO: check in this order, set request attribute "errorMessage", forward to error.jsp:
        //   1. both empty        -> "Username and password are required."
        //   2. username empty    -> "Username is required."
        //   3. password empty    -> "Password is required."
        //   4. username != validUsername -> "Incorrect username."
        //   5. password != validPassword -> "Incorrect password."
        // If all pass: forward to success.jsp

        forward(request, response, "/success.jsp"); // TODO: remove this placeholder
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
