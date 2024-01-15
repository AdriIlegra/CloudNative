package br.com.adriana.nogueira.decorator.bath;

import br.com.adriana.nogueira.decorator.bath.Bath;
import br.com.adriana.nogueira.decorator.bath.BathDecorator;
import com.google.inject.Inject;

public class Dry extends BathDecorator {

    private static final String DRY = "Dry";
    private static final double PRICE_DRY = 5.0;

    @Inject
    public Dry(Bath bath) {

        super(bath);
    }

    @Override
    public String modeBath() {

        return super.modeBath() + DRY;
    }

    @Override
    public double getPrice() {

        return super.getPrice() + PRICE_DRY;
    }

}
