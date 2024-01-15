package br.com.adriana.nogueira;


import br.com.adriana.nogueira.decorator.bath.Bath;
import br.com.adriana.nogueira.decorator.bath.DoBath;
import br.com.adriana.nogueira.decorator.bath.Dry;
import br.com.adriana.nogueira.decorator.bath.WithoutPerfume;
import br.com.adriana.nogueira.decorator.cut.DoHairCut;
import br.com.adriana.nogueira.decorator.cut.Hair;
import br.com.adriana.nogueira.decorator.cut.Long;
import br.com.adriana.nogueira.model.PetModel;
import br.com.adriana.nogueira.services.PetService;
import br.com.adriana.nogueira.services.PetStoreService;
import br.com.adriana.nogueira.util.PetModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(new PetModule());
        PetService petService = injector.getInstance(PetService.class);
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);


        PetModel pet1 = new PetModel(1L, "Bolinha", "Poodle", 2);
        PetModel pet2 = new PetModel(2L, "Bruce", "Buldogue", 6);
        PetModel pet3 = new PetModel(3L, "Ozzy", "Labrador", 3);
        PetModel pet4 = new PetModel(4L, "Dolly", "Poodle", 2);
        PetModel pet5 = new PetModel(5L, "Simba", "Golden", 5);
        PetModel pet6 = new PetModel(6L, "Lucky", "Chihuahua", 3);
        PetModel pet7 = new PetModel(7L, "Zeca", "Boxer", 6);
        PetModel pet8 = new PetModel(8L, "Buddy", "Husky", 4);
        PetModel pet9 = new PetModel(9L, "Max", "Pug", 2);
        PetModel pet10 = new PetModel(10L, "Pingo", "Yorkshire", 5);
        PetModel pet11 = new PetModel(11L, "Pandola", "Perdigueiro", 2);
        PetModel pet12 = new PetModel(12L, "Goob", "ViraLata", 3);

        try {
            // Adicionar pets
            petService.addPet(pet1);
            petService.addPet(pet2);
            petService.addPet(pet3);
            petService.addPet(pet4);
            petService.addPet(pet5);
            petService.addPet(pet6);
            petService.addPet(pet7);
            petService.addPet(pet8);
            petService.addPet(pet9);
            petService.addPet(pet10);
            petService.addPet(pet11);
            petService.addPet(pet12);


        } catch (Exception e) {
            System.out.println("Erro ao adicionar pet: " + e.getMessage());
        }

        // Remover pet
        petService.removePet(1L);

        // Buscar pet por id
        Optional<PetModel> pet = petService.searchById(2L);
        System.out.println("Pet encontrado: " + pet);

        // Buscar pet por idade
        System.out.println("Pets encontrados: " + petService.searchPetsByAge(3));

        Bath bath1 = new WithoutPerfume(new Dry(new DoBath()));
        System.out.println("Bath: " + bath1.modeBath() + " - Price: " + bath1.getPrice());
        Bath bath2 = new WithoutPerfume(new DoBath());
        System.out.println("Bath: " + bath2.modeBath() + " - Price: " + bath2.getPrice());
        Bath bath3 = new Dry(new DoBath());
        System.out.println("Bath: " + bath3.modeBath() + " - Price: " + bath3.getPrice());
        Bath bath4 = new DoBath();
        System.out.println("Bath: " + bath4.modeBath() + " - Price: " + bath4.getPrice());
        Hair hair1 = new Long(new DoHairCut());
        System.out.println("Hair: " + hair1.cutHair() + " - Price: " + hair1.getPrice());
        Hair hair2 = new DoHairCut();
        System.out.println("Hair: " + hair2.cutHair() + " - Price: " + hair2.getPrice());


    List<PetModel> top10List = getTop10ListByAge(petService.getPetList());

    // Imprimir os pets da lista top10List
     for(PetModel petModel : top10List) {
        System.out.println(petModel.getName());
    }
}

    public static List<PetModel> getTop10ListByAge(List<PetModel> petList) {

        // Obter os 10 primeiros pets da lista ordenada (ou menos, se a lista for menor que 10)
        int endIndex = Math.min(10, petList.size());
        return petList.subList(0, endIndex);
    }
}


