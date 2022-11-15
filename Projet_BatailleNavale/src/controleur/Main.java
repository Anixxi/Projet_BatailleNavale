package controleur;

import modele.*;


import java.util.Scanner;

/**
 * controleur.Main Classe qui sert à lancer le jeu, c'est le controleur
 * @author Kichoir, Thanujan, Sofiane, Amudhan
 * @version 1.0.0
 */


public class Main {
    public static void main(String[] args) {
        BatailleNavire batailleNavire = new BatailleNavire();
        Scanner scannerOption = new Scanner(System.in);
        System.out.println("Yoooo, Choisissez une option : \n 1.  JOUER UNE PARTIE \n 2.  CHARGER UNE PARTIE \n 3.  AIDES \n 4.  QUITTER \n" );
        System.out.print("> : " );

        int option = scannerOption.nextInt();
        if (option == 4){
            System.out.println("A la prochaine, ciao");
            System.exit(0);
        }

        System.out.print("Bienvenue dans le jeu Bataille navalle! Choisissez un mode\n[1] Joueur vs Joueur\n[2] Joueur vs IA\n> ");


        Scanner scanner = new Scanner(System.in);
        String mode = scanner.nextLine();
        while (!mode.equals("1") && !mode.equals("2")) {
            System.out.print("Entrée erronée - Veuillez choisir entre 1 et 2 \n> ");
            mode = scanner.nextLine();
        }

        if (mode.equals("1")) {
            System.out.println("Le mode : Joueur vs Joueur est demarré!");
            System.out.println("Joueur 1: Placez vos navires:");
            //Sets the ships of player 1 on his board
            while (true) {
                for (int i = 0; i < 5; i++) {
                    System.out.print("\nChoissez la direction de votre navire :  " + (i + 1) + "\n[0] Verticale\n[1] Horizontale\n> ");
                    String direction = scanner.nextLine();

                    while (!direction.equals("0") && !direction.equals("1")) {
                        System.out.print(" Direction erronée du navire! Choisissez un chiffre entre [0] pour verticale et [1] pour Horizontale \n> ");
                        direction = scanner.nextLine();
                    }
                    System.out.print("\nChoisissez la taille du navire entre " + (i + 1) + ":\n[1-7]\n> ");

                    System.out.println("\nChoisissez votre bateau : ");
                    System.out.println("\n1. Croiseur");
                    System.out.println("\n2. Cuirassé");
                    System.out.println("\n3. Destroyer");
                    System.out.println("\n4. Sous-Marin");
                    String taille = scanner.nextLine();



                    while (!taille.equals("1") && !taille.equals("2") && !taille.equals("3") && !taille.equals("4")) {
                        System.out.print("Veuillez choisir une valeur entre [1-4]\n> ");
                        taille = scanner.nextLine();
                    }

                    if(taille.equals("1")){
                        taille = "5";
                    } else if (taille.equals("2")) {
                        taille = "7";
                    } else if (taille.equals("3")) {
                        taille = "3";
                    } else if (taille.equals("4")) {
                        taille = "1";
                    }

                    System.out.print("\nIndiquez les coordonnées X du navire : " + (i + 1) + " :\nX: ");
                    String x = scanner.nextLine();
                    System.out.print("Y: ");
                    String y = scanner.nextLine();
                    while ((!x.equals("0") && !x.equals("1") && !x.equals("2") && !x.equals("3") && !x.equals("4") && !x.equals("5") && !x.equals("6") && !x.equals("7") && !x.equals("8") && !x.equals("9")) ||
                            (!y.equals("0") && !y.equals("1") && !y.equals("2") && !y.equals("3") && !y.equals("4") && !y.equals("5") && !y.equals("6") && !y.equals("7") && !y.equals("8") && !y.equals("9"))) {
                        System.out.println("Les coordonnées sont erronées !");
                        System.out.print("\nIndiquez les coordonnées X du navire : " + (i + 1) + " :\nX: ");
                        x = scanner.nextLine();
                        System.out.print("Y: ");
                        y = scanner.nextLine();
                    }
                    batailleNavire.getP1().choixNavire(Integer.parseInt(direction), Integer.parseInt(taille), i);
                    batailleNavire.getP1().getJoueurNavires()[i].pointDepartNavire(Integer.parseInt(y), Integer.parseInt(x));
                    if (batailleNavire.getP1().checkAvailable(Integer.parseInt(y), Integer.parseInt(x), i)) {
                        batailleNavire.getP1().placementNavires(i);
                        batailleNavire.getP1().afficherPlateauJoueur();
                    } else {
                        System.out.println("Impossible de placer le navire sélectionné ! Vous devez à nouveau décrire l'emplacement du navire. Assurez-vous de choisir un endroit disponible");
                        i--;
                        batailleNavire.getP1().afficherPlateauJoueur();
                        continue;
                    }
                }

                System.out.print("Êtes-vous d'accord avec cette configuration ?\n[o] Oui, laissez-moi jouer!\n[n] non, laisse-moi remettre mes bateaux en place!\n> ");
                String choix = scanner.nextLine();
                while (!choix.equals("o") && !choix.equals("n")) {
                    System.out.print("Mauvaise réponse! Choissiez entre [o] ou [n] pour continuer\n> ");
                    choix = scanner.nextLine();
                }
                if (choix.equals("o")) {
                    batailleNavire.effacerConsole();
                    break;
                } else {
                    batailleNavire.getP1().getPlateauxJoueur().initPlateau();
                    batailleNavire.effacerConsole();
                    continue;
                }
            }

            // Sets player 2's ships on his board
            System.out.println("Joueur 2: Placez vos navires:");
            while (true) {
                for (int i = 0; i < 5; i++) {
                    System.out.print("\nChoissez la direction de votre navire : " + (i + 1) + ":\n[0] Verticale\n[1] Horizontale\n> ");
                    String direction = scanner.nextLine();
                    while (!direction.equals("0") && !direction.equals("1")) {
                        System.out.print("Direction eronnée du navire! Choissez entre [0] pour verticale et [1]Horizontale \n> ");
                        direction = scanner.nextLine();
                    }
                    System.out.print("\nChoissez la taille du navire entre  " + (i + 1) + ":\n[1-7]\n>");
                    String taille = scanner.nextLine();
                    while (!taille.equals("1") && !taille.equals("2") && !taille.equals("3") && !taille.equals("4") && !taille.equals("5") && !taille.equals("6") && !taille.equals("7")) {
                        System.out.print("Veuillez choisir une valeur entre [1-7]\n> ");
                        taille = scanner.nextLine();
                    }

                    System.out.print("\nIndiquez le coordonné X du navire : " + (i + 1) + " :\nX: ");
                    String x = scanner.nextLine();
                    System.out.print("Y: ");
                    String y = scanner.nextLine();
                    while ((!x.equals("0") && !x.equals("1") && !x.equals("2") && !x.equals("3") && !x.equals("4") && !x.equals("5") && !x.equals("6") && !x.equals("7") && !x.equals("8") && !x.equals("9")) ||
                            (!y.equals("0") && !y.equals("1") && !y.equals("2") && !y.equals("3") && !y.equals("4") && !y.equals("5") && !y.equals("6") && !y.equals("7") && !y.equals("8") && !y.equals("9"))) {
                        System.out.println("Les coordonnées sont erronées !");
                        System.out.print("\nIndiquez les coordonnées X du navire : " + (i + 1) + " :\nX: ");
                        x = scanner.nextLine();
                        System.out.print("Y: ");
                        y = scanner.nextLine();
                    }
                    batailleNavire.getP2().choixNavire(Integer.parseInt(direction), Integer.parseInt(taille), i);
                    batailleNavire.getP2().getJoueurNavires()[i].pointDepartNavire(Integer.parseInt(y), Integer.parseInt(x));
                    if (batailleNavire.getP2().checkAvailable(Integer.parseInt(y), Integer.parseInt(x), i)) {
                        batailleNavire.getP2().placementNavires(i);
                        batailleNavire.getP2().afficherPlateauJoueur();
                    } else {
                        System.out.println("Impossible de placer le navire sélectionné ! Vous devez à nouveau décrire l'emplacement du navire. Assurez-vous de choisir un endroit disponible");
                        i--;
                        batailleNavire.getP2().afficherPlateauJoueur();
                        continue;
                    }
                }
                System.out.print("Êtes-vous d'accord avec cette configuration ?\n[o] Oui, laissez-moi jouer!\n[n] non, laisse-moi remettre mes bateaux en place!\n> ");
                String choix = scanner.nextLine();
                while (!choix.equals("o") && !choix.equals("n")) {
                    System.out.print("Mauvaise reponse! Choissiez entre [o] ou [n] pour continuer\n> ");
                    choix = scanner.nextLine();
                }
                if (choix.equals("o")) {
                    batailleNavire.effacerConsole();
                    break;
                } else {
                    batailleNavire.getP2().getPlateauxJoueur().initPlateau();
                    batailleNavire.effacerConsole();
                    continue;
                }
            }
            batailleNavire.effacerConsole();
            System.out.println("Configuration du navire terminée. ");
            System.out.println("\nJ1: Veuillez choisir votre mode de tir:\n[1] tir precis\n[2] tir sans precision\n> ");
            String modeTirJoueur1 = scanner.nextLine();
            while (!modeTirJoueur1.equals("1") && !modeTirJoueur1.equals("2")) {
                System.out.print("Mauvaise entrée - Veuillez sélectionner un mode de tir\n> ");
                modeTirJoueur1 = scanner.nextLine();
            }
            batailleNavire.effacerConsole();
            System.out.println("\nJ2: Veuillez choisir votre mode de tir:\n[1] tir precis\n[2] tir sans precision\n> ");
            String modeTirJoueur2 = scanner.nextLine();
            while (!modeTirJoueur2.equals("1") && !modeTirJoueur2.equals("2")) {
                System.out.print("Mauvaise entrée - Veuillez sélectionner un mode de tir\n> ");
                modeTirJoueur2 = scanner.nextLine();
            }
            batailleNavire.effacerConsole();
            int continuerLesTirs = 1; // Si le joueur tir le bateau adversaire, il peut tirer encore une fois
            int Joueur1TirReussit= 0;
            int Joueur2TirReussit = 0;
            while (!batailleNavire.veriferVictoire(1, Joueur1TirReussit) && !batailleNavire.veriferVictoire(2, Joueur2TirReussit)) {
                //Shoting process for player 1
                System.out.println("C'est le tour du Joueur 1");
                System.out.println("Joueur 1, presser la touche C\n> ");
                String resume = scanner.nextLine();
                while (!resume.equals("c"))
                    resume = scanner.nextLine();
                System.out.println("Plateau du Joueur:");
                batailleNavire.getP1().getPlateauxJoueur().afficherPlateauxJoueur();
                System.out.println("Plateau de l'adversaire:");
                batailleNavire.getP1().getPlateauxJoueur().afficherPlateauAdversaire();
                continuerLesTirs = 1;
                while (continuerLesTirs == 1) {
                    continuerLesTirs = 0;
                    System.out.print("\n\nJoueur 1 : Entrez les coordonnées de tir :\nX: ");
                    String p1ShotX, p1ShotY;
                    p1ShotX = scanner.nextLine();
                    System.out.print("Y: ");
                    p1ShotY = scanner.nextLine();
                    while ((!p1ShotX.equals("0") && !p1ShotX.equals("1") && !p1ShotX.equals("2") && !p1ShotX.equals("3") && !p1ShotX.equals("4") && !p1ShotX.equals("5") && !p1ShotX.equals("6") && !p1ShotX.equals("7") && !p1ShotX.equals("8") && !p1ShotX.equals("9")) ||
                            (!p1ShotY.equals("0") && !p1ShotY.equals("1") && !p1ShotY.equals("2") && !p1ShotY.equals("3") && !p1ShotY.equals("4") && !p1ShotY.equals("5") && !p1ShotY.equals("6") && !p1ShotY.equals("7") && !p1ShotY.equals("8") && !p1ShotY.equals("9"))) {
                        System.out.print("\nCoordonnées invalides - Choisir d'autre coordonnées de tir :\nX: ");
                        p1ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p1ShotY = scanner.nextLine();
                    }
                    boolean p1ShotAvailablity = batailleNavire.tirPossible(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1);
                    while ((!p1ShotAvailablity) || ((!p1ShotX.equals("0") && !p1ShotX.equals("1") && !p1ShotX.equals("2") && !p1ShotX.equals("3") && !p1ShotX.equals("4") && !p1ShotX.equals("5") && !p1ShotX.equals("6") && !p1ShotX.equals("7") && !p1ShotX.equals("8") && !p1ShotX.equals("9")) ||
                            (!p1ShotY.equals("0") && !p1ShotY.equals("1") && !p1ShotY.equals("2") && !p1ShotY.equals("3") && !p1ShotY.equals("4") && !p1ShotY.equals("5") && !p1ShotY.equals("6") && !p1ShotY.equals("7") && !p1ShotY.equals("8") && !p1ShotY.equals("9")))) {
                        System.out.print("\nCoordonnées invalides - Choisir d'autre coordonnées de tir\nX: ");
                        p1ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p1ShotY = scanner.nextLine();
                        p1ShotAvailablity = batailleNavire.tirPossible(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1);
                    }
                    int tmp = batailleNavire.tir(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1, Integer.parseInt(modeTirJoueur1));
                    if (tmp == 1) {
                        Joueur1TirReussit++;
                        continuerLesTirs = 1;
                    } else
                        continuerLesTirs = 0;
                    if (batailleNavire.veriferVictoire(1, Joueur1TirReussit)) {
                        System.out.println("****Joueur 1 a gagné !****\n\n");
                        System.out.println("Plateau du Joueur 1:");
                        batailleNavire.getP1().getPlateauxJoueur().afficherPlateauxJoueur();
                        System.out.println("\nPlateau du Joueur 2:");
                        batailleNavire.getP2().getPlateauxJoueur().afficherPlateauxJoueur();
                        System.out.println("\n##Fin du G A M E##");
                        System.exit(0);
                    }
                    batailleNavire.getP1().getPlateauxJoueur().afficherPlateauAdversaire();
                    try { //Stop le processus pdt 1 sec pour que le joueur observe
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }

                //Shooting process P1 P2
                batailleNavire.effacerConsole();
                System.out.println("C'est le tour du Joueur 2");
                System.out.println("Joueur 2, presser la touche R\n> ");
                resume = scanner.nextLine();
                while (!resume.equals("r"))
                    resume = scanner.nextLine();
                System.out.println("Plateau du Joueur:");
                batailleNavire.getP2().getPlateauxJoueur().afficherPlateauxJoueur();
                System.out.println("Plateau de l'adversaire:");
                batailleNavire.getP2().getPlateauxJoueur().afficherPlateauAdversaire();
                continuerLesTirs = 1;
                while (continuerLesTirs == 1) {
                    continuerLesTirs = 0;
                    System.out.print("\n\nJoueur 1 : Entrez les coordonnées de tir :\nX: ");
                    String p2ShotX, p2ShotY;
                    p2ShotX = scanner.nextLine();
                    System.out.print("Y: ");
                    p2ShotY = scanner.nextLine();
                    while ((!p2ShotX.equals("0") && !p2ShotX.equals("1") && !p2ShotX.equals("2") && !p2ShotX.equals("3") && !p2ShotX.equals("4") && !p2ShotX.equals("5") && !p2ShotX.equals("6") && !p2ShotX.equals("7") && !p2ShotX.equals("8") && !p2ShotX.equals("9")) ||
                            (!p2ShotY.equals("0") && !p2ShotY.equals("1") && !p2ShotY.equals("2") && !p2ShotY.equals("3") && !p2ShotY.equals("4") && !p2ShotY.equals("5") && !p2ShotY.equals("6") && !p2ShotY.equals("7") && !p2ShotY.equals("8") && !p2ShotY.equals("9"))) {
                        System.out.print("\nCoordonnées invalides - Choisir d'autre coordonnées de tir :\nX: ");
                        p2ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p2ShotY = scanner.nextLine();
                    }
                    boolean p2ShotAvailablity = batailleNavire.tirPossible(Integer.parseInt(p2ShotY), Integer.parseInt(p2ShotX), 2);
                    while ((!p2ShotAvailablity) || ((!p2ShotX.equals("0") && !p2ShotX.equals("1") && !p2ShotX.equals("2") && !p2ShotX.equals("3") && !p2ShotX.equals("4") && !p2ShotX.equals("5") && !p2ShotX.equals("6") && !p2ShotX.equals("7") && !p2ShotX.equals("8") && !p2ShotX.equals("9")) ||
                            (!p2ShotY.equals("0") && !p2ShotY.equals("1") && !p2ShotY.equals("2") && !p2ShotY.equals("3") && !p2ShotY.equals("4") && !p2ShotY.equals("5") && !p2ShotY.equals("6") && !p2ShotY.equals("7") && !p2ShotY.equals("8") && !p2ShotY.equals("9")))) {
                        System.out.print("\nCoordonnées invalides - Choisir d'autre coordonnées de tir\nX: ");
                        p2ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p2ShotY = scanner.nextLine();
                        p2ShotAvailablity = batailleNavire.tirPossible(Integer.parseInt(p2ShotY), Integer.parseInt(p2ShotX), 2);
                    }
                    int tmp2 = batailleNavire.tir(Integer.parseInt(p2ShotY), Integer.parseInt(p2ShotX), 2, Integer.parseInt(modeTirJoueur2));
                    if (tmp2 == 1) {
                        continuerLesTirs = 1;
                        Joueur2TirReussit++;
                    } else
                        continuerLesTirs = 0;
                    if (batailleNavire.veriferVictoire(2, Joueur2TirReussit)) {
                        System.out.println("****Joueur 2 a gagné!****\n\n");
                        System.out.println("Plateau du Joueur 2:");
                        batailleNavire.getP1().getPlateauxJoueur().afficherPlateauxJoueur();
                        System.out.println("\nPlayer 2 board:");
                        batailleNavire.getP2().getPlateauxJoueur().afficherPlateauxJoueur();
                        System.out.println("\n##Fin du G A M E##");
                        System.exit(0);
                    }
                    batailleNavire.getP2().getPlateauxJoueur().afficherPlateauAdversaire();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }


        } else if (mode.equals("2")) {
            //The exact same process as PvP for Player 1, Player 2's process is replaced with random methods
            System.out.println("PvE battle is going to start!");
            System.out.println("Selectionner vos bateaux:");
            while (true) {
                for (int i = 0; i < 5; i++) {
                    System.out.print("\nBateau selectionné " + (i + 1) + " direction:\n[0] Verticale\n[1] Horizontale\n> ");
                    String direction = scanner.nextLine();
                    while (!direction.equals("0") && !direction.equals("1")) {
                        System.out.print("La direction n'est pas valide ! Rechoisissez une direction SVP\n> ");
                        direction = scanner.nextLine();
                    }
                    System.out.print("\nBateau selectionné " + (i + 1) + " longueur:\n[2-5]\n> ");
                    String len = scanner.nextLine();
                    while (!len.equals("2") && !len.equals("3") && !len.equals("4") && !len.equals("5")) {
                        System.out.print("Ship's length is not accepted! Select ship's length again\n> ");// chnanger la loing
                        len = scanner.nextLine();
                    }

                    System.out.print("\nBateau selectionné " + (i + 1) + " coordonnées:\nX: ");
                    String x = scanner.nextLine();
                    System.out.print("Y: ");
                    String y = scanner.nextLine();
                    while ((!x.equals("0") && !x.equals("1") && !x.equals("2") && !x.equals("3") && !x.equals("4") && !x.equals("5") && !x.equals("6") && !x.equals("7") && !x.equals("8") && !x.equals("9")) ||
                            (!y.equals("0") && !y.equals("1") && !y.equals("2") && !y.equals("3") && !y.equals("4") && !y.equals("5") && !y.equals("6") && !y.equals("7") && !y.equals("8") && !y.equals("9"))) {
                        System.out.println("Coordonnées invalides - Choisir de nouvelles coordonnées:");
                        System.out.print("\nBateau selectionné " + (i + 1) + " coordonnées:\nX: ");
                        x = scanner.nextLine();
                        System.out.print("Y: ");
                        y = scanner.nextLine();
                    }
                    batailleNavire.getP1().choixNavire(Integer.parseInt(direction), Integer.parseInt(len), i);
                    batailleNavire.getP1().getJoueurNavires()[i].pointDepartNavire(Integer.parseInt(y), Integer.parseInt(x));
                    if (batailleNavire.getP1().checkAvailable(Integer.parseInt(y), Integer.parseInt(x), i)) {
                        batailleNavire.getP1().placementNavires(i);
                        batailleNavire.getP1().afficherPlateauJoueur();
                    } else {
                        System.out.println("Impossible de placer le navire sélectionné! Vous devez décrire à nouveau la place du navire. Assurez-vous de choisir une place disponible");
                        i--;
                        batailleNavire.getP1().afficherPlateauJoueur();
                        continue;
                    }
                }
                System.out.print("Êtes-vous d'accord avec cette configuration ?[y] Yep, laissez moi jouer !\n[n] nope, laissez-moi placer mes navires à nouveau!\n> ");
                String whoops = scanner.nextLine();
                while (!whoops.equals("y") && !whoops.equals("n")) {
                    System.out.print("Mauvaise réponse ! Selectionner [y] ou [n] pour continuer\n> ");
                    whoops = scanner.nextLine();
                }
                if (whoops.equals("y")) {
                    batailleNavire.effacerConsole();
                    break;
                } else {
                    batailleNavire.getP1().getPlateauxJoueur().initPlateau();
                    batailleNavire.effacerConsole();
                    continue;
                }
            }


            while (true) {
                for (int i = 0; i < 5; i++) {
                    int direction = batailleNavire.directionAleatoire();
                    int taille = batailleNavire.tailleAleatoireNavire();
                    int x = batailleNavire.coordonneesAleatoires();
                    int y = batailleNavire.coordonneesAleatoires();
                    batailleNavire.getP2().choixNavire(direction, taille, i);
                    batailleNavire.getP2().getJoueurNavires()[i].pointDepartNavire(y, x);
                    if (batailleNavire.getP2().checkAvailable(y, x, i)) {
                        batailleNavire.getP2().placementNavires(i);
                    } else {
                        i--;
                        continue;
                    }
                }
                break;
            }
            batailleNavire.effacerConsole();
            System.out.println("Configuration du navire terminée !");
            System.out.println("\nJoueur 1: Veuillez choisir votre type de tir:\n[1] Tir précis\n[2] Tir jaugé\n> ");
            String shotStyleP1 = scanner.nextLine();
            while (!shotStyleP1.equals("1") && !shotStyleP1.equals("2")) {
                System.out.print("Mauvaise entrée - Veuillez sélectionner un type de tir correct\n> ");
                shotStyleP1 = scanner.nextLine();
            }
            batailleNavire.effacerConsole();
            int continuerLesTirs = 1;
            int Joueur1TirReussit = 0;
            int Joueur2TirReussit = 0;
            while (!batailleNavire.veriferVictoire(1, Joueur1TirReussit) && !batailleNavire.veriferVictoire(2, Joueur2TirReussit)) {
                System.out.println("C'est votre tour");
                System.out.println("Plateau du Joueur : ");
                batailleNavire.getP1().getPlateauxJoueur().afficherPlateauxJoueur();
                System.out.println("Plateau de l'adversaire :");
                batailleNavire.getP1().getPlateauxJoueur().afficherPlateauAdversaire();
                continuerLesTirs = 1;
                while (continuerLesTirs == 1) {
                    continuerLesTirs = 0;
                    System.out.print("\n\nEntrer les coordonnées de tirs:\nX: ");
                    String p1ShotX, p1ShotY;
                    p1ShotX = scanner.nextLine();
                    System.out.print("Y: ");
                    p1ShotY = scanner.nextLine();
                    while ((!p1ShotX.equals("0") && !p1ShotX.equals("1") && !p1ShotX.equals("2") && !p1ShotX.equals("3") && !p1ShotX.equals("4") && !p1ShotX.equals("5") && !p1ShotX.equals("6") && !p1ShotX.equals("7") && !p1ShotX.equals("8") && !p1ShotX.equals("9")) ||
                            (!p1ShotY.equals("0") && !p1ShotY.equals("1") && !p1ShotY.equals("2") && !p1ShotY.equals("3") && !p1ShotY.equals("4") && !p1ShotY.equals("5") && !p1ShotY.equals("6") && !p1ShotY.equals("7") && !p1ShotY.equals("8") && !p1ShotY.equals("9"))) {
                        System.out.print("\nCoordonnées invalide - Saissisez des coordonnées valides:\nX: ");
                        p1ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p1ShotY = scanner.nextLine();
                    }
                    boolean p1ShotAvailablity = batailleNavire.tirPossible(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1);
                    while ((!p1ShotAvailablity) || ((!p1ShotX.equals("0") && !p1ShotX.equals("1") && !p1ShotX.equals("2") && !p1ShotX.equals("3") && !p1ShotX.equals("4") && !p1ShotX.equals("5") && !p1ShotX.equals("6") && !p1ShotX.equals("7") && !p1ShotX.equals("8") && !p1ShotX.equals("9")) ||
                            (!p1ShotY.equals("0") && !p1ShotY.equals("1") && !p1ShotY.equals("2") && !p1ShotY.equals("3") && !p1ShotY.equals("4") && !p1ShotY.equals("5") && !p1ShotY.equals("6") && !p1ShotY.equals("7") && !p1ShotY.equals("8") && !p1ShotY.equals("9")))) {
                        System.out.print("\nLes coordonnées sélectionnées ne sont pas valide - Selectionner d'autres coordonnées\nX: ");
                        p1ShotX = scanner.nextLine();
                        System.out.print("Y: ");
                        p1ShotY = scanner.nextLine();
                        p1ShotAvailablity = batailleNavire.tirPossible(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1);
                    }
                    int tmp = batailleNavire.tir(Integer.parseInt(p1ShotY), Integer.parseInt(p1ShotX), 1, Integer.parseInt(shotStyleP1));
                    if (tmp == 1) {
                        Joueur1TirReussit++;
                        continuerLesTirs = 1;
                    } else
                        continuerLesTirs = 0;
                    if (batailleNavire.veriferVictoire(1, Joueur1TirReussit)) {
                        System.out.println("****Tu as a gagné ! ****\n\n");
                        System.out.println("Ton plateau :");
                        batailleNavire.getP1().getPlateauxJoueur().afficherPlateauxJoueur();
                        System.out.println("\nPlateau de l'adversaire : ");
                        batailleNavire.getP2().getPlateauxJoueur().afficherPlateauxJoueur();
                        System.out.println("\n##Fin du G A M E##");
                        System.exit(0);
                    }
                    batailleNavire.getP1().getPlateauxJoueur().afficherPlateauAdversaire();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }

                batailleNavire.effacerConsole();
                continuerLesTirs = 1;
                while (continuerLesTirs == 1) {
                    continuerLesTirs = 0;
                    int p2ShotX, p2ShotY;
                    p2ShotX = batailleNavire.coordonneesAleatoires();
                    p2ShotY = batailleNavire.coordonneesAleatoires();
                    boolean p2ShotAvailablity = batailleNavire.tirPossible(p2ShotY, p2ShotX, 2);
                    while (!p2ShotAvailablity) {
                        p2ShotX = batailleNavire.coordonneesAleatoires();
                        p2ShotY = batailleNavire.coordonneesAleatoires();
                        p2ShotAvailablity = batailleNavire.tirPossible(p2ShotY, p2ShotX, 2);
                    }
                    int tmp2 = batailleNavire.tir(p2ShotY, p2ShotX, 2, 1);
                    if (tmp2 == 1) {
                        continuerLesTirs = 1;
                        Joueur2TirReussit++;
                    } else
                        continuerLesTirs = 0;
                    if (batailleNavire.veriferVictoire(2, Joueur2TirReussit)) {
                        System.out.println("****L'adversaire a gagné****\n\n");
                        System.out.println("Votre plateau :");
                        batailleNavire.getP1().getPlateauxJoueur().afficherPlateauxJoueur();
                        System.out.println("\nPlateau de l'adversaire :");
                        batailleNavire.getP2().getPlateauxJoueur().afficherPlateauxJoueur();
                        System.out.println("\n##Fin du G A M E##");
                        System.exit(0);
                    }
                    batailleNavire.getP1().afficherPlateauJoueur();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }


        }

    }

    public void chargerPartie() {
        System.out.println("Impossible pour le moment, fonctionnalité disponible bientot");
    }

    public void aidePartie() {
        System.out.println("Impossible pour le moment, fonctionnalité disponible bientot");
    }
}
