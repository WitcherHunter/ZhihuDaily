package com.example.zhou.daggertest.data.entity.response

import com.example.zhou.daggertest.data.entity.Story
import com.example.zhou.daggertest.data.entity.TopStory

/**
 * Created by zhou on 2017/3/17.
 */

data class LatestNews(val date:Long?,
                      val stories:ArrayList<Story>?,
                      val top_stories:ArrayList<TopStory>?)