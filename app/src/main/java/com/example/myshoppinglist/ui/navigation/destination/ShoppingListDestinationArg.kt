package com.example.myshoppinglist.ui.navigation.destination

import android.os.Bundle
import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import com.example.myshoppinglist.ui.navigation.arg.CustomNavType

internal abstract class ShoppingListDestinationArg<T>(
    baseRoute: String,
    protected val argName: String,
    protected val navType: CustomNavType<T>,
) : ShoppingListDestination() {

    override val route: String = "$baseRoute?$argName={$argName}"

    val navArg: NamedNavArgument = navArgument(argName) { type = navType }

    fun createRoute(arg: T): String = route
        .replace(oldValue = "{$argName}", newValue = encode(arg))

    abstract fun encode(arg: T): String

    abstract fun getArg(bundle: Bundle?): T?
}
