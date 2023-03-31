package dti.g25.pendu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import dti.g25.pendu.presentateur.Presentateur

//Couleur normale des boutons (mauve)
val COULEUR_NORMALE = 0xffFF6200ED.toInt()

//Couleur des boutons lorsqu'ils sont désactivés (gris)
val COULEUR_DÉSACTIVÉE = 0xff888888.toInt()

//Image du Jeu montrant le jeu du pendu
lateinit var imgPendu : ImageView

//Zone de texte contenant le score
lateinit var tvScore : TextView

//Bouton de réinitialisation
lateinit var btnRéinit : Button

//Zone de texte contenant le mot à deviner
lateinit var tvMot : TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val présentateur = Presentateur(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgPendu = findViewById(R.id.imgPendu)

        tvScore = findViewById(R.id.tvScore)

        tvMot = findViewById(R.id.tvMot)

        btnRéinit = findViewById(R.id.btnReinit)
        btnRéinit.setOnClickListener{rejouer()}

    }

    override fun onClick(v : View) {
        var idButton = v.id     //Id du bouton cliqué
        var btnCliqué : Button = findViewById(idButton)
        var letterCliqué = btnCliqué.text.toString().toCharArray()[0]    //N'arrive pas à le mettre juste Char alors utilise le premier élément du CharArray

        présentateur.sélectionnerLettre(letterCliqué)
    }

    /**
     * Recommence le jeu (quand le bouton Réinitialiser est cliqué)
     */
    fun rejouer(){
        présentateur.démarrer()
        tvMot.setTextColor(Color.BLACK)
    }


    /**
     * Désactiver les boutons des lettres lorsqu'il sont cliqués
     */
    fun désactiverLettreUtilisée(lettre : Char){
        val resID = getResources().getIdentifier("btn$lettre", "id", getPackageName());
        val btn : Button = findViewById(resID)

        btn.setBackgroundColor(COULEUR_DÉSACTIVÉE)      //Mettre la couleur du boutton à gris
        btn.isClickable = false     //Désactiver le bouton lorsqu'il est cliqué
    }


    /**
     * Réactiver les boutons quand le jeu recommence
     *
     * @param lettres liste des lettres utilisées ou à réactiver
     */
    fun réactiverLettres(lettres : CharArray){
        for (i in lettres.indices){
            var lettreBtn = lettres[i]      //Lettre sur le bouton et son id
            var idB = getResources().getIdentifier("btn$lettreBtn", "id", getPackageName());    //Id du bouton
            var btn : Button = findViewById(idB)

            btn.setBackgroundColor(COULEUR_NORMALE)     //Remettre la couleur du bouton à mauve
            btn.isClickable = true          //activer le bouton lorsque la partie est recommencée
        }
    }


    fun afficherScore(score : Int){
        tvScore.text = score.toString()
    }

    fun afficherSouligné(){
       tvMot.text = présentateur.motSouligné
    }

    /**
     * Affiche un message à l'utilisateur lorsqu'il perd
     * @param mot le mot à deviner
     */
    fun afficherPerte(mot : String){
        tvMot.text = "VOUS AVEZ PERDU! LE MOT ÉTAIT: " + mot
        tvMot.setTextColor(Color.RED)
    }

    /**
     * Affiche un message à l'utilisateur lorsqu'il gagne
     *
     */
    fun afficherGagné(){
        tvMot.text = "BRAVO! VOUS AVEZ GAGNÉ!!"
        tvMot.setTextColor(Color.GREEN)
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
