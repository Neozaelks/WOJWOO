import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Monde{
  private static final Scanner scanner = new Scanner(System.in);
  public static HashMap<String, Classe> dictionnaireClasses = new HashMap<String, Classe>();
  public static void initialiserClasses(){
    List<IAttaque> attaques = new ArrayList<IAttaque>(
      List.of(
        new Attaque("Attaque Normale", 50),
        new Attaque("Attaque Difficile", 35),
        new Attaque("Attaque Simple", 65)
      )
    ){};
    List<IAttaque> attaqueMonstre = new ArrayList<IAttaque>(
      List.of(
        new Attaque("Attaque Normale", 50)
      )
    ){};
    dictionnaireClasses.put("Aventurier", new Classe(attaques, "Aventurier"));
    dictionnaireClasses.put("Monstre", new Classe(attaqueMonstre, "Monstre"));
  }
  public static Classe getClasseInDictionnaire(String classe){
    if(dictionnaireClasses.get(classe) != null){
      return dictionnaireClasses.get(classe);
    }
    else{
      throw new RuntimeException();
    }
  }


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
    String nomPersonnage = scanner.nextLine();
    int pointsDeVie = new Random().nextInt(35,50);
    int degats = new Random().nextInt(5,15);
    System.out.println("Quelle classe voulez-vous choisir ?");
    dictionnaireClasses.forEach((key, value) -> {
      System.out.println(key);
    });
    String classeChoisie = scanner.nextLine();
    Classe aventurier = getClasseInDictionnaire(classeChoisie);
    Personnage personnage = new Personnage(
            nomPersonnage, pointsDeVie, degats, aventurier);
    System.out.println(personnage);
    return personnage;
  }
  public static Monstre monstreFactory() {
    String nomMonstre = debutNom[new Random().nextInt(debutNom.length)] +
            " " + finNom[new Random().nextInt(finNom.length)];
    int pointsDeVie = new Random().nextInt(20,40);
    int degats = new Random().nextInt(2, 10);
    Attaque attaque = new Attaque("Attaque", 50);
    List<IAttaque> attaques = new ArrayList<IAttaque>();
    attaques.add(attaque);
    Classe classe = new Classe(attaques, "monstre");
    Monstre monstre = new Monstre(nomMonstre, pointsDeVie, degats, classe);
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

}