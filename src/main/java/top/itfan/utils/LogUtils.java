package top.itfan.utils;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;


/**
 * Created by ralap on 2017/8/15.
 */
public class LogUtils {

    public static void longInfo(Logger logger, String info) {
        logger.info("=============================================================");
        logger.info(info);
        logger.info("=============================================================");
    }

}
