package com.whilchy.kedditbysteps.commons

import com.whilchy.kedditbysteps.commons.adapter.AdapterConstants
import com.whilchy.kedditbysteps.commons.adapter.ViewType

/**
 * Created by daniel on 23/05/17.
 */
data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>
)

data class RedditNewsItem (
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}