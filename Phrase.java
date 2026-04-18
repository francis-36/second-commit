// VOUS POUVEZ MODIFIER CE FICHIER

public class Phrase {
    private Mot premier, dernier;
    private int nbMots;
    private Mot [] mots;

    public Phrase() {
        // N'hésitez pas à modifier ce constructeur au besoin.
        // Vos changements seront automatiquement appliqués au constructeur ci-dessous.
        premier = dernier = null;
        nbMots = 0;
        mots = new Mot[10];
    }

    public Phrase(String str) {
        // Cette fonction initialise la phrase en ajoutant chaque mot de 'str' un par un.
        // Vous devrez coder la méthode ajouter(Mot mot) pour que cela fonctionne.
        this();
        String[] mots = str.split("\s");
        for (String mot : mots)
            ajouter(new Mot(mot));
    }

    @Override
    public String toString() { // c'est rare que j'écris des commentaires mais j'en ai vraiment besoin mtn
        String phrase = ""; // étape 1: je crée une chaine vide qui va stocké ma phrase
        for (int i = 0; i < nbMots; i++) { // étape 2: je parcours mon tableau ça ce voit mais je dis qd mm
            phrase += mots[i];         // étape 3: on ajoute chaque mots trouvé à la phrase
            if(i < nbMots - 1) {        // étape 4: si la valeur i (le chiffre) est inférieur à nbMots (le nombre de mots) on éxécute le -1 sert juste a ne pas mettre un espace en trop a la fin
                phrase += " ";  // étape 5: on ajoute l'espace après chaque mot ajouté a l'étape 3;
            }
        }
        return phrase;
    }

    public int getNbMots(){
        return nbMots;
    }

    public int getLongueur(){
        return this.toString().length();
    }

    public Mot getMot (int indexMot){
        if(indexMot >= 0 && indexMot < nbMots){
            return mots[indexMot];
        }
        return null;
    }

    public char getLettre(int indexMot, int indexLettre){
        if(indexMot >= 0 && indexMot < nbMots){
           Mot mots = getMot(indexMot);
           if(indexLettre >= 0 && indexLettre < mots.getNbLettres()){
               return mots.getLettre(indexLettre);
           }
        }
            return (char)0;
    }

    public char getLettre(int indexLettre){
        int compteur = 0;
        for (int i = 0; i < nbMots; i++) {
            Mot mots = getMot(i);
            for (int j = 0; j < mots.getNbLettres(); j++) {
                if(compteur == indexLettre){
                    return mots.getLettre(j);
                }
                compteur++;
            }
            if (i < nbMots - 1){
                if(compteur == indexLettre){
                    return ' ';
                }
                compteur++;
            }
        }

        return (char) 0;
    }

    public void ajouter(String str) {
        ajouter(new Phrase(str));
    }

    public boolean inserer(String str, int indexMot) {
        return inserer(new Phrase(str), indexMot);
    }

    // AJOUTEZ VOTRE CODE CI-DESSOUS
    public void ajouter(char c){
        Mot mots = getMot(nbMots - 1);
        mots.ajouter(c);
    }

    public void ajouter(Mot mot) {
        // Codez-moi!
        if(nbMots >= mots.length){
            Mot[] motagrandit = new Mot[mots.length * 2];
            for (int i = 0; i < mots.length; i++) {
                motagrandit[i] = mots[i];
            }
            mots = motagrandit;
        }
        mots[nbMots] = mot;
        nbMots++;
    }

    public void ajouter(Phrase autre) {
        // Codez-moi!
    }

    public boolean inserer(Phrase autre, int indexMot) {
        // Codez-moi!
        return true;
    }
}
