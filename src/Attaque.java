import java.util.Random;

public class Attaque implements IAttaque{

  public String nom;
  public String description;
  public int chanceDeToucher;

  Attaque(String nom, int chanceDeToucher){
    this.chanceDeToucher = chanceDeToucher;
    this.nom = nom;
  }

  public void lancerAttaque(ICombattant lanceur, ICombattant cible){
  }
  public String getNom(){
    return this.nom;
  }
  public String getDescription(){
    return this.description;
  }
  public int getChanceDeToucher(){
    return this.chanceDeToucher;
  }
  public String setNom(String nom){
    this.nom = nom;
    return this.nom;
  }
  public String setDescription(String description){
    this.description = description;
    return this.description;
  }
  public int setChanceDeToucher(int chanceDeToucher) {
    this.chanceDeToucher = chanceDeToucher;
    return this.chanceDeToucher;
  }

}
