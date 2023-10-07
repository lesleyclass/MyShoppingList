package com.example.myshoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myshoppinglist.di.uiModule
import com.example.myshoppinglist.ui.MyShoppingListContainer
import com.example.myshoppinglist.ui.theme.MyShoppingListTheme
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            modules(uiModule())
        }

        setContent {
            MyShoppingListTheme {
                MyShoppingListContainer()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyShoppingListTheme {
        MyShoppingListContainer()
    }
}
