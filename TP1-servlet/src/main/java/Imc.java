
public class Imc {
private double taille;
private double poids ;

public Imc (double taille ,double poids) {
	this.setTaille(taille);
	this.setPoids(poids);
}

public double getTaille() {
	return taille;
}

public void setTaille(double taille) {
	this.taille = taille;
}

public double getPoids() {
	return poids;
}

public void setPoids(double poids) {
	this.poids = poids;
};

public double calcul() {
	return this.getPoids() / (this.getTaille() * this.getTaille());
}


}
