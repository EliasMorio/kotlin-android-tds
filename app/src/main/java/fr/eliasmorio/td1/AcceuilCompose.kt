package fr.eliasmorio.td1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.eliasmorio.td1.ui.theme.TD1Theme

class AcceuilCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TD1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val choix = remember { mutableStateOf(0) }

    Column (modifier = Modifier.fillMaxHeight()){
        val name = stringResource(id = R.string.app_name)
        Text(text = "Choisissez un mode de transport",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )
        val defaultColor = remember { mutableStateOf(Color.White) }
        val selectedColor = remember { mutableStateOf(Color.Blue) }

        val modifierImage = Modifier
            .padding(60.dp)
            .size(70.dp)
            .border(2.dp, MaterialTheme.colors.primary, MaterialTheme.shapes.small)
        Row(modifier = Modifier.fillMaxWidth()) {

            Image(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_directions_walk_24),
                contentDescription = "Walk",
                modifier = modifierImage
                    .background(if (choix.value == 1) selectedColor.value else defaultColor.value)
                    .clickable {
                        choix.value = 1
                    }
            )
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_directions_bike_24),
                contentDescription = "Bike",
                modifier = modifierImage
                    .background(if (choix.value == 2) selectedColor.value else defaultColor.value)
                    .clickable {
                    choix.value = 2
                }
            )
        }

        Row(modifier =Modifier.fillMaxWidth() )  {
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_directions_car_24),
                contentDescription = "Car",
                modifier = modifierImage
                    .background(if (choix.value == 3) selectedColor.value else defaultColor.value)
                    .clickable { choix.value = 3 }

            )
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_directions_bus_24),
            contentDescription = "Bus",
                modifier = modifierImage
                    .background(if (choix.value == 4) selectedColor.value else defaultColor.value)
                    .clickable { choix.value = 4 }
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_train_24),
                contentDescription = "Train",
                modifier = modifierImage
                    .background(if (choix.value == 5) selectedColor.value else defaultColor.value)
                    .clickable { choix.value = 5 }
            )
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_airplanemode_active_24),
                contentDescription = "Plane",
                modifier = modifierImage
                    .background(if (choix.value == 6) selectedColor.value else defaultColor.value)
                    .clickable { choix.value = 6 }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TD1Theme {
        Greeting()
    }
}