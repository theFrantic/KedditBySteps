package com.whilchy.kedditbysteps.features.news

/**
 * Created by daniel on 22/05/17.
 */

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.whilchy.kedditbysteps.R
import com.whilchy.kedditbysteps.commons.RxBaseFragment
import com.whilchy.kedditbysteps.commons.extensions.inflate
import com.whilchy.kedditbysteps.features.news.adapter.NewsAdapter

import kotlinx.android.synthetic.main.news_fragment.*
import rx.schedulers.Schedulers

class NewsFragment : RxBaseFragment() {

    private val newsManager by lazy { NewsManager() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newList.setHasFixedSize(true)
        newList.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
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

    private fun requestNews() {
        val subscription = newsManager.getNews()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        {
                            retrievedNews -> (news_list.adapter as NewsAdapter).addNews(retrievedNews)
                        },
                        {
                            e -> Snackbar.make(news_list, e.message ?: "Something's gone wrong!", Snackbar.LENGTH_LONG).show()
                        }
                )
        subscriptions.add(subscription)
    }

    //endregion

}
