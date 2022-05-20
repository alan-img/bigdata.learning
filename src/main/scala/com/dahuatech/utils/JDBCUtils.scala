package com.dahuatech.utils

import java.io.InputStream
import java.sql.{Connection, DriverManager}
import java.util.Properties

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
  val username: String = prop.getProperty("jdbc.username")
  val password: String = prop.getProperty("jdbc.password")
  val url: String = prop.getProperty("jdbc.url")
  Class.forName(driverClassName)

  // instance register driver class
  val driverClassName: String = prop.getProperty("jdbc.driverClassName")

  /**
   * obtain database connection
   * @return to
   */
  def getConnection: Connection = {
    val conn: Connection = DriverManager.getConnection(url, username, password)
    conn
  }

}
