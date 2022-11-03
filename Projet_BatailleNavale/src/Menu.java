import java.util.Scanner;

public class Menu {

    public void createMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez une option : ");
        System.out.print("1.  JOUER UNE PARTIE   ");
        System.out.print("2.  CHARGER UNE PARTIE \n");
        System.out.print("3.  AIDES   ");
        System.out.print("4.  QUITTER \n");
        int mode = scanner.nextInt();
        if(mode == 1){
            jouer();
        } else if (mode == 2) {
            charger();
        } else if (mode == 3) {
            aides();
        }else{
            quitter();
        }
    }
    public void jouer(){
        System.out.println("Le jeu commence ! ");
        Plateau p = new Plateau();
        //p.getPlateau();
        System.out.println("------------------------");
        p.putBateau(165);
    }

    public void charger(){
        System.out.println("Le jeu est chargé ! ");
    }

    public void aides(){
        System.out.println("Voici les aides : ");
    }

    public void quitter(){
        System.out.println("Vous quitter le jeu ! A bientôt !");
        return;
    }
}
