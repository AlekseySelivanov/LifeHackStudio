package com.example.lifehack.presentation.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lifehack.R
import com.example.lifehack.data.network.Resource
import com.example.lifehack.databinding.FragmentCompanyListBinding
import com.example.lifehack.presentation.ui.MainActivity
import com.example.lifehack.presentation.ui.adapter.CompanyAdapter
import com.example.lifehack.presentation.viewmodel.CompanyViewModel
import kotlinx.android.synthetic.main.fragment_company_list.*
import kotlinx.android.synthetic.main.item_error.*

class CompanyListFragment : Fragment() {

    private var _binding: FragmentCompanyListBinding? = null
    private val binding get() = checkNotNull(_binding)


    private lateinit var viewModel: CompanyViewModel
    private lateinit var companyAdapter: CompanyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompanyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        bindRV()
        viewModel.company.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Success -> {
                    hideProgressBar()
                    hideErrorMessage()
                    resource.data?.let { request ->
                        companyAdapter.differ.submitList(request.toList())
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    resource.message?.let {
                        if (it != "")
                            showErrorMessage(it)
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        }


        btnRetry.setOnClickListener {
            viewModel.getData()
        }
        companyAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                it.id?.let { it1 -> putInt("id", it1.toInt()) }
            }

            val fragment2 = CompanyDetailFragment()
            fragment2.arguments = bundle
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment2)
                .addToBackStack(fragment2::class.java.name)
                .commit()
        }

        viewModel.getData()

    }


    private fun bindRV() {
        companyAdapter = CompanyAdapter()
        binding.rvBreakingNews.apply {
            adapter = companyAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun hideProgressBar() {
        binding.paginationProgressBar.visibility = View.INVISIBLE
        loading = false
    }

    private fun showProgressBar() {
        binding.paginationProgressBar.visibility = View.VISIBLE
        loading = true
    }

    private fun hideErrorMessage() {
        itemErrorMessage.visibility = View.INVISIBLE
        error = false
    }

    private fun showErrorMessage(message: String) {
        itemErrorMessage.visibility = View.VISIBLE
        tvErrorMessage.text = message
        this.error = true
    }

    private var loading = false
    private var error = false

    companion object {
        fun newInstance() = CompanyListFragment()
    }
}