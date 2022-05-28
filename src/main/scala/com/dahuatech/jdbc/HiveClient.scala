package com.dahuatech.jdbc

import com.dahuatech.utils.HiveUtils

import java.sql.{Connection, PreparedStatement, ResultSet}
import javax.sql.DataSource

object HiveClient {
  def main(args: Array[String]): Unit = {

    val dataSource: DataSource = HiveUtils.getDataSource
    val conn: Connection = dataSource.getConnection
    val ps: PreparedStatement = conn.prepareStatement("select * from t_admin")
    val resultSet: ResultSet = ps.executeQuery()
    while (resultSet.next()) {
      val username: String = resultSet.getString(4)
      val password: String = resultSet.getString(3)
      val email: String = resultSet.getString(5)

      println(s"username = ${username}, password = ${password}, emila = ${email}")
    }

  }
}
