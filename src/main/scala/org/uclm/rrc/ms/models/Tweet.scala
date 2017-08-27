package org.uclm.rrc.ms.models

case class User(id: Option[Int], id_str: Option[String], name: Option[String], verified: Option[Boolean], followers_count: Option[Long],
                friends_count: Option[Long], favourites_count: Option[Long], created_at: Option[String],
                lang: Option[String])

case class Coordinate(coordinates: Array[Double], `type`: String)

case class Tweet (created_at: Option[String], id: Option[Int], id_str: Option[String], text: Option[String],
                  source: Option[String], truncated: Option[Boolean],
                  retweet_count: Option[Long], favorite_count: Option[Long], lang: Option[String],
                  timestamp_ms: Option[String], user: Option[User], coordinates: Option[Coordinate])



case class Hashtag(hasthags: Array[String])