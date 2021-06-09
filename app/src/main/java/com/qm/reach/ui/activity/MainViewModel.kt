package com.qm.reach.ui.activity

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.qm.reach.base.viewmodel.AndroidBaseViewModel

//MARK:- todo refactor to inject
class MainViewModel(app: Application) : AndroidBaseViewModel(app) {
  val obsTitle = ObservableField<String>()
}