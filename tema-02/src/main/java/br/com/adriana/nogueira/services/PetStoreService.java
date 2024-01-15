package br.com.adriana.nogueira.services;


import br.com.adriana.nogueira.decorator.bath.Bath;
import br.com.adriana.nogueira.decorator.cut.Hair;
import br.com.adriana.nogueira.model.PetAtendimento;
import br.com.adriana.nogueira.model.PetModel;
import com.google.inject.Inject;

import java.util.*;

public class PetStoreService {

    private PetService petService;
    private List<PetAtendimento> listPetStore;
    private List<String> historic;
    private double totalPrice;

    @Inject
    public PetStoreService(PetService petService) {
        this.petService = petService;
        this.listPetStore = new ArrayList<>();
        this.historic = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public Double doBath(PetModel petModel, Bath bath) {
        this.totalPrice = bath.getPrice();
        this.historic.add(new PetAtendimento(petModel, bath).toString() + " Price: " + bath.getPrice());
        this.listPetStore.add(new PetAtendimento(petModel, bath)); // Adicionar à lista listPetStore
        return totalPrice;
    }

    public Double doCurt(PetModel petModel, Hair corte) {
        this.totalPrice = corte.getPrice();
        this.historic.add(new PetAtendimento(petModel, corte).toString() + " Price: " + corte.getPrice());
        this.listPetStore.add(new PetAtendimento(petModel, corte)); // Adicionar à lista listPetStore
        return totalPrice;
    }

    public Double doBathAndCurt(PetModel petModel, Bath bath, Hair corte) {
        this.totalPrice = bath.getPrice() + corte.getPrice();
        this.historic.add(new PetAtendimento(petModel, bath, corte).toString() + " Price: " + (bath.getPrice() + corte.getPrice()));
        this.listPetStore.add(new PetAtendimento(petModel, bath, corte)); // Adicionar à lista listPetStore
        return totalPrice;
    }


    public List<PetAtendimento> getListPetStore() {
        return listPetStore;

    }

    public static List<PetAtendimento> getTop10List(List<PetAtendimento> listPetStore) {
        // Ordena a lista em ordem decrescente com base no preço

        // Obtém os 10 primeiros elementos da lista ordenada (ou menos, se a lista for menor que 10)
        int endIndex = Math.min(10, listPetStore.size());
        return listPetStore.subList(0, endIndex);
    }
}



