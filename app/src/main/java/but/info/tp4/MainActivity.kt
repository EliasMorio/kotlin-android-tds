package but.info.tp4

import android.os.Bundle
import android.view.Menu
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import but.info.tp4.ui.*
import but.info.tp4.ui.theme.TP4Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val (recette, setRecette) = remember { mutableStateOf<IRecette>(GratinPates()) }
                    val drawerState = rememberDrawerState( initialValue = DrawerValue.Closed )
                    val scope = rememberCoroutineScope()
                    ModalDrawer(drawerContent = {Menu(recette, setRecette) { scope.launch { drawerState.close() } } }, drawerState = drawerState, ) {
                        val (page, setPage) = remember { mutableStateOf(Page.RESUME) }
                        Recette(page, setPage, recette) { scope.launch { drawerState.open() } }
                    }
                }
            }
        }
    }
}

@Composable
fun Menu(selectedRecette: IRecette, setRecette: IRecette.() -> Unit, close: () -> Unit){
    val recettes = HashMap<String, IRecette>()
    recettes["Gratin de pâtes"] = GratinPates()
    recettes["Caponata"] = Caponata()
    recettes["Madeleines"] = Madeleines()
    recettes["Stollen"] = Stollen()
    val selectedModifier = Modifier.background(MaterialTheme.colors.primary)

    Column() {
        IconButton(onClick = { close() }) {
            Icon(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = "Fermer")
        }
        for (recette in recettes) {
            TextButton(onClick = {
                setRecette(recette.value)
                close()},
                modifier = if (recette.value == selectedRecette) selectedModifier else Modifier) {
                Text(text = recette.key)
            }

        }
    }
}



@Composable
fun Recette(page: Page, setPage: (Page) -> Unit, recette: IRecette, clickMenu: () -> Unit ){
    Column() {
        val selectedColor = ButtonDefaults.outlinedButtonColors(backgroundColor = MaterialTheme.colors.secondary)

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(onClick = { clickMenu() },  ) {
                Icon(painter = painterResource(id = R.drawable.ic_menu), contentDescription = "Menu")
            }
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(onClick = { setPage(Page.RESUME) }, colors = if (page == Page.RESUME) selectedColor else ButtonDefaults.outlinedButtonColors()) {
                Text(text = "Résumé")
            }
            OutlinedButton(onClick = { setPage(Page.INGREDIENTS) }, colors = if (page == Page.INGREDIENTS) selectedColor else ButtonDefaults.outlinedButtonColors()) {
                Text(text ="Ingrédients")
            }
            OutlinedButton(onClick = { setPage(Page.RECETTE) }, colors = if (page == Page.RECETTE) selectedColor else ButtonDefaults.outlinedButtonColors()) {
                Text(text = "Recette")
            }
            Spacer(modifier = Modifier.weight(1f))

        }
        when (page) {
            Page.RESUME -> recette.Resume(modifier = Modifier.fillMaxSize())
            Page.INGREDIENTS -> recette.Ingredients(modifier = Modifier.fillMaxSize())
            Page.RECETTE -> recette.Recette(modifier = Modifier.fillMaxSize())
        }
    }
}