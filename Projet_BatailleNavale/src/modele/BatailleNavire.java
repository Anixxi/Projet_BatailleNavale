package modele;

import java.util.Random;

/**
 * Cette classe simule une bataille navale avec 2 joueurs.
 * Le joueur 1 est un humain
 * Le joueur 2 peut etre soit un joueur 2 soit une IA
 * @author Kichoir, Thanujan, Sofiane, Amudhan
 */

public class BatailleNavire {
    private Joueur p1; // Joueur Humain
    private Joueur p2; // Adversaire ou IA

    /**
     * Constructeur pour creer 2 classes joueur
     */
    public BatailleNavire() {
        p1 = new Joueur();
        p2 = new Joueur();
    }

    /**
     * C'est le tir precis : il touche les coordonnees exactes donnees
     * Les 2 plateaux sont mis à jour en fonction des tirs
     * @param x x coordonnee pour le tir
     * @param y y coordonnee pour le tir
     * @param numJoueur numero du joueur (1 ou 2)
     * @return Statue du tir | 1: touche   0: pas touche   -1: Unknown shot(This never happens anyway...)
     */
    public int tirPrecis(int x, int y, int numJoueur) { //1: touche | 0: pas touche
        if (numJoueur == 1) {
            boolean estNavire = p2.getPlateauxJoueur().estNavire(x, y);
            p1.getPlateauxJoueur().tir(x, y, estNavire);
            if (estNavire) {
                p1.getPlateauxJoueur().setPlateauJoueur(x, y, 1);
                p2.getPlateauxJoueur().setPlateauJoueur(x, y, 1);
                return 1;
            } else {
                p1.getPlateauxJoueur().setPlateauJoueur(x, y, 0);
                p2.getPlateauxJoueur().setPlateauJoueur(x, y, 2); //tir raté
                return 0;
            }
        } else if (numJoueur == 2) {
            boolean estNavire = p1.getPlateauxJoueur().estNavire(x, y);
            p2.getPlateauxJoueur().tir(x, y, estNavire);
            if (estNavire) {
                p2.getPlateauxJoueur().setPlateauJoueur(x, y, 1);
                p1.getPlateauxJoueur().setPlateauJoueur(x, y, 1);
                return 1;
            } else {
                p2.getPlateauxJoueur().setPlateauJoueur(x, y, 0);
                p1.getPlateauxJoueur().setPlateauJoueur(x, y, 2); //tir raté
                return 0;
            }
        }
        return -1;
    }

    /**
     * This is the lossy shot, it can hit either the exact coordinate or other 8 neighborhoods
     * @param x x coordonnee donnee
     * @param y y coordonnee donnee
     * @param numJoueur numero du joueur (1 ou 2)
     * @return Statue du tir | 1: touche - 0: pas touche
     */
    public int tirJuge(int x, int y, int numJoueur) { //1: touche | 0: pas touche
        Random random = new Random();
        int a = random.nextInt(3) - 1; //{-1,0,1}
        int b = random.nextInt(3) - 1; //{-1,0,1}
        while (!tirPossible(x + a, y + b, numJoueur)) { // Si le tir n'est pas disponible, générez une autre coordonnée aléatoire parmi 8 quartiers ou la coordonnée exacte donnée.
            a = random.nextInt(3) - 1;
            b = random.nextInt(3) - 1;
        }
        return tirPrecis(x + a, y + b, numJoueur); //Tire avec précision aux coordonnées exactes choisies ou dans 8 autres quartiers.
    }

    /**
     * Calls either accurate shot or lossy shot
     * @param x x coordonnee pour le tir
     * @param y y coordonnee pour le tir
     * @param numJoueur numero du joueur (1 ou 2)
     * @param styleTir (1: accurate shot | 2: lossy shot)
     * @return Statue du tir | 1: touche | 0: pas touche | -1: Unknown(It'll never happen anyway...)
     */


