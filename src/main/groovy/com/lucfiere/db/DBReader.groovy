package com.lucfiere.db

import com.lucfiere.utils.DBUtils

import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.DriverManager

/**
 * Created by XD.Wang on 2018/2/7.
 * Func: the base class for connecting database and reading data from it
 */
abstract class DBReader {

    private static Connection connection = null

    public static Connection getConection() {
        Class.forName(DBUtils.getDriver())
        connection = (Connection) DriverManager.getConnection(DBUtils.getMysqlUrl(), DBUtils.getMysqlName(), DBUtils.getMysqlUrl())
    }

    public static getAllTable(){
        DatabaseMetaData meta = connection.getMetaData()
        meta.getTables()
    }


}
