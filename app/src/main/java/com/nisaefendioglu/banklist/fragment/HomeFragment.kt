package com.nisaefendioglu.banklist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nisaefendioglu.banklist.adapter.BankAdapter
import com.nisaefendioglu.banklist.databinding.FragmentHomeBinding
import com.nisaefendioglu.banklist.model.Bank
import com.nisaefendioglu.banklist.utils.NetworkResults
import com.nisaefendioglu.banklist.utils.isNetworkConnected
import com.nisaefendioglu.banklist.utils.setVisibility
import com.nisaefendioglu.banklist.utils.showToast
import com.nisaefendioglu.banklist.viewmodel.BankViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, BankViewModel>() {

    private lateinit var bankAdapter: BankAdapter
    private val bankBranchList: MutableList<Bank> = mutableListOf()
    private val filteredBankBranchList: MutableList<Bank> = mutableListOf()

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun createViewModel(): BankViewModel {
        return ViewModelProvider(this)[BankViewModel::class.java]
    }

    override fun initView(savedInstanceState: Bundle?) {
        initBankAdapter()
        initSearchView()
        observeBankBranchList()
    }

    override fun initLogic() {
        super.initLogic()
        fetchBankBranches()
    }

    private fun fetchBankBranches() {
        if (!requireContext().isNetworkConnected) {
            showToast(requireContext(), "No Network")
        }
        getViewModel()?.getBankBranches()
    }

    private fun observeBankBranchList() {
        getViewModel()?.bankList?.observe(viewLifecycleOwner) { result ->
            handleBankBranchListResult(result)
        }
    }

    private fun handleBankBranchListResult(result: NetworkResults<List<Bank>>) {
        when (result) {
            is NetworkResults.LOADING -> showLoadingProgress(true)
            is NetworkResults.SUCCESS -> {
                showLoadingProgress(false)
                showBankBranchList(result.data?: emptyList())
            }
            is NetworkResults.ERROR -> {
                showLoadingProgress(false)
                showToast(requireContext(), "Network Error")
            }
        }
    }

    private fun showLoadingProgress(isVisible: Boolean) {
        getViewBinding()?.progressBar?.setVisibility(isVisible)
    }

    private fun showBankBranchList(bankBranches: List<Bank>) {
        bankBranchList.clear()
        bankBranchList.addAll(bankBranches)
        updateFilteredBankBranchList()
    }

    private fun updateFilteredBankBranchList() {
        val query = getViewBinding()?.searchView?.query?.toString()?.lowercase().orEmpty()
        filteredBankBranchList.clear()
        filteredBankBranchList.addAll(bankBranchList.filter { it.dc_SEHIR?.lowercase()?.contains(query) == true })
        bankAdapter.notifyDataSetChanged()
    }

    private fun initBankAdapter() {
        bankAdapter = BankAdapter(
            list = filteredBankBranchList,
            onClicked = { position ->
                val actionDetail = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    detailFragment = filteredBankBranchList[position]
                )
                findNavController().navigate(actionDetail)
            }
        )
        getViewBinding()?.rvBankList?.adapter = bankAdapter
    }

    private fun initSearchView() {
        getViewBinding()?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                updateFilteredBankBranchList()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                updateFilteredBankBranchList()
                return false
            }
        })
    }
}
