package dti.g25.pendu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import dti.g25.pendu.presentateur.Presentateur

val COULEUR_NORMALE = 0
val COULEUR_DÉSACTIVÉE = 0xff888888.toInt()

//Image du Jeu montrant le pendu
lateinit var imgPendu : ImageView

//Zone de texte contenant le score
lateinit var tvScore : TextView

//Bouton de réinitialisation
lateinit var btnRéinit : Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val présentateur = Presentateur(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgPendu = findViewById(R.id.imgPendu)

        tvScore = findViewById(R.id.tvScore)

        btnRéinit = findViewById(R.id.btnReinit)
        btnRéinit.setOnClickListener{rejouer()}

        val Q : Button = findViewById(R.id.btnQ)
        Q.setOnClickListener(this)
    }

    override fun onClick(v : View) {
        désactiverLettreUtilisée('Q')
    }

    fun rejouer(){
        présentateur.démarrer()
    }

    fun désactiverLettreUtilisée(lettre : Char){
        var btn : Button = lettre as Button
        //btn.isClickable = false
        btn.setBackgroundColor(COULEUR_DÉSACTIVÉE)
    }
    fun afficherScore(score : Int){
        tvScore.text = score.toString()
    }

    fun afficherImageErreur0(){
        imgPendu.setImageResource(R.drawable.erreur0)
    }

    fun afficherImageErreur1(){
        imgPendu.setImageResource(R.drawable.erreur1)
    }

    fun afficherImageErreur2(){
        imgPendu.setImageResource(R.drawable.erreur2)
    }

    fun afficherImageErreur3(){
        imgPendu.setImageResource(R.drawable.erreur3)
    }

    fun afficherImageErreur4(){
        imgPendu.setImageResource(R.drawable.erreur4)
    }

    fun afficherImageErreur5(){
        imgPendu.setImageResource(R.drawable.erreur5)
    }

    fun afficherImageErreur6(){
        imgPendu.setImageResource(R.drawable.erreur6)
    }

}
