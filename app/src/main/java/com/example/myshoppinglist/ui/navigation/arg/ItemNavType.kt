package com.example.myshoppinglist.ui.navigation.arg

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import com.example.myshoppinglist.ShoppingListUiState

internal class ItemNavType : CustomNavType<ShoppingListUiState>() {

    override fun get(bundle: Bundle, key: String): ShoppingListUiState? =
        bundle.parcelable(key)

    override fun parseValue(value: String): ShoppingListUiState =
        decode(value)

    override fun put(bundle: Bundle, key: String, value: ShoppingListUiState) {
        bundle.putParcelable(key, value)
    }
}

internal inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}
