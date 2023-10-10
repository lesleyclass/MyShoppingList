package com.example.myshoppinglist.ui.navigation.arg

import android.net.Uri
import androidx.navigation.NavType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal abstract class CustomNavType<T>(
    isNullableAllowed: Boolean = false,
) : NavType<T>(isNullableAllowed) {

    open val json: Json = Json

    fun String.encodeForRoute(): String =
        Uri.encode(this)
}

internal inline fun <reified T> CustomNavType<T>.encode(arg: T): String =
    json.encodeToString(arg).encodeForRoute()

internal inline fun <reified T> CustomNavType<T>.decode(value: String): T =
    json.decodeFromString(value)
