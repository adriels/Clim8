package com.adr.clim8.data.deserializer

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun <T> Map<String, Any>.deserializeJSON(destinationClass: Class<T>): T {
    val gson = Gson()
    return if (this is List<*>) {
        val jsonArray = gson.toJsonTree(this).asJsonArray
        val listType = object : TypeToken<List<T>>() {}.type
        gson.fromJson(jsonArray, listType)
    } else {
        val jsonObject = gson.toJsonTree(this).asJsonObject
        gson.fromJson(jsonObject, destinationClass)
    }
}