package com.example.zhou.daggertest.ui.fragment

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.zhou.daggertest.AppComponent
import com.example.zhou.daggertest.R
import com.example.zhou.daggertest.data.entity.TopStory
import com.example.zhou.daggertest.data.module.main.FirstFragmentModule
import com.example.zhou.daggertest.ui.base.BaseFragment
import com.example.zhou.daggertest.ui.contract.FirstContract
import com.example.zhou.daggertest.ui.presenter.FirstPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import org.jetbrains.anko.find
import javax.inject.Inject

/**
 * Created by zhou on 2017/3/15.
 *
 * 主页fragment
 */

class LatestNewsFragment : BaseFragment(), FirstContract.View{
    override fun startBanner(data: ArrayList<TopStory>) {
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
//        banner.setImages(data).setImageLoader(PicassoImageLoader()).start()
    }

    private object Holder {
        val Instance = LatestNewsFragment()
    }

    companion object {
        val INSTANCE: LatestNewsFragment by lazy { Holder.Instance }
    }

    override val layoutResource: Int = R.layout.fragment_first

    @Inject
    lateinit var presenter: FirstPresenter

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(FirstFragmentModule(this))
                .inject(this)
    }

    override fun start() {
        showTitle("LatestNewsFragment")

        swipeRefreshLsyout.setOnRefreshListener { presenter.loadNews() }

        recyclerView.layoutManager = LinearLayoutManager(activity)

        presenter.setAdapter(recyclerView)

        presenter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter.unSubscribe()
    }

    override fun showTitle(title: String) {
        activity.toolbar.title = title
    }

    override fun showNews() {

    }

    override fun showComplete() {
        swipeRefreshLsyout.isRefreshing = false
    }

    override fun showError(t: Throwable) {

    }

    inner class ImageViewHolder : com.bigkoo.convenientbanner.holder.Holder<TopStory>{
        lateinit var imageView : ImageView
        lateinit var title : TextView

        override fun UpdateUI(context: Context?, position: Int, data: TopStory?) {
            Picasso.with(context).load(data?.image).into(imageView)
            title.text = data?.title
        }

        override fun createView(context: Context?): View {
            var view = LayoutInflater.from(context).inflate(R.layout.item_banner,null,false)
            imageView = view.find(R.id.imageView)
            title = view.find(R.id.title)
            return view
        }

    }
}