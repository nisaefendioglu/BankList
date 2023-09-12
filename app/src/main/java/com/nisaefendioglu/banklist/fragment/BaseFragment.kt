package com.nisaefendioglu.banklist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {

    private var cachedView: View? = null
    private var viewBinding: VB? = null
    private lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (cachedView == null) {
            viewModel = createViewModel()
            viewBinding = createViewBinding(inflater, container)
            cachedView = viewBinding?.root
            readDataFromArguments()
            initView(savedInstanceState)
            initLogic()
        }
        return cachedView
    }

    abstract fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun createViewModel(): VM

    abstract fun initView(savedInstanceState: Bundle?)

    open fun readDataFromArguments() {}

    open fun initLogic() {}

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }

    protected fun getViewBinding(): VB? = viewBinding

    protected fun getViewModel(): VM? = viewModel
}
