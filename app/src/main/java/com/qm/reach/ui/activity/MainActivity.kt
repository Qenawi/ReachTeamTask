package com.qm.reach.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.qm.reach.R
import com.qm.reach.base.view.BaseActivity
import com.qm.reach.databinding.ActivityMainBinding
import timber.log.Timber

//MARK:- MainActivity @Docs
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
  NavController.OnDestinationChangedListener {

  override val mViewModel: MainViewModel by viewModels()
  private var navController: NavController? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setupNavController()
  }

  private fun setupNavController() {
    val navHostFragment =
      supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
    navController = navHostFragment.navController
    navController?.addOnDestinationChangedListener(this)
  }

  fun changeTitle(title: String?) {
    title?.let {
      mViewModel.obsTitle.set(title)
    } ?: Timber.e("title is null")
  }

  override fun onDestinationChanged(
    controller: NavController,
    destination: NavDestination,
    arguments: Bundle?
  ) {
    changeTitle(destination.label?.toString())
  }
}
