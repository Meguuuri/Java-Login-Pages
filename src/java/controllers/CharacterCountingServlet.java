package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Counts characters of the submitted string using the character sets
 * declared as init-params in web.xml, then forwards back to success.jsp.
 *
 * Request attributes read by success.jsp:
 *   inputString, stringLength, digitCount, vowelCount, consonantCount, symbolCount
 */
public class CharacterCountingServlet extends HttpServlet {

    private String digits;
    private String vowels;
    private String consonants;

    @Override
    public void init() throws ServletException {
        digits = getInitParameter("digits");
        vowels = getInitParameter("vowels");
        consonants = getInitParameter("consonants");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String input = request.getParameter("inputString");
        if (input == null) {
            input = "";
        }

        int digitCount = 0;
        int vowelCount = 0;
        int consonantCount = 0;
        int symbolCount = 0;

        // TODO: loop through each char of input:
        //   whitespace              -> skip (counts toward length only)
        //   in digits               -> digitCount++
        //   in vowels               -> vowelCount++
        //   in consonants           -> consonantCount++
        //   otherwise               -> symbolCount++
        // Expected for "Hello World 123!": length 16, digits 3, vowels 3, consonants 7, symbols 1

        request.setAttribute("inputString", input);
        request.setAttribute("stringLength", input.length());
        request.setAttribute("digitCount", digitCount);
        request.setAttribute("vowelCount", vowelCount);
        request.setAttribute("consonantCount", consonantCount);
        request.setAttribute("symbolCount", symbolCount);

        RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("success.jsp");
    }
}
