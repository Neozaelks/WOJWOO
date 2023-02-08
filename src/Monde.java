import java.util.Random;
import java.util.Scanner;

public class Monde{
  private static final Scanner scanner = new Scanner(System.in);

  public static void combat(ICombattant combattant1, ICombattant combattant2){
    //Le tour est accordé au combattant ayant le moins de dégâts.
    //En cas d'égalité, le tour est accordé au combattant1.
    //Si tour == true, alors c'est le tour du combattant1.
    boolean turn = combattant1.getDegats() >= combattant2.getDegats();
    while(combattant1.getPointsDeVie() > 0 && combattant2.getPointsDeVie() > 0){
      if(turn){
        System.out.println(
          Colorator.coloredPrint("Tour de " + combattant1 + " !", "PURPLE")
        );
        combattant1.attaquer(combattant2);
        System.out.println(
          Colorator.coloredPrint("Il reste " + combattant2.getPointsDeVie() + " HP à l'ennemi.", "BLUE")
        );
        turn = false;
      }
      else{
        System.out.println(
          Colorator.coloredPrint("Tour de " + combattant2 + " !", "PURPLE")
        );
        combattant2.attaquer(combattant1);
        System.out.println(
          Colorator.coloredPrint("Il vous reste " + combattant1.getPointsDeVie() + " HP.", "BLUE")
        );
        turn = true;
      }
    }
    if(combattant1.getPointsDeVie() <=0){
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