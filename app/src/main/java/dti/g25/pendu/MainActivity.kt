package dti.g25.pendu

import android.app.AlertDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import dti.g25.pendu.presentateur.Presentateur
lateinit var imgPendu : ImageView

lateinit var tvScore : TextView

lateinit var btnRéinit : Button

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
        var idButton = v.id
        var btnCliqué : Button = findViewById(idButton)
        var lettreCliquée = btnCliqué.text.toString().first()

        présentateur.sélectionnerLettre(lettreCliquée)
    }

    /**
     * Recommence le jeu (quand le bouton Réinitialiser est cliqué)
     */
    fun rejouer(){
        afficherAlèrte()
        tvMot.setTextColor(Color.BLACK)
    }


    /**
     * Désactiver les boutons des lettres lorsqu'il sont cliqués
     */
    fun désactiverLettreUtilisée(lettre : Char) {
        val resID = getResources().getIdentifier("btn$lettre", "id", getPackageName());
        val btn : Button = findViewById(resID)
        btn.isEnabled = false
    }


    /**
     * Réactiver les boutons quand le jeu recommence
     *
     * @param lettres liste des lettres utilisées ou à réactiver
     */
    fun réactiverLettres(lettres : CharArray) {
        for (i in lettres.indices){
            var lettreBtn = lettres[i]
            var idBouton = getResources().getIdentifier("btn$lettreBtn", "id", getPackageName());
            var btn : Button = findViewById(idBouton)
            btn.isEnabled = true
        }
    }


    fun afficherScore(score : Int) {
        tvScore.text = score.toString()
    }

    fun afficherSouligné(){
       tvMot.text = présentateur.motSouligné
    }

    fun afficherAlèrte(){
        var alèrteBuilder = AlertDialog.Builder(this)
        alèrteBuilder.setMessage(R.string.alèrte_message).setCancelable(false)
            .setPositiveButton(R.string.positive) {dialog, id -> présentateur.démarrer()}
            .setNegativeButton(R.string.negative) {dialog, id -> dialog.dismiss()}
        val alèrte = alèrteBuilder.create()
        alèrte.show()
    }

    /**
     * Affiche un message à l'utilisateur lorsqu'il perd
     * @param mot le mot à deviner
     */
    fun afficherPerte(mot : String) {
        tvMot.text = getResources().getString(R.string.jeu_perdu) + mot
        tvMot.setTextColor(Color.RED)
    }

    /**
     * Affiche un message à l'utilisateur lorsqu'il gagne
     *
     */
    fun afficherGagné() {
        tvMot.text = getResources().getString(R.string.jeu_gagné)
        tvMot.setTextColor(Color.GREEN)
    }


    fun afficherImageErreur0() {
        imgPendu.setImageResource(R.drawable.erreur0)
    }

    fun afficherImageErreur1() {
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
