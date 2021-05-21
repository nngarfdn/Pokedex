package com.udindev.pokdex.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanang.berberita.data.api.RetrofitBuilder
import com.nanang.retrocoro.ui.base.ViewModelFactory
import com.udindev.pokdex.R
import com.udindev.pokdex.data.response.PokemonResponse
import com.udindev.pokdex.data.response.Result
import com.udindev.pokdex.databinding.FragmentHomeBinding
import com.udindev.pokdex.network.ApiHelper
import com.udindev.pokdex.utils.Status

class HomeFragment : Fragment() {


    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel : HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupViewModel()
        setupObservers()

        return binding.root
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(HomeViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getPokemon().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
//                        progressbar.visibility = View.INVISIBLE
                        binding.rvPokemon.visibility = View.VISIBLE
                        resource.data?.let { users -> retrieveList(users) }
                    }

                    Status.ERROR -> {
//                        progressbar.visibility = View.INVISIBLE
                        binding.rvPokemon.visibility = View.VISIBLE
                        Log.d("message", "setupObservers: ${it.message}")
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }

                    Status.LOADING -> {
//                        progressbar.visibility = View.VISIBLE
                        binding.rvPokemon.visibility = View.INVISIBLE
//                        progressbar.playAnimation()
                    }
                }
            }
        })
    }

    private fun retrieveList(users: PokemonResponse) {
        val layoutManager = LinearLayoutManager(context)
        binding.rvPokemon.layoutManager = layoutManager
        val adapter = HomeAdapter(users.results as List<Result>)
        binding.rvPokemon.adapter = adapter

        Log.d("hasil", "retrieveList: ${users.results}")

    }
}