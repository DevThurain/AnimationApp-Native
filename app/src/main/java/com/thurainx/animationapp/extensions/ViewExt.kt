package com.thurainx.animationapp.extensions

import android.view.View

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun View.isShownOnScreen() = visibility == View.VISIBLE

fun View.toggleVisibility(){
    if(isShownOnScreen()) hide()
    else show()
}