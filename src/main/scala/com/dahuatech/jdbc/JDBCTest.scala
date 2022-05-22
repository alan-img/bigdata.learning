package com.dahuatech.jdbc

import java.sql.Connection

import com.dahuatech.utils.JDBCUtils

object JDBCTest {
  def main(args: Array[String]): Unit = {

    val conn: Connection = JDBCUtils.getConnection
    println(conn)
    conn.commit()

  }
}
