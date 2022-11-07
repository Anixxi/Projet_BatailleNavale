
public class Navire implements INavire{

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

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public int getTaille() {
        return this.taille;
    }

    @Override
    public boolean getStatus() {
        return this.estVivant;
    }

    @Override
    public void setEstVivant(boolean estVivant) {
        this.estVivant = estVivant;
    }

    @Override
    public void tirer(IPlateau plateau) throws Exception {
        System.out.println("En attente de tir pour le " + this.getNom()); //modif

    }

    @Override
    public void tirerAleatoire(IPlateau plateau) throws Exception {
        System.out.println("tire random");
    }
}
