package Global;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by golans on 5/19/2014.
 * Store project Global Vars
 */
public class GlobalVars {
    public static boolean IsOnLocal=true;
    public static String MongoUrl="localhost";

    public static String getCurrentTimeString()
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }
}
