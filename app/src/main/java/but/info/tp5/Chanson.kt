package but.info.tp5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Chanson {

    @PrimaryKey(autoGenerate = true)
    var id :Long = 0;
    var titre :String = "";
    var duree :String = "";
    var auteur :String = "";

    @Composable
    fun Display() {
        Row (modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.primary)) {
            Text(text = id.toString())
            Text(text = titre)
            Text(text = duree)
            Text(text = auteur)
        }
    }
}