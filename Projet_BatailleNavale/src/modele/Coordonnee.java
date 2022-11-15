package modele;

public class Coordonnee {
    private int xCoordonnee;
    private int yCoordonnee;
    private boolean touche;
    private boolean navireDetruit;
    private String typeNavire;

    public Coordonnee(int x, int y, boolean touche, boolean navireDetruit, String typeNavire){
        this.xCoordonnee=x;
        this.yCoordonnee=y;
        this.touche=touche;
        this.navireDetruit=navireDetruit;
        this.typeNavire=typeNavire;
    }

    public int getxCoordonnee() {
        return xCoordonnee;
    }

    public int getyCoordonnee() {
        return yCoordonnee;
    }

    public boolean isTouche() {
        return touche;
    }

    public boolean isNavireDetruit() {
        return navireDetruit;
    }

    public String getTypeNavire() {
        return typeNavire;
    }
}


