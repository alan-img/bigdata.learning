package com.dahuatech.utils

import com.alibaba.druid.pool.DruidDataSourceFactory

import java.io.InputStream
import java.sql.{Connection, DriverManager}
import java.util.Properties
import javax.sql.DataSource

/**
 * @author qinjiawei
 * @todo
 */
object JDBCUtils {

  // load jdbc config file
  val is: InputStream = getClass.getClassLoader.getResourceAsStream("jdbc.properties")
  val prop = new Properties()

  // load config file content to prop
  prop.load(is)

  // parse config param
  val username: String = prop.getProperty("username")
  val password: String = prop.getProperty("password")
  val url: String = prop.getProperty("url")
  val driverClassName: String = prop.getProperty("driverClassName")

  // instance register driver class
  Class.forName(driverClassName)

  /**
   * obtain database connection
   * @return to
   */
  def getConnection: Connection = {
    val conn: Connection = DriverManager.getConnection(url, username, password)
    conn
  }

  /**
   * obtain druid database connection pool
   */
  def getDataSource: DataSource = {
    val dataSource: DataSource = DruidDataSourceFactory.createDataSource(prop)
    dataSource
  }

}
