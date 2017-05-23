package com.whilchy.kedditbysteps.commons

/**
 * Created by daniel on 23/05/17.
 */
data class RedditNewsItem (
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
)