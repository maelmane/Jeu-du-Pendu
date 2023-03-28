package dti.g25.pendu.modèle

class Jeu(listeDeMots : Array<String>) {
    var pointage : Int = 0
    var nbErreurs : Int = 0
    lateinit private var lettresEssayées : CharArray
    private var motÀDeviner : String
    lateinit var mots : Array<String>


    init {
        mots = listeDeMots
        if (mots.isEmpty()){
            throw IllegalArgumentException("La liste de mots est vide")
        }
        motÀDeviner = sélectionnerProchainMot()
    }


    /**
     * Sélectionne au hasard le prochain mot à deviner
     *
     * @return un mot sélectionné au hasard
     */
    fun sélectionnerProchainMot() : String {
        var numéroAléatoire = kotlin.random.Random.nextInt(mots.size)
        var prochainMot = mots[numéroAléatoire]
        return prochainMot
    }


    /**
     * vérifie si une lettre essayée se trouve dans le mot
     * à deviner et ajuste les propriétés
     *
     * @param lettre la lettre essayée
     *
     * @return vrai si et seulement si la lettre essayée se trouve dans le mot à deviner
     */
    fun essayerUneLettre(lettre : Char) : Boolean{
        //Ajouter la lettre essayée à la liste de lettres essayées
        lettresEssayées += lettre

        //Liste des lettres dans le mot à deviner
        var lettresMotÀDeviner : CharArray = motÀDeviner.toCharArray()

        //Booléen vérifiant si la lettre essayée est dans le mot
        var estDansLeMot = false

        for (l in lettresMotÀDeviner){
            if (lettre == l){
                estDansLeMot = true
            }
        }
        if(estDansLeMot){
            pointage++
            return true
        }else{
            nbErreurs++
            return false
        }
    }


    /**
     * @return vrai si et seulement si toutes les lettres du mot ont été découvertes
     */
    fun estRéussi() : Boolean{
        return false
    }


    /**
     * Réinitialise le jeu
     */
    fun réinitialiser(){
        pointage = 0
        nbErreurs = 0
        motÀDeviner = sélectionnerProchainMot()
    }
}