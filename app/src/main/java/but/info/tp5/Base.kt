package but.info.tp5

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


abstract class Base : RoomDatabase(){
    abstract fun chansonDAO(): ChansonDAO

    companion object {
        private var INSTANCE: Base? = null

        fun getInstance(context: Context) : Base{
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    Base::class.java,
                    "module.sqlite"
                ).build()
            }
            return INSTANCE!!
        }

    }

}