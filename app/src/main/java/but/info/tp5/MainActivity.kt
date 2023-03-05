package but.info.tp5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import but.info.tp5.ui.theme.TP5Theme
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val modeleBase by viewModels<ModeleBase>()
        setContent {
            TP5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        AddChanson(modeleBase)
                        DisplayAllChansons(modeleBase = modeleBase)

                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TP5Theme {
        Greeting("Android")
    }
}

@Composable
fun AddChanson(modeleBase : ModeleBase) {
    val (name, setName) = remember { mutableStateOf("") }
    val (duree, setDuree) = remember { mutableStateOf("") }
    val (auteur,setAuteur) = remember { mutableStateOf("") }

    Column() {
        TextField(value = name, onValueChange = {
            setName(it)
        })

        TextField(value = auteur, onValueChange = {
            setAuteur(it)
        })
        TextField(value = duree, onValueChange = {
            setDuree(it)
        })

        Button(onClick = {
            Thread {
                val chanson = Chanson()
                chanson.titre = name
                chanson.auteur = auteur
                chanson.duree = duree
                setDuree("")
                setAuteur("")
                setName("")
                modeleBase.ajouterChanson(chanson)
            }.start()

        }) {
            Text("Ajouter")
        }
    }
}

@Composable
fun DisplayAllChansons(modeleBase : ModeleBase) {
    val chansons = modeleBase.getChansons().value
    print(chansons)
    Column() {
        if (chansons != null) {
            for (chanson in chansons) {
                chanson.Display()
            }
        }
    }

}
