package com.example.myshoppinglist.ui.navigation.destination

import android.os.Bundle
import com.example.myshoppinglist.ItemUiState
import com.example.myshoppinglist.ui.navigation.arg.ItemNavType
import com.example.myshoppinglist.ui.navigation.arg.encode
import com.example.myshoppinglist.ui.navigation.arg.parcelable

internal object NewProduct : ShoppingListDestinationArg<ItemUiState>(
    baseRoute = "new-product",
    argName = "uiState",
    navType = ItemNavType(),
){
    override fun encode(arg: ItemUiState): String =
        navType.encode(arg)

    override fun getArg(bundle: Bundle?): ItemUiState? =
        bundle?.parcelable(argName)
}
