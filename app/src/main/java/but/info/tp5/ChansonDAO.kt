package but.info.tp5

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ChansonDAO {

    @Query("SELECT * FROM chanson")
    fun getAll(): LiveData<List<Chanson>>

    @Query("SELECT * FROM chanson WHERE id = :id")
    fun getById(id: Long): LiveData<Chanson>

    @Query("I")


}