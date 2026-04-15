// VOUS POUVEZ MODIFIER CE FICHIER

import java.util.Arrays;

public class Mot {
    private char[] lettres;
    private int nbLettres;

    public Mot suivant = null;

    public Mot() {
        lettres = new char[0];
        nbLettres = 0;
    }

    public Mot(String str) {
        assert str.indexOf(' ') == -1 : "Un mot ne peut contenir d'espaces";
        lettres = str.toCharArray();
        nbLettres = str.length();
    }

    // AJOUTEZ VOTRE CODE CI-DESSOUS
    @Override
    public String toString() {
        return new String(lettres, 0, nbLettres);
    }
    public int getLongueur(){
        return nbLettres;
    }
    public char getLettre(int index) {
        if(index < 0){
            return 0;
        }
        return lettres[index];
    }
    public void ajouter(char lettre){
        if(nbLettres == lettres.length){
            agrandir();
            lettres[nbLettres] = lettre;
            nbLettres++;
        }
    }
    private void agrandir(){
       int taillenouvelle = nbLettres * 2 + 1;
       char[] tabtemp = new char[taillenouvelle];
        for (int i = 0; i < nbLettres; i++) {
            tabtemp[i] = lettres[i];
        }
        lettres = tabtemp;
    }

    public boolean inserer(char lettre, int index){
        if(nbLettres == lettres.length) {
            agrandir();
        }
        if(index >= 0 && index <= lettres.length){
            for (int i = nbLettres; i > index ; i--) {
                lettres[i] = lettres[i - 1];
            }
            lettres[index] = lettre;
            nbLettres++;
            return true;
        }
        return false;
    }
}
