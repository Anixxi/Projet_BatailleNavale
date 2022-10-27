
public abstract class Navire implements INavire{

    protected boolean estVivant; //private?
    
    protected boolean navireABouger;
    
    protected int taille;
    
    protected String nom;
    
    protected final Object objectPartage;

    protected int impacte;


    protected Navire(Object object) {
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
