package com.qm.reach.ui.fragment.home.view

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.qm.reach.base.view.BaseFragment
import com.qm.reach.databinding.FragmentHomeBinding
import com.qm.reach.di.Injectable
import com.qm.reach.ui.fragment.home.protocols.HomeViewProtocol
import com.qm.reach.ui.fragment.home.router.HomeRouter
import com.qm.reach.ui.fragment.home.viewmodel.HomeViewModel
import com.qm.reach.util.observe
import javax.inject.Inject

//MARK:- Home Fragment @Docs
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(),
  Injectable,
  CustomSearchViewDelegate, HomeViewProtocol {
  override fun pageTitle(): String = ""

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  override val mViewModel: HomeViewModel by viewModels { viewModelFactory }
  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    //MARK:- basic error handling
    observe(mViewModel.errorMessage) { e ->
      e?.let { eNonNull ->
        Toast.makeText(context, eNonNull, Toast.LENGTH_SHORT).show()
        mViewModel.errorMessage.postValue(null)
      }
    }
    //MARK:- setup binding
    binding.tilSearch.callBack = this
    mViewModel.view = this
  }

  //MARK:- onSearch View Selection
  override fun onSearcSelection() {
    mViewModel.filter()
  }

  //MARK:- match text using pattern REGX util
  override fun handleOfferOnclick(str: String) {

    if (Patterns.PHONE.matcher(str).find()) HomeRouter.callPhone(str, this)
    else if (Patterns.WEB_URL.matcher(str).find()) HomeRouter.openUrl(str, this)
  }
}