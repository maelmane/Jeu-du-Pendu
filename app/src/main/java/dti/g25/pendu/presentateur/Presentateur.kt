package dti.g25.pendu.presentateur

import android.util.Log
import dti.g25.pendu.MainActivity
import dti.g25.pendu.modèle.Jeu

class Presentateur(var vue: MainActivity) {


    //Mots à deviner
    val mot1 = "MONSTRE".uppercase()
    val mot2 = "CHAT".uppercase()
    val mot3 = "PALOURDE".uppercase()
    val mot4 = "ROUTE".uppercase()
    val mot5 = "GESTUEL".uppercase()
    val mot6 = "POIL".uppercase()
    val mot7 = "ADMINISTRATION".uppercase()
    val mot8 = "CONVERTIR".uppercase()
    val mot9 = "REPUBLIQUE".uppercase()
    val mot10 = "VERDICT".uppercase()

    //Liste de mots à deviner
    val listeDeMots : Array<String> = arrayOf(mot1, mot2, mot3, mot4, mot5, mot6, mot7, mot8, mot9, mot10)



    val jeu = Jeu(listeDeMots)
    var motSouligné = ""

    /**
     * Réagit à la sélection par l’utilisateur d’une des lettres
     */
    fun sélectionnerLettre(lettre: Char) {
        //Désactiver la lettre avec la vue
        vue.désactiverLettreUtilisée(lettre)

        motSouligné = jeu.étatLettres()
        vue.afficherSouligné()

        var bonneLettre = jeu.essayerUneLettre(lettre)


        if(!bonneLettre){   //Si Mauvaise Lettre
            when (jeu.nbErreurs){
                1 -> vue.afficherImageErreur1()
                2 -> vue.afficherImageErreur2()
                3 -> vue.afficherImageErreur3()
                4 -> vue.afficherImageErreur4()
                5 -> vue.afficherImageErreur5()
                6 -> {  //Jeu Perdu
                    vue.afficherImageErreur6()
                    vue.afficherPerte(jeu.motÀDeviner)
                }
            }
        }
        vue.afficherScore(jeu.pointage)

        //Si le jeu est gagné
        if (jeu.estRéussi()){
            vue.afficherGagné()
        }
    }

    /**
     * Démarre le jeu
     */
    fun démarrer(){
        jeu.réinitialiser()
        motSouligné = jeu.étatLettres()
        vue.afficherImageErreur0()
        vue.réactiverLettres(jeu.lettresÀRéactiver)
        jeu.étatLettres()
        vue.afficherSouligné()    //Mettre fonction état de lettre??
        vue.afficherScore(jeu.pointage)
    }
}