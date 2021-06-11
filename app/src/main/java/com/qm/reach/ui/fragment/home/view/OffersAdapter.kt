package com.qm.reach.ui.fragment.home.view

import android.view.ViewGroup
import com.qm.reach.R
import com.qm.reach.base.view.BaseAdapter
import com.qm.reach.base.view.BaseViewHolder
import com.qm.reach.ui.fragment.home.HomeItem
import com.qm.reach.ui.fragment.home.model.CategoryUIItem
import com.qm.reach.ui.fragment.home.model.OfferUIItem
import com.qm.reach.ui.fragment.home.model.SupCategoriesUIItem

class OffersAdapter(itemClick: (OfferUIItem) -> Unit) : BaseAdapter<OfferUIItem>(itemClick) {

  override fun layoutRes(): Int = R.layout.offer_list_item
  override fun onViewHolderCreated(viewHolder: BaseViewHolder<OfferUIItem>) {
  }
}

