package br.com.adriana.nogueira.decorator.cut;

import com.google.inject.Inject;

public class Long extends HairCutDecorator{

    private static final String LONG = "Long";
    private static final double PRICE_LONG = 10.0;
@Inject
    public Long(Hair hair) {
        super(hair);
    }



    @Override
    public String cutHair() {
        return super.cutHair() + LONG;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE_LONG;
    }
}
