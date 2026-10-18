package listeners;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
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
    
    private ScheduledExecutorService scheduler;

    public void contextInitialized(ServletContextEvent sce) {
       final ServletContext ctx = sce.getServletContext();

        ctx.setAttribute("appDate", new Date());

        // Header: SUBJECT / SECTION / LASTNAME1 - LASTNAME2
        String header = ctx.getInitParameter("headerSubject") + " / "
                + ctx.getInitParameter("headerSection") + " / "
                + ctx.getInitParameter("headerNames");
        ctx.setAttribute("headerText", header);

  
        ctx.setAttribute("footerText", ctx.getInitParameter("footerMP"));
        
        scheduler = Executors.newSingleThreadScheduledExecutor();
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String currentTime = df.format(new Date());
                ctx.setAttribute("liveClock", currentTime);
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        ctx.removeAttribute("appDate");
        ctx.removeAttribute("headerText");
        ctx.removeAttribute("footerText");
        ctx.removeAttribute("liveClock");
    }
}
