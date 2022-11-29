package com.example.lifehack.presentation.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.lifehack.databinding.FragmentCompanyDetailBinding
import com.example.lifehack.presentation.ui.MainActivity
import com.example.lifehack.presentation.ui.adapter.CompanyAdapter
import com.example.lifehack.presentation.viewmodel.CompanyViewModel

class CompanyDetailFragment : Fragment() {

    private var _binding: FragmentCompanyDetailBinding? = null
    private val binding get() = checkNotNull(_binding)
    private lateinit var viewModel: CompanyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompanyDetailBinding.inflate(inflater, container, false)
        viewModel = (activity as MainActivity).viewModel
        arguments?.let { viewModel.getDetailData(it.getInt("id")) }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.detailCompany.observe(viewLifecycleOwner) { resource ->
                binding.apply {
                    resource.data?.let { request ->
                        description.text = request[0].description
                        img.load(CompanyAdapter.BASE_URL + request[0].image)
                        lat.text = request[0].lat
                        lon.text = request[0].lon
                        name.text = request[0].name
                        phone.text = request[0].phone
                        www.text = request[0].www
                    }
                }
            }
        }
    }