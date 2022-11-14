import java.util.Scanner;

public class Menu {
    
    //private final Object objet;
    
    private 


    public void createMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez une option : ");
        System.out.print("1.  JOUER UNE PARTIE   ");
        System.out.print("2.  CHARGER UNE PARTIE \n");
        System.out.print("3.  AIDES   ");
        System.out.print("4.  QUITTER \n");
        jouer();
        //int mode = scanner.nextInt();
        // if(mode == 1){
        //     jouer();
        // } else if (mode == 2) {
        //     charger();
        // } else if (mode == 3) {
        //     aides();
        // }else{
        //     quitter();
        // }
    }
    public void jouer(){
        System.out.println("Le jeu commence ! ");
        Plateau p1 = new Plateau(15,15);
        p1.afficher();

        for (int i=0;i<=15; i++){

            if(i<=9){
            System.out.print(i+"  ");
            }
            if(i>9){
           System.out.print(i+" ");

            }

           // System.out.print(i+"  ");

        }
        //placerNavireAlea();
        //p.putBateau(165);
    }

    private void placerNavireAlea(Object objet) {
        cuirasseJoueur = new Cuirasse(objet);
        
        




        for(int i = 0; i < 10; i++){
            
        }
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
