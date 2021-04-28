package com.example.emojiapp.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception

inline fun <reified T> parseJSON(payload: String): T? {
    return try {
        Gson().fromJson(payload, object: TypeToken<T>() {}.type)
    }catch (e: Exception){
        null
    }
}

inline fun <reified T> readJSONFromFile(context: Context, fileName: String): T?{
    return try {
        val jsonPayload: String = context.assets.open(fileName).bufferedReader().use { it.readText() }
        parseJSON<T>(jsonPayload)
    }catch (e: Exception){
        null
    }
}