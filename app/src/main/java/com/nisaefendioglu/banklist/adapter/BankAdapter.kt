package com.nisaefendioglu.banklist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nisaefendioglu.banklist.databinding.BankItemLayoutBinding
import com.nisaefendioglu.banklist.model.Bank

class BankAdapter(
    private val list: MutableList<Bank>,
    private val onClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<BankAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: BankItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener { onClicked(adapterPosition) }
        }

        fun bind(item: Bank) {
            binding.bankItem = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = BankItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = list[position])
    }

    override fun getItemCount(): Int = list.size
}


