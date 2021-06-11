package com.qm.reach.ui.fragment.home.router

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import com.qm.reach.ui.fragment.home.view.HomeFragment

//MARK:-
object HomeRouter {
  //MARK:- url Open url
  fun openUrl(
    st: String?,
    fragment: HomeFragment
  ) {
    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse(st)
    fragment.startActivity(i)
  }

  //MARK:- url open dialer
  fun callPhone(
    st: String?,
    fragment: HomeFragment
  ) {
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse("tel:${st}")
    fragment.startActivity(intent)
  }
}