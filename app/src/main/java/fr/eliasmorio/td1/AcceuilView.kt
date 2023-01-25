package fr.eliasmorio.td1

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class AcceuilView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceuil_view)

        val btns = arrayOf(findViewById<ImageButton>(R.id.btnWalk),
            findViewById<ImageButton>(R.id.btnBike),
            findViewById<ImageButton>(R.id.btnCar),
            findViewById<ImageButton>(R.id.btnBus),
            findViewById<ImageButton>(R.id.btnTrain),
            findViewById<ImageButton>(R.id.btnPlane));

        fun onClick(v: View) {
            for (btn in btns) {
                if (btn == v) {
                    btn.setColorFilter(Color.BLUE)
                    btn.backgroundTintList = ColorStateList(
                        arrayOf(intArrayOf(android.R.attr.state_enabled)),
                        intArrayOf(Color.BLUE)
                    )
                } else {
                    btn.setColorFilter(Color.BLACK
                    )
                }
            }
            findViewById<TextView>(R.id.transportTitle).text =  "Transport choisi : " + v.contentDescription
        }

        for (btn in btns) {
            btn.setOnClickListener {
                onClick(it)
            }
        }



    }


}