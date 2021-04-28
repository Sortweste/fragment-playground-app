package com.example.emojiapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.emojiapp.data.Emoji
import com.example.emojiapp.utils.emojiPayload
import com.example.emojiapp.utils.parseJSON

class EmojiViewModel: ViewModel() {
    private val emojiList: List<Emoji> = parseJSON(emojiPayload.toString())!!

    private var _index = MutableLiveData<Int>()
    val index: LiveData<Int>
        get() = _index

    val lastIndex = emojiList.lastIndex

    private var _current = MutableLiveData<Emoji>()
    val current: LiveData<Emoji>
        get() = _current

    init {
        _index.value= 0
        _current.value = emojiList[0]
    }


    fun onNext(){
        _index.apply {
            value = value?.plus(1)?.coerceIn(0, emojiList.lastIndex)
        }
    }
    fun onPrevious(){
        _index.apply {
            value = value?.minus(1)?.coerceIn(0, emojiList.lastIndex)
        }
    }

    fun setInfo(){
        _current.apply {
            value = emojiList[index.value!!]
        }
    }

}