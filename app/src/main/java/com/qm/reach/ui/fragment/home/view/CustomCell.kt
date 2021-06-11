package com.qm.reach.ui.fragment.home.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.qm.reach.R
import com.qm.reach.databinding.CategoryCellLayoutBinding
import com.qm.reach.ui.fragment.home.model.CategoryUIItem

//MARK:- CustomCell @Docs
class CustomCell(
  context: Context,
  attrs: AttributeSet?,
) : LinearLayout(context, attrs), CustomViewBinding {
  constructor(context: Context) : this(context, null)

  var binding: CategoryCellLayoutBinding = DataBindingUtil.inflate(
    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
    R.layout.category_cell_layout, this, true
  )
  private val adapter = CategoryAdapter({})

  init {
    // MARK:- setUp adapters
    layoutParams = LayoutParams(
      android.view.ViewGroup.LayoutParams.MATCH_PARENT,
      android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    )
    orientation = VERTICAL
  }

  //MARK:- populate Custom Cell
  fun populate(dataSrc: CategoryUIItem) {
    adapter.setList(dataSrc.arrayList)
    binding.lRecycler.adapter = adapter
    binding.textView2.text = dataSrc?.mainTitle
  }

  override fun getBinding(): ViewDataBinding {
    return binding
  }
}

//MARK:- custom binding
interface CustomViewBinding {
  fun getBinding(): ViewDataBinding
}