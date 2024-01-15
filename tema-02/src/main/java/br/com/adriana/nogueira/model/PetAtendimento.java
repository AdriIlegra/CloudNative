package br.com.adriana.nogueira.model;


import br.com.adriana.nogueira.decorator.bath.Bath;
import br.com.adriana.nogueira.decorator.cut.Hair;
import com.google.inject.Inject;

public class PetAtendimento {

    private PetModel petModel;
    private Bath bath;
    private Hair hair;
    private double totalPrice = 0;
    private double price;


    public PetAtendimento(PetModel petModel, Bath bath) {
        this.petModel = petModel;
        this.bath = bath;
        this.totalPrice = bath.getPrice();
    }


    public PetAtendimento(PetModel petModel, Hair hair) {
        this.petModel = petModel;
        this.hair = hair;
        this.totalPrice = hair.getPrice();
    }

    @Inject
    public PetAtendimento(PetModel petModel, Bath bath, Hair hair) {
        this.petModel = petModel;
        this.bath = bath;
        this.hair = hair;
        this.totalPrice = bath.getPrice() + hair.getPrice();
    }

    public PetAtendimento(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PetModel getPetModel() {
        return petModel;
    }

    public void setPetModel(PetModel petModel) {
        this.petModel = petModel;
    }

    public Bath getBath() {
        return bath;
    }

    public void setBath(Bath bath) {
        this.bath = bath;
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public double getTotalPrice() {
        return totalPrice;

    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "PetAtendimento{" +
                "petModel=" + petModel +
                ", bath=" + bath +
                ", hair=" + hair +
                ", price=" + totalPrice +
                '}';
    }
}




