package com.whilchy.kedditbysteps.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by daniel on 22/05/17.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}