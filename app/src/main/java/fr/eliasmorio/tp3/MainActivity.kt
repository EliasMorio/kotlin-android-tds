package fr.eliasmorio.tp3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
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
            val (sel, setSel) = remember { mutableStateOf(-1) }
            val (t, setT) = remember{mutableStateOf("")}
            val contenu = remember {
                mutableStateListOf<String>()
            }
            TP3Theme {
                val mod = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                Column {
                    Liste(mod, contenu, sel, setSel)
                    Liste(mod, contenu, sel, setSel)
                    Entree(t = t, setT = setT, contenu = contenu)
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Liste(modifier: Modifier = Modifier, liste : List<String>,  sel : Int, setSel : (Int) -> Unit) {
    val context = LocalContext.current

    Column () {
        for (ind in liste.indices){
            Surface(color = if (ind == sel) Color.Blue else Color.Transparent,
                modifier = modifier.clickable {
                    setSel(ind)
                    Toast.makeText(context, "Clic", Toast.LENGTH_SHORT).show()
                }) {
                Text(text = liste[ind])
            }
        }
    }
}

@Composable
fun Entree(t : String, setT : (String) -> Unit, contenu : MutableList<String>){
    Row() {
        Text(text = "Texte : ")
        TextField(value = t, onValueChange = { setT(it) })
        Button(onClick = {
            contenu.add(t)
                         setT("")}, content = { Text(text = "+") })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val mod = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .background(Color.LightGray)

}