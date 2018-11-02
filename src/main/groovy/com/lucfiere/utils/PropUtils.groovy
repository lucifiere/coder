package com.lucfiere.utils

import com.lucfiere.common.Cons
import org.slf4j.LoggerFactory

/**
 * Created by XD.Wang on 2018/2/7.
 * Func: to read data from properties file
 */
final class PropUtils {

    private static def LOG = LoggerFactory.getLogger(PropUtils.class)

    private static Properties DB_PROP

    static Properties read(String file) {
        def prop = new Properties()
        LOG.debug("""read config from ${file}""")
        DB_PROP = new Properties()
        prop.load(PropUtils.class.getResourceAsStream(file))
        prop
    }

    static Properties readDBProp(boolean refresh) {
        (refresh || DB_PROP == null) ? read(Cons.DB_CONFIG) : DB_PROP
    }

}
