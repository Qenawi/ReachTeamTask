package com.qm.reach.base.view

import android.os.Bundle
import androidx.databinding.ObservableBoolean
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.qm.reach.BR
import com.qm.reach.util.bindView
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by Qenawi on 7/17/2020.
 **/

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : DaggerAppCompatActivity() {

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

  val showProgress = ObservableBoolean()
  protected abstract val mViewModel: VM
  lateinit var binding: B

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = bindView()
    binding.setVariable(BR.viewModel, mViewModel)
  }

  //MARK:- dispatch injector
  override fun supportFragmentInjector() = dispatchingAndroidInjector
}
