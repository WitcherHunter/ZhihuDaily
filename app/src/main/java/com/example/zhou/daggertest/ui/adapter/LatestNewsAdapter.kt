package com.example.zhou.daggertest.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.zhou.daggertest.R
import com.example.zhou.daggertest.data.entity.Story
import com.squareup.picasso.Picasso

/**
 * Created by zhou on 2017/3/17.
 */

class LatestNewsAdapter(data: List<Story>) : BaseQuickAdapter<Story, BaseViewHolder>(R.layout.item_latest_news, data) {

    override fun convert(helper: BaseViewHolder, item: Story) {
        helper.setText(R.id.tvTitle,item.title)
        Picasso.with(mContext)?.load(item.images?.get(0))?.into(helper.getView<ImageView>(R.id.ivPic))
    }
}
