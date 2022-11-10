package com.example.scoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.scoreapp.databinding.FragmentResultBinding
import com.example.scoreapp.databinding.FragmentScoreBinding


class ScoreFragment : Fragment(R.layout.fragment_score) {


    private var score = 1
    private lateinit var binding: FragmentScoreBinding
    private lateinit var viewModel: AppViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentScoreBinding.bind(view)

        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        binding.btnInc.setOnClickListener {
            viewModel.increment()
        }



        binding.btnNav.setOnClickListener {
            score = viewModel.score.value!!
            view.findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToResultFragment(score))
        }

        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.tvScore.text = newScore.toString()
        })



    }

}