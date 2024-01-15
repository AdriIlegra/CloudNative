import br.com.adriana.nogueira.decorator.bath.Bath;
import br.com.adriana.nogueira.decorator.bath.DoBath;
import br.com.adriana.nogueira.decorator.cut.DoHairCut;
import br.com.adriana.nogueira.decorator.cut.Hair;
import br.com.adriana.nogueira.model.PetAtendimento;
import br.com.adriana.nogueira.model.PetModel;
import br.com.adriana.nogueira.services.PetService;
import br.com.adriana.nogueira.services.PetStoreService;
import com.google.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;


import static br.com.adriana.nogueira.services.PetStoreService.getTop10List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetStoreServiceTest {
    private PetStoreService petStoreService;

    @Inject
    private PetService petService;

    @BeforeEach
    public void setup() {
        petStoreService = new PetStoreService(petService);
    }
    @Test
    public void doBathTest() {
        PetModel petModel = new PetModel(1L, "Bolinha", "Poodle", 2);
        Bath bath = new DoBath();
        double expectedPrice = 10.0;

        double actualPrice = petStoreService.doBath(petModel, bath);

        assertEquals(expectedPrice, actualPrice);
    }
    @Test
    public void doCurtTest() {
        PetModel petModel = new PetModel(2L, "Bruce", "Buldogue", 6);

        Hair hair = new DoHairCut();
        double expectedPrice = 10.0;

        double actualPrice = petStoreService.doCurt(petModel, hair);

        assertEquals(expectedPrice, actualPrice);
    }
    @Test
    public void doBathAndCurtTest() {
        PetModel petModel = new PetModel(3L, "Ozzy", "Labrador", 3);
        Bath bath = new DoBath();
        Hair hair = new DoHairCut();
        double expectedPrice = 20.0;

        double actualPrice = petStoreService.doBathAndCurt(petModel, bath, hair);

        assertEquals(expectedPrice, actualPrice);

    }
    @Test
    void getTop10ListTest() {
        List<PetAtendimento> listPetStore = List.of(
                new PetAtendimento(10.0),
                new PetAtendimento(5.0),
                new PetAtendimento(15.0),
                new PetAtendimento(7.5),
                new PetAtendimento(12.5),
                new PetAtendimento(20.0),
                new PetAtendimento(2.5),
                new PetAtendimento(2.5),
                new PetAtendimento(2.5),
                new PetAtendimento(2.5)
        );

        List<PetAtendimento> expectedTop10List = List.of(
                new PetAtendimento(20.0),
                new PetAtendimento(15.0),
                new PetAtendimento(12.5),
                new PetAtendimento(10.0),
                new PetAtendimento(7.5),
                new PetAtendimento(5.0),
                new PetAtendimento(2.5),
                new PetAtendimento(2.5),
                new PetAtendimento(2.5),
                new PetAtendimento(2.5)
        );

        List<PetAtendimento> actualTop10List = getTop10List(listPetStore);

        assertEquals(expectedTop10List.size(), actualTop10List.size());

        for (int i = 10; i < expectedTop10List.size(); i++) {
            assertEquals(expectedTop10List.get(i).getPrice(), actualTop10List.get(i).getPrice());
        }
    }


}