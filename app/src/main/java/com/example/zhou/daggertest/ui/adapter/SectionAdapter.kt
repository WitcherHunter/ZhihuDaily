package com.example.zhou.daggertest.ui.adapter

import android.view.View
import android.widget.ImageView

import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.zhou.daggertest.R
import com.example.zhou.daggertest.data.entity.NewStory
import com.squareup.picasso.Picasso

/**
 * Created by zhou on 2017/3/17.
 */

class SectionAdapter(layoutResId: Int, sectionHeadResId: Int, data: List<NewStory>) :
        BaseSectionQuickAdapter<NewStory, BaseViewHolder>(layoutResId, sectionHeadResId, data) {

    override fun convertHead(helper: BaseViewHolder, item: NewStory) {
        helper.setText(R.id.tvDate, item.header)
    }

    override fun convert(helper: BaseViewHolder, item: NewStory) {
        helper.setText(R.id.tvTitle, item.t.title)
        Picasso.with(mContext)
                .load(item.t.images!![0])
                .into(helper.getView<View>(R.id.ivPic) as ImageView)
    }
}
