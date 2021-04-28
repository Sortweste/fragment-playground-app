package com.example.emojiapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.emojiapp.databinding.ActivityMainBinding
import com.example.emojiapp.ui.fragments.EmojiFragment
import com.example.emojiapp.viewmodels.EmojiViewModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EmojiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bind()
        initObservers()
    }

    private fun componentsVisibility(status: Int){
        binding.next.visibility = status
        binding.prev.visibility = status
    }

    private fun bind(){
        binding.next.setOnClickListener { viewModel.onNext() }
        binding.prev.setOnClickListener { viewModel.onPrevious() }
    }

    private fun initObservers(){
        viewModel.index.observe(this){
            when(it){
                0 -> binding.prev.visibility = View.GONE
                viewModel.lastIndex -> binding.next.visibility = View.GONE
                else -> componentsVisibility(View.VISIBLE)
            }
            viewModel.setInfo()
            val fragment = EmojiFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .replace(binding.fragment.id, fragment)
                .commit()
        }
    }

}