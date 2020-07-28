package com.example.textgenerator.screens.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.textgenerator.R
import com.example.textgenerator.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private lateinit var binding : FragmentTitleBinding
    private lateinit var gameViewModel : TitleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        binding.lifecycleOwner = this

        gameViewModel = ViewModelProvider(this).get(TitleViewModel::class.java)
        binding.titleViewModel = gameViewModel

        gameViewModel.navigateToGenerationOptionsFragment.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                this.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGenerationOptionsFragment())

                gameViewModel.doneNavigatingToGenerateOptionsFragment()
            }
        })

        gameViewModel.navigateToAboutPage.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                this.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToAboutFragment())

                gameViewModel.doneNavigatingToAboutFragment()
            }
        })

        return binding.root
    }
}
