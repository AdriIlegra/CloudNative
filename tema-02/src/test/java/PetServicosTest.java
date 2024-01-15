
import br.com.adriana.nogueira.model.PetModel;
import br.com.adriana.nogueira.services.PetService;

import br.com.adriana.nogueira.services.PetStoreService;
import br.com.adriana.nogueira.util.PetModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;




public class PetServicosTest {
    @Inject
    private PetStoreService petStoreService;
    @Inject
    private PetService petService;


    @BeforeEach
    public void setup() {
        Injector injector = Guice.createInjector(new PetModule());

        petService = injector.getInstance(PetService.class);
        petStoreService = injector.getInstance(PetStoreService.class);
    }

    @Test
    public void testAddPet() throws Exception {
        PetModel pet = new PetModel();
        pet.setId(1L);
        pet.setName("Fido");
        pet.setAge(3);

        PetModel addedPet = petService.addPet(pet);
        System.out.println("Pet adicionado: " + addedPet);
    }




    @Test
    public void searchByAgeTest() {
        PetModel pet1 = new PetModel(1L, "Bolinha", "Poodle", 2);
        PetModel pet2 = new PetModel(2L, "Bruce", "Buldogue", 6);
        PetModel pet3 = new PetModel(3L, "Ozzy", "Labrador", 3);
        PetModel pet4 = new PetModel(4L, "Dolly", "Poodle", 2);

        try {
            petService.addPet(pet1);
            petService.addPet(pet2);
            petService.addPet(pet3);
            petService.addPet(pet4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int searchAge = 3;
        List<PetModel> petsByAge = petService.searchPetsByAge(searchAge);

        System.out.println("Pets com idade " + searchAge + ":");
        for (PetModel pet : petsByAge) {
            System.out.println(pet);
        }
    }

    @Test
    public void removePetTest() throws Exception {
        boolean result = petService.removePet(2L);
        Assertions.assertTrue(result);
        List<PetModel> petList = petService.getPetList();
        Optional<PetModel> removedPet = petService.searchById(2L);
        Assertions.assertFalse(removedPet.isPresent());
    }


    @Test
    public void searchByIdTest() {
        PetModel pet3 = new PetModel(3L, "Ozzy", "Labrador", 3);
        try {
            petService.addPet(pet3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Optional<PetModel> pet = petService.searchById(3L);
        Assertions.assertTrue(pet.isPresent());
        PetModel foundPet = pet.get();
        Assertions.assertEquals("Ozzy", foundPet.getName());
        Assertions.assertEquals("Labrador", foundPet.getRace());
        Assertions.assertEquals(3, foundPet.getAge());
    }
}