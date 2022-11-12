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
        for (int i = 1, k =0; i<=nombreLigne; i++, k++){
        if(i<= 9){
            System.out.print(" "+i);
        }
        if(i > 9){
            System.out.print(i);
        }

            for (int j = 1;j<=nombreColonne; j++){

                System.out.print(" - ");

            }
            System.out.println("");

            //System.out.print(1);
        }

        /*for (int i=0; i<nombreLigne; ++i) {

            for (int j = 0; j < nombreColonne; j++) {
                //System.out.println(j+1);

                if(plateau[i][j].estVivant){
                    //System.out.print(" | X ");
                    //plateau [i][j] = plateau[i][j].;
                }else{
                    System.out.println(i+1);
                    System.out.print(" | ");
                }
            }
            System.out.println("");
        }*/


    }
}


