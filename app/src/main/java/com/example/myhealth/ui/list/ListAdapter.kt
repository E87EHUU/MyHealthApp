package com.example.myhealth.ui.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.databinding.ItemDateBinding
import com.example.myhealth.data.model.Health

class ListAdapter(private val adapter: IndicationAdapter) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var list = listOf<Health>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Health>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemDateBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(health: Health) {
            binding.apply {
                tvDate.text = health.date
                adapter.submitList(mutableListOf())
                health.indications?.let { adapter.submitList(it) }
                rvIndications.adapter = adapter
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}