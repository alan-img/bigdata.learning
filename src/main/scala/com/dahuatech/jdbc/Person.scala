package com.dahuatech.jdbc

import scala.beans.BeanProperty

class Person {
  @BeanProperty
  var name: String = _
  @BeanProperty
  var age: Int = _

  def this(name: String, age: Int) {
    this
    this.name = name
    this.age = age
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Person]

  override def equals(other: Any): Boolean = other match {
    case that: Person =>
      (that canEqual this) &&
        name == that.name &&
        age == that.age
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, age)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"Person($name, $age)"
}