package br.com.adriana.nogueira.decorator.cut;

import com.google.inject.Inject;

public class Short extends HairCutDecorator{

    private static final String SHORT = "Short";
    private static final double PRICE_SHORT = 5.0;
    @Inject
    public Short(Hair hair) {
        super(hair);
    }

    @Override
    public String cutHair() {
        return super.cutHair() + SHORT;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE_SHORT;
    }
}
