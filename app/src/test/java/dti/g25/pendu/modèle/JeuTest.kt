package dti.g25.pendu.modèle

import junit.framework.TestCase.assertEquals
import org.junit.Test


class JeuTest {
    val mot = "chat".uppercase()
    val listeDeMots : Array<String> = arrayOf(mot)

    @Test
    fun `Étant donné une lettre A , lorsqu'on essaye de la deviner dans le mot chat, on obtient true`(){
        //Mise en place
        val valeurSouhaitée = true
        var lettre = 'A'



        //Action
        var cobaye = Jeu(listeDeMots)
        var sortieObservée = cobaye.essayerUneLettre(lettre)

        //Vérification
        assertEquals(valeurSouhaitée, sortieObservée)
    }


    @Test
    fun `Étant donné une lettre B , lorsqu'on essaye de la deviner dans le mot chat, on obtient false`(){
        //Mise en place
        val valeurSouhaitée = false
        var lettre = 'B'



        //Action
        var cobaye = Jeu(listeDeMots)
        var sortieObservée = cobaye.essayerUneLettre(lettre)

        //Vérification
        assertEquals(valeurSouhaitée, sortieObservée)
    }

    @Test
    fun `Étant donné une liste de mots vide , lorsqu'on  débute le jeu, on obtient IllegalArgumentException("La liste de mots est vide")`(){
        //Mise en place
        val listeDeMotsVide : Array<String> = arrayOf()
        var sortieObservée : String? = ""


        //Action
        try {
            var cobaye = Jeu(listeDeMotsVide)
        }catch (e : IllegalArgumentException){
            sortieObservée = e.message
        }

        //Vérification
        assertEquals("La liste de mots est vide", sortieObservée)
    }


    @Test
    fun `Étant donné les lettres essayées sont 'T' et 'H' pour le mot à deviner "chat", lorsqu'on visualise l'état des lettres, on obtient "_ H _ T "`(){
        //Mise en place
        val valeurSouhaitée = "_ H _ T "
        var lettre1 = 'T'
        var lettre2 = 'H'



        //Action
        var cobaye = Jeu(listeDeMots)
        cobaye.essayerUneLettre(lettre1)
        cobaye.essayerUneLettre(lettre2)
        var sortieObservée = cobaye.étatLettres()

        //Vérification
        assertEquals(valeurSouhaitée, sortieObservée)
    }


    @Test
    fun `Étant donné les lettres essayées sont 'V' et 'W' pour le mot à deviner "chat", lorsqu'on visualise l'état des lettres, on obtient "_ _ _ _ "`(){
        //Mise en place
        val valeurSouhaitée = "_ _ _ _ "
        var lettre1 = 'V'
        var lettre2 = 'W'



        //Action
        var cobaye = Jeu(listeDeMots)
        cobaye.essayerUneLettre(lettre1)
        cobaye.essayerUneLettre(lettre2)
        var sortieObservée = cobaye.étatLettres()

        //Vérification
        assertEquals(valeurSouhaitée, sortieObservée)
    }

    @Test
    fun `Étant donné les lettres essayées sont 'A' et 'W' pour le mot à deviner "chat", lorsqu'on visualise l'état des lettres, on obtient "_ _ A _ "`(){
        //Mise en place
        val valeurSouhaitée = "_ _ A _ "
        var lettre1 = 'A'
        var lettre2 = 'W'



        //Action
        var cobaye = Jeu(listeDeMots)
        cobaye.essayerUneLettre(lettre1)
        cobaye.essayerUneLettre(lettre2)
        var sortieObservée = cobaye.étatLettres()

        //Vérification
        assertEquals(valeurSouhaitée, sortieObservée)
    }
}