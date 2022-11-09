import java.util.ArrayList;
import java.util.List;

public class Plateau {

    // attributs
    private int nombreLigne;
    private int nombreColonne;
    private Navire [] [] plateau;


    // Constructeur
    public Plateau (int a, int o) {
        nombreLigne = a;
        nombreColonne = o;
        plateau = new Navire[nombreLigne][nombreColonne];

        for (int i = 0; i<nombreLigne; i++) {
            for (int j=0; j<nombreColonne; j++) {
                plateau [i][j] = new Navire(false);
            }
        }
    }
    public void afficher () {
        System.out.println();
        for (int i=0; i<nombreLigne; i++) {
            for (int j = 0; j < nombreColonne; j++) {

                if(plateau[i][j].estVivant){
                    System.out.print(" | X ");
                }else{
                    System.out.print(" | ");
                }
            }
            System.out.println("");
        }
        System.out.println();



    }
}


