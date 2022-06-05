package com.dahuatech.scala
import scala.collection.immutable
import scala.util.control.Breaks

object Demo {
  def main(args: Array[String]): Unit = {
    def a(s: String) = {
      println(s)
    }

    println(a _)
    a("alan")

    val b = a _
    println(b)
    b("jack")

    val f = (s: String) => println(s)
    println(f)
    f("asdfa")

    def aa(a: Int)(b: Int) = {
      a + b
    }

    println(aa(10)(20))
  }
}
