abstract class Combattant {
  public String nom;
  public int pointsDeVie;
  public int degats;

  public Combattant(String nom, int pointsDeVie, int degats) {
    this.nom = nom;
    this.pointsDeVie = pointsDeVie;
    this.degats = degats;
  }

  public String toString() {
    return("nom: " + this.nom +
            ", pointsDeVie: " + this.pointsDeVie +
            ", dégâts: " + this.degats);
  }
}
