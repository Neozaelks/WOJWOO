public class Main {
  public static void main(String[] args) {
    Monde.initialiserClasses();
    Personnage personnage = Monde.personnageFactory();
    Monstre monstre = Monde.monstreFactory();
    Monde.combat(personnage,monstre);
  }
}