package dti.g25.pendu.modèle

class Jeu(listeDeMots : Array<String>) {
    var pointage : Int = 0
    var nbErreurs : Int = 0
    var lettresEssayées = charArrayOf()
    var motÀDeviner : String
    var mots : Array<String>

    init {
        mots = listeDeMots
        if (mots.isEmpty()){
            throw IllegalArgumentException("La liste de mots est vide")
        }
        motÀDeviner = sélectionnerProchainMot().uppercase()
    }


    /**
     * Sélectionne au hasard le prochain mot à deviner
     *
     * @return un mot sélectionné au hasard
     */
    fun sélectionnerProchainMot(): String {
        return mots.random()
    }


    /**
     * vérifie si une lettre essayée se trouve dans le mot
     * à deviner et ajuste les propriétés pointage et nbErreurs
     *
     * @param lettre la lettre essayée
     *
     * @return vrai si et seulement si la lettre essayée se trouve dans le mot à deviner
     */
    fun essayerUneLettre(lettre : Char) : Boolean {
        lettresEssayées += lettre

        var estDansLeMot = false

        for (l in motÀDeviner.toCharArray()) {
            if (lettre == l) {
                estDansLeMot = true
                pointage++
            }
        }
        if (!estDansLeMot) {
            nbErreurs++
        }
        return estDansLeMot
    }


    /**
     * @return vrai si et seulement si toutes les lettres du mot ont été découvertes
     */
    fun estRéussi() : Boolean {
        return pointage == motÀDeviner.length
    }

    /**
     * @return un tableau de caractères représentant chacun une lettre du mot à deviner par :
     *     - La lettre en question, en majuscule, si la lettre a été découverte
     *     - Le caractère souligné (_) si la lettre n’a pas été découverte
     *
     *     NE FONCTIONNE PAS COMME IL FAUT: LETTRE APPARAIT APRÈS AVOIR CLIQUER SUR UNE AUTRE LETTRE
     */
    fun étatLettres() : String {
        var caractèreSouligné = StringBuilder()

        for (l in motÀDeviner.toCharArray().indices) {
            caractèreSouligné.append('_')
            caractèreSouligné.append(' ')
            for(i in lettresEssayées.indices) {
                if (motÀDeviner.toCharArray()[l] == lettresEssayées[i]) {
                    caractèreSouligné[l*2] = lettresEssayées[i]
                }
            }
        }
        return caractèreSouligné.toString()
    }


    /**
     * Réinitialise le jeu
     */
    fun réinitialiser() {
        pointage = 0
        nbErreurs = 0
        motÀDeviner = sélectionnerProchainMot()
        lettresEssayées = charArrayOf()
    }
}