package souvenirs.Souvenirs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;


class SouvenirsProcessorTest {
    private SouvenirsProcessor souvenirsProcessor;
    private  List<Souvenir> souvenirs;


    @BeforeEach
    void setUp(){
        souvenirsProcessor = new SouvenirsProcessor();
        souvenirs = createList();
    }

    @Test
    void sortByManufacturerTEST() {
        List<Souvenir> result = souvenirsProcessor.sortByManufacturer(souvenirs, "CLOVER");
        for (Souvenir souvenir : result) {
            System.out.println(souvenir);
        }
    }

    @Test
    void sortByYearName() {
        List<Souvenir> result = souvenirsProcessor.sortByYearAndName(souvenirs, "Skeleton", "2020");
        for (Souvenir souvenir : result) {
            System.out.println(souvenir);
        }
    }

    @Test
    void sortByMAnName() {
        List<Souvenir> result = souvenirsProcessor.sortManufacturer(souvenirs);
        for (Souvenir souvenir : result) {
            System.out.println(souvenir);
        }
    }

    @Test
    void sortByYearTEST(){
        List<Souvenir> result = souvenirsProcessor.sortByYear(souvenirs);
        for (Souvenir souvenir : result) {
            System.out.println(souvenir);
        }
    }

    @Test
    void deleteMANTEST(){
        ArrayList<Souvenir> expected = new ArrayList<>();
        expected.add(new Souvenir("Skeleton", new Manufacturer("CEMETERY", "USA"), "21.12.2020", 2460.18));
        List<Souvenir> result = souvenirsProcessor.deleteManufacturer(souvenirs, "CLOVER");
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
    }


    private ArrayList<Souvenir> createList(){
            ArrayList<Souvenir> souvenirs = new ArrayList<>();
            souvenirs.add(new Souvenir("Skull", new Manufacturer("CLOVER", "UKRAINE"), "03.08.2023", 625.00));
            souvenirs.add(new Souvenir("Skeleton", new Manufacturer("CEMETERY", "USA"), "21.12.2020", 2460.18));
            souvenirs.add(new Souvenir("Skeleton", new Manufacturer("CLOVER", "UKRAINE"), "21.12.2019", 2460.18));
            return souvenirs;
        }
}