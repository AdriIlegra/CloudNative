package br.com.adriana.nogueira.decorator.bath;

import br.com.adriana.nogueira.decorator.bath.Bath;
import br.com.adriana.nogueira.decorator.bath.BathDecorator;
import com.google.inject.Inject;

public class Water extends BathDecorator {

    private static final String WATER = "Water";
    private static final double PRICE_WATER = 2.0;

    @Inject
    public Water(Bath bath) {

        super(bath);
    }

   @Override
   public String modeBath() {

        return super.modeBath() + WATER;
    }
    @Override
    public double getPrice() {

        return super.getPrice() + PRICE_WATER;
    }
}