    public int tir(int x, int y, int numJoueur, int styleTir) {//1: touche | 0: pas touche
        if (styleTir == 1) {
            return tirPrecis(x, y, numJoueur);
        } else if (styleTir == 2) {
            return tirJuge (x, y, numJoueur);
        }
        return -1;
    }

    /**
     * disponibilité des tirs
     * @param x x coordonnee de la coordonnee de tir choisi
     * @param y y coordonnee de la coordonnee de tir choisi
     * @param numJoueur numero du joueur (1 ou 2)
     * @return disponibilite des tirs : vrai: disponible | faux: pas disponible
     */

    public boolean tirPossible(int x, int y, int numJoueur) {
        if (x > 9 || x < 0 || y > 9 || y < 0) {
            return false;
        } else {
            if (numJoueur == 1) {
                if (p1.getPlateauxJoueur().getplateauAdversaire()[x][y] != -1)
                    return false;
                else
                    return true;
            } else if (numJoueur == 2) {
                if (p2.getPlateauxJoueur().getplateauAdversaire()[x][y] != -1)
                    return false;
                else
                    return true;

            }
        }
        return false;
    }

    /**
     * nombre total de coups nécessaires pour gagner = longueur totale des navires de l'adversaire
     * @param numJoueur numero du joueur (1 ou 2)
     * @return total des tirs réussis nécessaires pour gagner = longueur totale des navires de l'adversaire
     */
    public int tirsNecessairesPourGagner(int numJoueur) {
        int compteur = 0;
        if (numJoueur == 1) {
            for (int i = 0; i < 5; i++) {
                compteur += p2.getJoueurNavires()[i].getTaille();
            }
        } else if (numJoueur == 2) {
            for (int i = 0; i < 5; i++){
                compteur += p1.getJoueurNavires()[i].getTaille();
            }
        }
        return compteur;
    }

    /**
     * si le nombre total de coups réussis = le nombre total de coups nécessaires pour gagner : le joueur a gagné la partie !
     * @param numJoueur joueur 1 ou joueur 2
     * @param coupJoueur Tir du joueur réussi
     * @return Vrai : joueur gagne la partie | faux : le joueur a perdu
     */
    public boolean veriferVictoire(int numJoueur, int coupJoueur){//true: win | false: no win yet
        if(numJoueur == 1 && coupJoueur == tirsNecessairesPourGagner(numJoueur)){
            return true;
        }
        else if(numJoueur == 2 && coupJoueur == tirsNecessairesPourGagner(numJoueur)){
            return true;
        }
        else
            return false;
    }

    /**
     * Genere une longeur aleatoire pour un navire de l'IA
     * @return longueur aleatoire pour un navire de l'IA
     */
    public int tailleAleatoireNavire(){
        Random rand = new Random();
        return rand.nextInt(4)+2; //{2,3,4,5}
    }

    /**
     * Genere coordonnee aleatoire pour le tire de l'IA (pour x et y)
     * @return coordonnee aleatoire pour le tire de l'IA
     */
    public int coordonneesAleatoires(){
        Random rand = new Random();
        return rand.nextInt(10); //{0,1,...,9}
    }

    /**
     * Genere une direction aleatoire pour l'IA du navire (1:Horizontal | 0:Vertical}
     * @return direction aleatoire pour l'IA navire (1:Horizontal | 0:Vertical}
     */
    public int directionAleatoire(){
        Random rand = new Random();
        return rand.nextInt(2); //{0,1}
    }

    /**
     * Pour effacer l'ecran
     */
    public void effacerConsole() {
        System.out.flush();
        for (int i = 0; i < 60; i++) {
            System.out.println();
        }
        System.out.flush();
    }

    /* ***************************** ce sont les methodes GETTER ET SETTER **************************** */
    public Joueur getP1() {
        return p1;
    }

    public void setP1(Joueur p1) {
        this.p1 = p1;
    }

    public Joueur getP2() {
        return p2;
    }

    public void setP2(Joueur p2) {
        this.p2 = p2;
    }

}
