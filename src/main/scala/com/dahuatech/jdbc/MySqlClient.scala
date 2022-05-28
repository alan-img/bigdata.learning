package com.dahuatech.jdbc

import java.sql.{Connection, PreparedStatement, ResultSet}
import com.dahuatech.utils.MySqlUtils
import org.apache.commons.dbutils.handlers.BeanHandler
import org.apache.commons.dbutils.{DbUtils, QueryRunner}

import javax.sql.DataSource

object MySqlClient {
  def main(args: Array[String]): Unit = {

    val dataSource: DataSource = MySqlUtils.getDataSource
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
