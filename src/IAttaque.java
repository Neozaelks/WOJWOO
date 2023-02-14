public interface IAttaque {
  public void lancerAttaque(ICombattant lanceur, ICombattant cible);

  //Getters & Setters
  public String getNom();
  public String getDescription();
  public int getChanceDeToucher();
  public String setNom(String nom);
  public String setDescription(String description);
  public int setChanceDeToucher(int chanceDeToucher);
}
