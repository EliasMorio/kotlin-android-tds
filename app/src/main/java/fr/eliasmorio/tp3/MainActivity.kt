package fr.eliasmorio.tp3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.eliasmorio.tp3.ui.theme.TP3Theme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP3Theme {
                val mod = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Liste(mod)
                }
            }
        }
    }
}

@Composable
fun Liste(modifier: Modifier = Modifier ) {
    val liste = listOf("Elément 1", "Elément 2", "Elément 3")
    val context = LocalContext.current


    Column () {
        for (el in liste){
            Surface(color = Color.Transparent, modifier = modifier.clickable { Toast.makeText(context, "Clic", Toast.LENGTH_SHORT).show() }) {
                Text(text = el)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val mod = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .background(Color.LightGray)
    TP3Theme {
        Liste(mod)
    }
}