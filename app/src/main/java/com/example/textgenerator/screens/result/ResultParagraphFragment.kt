package com.example.textgenerator.screens.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.textgenerator.R
import com.example.textgenerator.databinding.FragmentResultParagraphBinding

class ResultParagraphFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentResultParagraphBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_result_paragraph, container, false)

        var args =
            ResultParagraphFragmentArgs.fromBundle(
                requireArguments()
            )

        binding.text = args.numberOfParagraphs

        return binding.root
    }
}
