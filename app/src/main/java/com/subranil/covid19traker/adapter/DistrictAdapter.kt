package com.subranil.covid19traker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.subranil.covid19traker.databinding.ItemDistrictBinding
import com.subranil.covid19traker.models.DistrictData

class DistrictAdapter : ListAdapter<DistrictData, DistrictAdapter.TotalViewHolder>(DIFF_CALLBACK) {


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DistrictData>() {
            override fun areItemsTheSame(oldItem: DistrictData, newItem: DistrictData): Boolean {
                return oldItem.district == newItem.district
            }

            override fun areContentsTheSame(oldItem: DistrictData, newItem: DistrictData): Boolean {
                return oldItem.district == newItem.district
            }
        }
    }

    class TotalViewHolder(private val binding: ItemDistrictBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(details: DistrictData) {
            binding.textDistrictName.text = details.district
            binding.textNotes.text = details.notes
            binding.textConfirmed.text = details.confirmed.toString()
            binding.textActive.text = details.active.toString()
            binding.textDeath.text = details.deceased.toString()
            binding.textRecovered.text = details.recovered.toString()

            // New Confirmed
            details.delta.confirmed.let {
                if (it == 0) {
                    binding.groupStateNewConfirm.visibility = View.GONE
                } else {
                    binding.groupStateNewConfirm.visibility = View.VISIBLE
                    binding.textDistrictNewConfirm.text = details.delta.confirmed.toString()
                }
            }
            // New Recovered
            details.delta.recovered.let {
                if (it == 0) {
                    binding.groupStateNewRecover.visibility = View.GONE
                } else {
                    binding.groupStateNewRecover.visibility = View.VISIBLE
                    binding.textDistrictNewRecover.text = details.delta.recovered.toString()
                }
            }
            // New Deaths
            details.delta.deceased.let {
                if (it == 0) {
                    binding.groupStateNewDeaths.visibility = View.GONE
                } else {
                    binding.groupStateNewDeaths.visibility = View.VISIBLE
                    binding.textDistrictNewDeath.text = details.delta.deceased.toString()
                }
            }
            // Handling cases with notes
            details.notes.let {
                if (it.isBlank()) {
                    binding.textNotes.visibility = View.GONE
                } else {
                    binding.textNotes.visibility = View.VISIBLE
                    binding.textNotes.text = details.notes
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TotalViewHolder(
        ItemDistrictBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: TotalViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}