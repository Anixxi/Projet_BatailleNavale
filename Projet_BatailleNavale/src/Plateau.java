import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private int nbCase = 15;
    private int ligne = 15;
    //private String grille = "|   "; //la case
    //private String bateau = "| b ";

    //private List [] grandTab; // faire un tableau qui contient des tab => grandTab(le plateau) | 15 petits tableau qui représente une ligne chaque
    ArrayList<Integer> grandTab = new ArrayList<Integer>();


    //private ligneGrille char[] = [];
    protected int posBateau;
    int pos = 0;


    public Plateau(){

    }
    public Plateau(Object o){
        Navire croiseur = new Croiseur(o);
        Navire destroyer = new Destroyer(o);
        Navire cuirasse = new Cuirasse(o);
    }

    public String getPlateau(){
        for(int j = 0; j < ligne ; j++){
            //for(int i = 0 ; i<= nbCase; i++){System.out.print(grille);};
            System.out.print('\n');
        }
        return null;
    }


    public void remplirTab(){
        for(int i = 0 ; i < 15 ; i++){
            System.out.println(i);
            this.grandTab.get(i).add(i);
        }
    }


    public void setPosBateau(int posBateau){
        this.posBateau = posBateau;
    }
    public List[] putBateau(int posBateau){ //peut être séparer les méthodes ?? 1) affichage 2)incruste le bateau des qu'on est arrivé à la pos
        /***
        this.pos = 0;
        int tailleBateau = 9;
        setPosBateau(posBateau);
        for(int j = 0; j < ligne ; j++){
            for(int i = 0 ; i<= nbCase; i++){
                if(this.pos == this.posBateau){
                    while(tailleBateau > 0){
                        System.out.print(bateau);
                        tailleBateau --;
                    }
                    i++;
                }else{
                    System.out.print(grille);
                }
                this.pos++;
            };
            System.out.print('\n');
        }
        return null;
         ***/
        remplirTab();
        System.out.println("affiche grandTab");
        toString();

        return null;
    }

    public String toString(){
        //String str = new String(this.grandTab);
        //System.out.println(str);
        System.out.println(this.grandTab);
        return null;
    }

}
