package modele;

import vue.Plateau;

/**
 * Cette classe simule un joueur dans le jeu
 * @author Kichoir, Thanujan, Sofiane, Amudhan
 */
public class Joueur {
    private Plateau plateauJoueur; //Chaque joueur a un plateau de joueur et un plateau d'adversaire.
    private Navire[] joueurNavires; //Chaque joueur a 5 navires

    /**
     * Crée un nouvel objet plateau pour le joueur (chaque plateau a 2 pièces : le plateau du joueur et le plateau de l'adversaire).
     * 5 navires à placer pour le joueur
     * Initialise le plateau du joueur avec des espaces vides dans son plateau (aucun navire n'est situé pour le moment).
     */
    public Joueur() {
        plateauJoueur = new Plateau();
        joueurNavires = new Navire[5];
        for (int i = 0; i < 5; i++) {
            joueurNavires[i] = new Navire();
        }
        plateauJoueur.initPlateau();
    }

    /**
     *
     * @param angleStatut Statut de l'angle pour le navire sélectionné (0 : vertical | 1 : horizontal)
     * @param taille taille du navire choisi
     * @param tailleNavire Numéro de navire Peut être parmi {0,1,2,3,4}
     */
    public void choixNavire(int angleStatut, int taille, int tailleNavire) {
        joueurNavires[tailleNavire].setangleStatut(angleStatut); //Définit le statut de l'angle pour le navire choisi
        joueurNavires[tailleNavire].setColsOrlignes(taille); //Set soit des colonnes ou des lignes pour le navire selon l'état de l'angle
    }

    /**
     * Place le navire choisi sur le plateau du joueur.
     * @param tailleNavire est le numéro du navire choisi. Il peut être compris entre {0,1,2,3,4}.
     */
    public void placementNavires(int tailleNavire) {
        for (int i = joueurNavires[tailleNavire].getpointDepartX(); i < joueurNavires[tailleNavire].getCols() + joueurNavires[tailleNavire].getpointDepartX(); i++) {
            for (int j = joueurNavires[tailleNavire].getpointDepartY(); j < joueurNavires[tailleNavire].getlignes() + joueurNavires[tailleNavire].getpointDepartY(); j++) {
                plateauJoueur.placerNavires(i, j); //Met 0 dans la coordonnée donnée, ce qui signifie qu'il y a un navire sur le plateau.
            }
        }
    }

    /**
     * Vérifier s'il est possible de placer un navire aux coordonnées données ou non
     * @param x coordonnée x
     * @param y coordonnée y
     * @param tailleNavire Numéro du navire que nous voulons vérifier s'il est possible de le placer aux coordonnées données.
     * Retourne true : Il est possible de placer le vaisseau aux coordonnées données | false : Il n'est pas possible de placer le navire aux coordonnées données.
     */
    public boolean checkAvailable(int x, int y, int tailleNavire) {
        for (int i = joueurNavires[tailleNavire].getpointDepartX(); i < joueurNavires[tailleNavire].getCols() + joueurNavires[tailleNavire].getpointDepartX(); i++) {
            for (int j = joueurNavires[tailleNavire].getpointDepartY(); j < joueurNavires[tailleNavire].getlignes() + joueurNavires[tailleNavire].getpointDepartY(); j++) {
                if (i > 9 || i < 0 || j > 9 || j < 0 || plateauJoueur.getPlateauJoueur()[i][j] != -1 ) //Si les coordonnées ne sont pas situées dans le tableau ou si un navire se trouve déjà à l'endroit des coordonnées données, il n'est pas possible d'y placer le navire.
                    return false;
            }
        }
        return true;
    }

    /******************** METHODS GETTER ***************************/
    public void afficherPlateauJoueur() {
        plateauJoueur.afficherPlateauxJoueur();
    }

    public void afficherPlateauAdversaire() {
        plateauJoueur.afficherPlateauAdversaire();
    }

    public Plateau getPlateauxJoueur() {
        return plateauJoueur;
    }

    public Navire[] getJoueurNavires() {
        return joueurNavires;
    }
}
