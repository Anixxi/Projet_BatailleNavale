package vue;


/**
 * Cette classe simule les plateaux de chaque joueur
 * @author Kichoir, Thanujan, Sofiane, Amudhan
 */
public class Plateau {
    private static final int lignes = 10;
    private static final int colonnes = 10;
    private int[][] plateauAdversaire;
    private int[][] plateauJoueur;

    /**
     * On realise 2 tableaux 2D pour le joueur et son adversaire
     */
    public Plateau() {
        plateauAdversaire = new int[lignes][colonnes];
        plateauJoueur = new int[lignes][colonnes];
    }
    /********** Methode GETTER **********/
    public static int getlignes() {
        return lignes;
    }

    public static int getcolonnes() {
        return colonnes;
    }

    /**
     * Initialise les tableaux du joueur et de l'adversaire avec -1 pour chaque
     */
    public void initPlateau() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                plateauAdversaire[i][j] = -1;
                plateauJoueur[i][j] = -1;
            }
        }
    }

    /**
     * Pour montrer le plateau de l'adversaire
     */
    public void afficherPlateauAdversaire() {
        System.out.println("  |\t0 |\t1 |\t2 |\t3 |\t4 |\t5 |\t6 |\t7 |\t8 |\t9 |");
        System.out.println("--|---+---+---+---+---+---+---+---+---+---|");

        for (int ligne = 0; ligne < lignes; ligne++) {
            System.out.print(ligne + " |");
            for (int colonne = 0; colonne < colonnes; colonne++) {
                if (plateauAdversaire[ligne][colonne] == -1) {
                    System.out.print("\t" + " ");
                } else if (plateauAdversaire[ligne][colonne] == 0) {
                    System.out.print("\t" + ConsoleCouleurs.BLUE_BACKGROUND_BRIGHT + "X" + ConsoleCouleurs.RESET); //raté
                } else if (plateauAdversaire[ligne][colonne] == 1) {
                    System.out.print("\t" + ConsoleCouleurs.RED_BACKGROUND_BRIGHT + "&" + ConsoleCouleurs.RESET); //touché
                }
                System.out.print(" |");
            }
            System.out.println();
            System.out.println("--|---+---+---+---+---+---+---+---+---+---|");
        }
    }

    /**
     * Pour montrer le plateau du joueur
     */
    public void afficherPlateauxJoueur() {
        System.out.println("  |\t0 |\t1 |\t2 |\t3 |\t4 |\t5 |\t6 |\t7 |\t8 |\t9 |");
        System.out.println("--|---+---+---+---+---+---+---+---+---+---|");

        for (int ligne = 0; ligne < lignes; ligne++) {
            System.out.print(ligne + " |");
            for (int colonne = 0; colonne < colonnes; colonne++) {
                if (plateauJoueur[ligne][colonne] == -1) {
                    System.out.print("\t" + " ");
                } else if (plateauJoueur[ligne][colonne] == 0) {
                    System.out.print("\t" + ConsoleCouleurs.GREEN_BACKGROUND + "@" + ConsoleCouleurs.RESET);
                } else if (plateauJoueur[ligne][colonne] == 1) {
                    System.out.print("\t" + ConsoleCouleurs.RED_BACKGROUND_BRIGHT + "#" + ConsoleCouleurs.RESET);
                } else if (plateauJoueur[ligne][colonne] == 2) {
                    System.out.print("\t" + ConsoleCouleurs.YELLOW_BACKGROUND + "." + ConsoleCouleurs.RESET);
                }
                System.out.print(" |");
            }
            System.out.println();
            System.out.println("--|---+---+---+---+---+---+---+---+---+---|");
        }
    }

    /**
     *
     * @param x x coordonnee
     * @param y y coordonnee
     * @return Vrai :  Il y a deja un navire aux coordonnées données | Faux : il n'y a pas de navire aux coordonnées données
     */

    //
    public boolean estNavire(int x, int y) {
        if (plateauJoueur[x][y] == 0)
            return true;
        else
            return false;
    }

    /**
     * Nous vérifions la disponibilité tirs avec la méthode de la classe BatailleNavale. S'il est disponible, nous tirons en utilisant cette méthode.
     * @param x x coordonnee pour le tir
     * @param y y coordonnee pour le tir
     * @param bool vrai : touche | faux: pas touche
     */
    public void tir(int x, int y, boolean bool) { //true: shot hit | false: no hit
        if (bool) {
            plateauAdversaire[x][y] = 1;
        } else {
            plateauAdversaire[x][y] = 0;
        }
    }


    /**
     * Place le navire sur le plateau du joueur
     * @param x x coordonnee du navire
     * @param y y coordonnee du navire
     */
    public void placerNavires(int x, int y) {
        plateauJoueur[x][y] = 0;
    }

    /* ********** THESE ARE GETTER AND SETTER METHODS ************* */
    public int[][] getplateauAdversaire() {
        return plateauAdversaire;
    }

    public void setplateauAdversaire(int x, int y, int statut) {
        this.plateauAdversaire[x][y] = statut;
    }

    public int[][] getPlateauJoueur() {
        return plateauJoueur;
    }

    public void setPlateauJoueur(int x, int y, int statut) {
        this.plateauJoueur[x][y] = statut;
    }
}


