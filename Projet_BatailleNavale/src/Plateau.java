public class Plateau {

    private int nbCase = 15;
    private int ligne = 15;
    private String grille = "|   "; //la case
    private String bateau = "| b ";
    protected int posBateau;
    int pos = 0;

    public Plateau(){    }

    public String getPlateau(){
        for(int j = 0; j < ligne ; j++){
            for(int i = 0 ; i<= nbCase; i++){System.out.print(grille);};
            System.out.print('\n');
        }
        return null;
    }

    public void setPosBateau(int posBateau){
        this.posBateau = posBateau;
    }
    public String putBateau(int posBateau){ //peut être séparer les méthodes ?? 1) affichage 2)incruste le bateau des qu'on est arrivé à la pos
        this.pos = 0;
        setPosBateau(posBateau);
        for(int j = 0; j < ligne ; j++){
            for(int i = 0 ; i<= nbCase; i++){
                if(this.pos == this.posBateau){
                    System.out.print(bateau);
                }else{
                    System.out.print(grille);
                }
                this.pos++;
            };
            System.out.print('\n');
        }
        return null;
    }

}
