package br.com.adriana.nogueira.decorator.bath;


import com.google.inject.Inject;

public class DoBath implements Bath {

    public  double PRICE = 10.0;




    @Override
    public String modeBath() {

        return "DoBath";
    }

    @Override
    public double getPrice() {

        return PRICE;
    }
}

