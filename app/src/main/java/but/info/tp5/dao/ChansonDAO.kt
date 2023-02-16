package but.info.tp5.dao

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import but.info.tp5.entity.Chanson
import java.util.concurrent.Flow

@Dao
interface ChansonDAO {

    @Query("SELECT * FROM chanson")
    fun getAll(): LiveData<List<Chanson>>

    @Query("SELECT * FROM chanson WHERE id = :id")
    fun getById(id: Long): LiveData<Chanson>


}