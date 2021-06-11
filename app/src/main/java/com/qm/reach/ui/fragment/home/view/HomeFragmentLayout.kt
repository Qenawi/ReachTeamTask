package com.qm.reach.ui.fragment.home.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.qm.reach.BR
import com.qm.reach.R
import com.qm.reach.util.getColorFromRes

//MARK:- Auto Load Cover Photo
@BindingAdapter(value = ["cover_color"], requireAll = false)
fun View.coverColor(st: String?) {
  this.setBackgroundColor(Color.parseColor(st))
}

//MARK:- Auto Load Font Color
@BindingAdapter(value = ["font_color"], requireAll = false)
fun TextView.fontColor(st: String?) {
  this.setTextColor(Color.parseColor(st))
}

//MARK:- custom view extensions
@BindingAdapter(value = ["viewModel"], requireAll = false)
fun View.setCustomViewModel(v: ViewModel) {
  if (this is CustomViewBinding) getBinding().setVariable(BR.viewModel, v)
}

//MARK:- custom view extensions
@BindingAdapter(value = ["bottomType", "bottomSelection"], requireAll = true)
fun View.handleNavigationSelection(
  type: BottomBarNavigation,
  selection: BottomBarNavigation?
) {
  selection?.let { select ->
    //MARK:- selected
    if (select == type)
    {
      if (this is TextView) {
        this.setTextColor(context.getColorFromRes(R.color.colorPrimary))
      } else {
        ImageViewCompat.setImageTintList(
          this as ImageView, ColorStateList.valueOf(context.getColorFromRes(R.color.colorPrimary))
        )
      }
    }
    //MARK:- not selected
    else {
      if (this is TextView) {
        this.setTextColor(context.getColorFromRes(R.color.gray))
      } else {
        ImageViewCompat.setImageTintList(
          this as ImageView, ColorStateList.valueOf(context.getColorFromRes(R.color.gray))
        )
      }
    }
  }
}