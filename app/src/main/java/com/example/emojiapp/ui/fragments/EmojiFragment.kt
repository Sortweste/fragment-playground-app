package com.example.emojiapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.emojiapp.databinding.FragmentEmojiBinding
import com.example.emojiapp.viewmodels.EmojiViewModel

class EmojiFragment : Fragment() {

    private var _binding: FragmentEmojiBinding? = null
    private val binding get() =_binding!!

    private val viewModel: EmojiViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmojiBinding.inflate(inflater, container,false)
        binding.emojiViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                EmojiFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}