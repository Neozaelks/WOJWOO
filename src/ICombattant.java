public interface ICombattant {
    public void attaquer(ICombattant adversaire);
    public void defendre(int degats);

    //getters & setters
    public String getNom();
    public int getDegats();
    public int getPointsDeVie();
    public String setNom(String nom);
    public int setDegats(int degats);
    public int setPointsDeVie(int pointsDeVie);
}
