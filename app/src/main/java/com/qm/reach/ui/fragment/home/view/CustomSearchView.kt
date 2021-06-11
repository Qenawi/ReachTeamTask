package com.qm.reach.ui.fragment.home.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.qm.reach.R
import com.qm.reach.databinding.SearchViewBinding

//MARK:- CustomSearch Delegate
interface CustomSearchViewDelegate
{
  //MARK:- onSearch Button Select
  fun onSearcSelection()
}

//MARK:- Custom Search View
class CustomSearchView(
  context: Context,
  attrs: AttributeSet?,
) : LinearLayout(context, attrs), CustomViewBinding {

  var binding: SearchViewBinding = DataBindingUtil.inflate(
    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
    R.layout.search_view, this, true
  )
  var callBack: CustomSearchViewDelegate? = null

  init {
    // MARK:- setUp adapters
    layoutParams = LayoutParams(
      android.view.ViewGroup.LayoutParams.MATCH_PARENT,
      android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    )
    orientation = HORIZONTAL
    //MARK:- handle action
    handleOnImAction()
  }

  override fun getBinding(): ViewDataBinding {
    return binding
  }

  private fun handleOnImAction() {
    binding.lSearch.setOnEditorActionListener { v, actionId, event ->
      var emit = false
      if (actionId == EditorInfo.IME_ACTION_SEARCH) {
        closeKeyboard(this)
        callBack?.onSearcSelection()
        emit = true
      }
      return@setOnEditorActionListener !emit
    }
  }
}

//MARK:- close keyboard after search is selection
private fun closeKeyboard(ctx: View) {
  val imm: InputMethodManager? =
    ctx.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
  imm?.hideSoftInputFromWindow(ctx.windowToken, 0)
}

