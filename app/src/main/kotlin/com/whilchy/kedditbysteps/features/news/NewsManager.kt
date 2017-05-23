package com.whilchy.kedditbysteps.features.news

import com.whilchy.kedditbysteps.api.RestAPI
import com.whilchy.kedditbysteps.commons.RedditNews
import com.whilchy.kedditbysteps.commons.RedditNewsItem
import rx.Observable

/**
 * Created by daniel on 23/05/17.
 */
class NewsManager(private val api: RestAPI = RestAPI()) {

    /**
     * Returns Reddit news paginated by the given limit
     *
     * @param after indicates the next page to navigate
     * @param limit the number of news to request
     */
    fun getNews(after: String, limit: String = "10"): Observable<RedditNews>{
        return Observable.create {
            subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val dataResponse = response.body().data
                val news = response.body().data.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news
                )
                subscriber.onNext(redditNews)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}