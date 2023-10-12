package com.example.myshoppinglist.ui.navigation.destination


import org.junit.Test
import com.google.common.truth.Truth.assertThat

@Suppress("UnnecessaryVariable")
internal class NewProductTest {

    @Test
    fun route_shouldReturnNewProductRoute() {
        val actual = Main.route

        val expected = "new-product"
        assertThat(actual).isEqualTo(expected)
    }
}