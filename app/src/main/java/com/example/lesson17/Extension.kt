package com.example.lesson17

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.glide(url: String){
    Glide.with(this).load(url).into(this as ImageView)
}