import java.util.Random;
import java.util.Scanner;

public class Monde{
  private static final Scanner scanner = new Scanner(System.in);

  public static void combat(Personnage personnage, Monstre monstre){
    //Le tour est accordé au combattant ayant le moins de dégâts.
    //En cas d'égalité, le tour est accordé au personnage.
    //Si tour == true, alors c'est le tour du personnage.
    boolean turn = personnage.degats >= monstre.degats;
    while(personnage.pointsDeVie > 0 && monstre.pointsDeVie > 0){
      if(turn){
        Colorator.coloredPrint("Tour du joueur!", "PURPLE");
        /*  Le combattant va lancer un dé pour savoir s'il réussit son
        attaque, ou non.
        00-05 > 00% des dégâts.  | Esquivé !
        06-49 > 50% des dégâts.  | Résisté !
        50-94 > 100% des dégâts. | Touché !
        95-99 > 200% des dégâts. | CRITIQUE !
        */
        int roll = new Random().nextInt(0,99);
        if(roll <= 5){
          System.out.println("Le monstre a esquivé!");
        }
        else if (roll <= 49) {
          int degatsInfliges = (int)(Math.round(personnage.degats * 0.5));
          monstre.pointsDeVie -= degatsInfliges;
          System.out.println("Le monstre a résisté!");
          System.out.println(
                  "Vous avez infligé " + degatsInfliges + " dégâts.");
        }
        else if (roll <= 94){
          monstre.pointsDeVie -= personnage.degats;
          System.out.println("Touché!");
          System.out.println(
                  "Vous avez infligé " + personnage.degats + " dégâts.");
        }
        else if (roll <= 99){
          int degatsInfliges = personnage.degats * 2;
          monstre.pointsDeVie -= degatsInfliges;
          System.out.println("Coup critique!");
          System.out.println(
                  "Vous avez infligé " + degatsInfliges + " dégâts.");
        }
        System.out.println(
                "Il vous reste " + personnage.pointsDeVie + " HP.");
        turn = false;
      }
      else{
        System.out.println("Tour de l'ennemi!");
        /*  Le combattant va lancer un dé pour savoir s'il réussit son
        attaque, ou non.
        00-05 > 00% des dégâts.  | Esquivé !
        06-49 > 50% des dégâts.  | Résisté !
        50-94 > 100% des dégâts. | Touché !
        95-99 > 200% des dégâts. | CRITIQUE !
        */
        int roll = new Random().nextInt(0,99);
        if(roll <= 5){
          System.out.println("Vous avez esquivé l'attaque!");
        }
        else if (roll <= 49) {
          int degatsInfliges = (int)(Math.round(monstre.degats * 0.5));
          personnage.pointsDeVie -= degatsInfliges;
          System.out.println("Vous avez résisté à l'attaque!");
          System.out.println(
                  "Vous avez subi " + degatsInfliges + " dégâts.");
        }
        else if (roll <= 94){
          personnage.pointsDeVie -= monstre.degats;
          System.out.println("Le monstre vous a attaqué!");
          System.out.println(
                  "Vous avez subi " + monstre.degats + " dégâts.");
        }
        else if (roll <= 99) {
          int degatsInfliges = monstre.degats * 2;
          personnage.pointsDeVie -= degatsInfliges;
          System.out.println("Coup critique!");
          System.out.println(
                  "Vous avez subi " + degatsInfliges + " dégâts.");
        }
        turn = true;
        System.out.println(
                "Il reste à l'ennemi " + monstre.pointsDeVie + " HP.");
      }
    }
    if(personnage.pointsDeVie <=0){
      System.out.println("Perdu ! Vous êtes mort.");
    }
    else{
      System.out.println("Et c'est gagné!");
    }
  }

  public static Personnage personnageFactory(){
    System.out.println("Entrez le nom de votre personnage :");
    String nomPersonnage = scanner.next();
    int pointsDeVie = new Random().nextInt(35,50);
    int degats = new Random().nextInt(5,15);
    Personnage personnage = new Personnage(
            nomPersonnage, pointsDeVie, degats);
    System.out.println(personnage);
    return personnage;
  }
  public static Monstre monstreFactory() {
    String nomMonstre = debutNom[new Random().nextInt(debutNom.length)] +
            " " + finNom[new Random().nextInt(finNom.length)];
    int pointsDeVie = new Random().nextInt(20,40);
    int degats = new Random().nextInt(2, 10);
    Monstre monstre = new Monstre(nomMonstre, pointsDeVie, degats);
    System.out.println(monstre);
    return monstre;
  }

  public static String[] debutNom = new String[]{
          "Ange","Archer","Artificier","Assassin","Avatar","Barde","Basilic",
          "Berserker","Cauchemar","Céphalide","Changeforme","Chat","Cheval",
          "Chevalier","Chèvre","Chien","Chimère","Crabe","Crocodile","Cuirassé",
          "Cyclope","Demi-Dieu","Démon","Diable","Diablotin","Dieu","Dinosaure",
          "Djaggernaut","Djinn","Dragon","Drone","Druide","Dryade","Écureuil",
          "Eldrazi","Élémentaire","Éléphant","Elfe","Engeance","Esprit","Furet",
          "Géant","Germe","Gnoll","Gnome","Gobelin","Golem","Grenouille","Griffon",
          "Guerrier","Guivre","Hamster","Harpie","Hippogriffe","Hippopotame",
          "Horreur","Huître","Humain","Hydre","Hyène","Illusion","Insecte","Kavru",
          "Kobold","Kor","Kraken","Lapin","Léviathan","Lézard","Lhurgoyf","Licorne",
          "Limace","Limon","Loup","Loup-Garou","Garou (le chanteur)","Loutre",
          "Mangouste","Manticore","Méduse","Mercenaire","Minotaure","Moine",
          "Monstruosité","Mouton","Mutant","Myr","Naga","Nain","Nephilim","Ninja",
          "Noble","Nymphe","Ogre","Oiseau","Ombre","Ondin","Orque","Ours","Pangolin",
          "Pégase","Phoenix","Pieuvre","Pirate","Plante","Poisson","Ranger","Rat",
          "Renard","Requin","Rhinocéros","Salamandre","Samouraï","Sanglier",
          "Sangsue","Scorpion","Shamane","Singe","Sirène","Soldat","Sorcier",
          "Sphinx","Squelette","Sylvin","Taupe","Tortue","Troll","Vampire",
          "Ver","Yéti"
  };
  public static String[] finNom = new String[]{
          "d'Eau","de Terre","de Feu","de Lumière","des Ténèbres","de Vent",
          "énervé","déprimé","encourageant","de Carglass","Légendaire","Mythique"
  };

//  public static void afficherInformations(){
//    //OSEF
//  }
}