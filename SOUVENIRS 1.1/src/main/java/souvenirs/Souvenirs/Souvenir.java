package souvenirs.Souvenirs;

import java.io.Serializable;
import java.util.List;

/*
Для сувенірів необхідно зберігати:
• назву;
• реквізити виробника;
• дату випуску;
• ціну.
 */

public class Souvenir implements Serializable {

    private String name;
    private Manufacturer manufacturer;
    private String date;
    private Double price;

    public Souvenir(){

    }

    public Souvenir(String name, Manufacturer manufacturer, String date, double price){
        this.name = name;
        this.manufacturer = manufacturer;
        this.date = date;
        this.price = price;
    }

    public String toString(){
        return "Назва: " + name + " Виробник: " + manufacturer + " Дата виробництва: " + date + " Ціна: " + price;
    }

    public List<Souvenir> add(List<Souvenir> souvenirs, Souvenir newSouvenir){
        souvenirs.add(newSouvenir);
        return souvenirs;
    }

    public String getName() {
        return name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturerName(String manufacturer) {
        this.manufacturer.setName(manufacturer);
    }

    public void setManufacturerCountry(String country) {
        this.manufacturer.setCountry(country);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
