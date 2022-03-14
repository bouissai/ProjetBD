package model;

public class Modele {
    private Marque marque ;
    private double cout ;

    public Marque getMarque() {
        return marque;
    }

    public Modele(Marque marque, double cout) {
        this.marque = marque;
        this.cout = cout;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }
}
