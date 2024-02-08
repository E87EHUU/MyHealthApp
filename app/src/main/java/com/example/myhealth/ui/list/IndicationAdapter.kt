package com.example.myhealth.ui.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.R
import com.example.myhealth.databinding.ItemIndicationBinding
import com.example.myhealth.data.model.Indication

class IndicationAdapter : RecyclerView.Adapter<IndicationAdapter.ViewHolder>() {

    private var list = listOf<Indication>()
    private val colors = listOf(R.drawable.yellow_gradient, R.drawable.green_gradient)

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Indication>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemIndicationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(indication: Indication, color: Int) {
            binding.apply {
                root.setBackgroundResource(color)
                indicationTime.text = indication.time
                indicationUpperPressure.text = indication.upperPressure.toString()
                indicationLowerPressure.text = indication.lowerPressure.toString()
                indicationPulse.text = indication.pulse.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemIndicationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], colors[position % 2])
    }
}