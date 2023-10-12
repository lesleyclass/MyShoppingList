package com.example.myshoppinglist.ui.navigation.destination


import org.junit.Test
import com.google.common.truth.Truth.assertThat

@Suppress("UnnecessaryVariable")
internal class MainTest {

    @Test
    fun route_shouldReturnMainRoute() {
        val actual = Main.route

        val expected = "main"
        assertThat(actual).isEqualTo(expected)
    }
}