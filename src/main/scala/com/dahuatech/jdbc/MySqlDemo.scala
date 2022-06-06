package com.dahuatech.jdbc

import com.alibaba.druid.util.lang.Consumer

import java.sql.{Connection, PreparedStatement, ResultSet}
import com.dahuatech.utils.MySqlUtils
import org.apache.commons.dbutils.handlers.{BeanHandler, BeanListHandler}
import org.apache.commons.dbutils.{DbUtils, QueryRunner}

import java.util
import javax.sql.DataSource

object MySqlDemo {
  def main(args: Array[String]): Unit = {

    val dataSource: DataSource = MySqlUtils.getDataSource
    val conn: Connection = dataSource.getConnection

    // 方式一；使用原生jdbc
//    val ps: PreparedStatement = conn.prepareStatement("select * from t_admin")
//    val resultSet: ResultSet = ps.executeQuery()
//    while (resultSet.next()) {
//      val username: String = resultSet.getString(4)
//      val password: String = resultSet.getString(3)
//      val email: String = resultSet.getString(5)
//
//      println(s"username = ${username}, password = ${password}, emila = ${email}")
//    }

    // 方式二：使用common-dbutils（推荐）
    val queryRunner: QueryRunner = new QueryRunner()
    val list: util.List[Person] = queryRunner.query(conn, "select * from stu", new BeanListHandler(classOf[Person]))
    val iter: util.Iterator[Person] = list.iterator()
    while (iter.hasNext) {
      println(iter.next())
    }

  }
}

