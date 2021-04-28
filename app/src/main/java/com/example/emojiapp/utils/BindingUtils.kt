package com.example.emojiapp.utils

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImageUrl")
fun bindImageUrl(view: ImageView, url: String?){
    if(!url.isNullOrBlank())
        Glide.with(view.context).asBitmap().load(Uri.parse(url)).fitCenter().into(view)
}