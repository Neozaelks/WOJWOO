abstract class Combattant implements ICombattant{
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
  public void attaquer(ICombattant adversaire){
    adversaire.defendre(this.degats);
    System.out.println("L'attaque a infligé " + this.degats + " !");
  }
  public void defendre(int degats){
    this.pointsDeVie = this.pointsDeVie - degats;
  }
  public String getNom(){
    return this.nom;
  }
  public int getDegats(){
    return this.degats;
  }
  public int getPointsDeVie(){
    return this.pointsDeVie;
  }
  public String setNom(String nom){
    this.nom = nom;
    return this.nom;
  }
  public int setDegats(int degats){
    this.degats = degats;
    return this.degats;
  }
  public int setPointsDeVie(int pointsDeVie){
    this.pointsDeVie = pointsDeVie;
    return this.pointsDeVie;
  }
}