import java.util.List;
import java.util.Random;

public class Classe {
  private List<IAttaque> attaques;
  private String nom;

  Classe(){}
  Classe(List<IAttaque> attaques, String nom){
    this.attaques = attaques;
    this.nom = nom;
  }

  public IAttaque getAttaques() {
    Random random = new Random();
    int index = random.nextInt(0, attaques.size());
    return attaques.get(index);
  }
  public void setNom(String nom) {
    this.nom = nom;
  }
  public String getNom() {
    return nom;
  }
}
