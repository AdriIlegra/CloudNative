package br.com.adriana.nogueira.services;

import br.com.adriana.nogueira.model.PetModel;
import com.google.inject.Inject;

import java.util.*;
import java.util.stream.Collectors;

public class PetService {
    private final List<PetModel> petList;

    @Inject
    public PetService() {
        this.petList = new ArrayList<>();
    }

    public PetModel addPet(PetModel pet) throws Exception {
        if (petList != null) {
            petList.add(pet);
            return pet;
        } else {
            throw new Exception("Pet list e nula");
        }
    }

    public boolean removePet(Long id) throws Exception {
        petList.removeIf(pet -> Objects.equals(pet.getId(), id));
        return true;
    }

    public List<PetModel> searchPetsByAge(int age) {
        return petList.stream()
                .filter(pet -> pet.getAge() == age)
                .collect(Collectors.toList());
    }

    public Optional<PetModel> searchById(Long id) {
        return petList.stream()
                .filter(pet -> Objects.equals(pet.getId(), id))
                .findFirst();
    }
    public List<PetModel> getPetList() {
        return Collections.unmodifiableList(petList);
    }

}

