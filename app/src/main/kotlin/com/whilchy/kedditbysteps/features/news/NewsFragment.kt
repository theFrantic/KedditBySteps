package com.whilchy.kedditbysteps.features.news

/**
 * Created by daniel on 22/05/17.
 */

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.whilchy.kedditbysteps.R
import com.whilchy.kedditbysteps.commons.RedditNewsItem
import com.whilchy.kedditbysteps.commons.extensions.inflate
import com.whilchy.kedditbysteps.features.news.adapter.NewsAdapter

import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newList.setHasFixedSize(true)
        newList.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i,
                        1457207701L - i * 200, // time
                        "http://lorempixel.com/200/200/technics/$i",
                        "url"
                ))
            }
            (news_list.adapter as NewsAdapter).addNews(news)
        }
    }


    //region Private Methods

    private val newList by lazy {
        news_list
    }

    private fun initAdapter() {
        if (newList.adapter == null) {
            newList.adapter = NewsAdapter()
        }
    }

    //endregion

}
