package br.com.adriana.nogueira.decorator.bath;

import com.google.inject.Inject;

public class WithoutPerfume extends BathDecorator {

    private static final  String WITHOUT_PERFUME = "Without Perfume";
    private static final  double PRICE_WITHOUT_PERFUME = 5.0;

    @Inject
    public WithoutPerfume(Bath bath) {

        super(bath);
    }

   @Override
   public String modeBath() {

        return super.modeBath() + WITHOUT_PERFUME;
    }

    @Override
    public double getPrice() {

        return super.getPrice() + PRICE_WITHOUT_PERFUME;
    }


}
