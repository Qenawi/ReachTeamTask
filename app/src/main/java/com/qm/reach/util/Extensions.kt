package com.qm.reach.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.AnimRes
import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.qm.reach.BR
import com.qm.reach.R
import com.qm.reach.app.BaseApplication
import com.qm.reach.base.network.IsRepo
import com.qm.reach.base.view.BaseFragment
import com.qm.reach.ui.activity.MainActivity
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import java.io.File
import java.lang.reflect.ParameterizedType


private val imageHeight = 300
private val imageWidth = 300


fun Activity.showActivity(
    destActivity: Class<out AppCompatActivity>,
    intent: Intent = Intent(this, destActivity)
) {
    this.startActivity(intent)
}

fun AppCompatActivity.findFragmentById(id: Int): Fragment? {
    supportFragmentManager.let {
        return it.findFragmentById(id)
    }
}


fun <T> IsRepo.requestNetworkCall(
    callMethod: Flowable<Resource<T>>,
): MediatorLiveData<Resource.Success<T>> {
    val mutLiveData = MediatorLiveData<Resource.Success<T>>()
    val source = LiveDataReactiveStreams.fromPublisher(
        callMethod.subscribeOn(Schedulers.io())
            .onErrorReturn { ex ->
                Timber.e("$ex")
                Resource.Error(ex.message)
            }
    )
    mutLiveData.addSource(source) {
        mutLiveData.value = Resource.Success(it.data, it.message)
        mutLiveData.removeSource(source)
    }
    return mutLiveData
}


fun Activity.restartApp() {
    showActivity(MainActivity::class.java)
    finishAffinity()
}






fun Context.getColorFromRes(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(this, colorRes)
}




fun <T : AndroidViewModel> T.app() = this.getApplication<BaseApplication>()
fun String.uri(): Uri? {
    return try {
        Uri.fromFile(File(this))
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

fun Activity?.dialContactPhone(phoneNumber: String) = this?.run {
    startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)))
}


fun validateData(size: Int?, progress: Boolean?): Boolean? {
    return if (progress == false)
        (size ?: 0 > 0)
    else false
}

fun validateHolder(size: Int?, progress: Boolean?): Boolean? {
    return if (progress == false)
        (size ?: 0 == 0)
    else false
}


fun String.isValidUrl(): Boolean {
    return try {
        URLUtil.isValidUrl(this) && Patterns.WEB_URL.matcher(this).matches()
    } catch (e: Exception) {
        Timber.e(e)
        false
    }
}


fun ImageView.loadImageFromURL(url: String, progressBar: ProgressBar? = null) {
    val requestOptions = RequestOptions()
        .centerCrop()
        .override(imageWidth , imageHeight)
    progressBar?.visible()
    Glide.with(this).asBitmap()
        .load(url)
        .apply(requestOptions)
        .error(R.drawable.ic_broken_image)
        .addListener(object : RequestListener<Bitmap> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Bitmap>?,
                isFirstResource: Boolean
            ): Boolean {
                Timber.e("$e url: $url")
                setImageResource(R.drawable.ic_broken_image)
                progressBar?.gone()
                return true
            }

            override fun onResourceReady(
                resource: Bitmap?,
                model: Any?,
                target: Target<Bitmap>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                setImageBitmap(resource)
                progressBar?.gone()
                return true
            }

        })
        .into(object : BitmapImageViewTarget(this) {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                super.onResourceReady(resource, transition)
                progressBar?.gone()
            }
        })
}


inline fun <reified T : BaseFragment<*, *>> FragmentActivity.replaceFragment(
    bundle: Bundle? = null
) {
    val fragment = T::class.java.newInstance()
    fragment.let { myFrag ->
        supportFragmentManager.commit {
            if (!AppUtil.isOldDevice())
                setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            myFrag.arguments = bundle
            replace(R.id.fragment_container_view, myFrag, myFrag.tag)
            addToBackStack(myFrag::class.java.name)
        }
    }
}


fun String.removeSpaces(): String = this.replace(" ", "").trim()

fun CharSequence.removeSpaces(): CharSequence = this.toString().replace(" ", "").trim()

fun Fragment.showKeyboard(show: Boolean) {
    view?.let { activity?.showKeyboard(it, show) }
}

fun Activity.showKeyboard(show: Boolean) {
    showKeyboard(currentFocus ?: View(this), show)
}

