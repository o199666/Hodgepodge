package com.cwj.common.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.byl.mvvm.api.error.ErrorResult
import com.cwj.common.event.EventBusUtils
import com.cwj.common.event.EventMessage
import org.greenrobot.eventbus.Subscribe


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/30
 *  desc   : Fragment 基类
 */
abstract class BaseFragment<VD : ViewDataBinding, VM : BaseViewModel> : Fragment() {
    lateinit var bd: VD
    lateinit var vm: VM
    internal var view: View? = getView()
    private var isViewCreated = false

    /**
     * 设置每个页面的布局ID
     */
    abstract val layoutId: Int
    abstract val viewModel: BaseViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        EventBusUtils.register(this)
        //注册
        if (view == null) {
            bd = DataBindingUtil.inflate(inflater, layoutId, container, false)
            bd!!.lifecycleOwner = this
            bd!!.executePendingBindings()
            val layout = LinearLayout(context) //创建空的动态线性布局对象，传入参数为context

            val button = Button(context) //创建一个空按钮，参数同上
            button.setText("1212")
            layout.addView(button) //添加按钮实例到布局
            bd.root.tag=layout
            view = bd.root

        }


        return view

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

    /**
     * 当 Fragment 页面创建完成，做一些工作。
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(javaClass.name, "onViewCreated")
        isViewCreated = true;
        initVD()
    }

    //需要懒加载的数据，重写此方法
    abstract fun lazyLoadData()


    //事件传递
    @Subscribe
    fun onEventMainThread(msg: EventMessage) {
        handleEvent(msg)
    }

    // 其他页面调用这个接收Event
    open fun handleEvent(msg: EventMessage) {

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBusUtils.register(this)

    }

    /**
     * 接口请求错误回调
     */
    open fun errorResult(errorResult: ErrorResult) {}

    /**
     * 初始化工作
     */
    abstract fun initVD()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(javaClass.name, "onAttach")

    }

    override fun onStop() {
        super.onStop()
        Log.e(javaClass.name, "onStop")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(javaClass.name, "onCreate")
        regVm(viewModel)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(javaClass.name, "onDestroyView")

    }

    override fun onStart() {
        super.onStart()
        Log.e(javaClass.name, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.e(javaClass.name, "onPause")

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e(javaClass.name, "onActivityCreated")

    }

    override fun onDetach() {
        super.onDetach()
        Log.e(javaClass.name, "onDetach")

    }

    override fun onResume() {
        super.onResume()
        Log.e(javaClass.name, "onResume")
        if (isViewCreated) {
            lazyLoadData()
        }
    }


}

 