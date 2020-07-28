package com.example.textgenerator.screens.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.textgenerator.R
import com.example.textgenerator.databinding.FragmentGenerationOptionsBinding

class GenerationOptionsFragment : Fragment() {
    private lateinit var generateOptionsViewModel : GenerationOptionsViewModel
    private lateinit var binding : FragmentGenerationOptionsBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_generation_options, container, false)
        binding.lifecycleOwner = this

        generateOptionsViewModel = ViewModelProvider(this)
            .get(GenerationOptionsViewModel::class.java)

        binding.generateOptionsViewModel = generateOptionsViewModel

        generateOptionsViewModel.navigateToResultParagraphFragment.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                if(binding.numberOfParagraphsInput.text.isNotEmpty()) {
                    val numberOfParagraphs = binding.numberOfParagraphsInput.text.toString()

                    this.findNavController().navigate (
                        GenerationOptionsFragmentDirections.actionGenerationOptionsFragmentToResultParagraphFragment(
                            generateOptionsViewModel.generateParagraph(numberOfParagraphs)
                        )
                    )

                    generateOptionsViewModel.doneNavigatingToResultParagraphFragment()
                } else {
                    Toast.makeText(context, R.string.how_many_paragraphs_field_empty, Toast.LENGTH_SHORT).show()
                }
            }
        })

        return binding.root
    }
}
