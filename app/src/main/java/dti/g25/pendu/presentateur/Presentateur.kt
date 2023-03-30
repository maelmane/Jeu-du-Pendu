package dti.g25.pendu.presentateur

import dti.g25.pendu.MainActivity
import dti.g25.pendu.modèle.Jeu

class Presentateur(var vue: MainActivity) {

    //Mots à deviner
    val mot1 = "MONSTRE"
    val mot2 = "TAILLE"
    val mot3 = "PALOURDE"
    val mot4 = "ROUTE"
    val mot5 = "TATOUAGE"
    val mot6 = "AUBERGINE"
    val mot7 = "ADMINISTRATION"
    val mot8 = "CONVERTIR"
    val mot9 = "REPUBLIQUE"
    val mot10 = "VERDICT"

    //Liste de mots à deviner
    val listeDeMots : Array<String> = arrayOf(mot1, mot2, mot3, mot4, mot5, mot6, mot7, mot8, mot9, mot10)

    val jeu = Jeu(listeDeMots)

    fun sélectionnerLettre(lettre: Char) {
        //Désactiver la lettre avec la vue
        vue.désactiverLettreUtilisée(lettre)
        var bonneLettre = jeu.essayerUneLettre(lettre)
        if (!bonneLettre){
            //
        }
        //Désactiver le boutton de la lettre
    }

    fun démarrer(){
        vue.afficherImageErreur0()
        jeu.réinitialiser()
    }
}