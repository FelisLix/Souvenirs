package souvenirs.Souvenirs;


import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SouvenirsProcessor {

    //• Вивести інформацію про сувеніри заданого виробника.
    public List<Souvenir> sortByManufacturer(List<Souvenir> souvenirs, String manufacturer){
        return souvenirs.stream().filter(s -> Objects.equals(s.getManufacturer().getName(), manufacturer)).toList();
    }

    //• Вивести інформацію про сувеніри, виготовлені в заданій країні
    public List<Souvenir> sortByCountry(List<Souvenir> souvenirs, String country){
        return souvenirs.stream().filter(s -> Objects.equals(s.getManufacturer().getCountry(), country)).toList();
    }

    //• Вивести інформацію про виробників, чиї ціни на сувеніри менше заданої.
    public List<Souvenir> sortByPrice(List<Souvenir> souvenirs, Double price){
        return souvenirs.stream().filter(s -> s.getPrice() < price).toList();
    }

    //• Вивести інформацію по всіх виробниках та, для кожного виробника вивести інформацію про всі сувеніри, які він виробляє.
    public List<Souvenir> sortManufacturer(List<Souvenir> souvenirs){
       return souvenirs.stream().sorted(Comparator.comparing(s -> s.getManufacturer().getName())).toList();
    }

    //• Вивести інформацію про виробників заданого сувеніру, виробленого у заданому року.
    public List<Souvenir> sortByYearAndName(List<Souvenir> souvenirs,String souvenir,  String year){
        return souvenirs.stream().filter(s -> Objects.equals(s.getDate().substring(s.getDate().length() - 4), year))
                .filter(s -> Objects.equals(s.getName(), souvenir)).toList();
    }

    //• Для кожного року вивести список сувенірів, зроблених цього року.
    public List<Souvenir> sortByYear(List<Souvenir> souvenirs){
        return souvenirs.stream().sorted(Comparator.comparing(s -> s.getDate().substring(s.getDate().length() - 4))).toList();
    }

    //• Видалити заданого виробника та його сувеніри.
    public List<Souvenir> deleteManufacturer(List<Souvenir> souvenirs, String manufacturer){
        return souvenirs.stream().filter(s -> !Objects.equals(s.getManufacturer().getName(), manufacturer)).toList();

    }
}
