package but.info.tp5

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Chanson {

    @PrimaryKey
    var id :Long = 0;
    var titre :String = "";
    var duree :Int = 0;
    var auteur :String = "";


}