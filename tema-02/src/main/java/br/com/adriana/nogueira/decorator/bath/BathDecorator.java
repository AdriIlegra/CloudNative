package br.com.adriana.nogueira.decorator.bath;

import com.google.inject.Inject;

public class BathDecorator implements Bath {

    private Bath bath;
    @Inject
    public BathDecorator(Bath bath){

        this.bath = bath;
    }



    @Override
    public String modeBath() {

            return bath.modeBath();

    }

    @Override
    public double getPrice() {

        return bath.getPrice();
    }
}
