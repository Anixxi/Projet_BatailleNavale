import java.util.ArrayList;
import java.util.List;

public class Plateau {

    // attributs
    private int nombreLigne;
    private int nombreColonne;
    private INavire [] [] plateau;


    // Constructeur
    public Plateau (int a, int o) {
        nombreLigne = a;
        nombreColonne = o;
        plateau = new INavire[nombreLigne][nombreColonne];

        for (int i = 0; i<nombreLigne; i++) {
            for (int j=0; j<nombreColonne; j++) {
                plateau [i][j] = null;

            }
        }
    }
    public void afficher () {
        System.out.println();
        for (int i=0; i<nombreLigne; i++) {
            for (int j = 0; j < nombreColonne; j++) {

                System.out.print(" | " + plateau[i][j]);
            }
            System.out.println("|");
        }
        System.out.println();



    }
}


