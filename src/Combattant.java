import java.util.Random;

abstract class Combattant implements ICombattant{
  public String nom;
  public int pointsDeVie;
  public int degats;
  public Classe classe;

  public Combattant(String nom, int pointsDeVie, int degats, Classe classe) {
    this.nom = nom;
    this.pointsDeVie = pointsDeVie;
    this.degats = degats;
    this.classe = classe;
  }
  public String toString() {
    return("nom: " + this.nom +
            ", pointsDeVie: " + this.pointsDeVie +
            ", dégâts: " + this.degats) +
            ", classe: " + this.classe;
  }
  public void attaquer(ICombattant adversaire){
    IAttaque attaque = this.classe.getAttaques();
    int chancesDeToucher = attaque.getChanceDeToucher();
    Random random = new Random();
    int numberRolled = random.nextInt(0,100);
    int degatsAInfliger = 0;
    if(numberRolled <= 5){
      degatsAInfliger = this.degats * 2;
    }else if(numberRolled <= chancesDeToucher){
      degatsAInfliger = this.degats;
    }
    System.out.println(
      Colorator.coloredPrint(attaque.getNom(), "BLUE")
    );
    adversaire.defendre(degatsAInfliger);
    System.out.println("L'attaque a infligé " + degatsAInfliger + " !");
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