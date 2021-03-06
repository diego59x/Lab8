package com.example.laboratorio5apps.ui.results

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratorio5apps.R
import com.example.laboratorio5apps.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {

    private lateinit var resultsViewModel: ResultsViewModel
    private lateinit var binding: FragmentResultsBinding

    @SuppressLint("StringFormatMatches")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resultsViewModel =
            ViewModelProviders.of(this).get(ResultsViewModel::class.java)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_results, container, false
        )
        binding.model = resultsViewModel
        //
        binding.rating.text = getString(R.string.rating_number,  resultsViewModel.rating.value)
        //binding.encuestas.text = getString(R.string.encuestas_number, Results.getQuizesSize())
        binding.newQuiz.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_nav_results_to_nav_question)
        }
        binding.seeAnswers.setOnClickListener{view: View ->
            //Toast.makeText(context, Results.toStringFormat(), Toast.LENGTH_LONG).show()
        }
        return binding.root
    }

}