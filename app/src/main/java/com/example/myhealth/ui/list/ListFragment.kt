package com.example.myhealth.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myhealth.R
import com.example.myhealth.data.model.Indication
import com.example.myhealth.databinding.FragmentListBinding
import com.example.myhealth.utils.getTime
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val adapter: ListAdapter by inject()
    private val viewModel: HealthViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListBinding.bind(view)

        viewModel.getLivData().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.apply {
            rvIndications.adapter = adapter

            addIndication.setOnClickListener {
                val indication =
                    Indication(
                        time = getTime(),
                        upperPressure = (100..200).random(),
                        lowerPressure = (60..120).random(),
                        pulse = (50..150).random()
                    )

                viewModel.setIndication(indication)
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}