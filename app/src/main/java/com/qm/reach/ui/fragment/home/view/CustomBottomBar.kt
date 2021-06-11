package com.qm.reach.ui.fragment.home.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.qm.reach.R
import com.qm.reach.databinding.CategoryCellLayoutBinding
import com.qm.reach.databinding.CustomBottomBarBinding

class CustomBottomBar(
  context: Context,
  attrs: AttributeSet?,
) : LinearLayout(context, attrs), CustomViewBinding {
  constructor(context: Context) : this(context, null)

  var binding: CustomBottomBarBinding = DataBindingUtil.inflate(
    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
    R.layout.custom_bottom_bar, this, true
  )

  init {
    // MARK:- setUp adapters
    layoutParams = LayoutParams(
      android.view.ViewGroup.LayoutParams.MATCH_PARENT,
      android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    )
    orientation = VERTICAL
  }

  override fun getBinding(): ViewDataBinding {
    return binding
  }
}

enum class BottomBarNavigation {
  Search,
  Other,
  Profile
}
