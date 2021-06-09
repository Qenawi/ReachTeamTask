package com.qm.reach.ui.fragment.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.qm.reach.base.network.Status.*
import com.qm.reach.base.view.BaseFragment
import com.qm.reach.databinding.FragmentHomeBinding
import com.qm.reach.di.Injectable
import com.qm.reach.ui.fragment.home.viewmodel.HomeViewModel
import com.qm.reach.util.observe
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), Injectable {
    override fun pageTitle(): String = ""

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val mViewModel: HomeViewModel by viewModels {
        viewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.apply {
            observe(mutableLiveData) {
                when (it) {
                }
            }
            observe(observeUsers()) {
                when (it?.status) {
                    SUCCESS -> {
                        showProgress(false)
                        loadDataOnAdapter(it.data?.results)
                    }
                    MESSAGE -> {
                        showProgress(false)
                        //activity?.showErrorDialog(it.message)
                    }
                    LOADING -> {
                        showProgress()
                    }
                }
            }
        }
    }

}