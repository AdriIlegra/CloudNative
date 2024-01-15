package br.com.adriana.nogueira.decorator.bath;

import com.google.inject.Inject;

public class WithPerfume extends BathDecorator {
    private static final String PERFUME = "Perfume";
    private  static final double PRICE_PERFUME = 10.0;
    @Inject
    public WithPerfume(Bath bath){

        super(bath);
    }

    @Override
    public String modeBath(){

        return super.modeBath() + PERFUME;
    }

    @Override
    public double getPrice(){

        return super.getPrice() + PRICE_PERFUME;
    }
}
