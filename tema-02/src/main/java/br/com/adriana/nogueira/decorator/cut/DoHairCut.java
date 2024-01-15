package br.com.adriana.nogueira.decorator.cut;

import com.google.inject.Inject;

public class DoHairCut implements Hair {

    private static double PRICE_CUT = 10.0;

    @Inject
    public DoHairCut() {

    }

    @Override
    public String cutHair() {
        return "DoHairCut";    }

    @Override
    public double getPrice() {

        return PRICE_CUT;
    }
}
