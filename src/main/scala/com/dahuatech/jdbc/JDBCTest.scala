package com.dahuatech.jdbc

import java.sql.Connection
import com.dahuatech.utils.JDBCUtils

import javax.sql.DataSource

object JDBCTest {
  def main(args: Array[String]): Unit = {

    val dataSource: DataSource = JDBCUtils.getDataSource
    val conn: Connection = dataSource.getConnection

    println(conn)

  }
}
