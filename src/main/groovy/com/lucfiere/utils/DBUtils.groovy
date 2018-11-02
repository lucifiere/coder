package com.lucfiere.utils

/**
 * Created by XD.Wang on 2018/2/7.
 * Func: tools for ddl
 */
final class DBUtils {

    private static Properties MYSQL_CONFIG

    static {
        reloadConfig()
    }

    private static void reloadConfig() {
        MYSQL_CONFIG = PropUtils.readDBProp(true)
    }

    static String getMysqlPassword(boolean reload = false) {
        if (reload) reloadConfig()
        MYSQL_CONFIG.getProperty("mysql.password")
    }

    static String getMysqlName(boolean reload = false) {
        if (reload) reloadConfig()
        MYSQL_CONFIG.getProperty("mysql.name")
    }

    static String getMysqlUrl(boolean reload = false) {
        if (reload) reloadConfig()
        MYSQL_CONFIG.getProperty("mysql.url")
    }

    static String getDriver(boolean reload = false) {
        if (reload) reloadConfig()
        MYSQL_CONFIG.getProperty("driver")
    }

}
