package com.example.scoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.scoreapp.databinding.FragmentResultBinding
import com.example.scoreapp.databinding.FragmentScoreBinding


class ResultFragment : Fragment(R.layout.fragment_result){


    private lateinit var binding: FragmentResultBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultBinding.bind(view)

        val args = ResultFragmentArgs.fromBundle(requireArguments())
        binding.tvPrint.text = args.score.toString()
        Toast.makeText(context, "NumCorrect: ${args.score}", Toast.LENGTH_LONG).show()

    }
}



