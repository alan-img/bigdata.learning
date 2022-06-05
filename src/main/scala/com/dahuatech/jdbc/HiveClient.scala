package com.dahuatech.jdbc

import com.dahuatech.utils.HiveUtils
import org.apache.commons.dbutils.QueryRunner
import org.apache.commons.dbutils.handlers.BeanListHandler

import java.sql.{Connection, PreparedStatement, ResultSet}
import java.util
import javax.sql.DataSource

object HiveClient {
  def main(args: Array[String]): Unit = {

    val dataSource: DataSource = HiveUtils.getDataSource
    val conn: Connection = dataSource.getConnection
    val ps: PreparedStatement = conn.prepareStatement("select * from stu")
    val resultSet: ResultSet = ps.executeQuery()
    while (resultSet.next()) {
      val name: String = resultSet.getString(1)
      val age: String = resultSet.getString(2)

      println(s"name = ${name}, age = ${age}")
    }

  }
}
