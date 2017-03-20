package com.example.zhou.daggertest.util

import android.content.Context
import android.widget.ImageView
import com.example.zhou.daggertest.data.entity.TopStory
import com.squareup.picasso.Picasso
import com.youth.banner.loader.ImageLoader

/**
 * Created by zhou on 2017/3/19.
 */

class PicassoImageLoader : ImageLoader(){
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        var story = path as TopStory
        Picasso.with(context).load(story.image).into(imageView)
    }

}