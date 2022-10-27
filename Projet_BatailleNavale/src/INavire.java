public interface INavire {

    public String getNom();

    public int getTaille();

    public boolean getStatus();

    public void setEstVivant(boolean estVivant); // a modif

    public void tirer(IPlateau plateau) throws Exception;

    public void tirerAleatoire(IPlateau plateau) throws Exception;


}
