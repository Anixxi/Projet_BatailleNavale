package modele;

/**
 * Cette classe simule un navire
 * @author Kichoir, Thanujan, Sofiane, Amudhan
 */
public class Navire {
    private int angleStatut; //1: horizontal | 0: vertical
    private int lignes;
    private int cols;
    private int pointDepartX;
    private int pointDepartY;
    private int taille;

    private String typeNavire;



    /**
     * Définit le statut de l'angle et la taille à zéro par défaut. Cela va changer plus tard
     */
    public Navire() {
        angleStatut = 0;
        taille = 0;
    }

    /*************************** LES MÉTHODES GETTER ET SETTER ************************/
    public int getangleStatut() {
        return angleStatut;
    }

    public void setangleStatut(int angleStatut) {
        this.angleStatut = angleStatut;
    }

    public int getlignes() {
        return lignes;
    }

    public void setlignes(int lignes) {
        this.lignes = lignes;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getpointDepartX() {
        return pointDepartX;
    }

    public int getpointDepartY() {
        return pointDepartY;
    }
    /*************************** MÉTHODES GETTER ET SETTER ************************/


    /**
     * Récupère la taille du navire et définit le nombre de colonnes et de lignes du navire en fonction de l'état de l'angle.
     * @param num Est la taille du navire donnée par l'utilisateur, peut être comprise entre {2,3,4,5}.
     */
    public void setColsOrlignes(int num) {
        if (angleStatut == 0) { //Si le navire est vertical
            lignes = 1;
            cols = num;
            taille = num;
        } else if (angleStatut == 1) {//Si le navire est horizontal
            lignes = num;
            cols = 1;
            taille = num;
        }
    }

    /**
     * Définit le point de départ du vaisseau (Coordonnées de l'extrême gauche pour le vaisseau horizontal | L'extrême haut pour le vaisseau vertical)
     * @param x x coordonnée du lieu de départ
     * @param y coordonnée y du lieu de départ
     */
    public void pointDepartNavire(int x, int y) {
        this.pointDepartX = x;
        this.pointDepartY = y;
    }

    /**
     *
     * @return taille du navire
     */
    public int getTaille() {
        return taille;
    }
}
