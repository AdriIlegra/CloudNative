package br.com.adriana.nogueira.decorator.cut;

import com.google.inject.Inject;

public class HairCutDecorator implements Hair {

    private Hair hair;

    @Inject
    public HairCutDecorator(Hair hair) {
        this.hair = hair;
    }

    @Override
    public String cutHair() {
        return hair.cutHair();
    }

    @Override
    public double getPrice() {
        return hair.getPrice();
    }
}
