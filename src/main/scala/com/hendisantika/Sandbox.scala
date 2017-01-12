package com.hendisantika

import com.twitter.finagle.Mysql
import com.twitter.finagle.mysql.{IntValue, StringValue}
import com.twitter.util.{Await, Future}

/**
  * Created by hendisantika on 28/12/16.
  */
object Sandbox {
  def main(args: Array[String]) {

    val client = Mysql.client
      .withCredentials("root", "root")
      .withDatabase("scalaDB")
      .newRichClient("localhost:3306")

    val users: Future[Seq[(Int, String)]] = client.select("select id, name from names") { row =>
      val IntValue(id) = row("id").get
      val StringValue(name) = row("name").get
      (id, name)
    }

    users onSuccess { results: Seq[(Int, String)] =>
      results.foreach { record: (Int, String) =>
        println(record._2)
      }
    }

    Await.ready(users)
  }
}
