package com.qm.reach.ui.fragment.home.view

import com.qm.reach.R
import com.qm.reach.base.view.BaseAdapter
import com.qm.reach.base.view.BaseViewHolder
import com.qm.reach.ui.fragment.home.HomeItem

class HomeAdapter(itemClick: (HomeItem) -> Unit) : BaseAdapter<HomeItem>(itemClick) {

    override fun layoutRes(): Int = R.layout.item_home_view
    override fun onViewHolderCreated(viewHolder: BaseViewHolder<HomeItem>) {

    }
}