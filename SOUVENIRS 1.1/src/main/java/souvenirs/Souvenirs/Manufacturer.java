package souvenirs.Souvenirs;

import java.io.Serializable;

/*
Для виробників необхідно зберігати:
• назву;
• країну.
 */

public class Manufacturer implements Serializable {

    private String name;
    private String country;

    public Manufacturer(String name, String country){
        this.name = name;
        this.country = country;
    }

    public String toString(){
        return "«" + name + "»; " + country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
