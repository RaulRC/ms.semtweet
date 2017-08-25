package org.uclm.rrc.ms.models

case class Tweet (created_at: String, id: Long, text: String, source: String, truncated: Boolean,
                  retweet_count: Long, favorite_count: Long, lang: String, timestamp_ms: String)

case class User(id: Long, name: String, verifie: Boolean, followers_count: Long, friend_count: Long,
                favourites_count: Long, created_at: String, lang: String, time_zone: String)

case class Coordinate(longLag: Array[Long])

case class Hashtag(hasthags: Array[String])