package com.example.myshoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myshoppinglist.di.uiModule
import com.example.myshoppinglist.ui.navigation.MyShoppingListContainer
import com.example.myshoppinglist.theme.MyShoppingListTheme
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            modules(uiModule())
        }

        setContent {
            MyShoppingListTheme {
                MyShoppingListContainer(
                    onCloseClick = { finishPayment() },
                )
            }
        }
    }

    private fun finishPayment() = finish()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyShoppingListTheme {
        MyShoppingListContainer(
            onCloseClick = {},
        )
    }
}
