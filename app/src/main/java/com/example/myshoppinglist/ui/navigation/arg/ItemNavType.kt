package com.example.myshoppinglist.ui.navigation.arg

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import com.example.myshoppinglist.ItemUiState

internal class ItemNavType : CustomNavType<ItemUiState>() {

    override fun get(bundle: Bundle, key: String): ItemUiState? =
        bundle.parcelable(key)

    override fun parseValue(value: String): ItemUiState =
        decode(value)

    override fun put(bundle: Bundle, key: String, value: ItemUiState) {
        bundle.putParcelable(key, value)
    }
}

internal inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}
