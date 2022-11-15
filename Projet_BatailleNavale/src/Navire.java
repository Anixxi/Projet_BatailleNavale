
public abstract class Navire{

    protected boolean estVivant; //private?
    protected boolean navireABouger;
    protected int taille;
    protected String nom;
    public Object objectPartage;
    protected int impacte;
    protected int pointDeVie; //point de vie

    public Navire(){}

    public Navire(boolean vivant){
        this.estVivant = vivant;
    }
    public Navire(Object object) {
        objectPartage = object;
        this.estVivant = true;
    }

    public int getImpacte(){
        return impacte;
    }

    public boolean navireABouger() {
        return this.navireABouger;
    }

    public boolean setNavireBouger(boolean aBouger){
        return this.navireABouger = aBouger;
    }


}
