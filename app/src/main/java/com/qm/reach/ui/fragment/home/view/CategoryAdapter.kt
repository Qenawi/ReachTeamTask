package com.qm.reach.ui.fragment.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.qm.reach.R
import com.qm.reach.base.view.BaseAdapter
import com.qm.reach.base.view.BaseViewHolder
import com.qm.reach.ui.fragment.home.model.SupCategoriesUIItem

//MARK:- CategoryAdapter @Docs
class CategoryAdapter(itemClick: (SupCategoriesUIItem) -> Unit) : BaseAdapter<SupCategoriesUIItem>(
  itemClick
) {
  private val lastITem = 1
  private val notLastItem = 2
  override fun layoutRes(): Int = R.layout.category_list_item
  override fun onViewHolderCreated(viewHolder: BaseViewHolder<SupCategoriesUIItem>) {}


  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): BaseViewHolder<SupCategoriesUIItem> {
    return if (viewType == notLastItem)
     super.onCreateViewHolder(parent, viewType)
     else{
      val binding2 = DataBindingUtil.inflate<ViewDataBinding>(
        LayoutInflater.from(parent.context),
        R.layout.category_list_item_more,
        parent,
        false
      )
      return BaseViewHolder<SupCategoriesUIItem>(binding2).apply {}
     }
  }

  //MARK:- getItemType
  override fun getItemViewType(position: Int): Int
  {
    return if (mCurrentList[position]?.id == -1) lastITem else notLastItem
  }
}
