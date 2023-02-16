package but.info.tp5

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ModeleBase(app : Application) : AndroidViewModel(app) {
    private val base = Base.getInstance(app)

    fun getChansons() : LiveData<List<Chanson>> {
        return base.chansonDAO().getAll()
    }

    fun getChanson(id : Long) : LiveData<Chanson> {
        return base.chansonDAO().getById(id)
    }

    fun ajouterChanson(chanson : Chanson) {
        base.chansonDAO().insert(chanson)
    }






}