fun Context.showKeyboard(view: View, show: Boolean) {
    with(view) {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (show)
            inputMethodManager.toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY
            )
        else
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }
}


fun View.initAnimation(@AnimRes animRes: Int, seconds: Int, onEndCallBack: () -> Unit = {}) {
    val animation = AnimationUtils.loadAnimation(context, animRes)
    animation.duration = seconds.toLong() * 1000
    startAnimation(animation)
    animation.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            onEndCallBack()
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }
    })
}

fun <T : Any> Any.getTClass(): Class<T> {
    return (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
}

inline fun <reified VM : ViewModel> ViewModelStoreOwner.bindViewModel(
    binding: ViewDataBinding,
    factory: ViewModelProvider.Factory? = null, body: VM.() -> Unit
): VM {
    return if (this is Fragment) {
        val vm by lazy {
            ViewModelProvider(
                this,
                factory ?: defaultViewModelProviderFactory
            )[VM::class.java]
        }
        binding.setVariable(BR.viewModel, vm)
        vm.apply(body)
    } else {
        val act = this as AppCompatActivity
        val vm by lazy {
            ViewModelProvider(
                act,
                factory ?: defaultViewModelProviderFactory
            )[VM::class.java]
        }
        binding.setVariable(BR.viewModel, vm)
        vm.apply(body)
    }
}


@Suppress("UNCHECKED_CAST")
fun <B : ViewDataBinding> LifecycleOwner.bindView(container: ViewGroup? = null): B {
    return if (this is Activity) {
        val inflateMethod = getTClass<B>().getMethod("inflate", LayoutInflater::class.java)
        val invokeLayout = inflateMethod.invoke(null, this.layoutInflater) as B
        this.setContentView(invokeLayout.root)
        invokeLayout
    } else {
        val fragment = this as Fragment
        val inflateMethod = getTClass<B>().getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            error("Cannot access view bindings. View lifecycle is ${lifecycle.currentState}!")
        }
        val invoke: B = inflateMethod.invoke(null, layoutInflater, container, false) as B
        invoke
    }
}

fun <T : Any?, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(if (this is Fragment) viewLifecycleOwner else this, Observer {
        if (lifecycle.currentState == Lifecycle.State.RESUMED) {
            body(it)
        }
    })
}

inline fun <reified T : AppCompatActivity> Fragment.castToActivity(
    callback: (T?) -> Unit
): T {
    return if (requireActivity() is T) {
        callback(requireActivity() as T)
        requireActivity() as T
    } else {
        Timber.e("class cast exception, check your fragment is in the correct activity")
        callback(null)
        throw ClassCastException()
    }

}


fun View.visible(){
    visibility = View.VISIBLE
}
fun View.gone(){
    visibility = View.GONE
}
fun View.invisible(){
    visibility = View.INVISIBLE
}


fun LifecycleOwner.navigateSafe(directions: NavDirections, navOptions: NavOptions? = null) {
    val navController: NavController?
    val mView: View?
    if (this is Fragment) {
        navController = findNavController()
        mView = view
    } else {
        val activity = this as Activity
        navController = activity.findNavController(R.id.fragment_container_view)
        mView = currentFocus
    }
    if (canNavigate(navController, mView)) navController.navigate(directions, navOptions)
}

fun LifecycleOwner.navigateSafe(@IdRes navFragmentRes: Int, bundle: Bundle? = null) {
    val navController: NavController?
    val mView: View?
    if (this is Fragment) {
        navController = findNavController()
        mView = view
    } else {
        val activity = this as Activity
        navController = activity.findNavController(R.id.fragment_container_view)
        mView = currentFocus
    }
    if (canNavigate(navController, mView)) navController.navigate(navFragmentRes, bundle)
}

fun canNavigate(controller: NavController, view: View?): Boolean {
    val destinationIdInNavController = controller.currentDestination?.id
    // add tag_navigation_destination_id to your res\values\ids.xml so that it's unique:
    val destinationIdOfThisFragment =
        view?.getTag(R.id.tag_navigation_destination_id) ?: destinationIdInNavController

    // check that the navigation graph is still in 'this' fragment, if not then the app already navigated:
    return if (destinationIdInNavController == destinationIdOfThisFragment) {
        view?.setTag(R.id.tag_navigation_destination_id, destinationIdOfThisFragment)
        true
    } else {
        Timber.e("May not navigate: current destination is not the current fragment.")
        false
    }
}
