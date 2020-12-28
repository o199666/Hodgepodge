package com.cwj.common.base

import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.afollestad.materialdialogs.MaterialDialog
import com.alibaba.android.arouter.launcher.ARouter
import com.byl.mvvm.api.error.ErrorResult
import com.cwj.common.base.BaseApplication.Companion.mContext
import com.cwj.common.event.EventBusUtils
import com.cwj.common.event.EventCode
import com.cwj.common.event.EventMessage
import com.cwj.common.utils.ActivityUtils
import com.cwj.common.utils.ToastUtil
import org.greenrobot.eventbus.Subscribe

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/30
 *  desc   : 基类
 */
abstract class BaseActivity<VD : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    lateinit var bd: VD
    lateinit var vm: VM
    private var dialog: MaterialDialog? = null

    /**
     * 设置每个页面的布局ID
     */
    abstract val layoutId: Int
    abstract val viewModel: BaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        //添加Activity管理
//        ActivityUtils.addActivity(this)

        //注册EvenBus
        EventBusUtils.register(this)
        /**
         * 加载布局
         */
        bd = DataBindingUtil.setContentView(this, layoutId)
        bd.lifecycleOwner = this
        regVm(viewModel)
        initView()
    }

    /**
     * 注册 ViewModel
     *
     */
    fun regVm(T: BaseViewModel) {
        if (viewModel == null) {
        } else {
            vm = ViewModelProvider(this).get(viewModel::class.java) as VM
            lifecycle.addObserver(vm)
        }
    }


    fun initView() {
        //错误信息
        vm.errorData.observe(this, Observer {
            if (it.show) ToastUtil.showToast(mContext, it.errMsg)
            errorResult(it)
        })
//        vm.isShowLoading.observe(this, Observer {
//            if (it) showLoading() else dismissLoading()
//        })
    }



    /**
     * 接口请求错误回调
     */
    open fun errorResult(errorResult: ErrorResult) {}

    /**
     * 防止系统字体影响到app的字体
     *
     * @return
     */
    open fun initResources(): Resources? {
        val res: Resources = super.getResources()
        val config = Configuration()
        config.setToDefaults()
        res.updateConfiguration(config, res.displayMetrics)
        return res
    }

    /**
     *  统一状态栏
     */
    fun initAppBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }
    }

//    private var loadingDialog: ProgressDialog? = null

//    private fun showLoading() {
//        if (loadingDialog == null) {
//            loadingDialog = ProgressDialog(getContext())
//        }
//        loadingDialog!!.show()
//    }
//
//    private fun dismissLoding() {
//        loadingDialog?.dismiss()
//        loadingDialog = null
//    }


    /**
     * 注册ViewModel
     */


    //不传参
    fun startARouter(uri: String) {
        ARouter.getInstance().build(uri).navigation();
    }

    //事件传递
    @Subscribe
    fun onEventMainThread(msg: EventMessage) {
        handleEvent(msg)
    }

    // 其他页面调用这个接收Event
    open fun handleEvent(msg: EventMessage) {
        if (msg.code == EventCode.LOGIN_OUT) {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBusUtils.register(this)
        ActivityUtils.removeActivity(this)
    }


}

 