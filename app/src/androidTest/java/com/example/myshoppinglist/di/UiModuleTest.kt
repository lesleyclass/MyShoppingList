package com.example.myshoppinglist.di

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myshoppinglist.ui.store.ItemsStore
import com.example.myshoppinglist.validation.SaveButtonValidation
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

@RunWith(AndroidJUnit4::class)
internal class UitModulesTest : KoinTest {

    @Test
    fun koin_shouldCheckModules() {
        koinApplication {
            val itemsStore = ItemsStore()
            val saveButtonValidation = SaveButtonValidation()

            checkModules {
                withInstance(itemsStore)
                withInstance(saveButtonValidation)

                modules(
                    uiModule()
                )
            }
        }
    }
}