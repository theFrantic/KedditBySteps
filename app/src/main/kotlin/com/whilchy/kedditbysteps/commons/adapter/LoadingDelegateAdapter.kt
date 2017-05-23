package com.whilchy.kedditbysteps.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.whilchy.kedditbysteps.R
import com.whilchy.kedditbysteps.commons.extensions.inflate

/**
 * Created by daniel on 23/05/17.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder (
            parent.inflate(R.layout.news_item_loading)) {
    }

}