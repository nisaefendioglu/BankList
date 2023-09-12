package com.nisaefendioglu.banklist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.nisaefendioglu.banklist.R
import com.nisaefendioglu.banklist.databinding.FragmentDetailBinding
import com.nisaefendioglu.banklist.utils.FirebaseAnalyticsUtils
import com.nisaefendioglu.banklist.utils.openMap
import com.nisaefendioglu.banklist.utils.setTextViewText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bankItem = args.detailFragment
        val infoNotAvailable = getString(R.string.no_information)

        with(binding) {
            setTextViewText(tvBankCity, bankItem.dc_SEHIR, infoNotAvailable)
            setTextViewText(tvBankBranch, bankItem.dc_BANKA_SUBE, infoNotAvailable)
            setTextViewText(tvBankCode, bankItem.dc_BANK_KODU, infoNotAvailable)
            setTextViewText(tvBankAdress, bankItem.dc_ADRES, infoNotAvailable)

            FirebaseAnalyticsUtils.logBankInformation(bankItem)

            btnDirection.setOnClickListener {
                context?.openMap(bankItem?.dc_ADRES)
            }
        }

        return binding.root
    }
}
