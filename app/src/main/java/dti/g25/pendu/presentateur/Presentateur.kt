package dti.g25.pendu.presentateur

import android.util.Log
import dti.g25.pendu.MainActivity
import dti.g25.pendu.modèle.Jeu

class Presentateur(var vue: MainActivity) {

    val listeDeMots = arrayOf("MONSTRE","CHAT","PALOURDE",
        "ROUTE","GESTUEL","POIL","ADMINISTRATION","CONVERTIR",
        "REPUBLIQUE","VERDICT" )

    val jeu = Jeu(listeDeMots)
    var motSouligné = ""

    /**
     * Réagit à la sélection par l’utilisateur d’une des lettres
     */
    fun sélectionnerLettre(lettre: Char) {
        vue.désactiverLettreUtilisée(lettre)
        motSouligné = jeu.étatLettres()
        vue.afficherSouligné()
        var bonneLettre = jeu.essayerUneLettre(lettre)

        if (!bonneLettre)  {
            when (jeu.nbErreurs) {
                1 -> vue.afficherImageErreur1()
                2 -> vue.afficherImageErreur2()
                3 -> vue.afficherImageErreur3()
                4 -> vue.afficherImageErreur4()
                5 -> vue.afficherImageErreur5()
                6 -> {
                    vue.afficherImageErreur6()
                    vue.afficherPerte(jeu.motÀDeviner)
                }
            }
        }
        vue.afficherScore(jeu.pointage)

        if (jeu.estRéussi()) {
            vue.afficherGagné()
        }
    }

    /**
     * Démarre le jeu
     */
    fun démarrer() {
        vue.réactiverLettres(jeu.lettresEssayées)
        jeu.réinitialiser()
        motSouligné = jeu.étatLettres()
        vue.afficherImageErreur0()
        jeu.étatLettres()
        vue.afficherSouligné()
        vue.afficherScore(jeu.pointage)
    }
}