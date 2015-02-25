package Global;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.*;

/**
 * Created by golans on 5/26/2014.
 */
public class CLogger {
    private static Logger loggerJob = null;
    static private FileHandler fileTxt;

    static private FileHandler fileHTML;
    static private Formatter formatterHTML;

    static public void setup() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Calendar cal = Calendar.getInstance();
        setup("C:/logs/log_" + dateFormat.format(cal.getTime()));
    }

    static private void setup(String path) {
        loggerJob = Logger.getLogger("logger");

        try {
            // This block configure the logger with handler and formatter
            System.out.println();
            fileTxt = new FileHandler(path + ".txt");
            loggerJob.addHandler(fileTxt);
            SimpleFormatter formatter = new SimpleFormatter();
            fileTxt.setFormatter(formatter);
            fileHTML = new FileHandler(path+ ".html");
            // create an HTML formatter
            formatterHTML = new HtmlFormatter();
            fileHTML.setFormatter(formatterHTML);
            loggerJob.addHandler(fileHTML);
        } catch (SecurityException e) {
            if(!path.equals("logger_")) setup("logger_");
                else e.printStackTrace();
        } catch (IOException e) {
            if(!path.equals("logger_")) setup("logger_");
                 else e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance()
    {
        if (loggerJob == null)
            setup();
        else
        {
            fileTxt.flush();
            fileHTML.flush();
        }
        return loggerJob;
    }

    public static synchronized void closeInstance()
    {
        if (fileTxt != null)
        {
            fileTxt.flush();
            try
            {
                fileTxt.close();
            }
            catch (SecurityException e)
            {
                System.out.println(e.getStackTrace());
            }
            fileTxt = null;
        }
        if (fileHTML != null)
        {
            fileHTML.flush();
            try
            {
                fileHTML.close();
            }
            catch (SecurityException e)
            {
                System.out.println(e.getStackTrace());
            }
            fileHTML = null;
        }
        loggerJob = null;
    }
}
