import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log {
    private static final Logger log = LogManager.getLogger(Log.class);

    public void info(String text) {
        log.info(text);
    }
}
