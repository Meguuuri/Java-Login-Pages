package listeners;

import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Runs once when the web app starts. Stores the startup Date plus the
 * common header/footer text in the ServletContext (application scope).
 *
 * Attributes created (use in JSP as ${applicationScope.xxx}):
 *   appDate, headerText, footerText
 */
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        // Startup date/time (does not auto-update, per the MP spec)
        ctx.setAttribute("appDate", new Date());

        // Header: SUBJECT / SECTION / LASTNAME1 - LASTNAME2
        String header = ctx.getInitParameter("headerSubject") + " / "
                + ctx.getInitParameter("headerSection") + " / "
                + ctx.getInitParameter("headerNames");
        ctx.setAttribute("headerText", header);

        // Footer identifier
        ctx.setAttribute("footerText", ctx.getInitParameter("footerMP"));
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        ctx.removeAttribute("appDate");
        ctx.removeAttribute("headerText");
        ctx.removeAttribute("footerText");
    }
}
