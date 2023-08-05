package souvenirs.IO;

import souvenirs.Souvenirs.Manufacturer;
import souvenirs.Souvenirs.Souvenir;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO {

    public List<Souvenir> readObjects(){
        String filePath = "souvenirs.txt";
        File file = new File(filePath);
        if (!file.exists()) {
          createFile();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("souvenirs.txt"))){
            return (List<Souvenir>)  ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeObjects(List<Souvenir> souvenirs){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("souvenirs.txt"))) {
            oos.writeObject(souvenirs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createFile() {
        List<Souvenir> souvenirs = new ArrayList<>();
        souvenirs.add(new Souvenir("Creepy Goth Bunny", new Manufacturer("LKMYHY", "China"), "03.08.2023", 625.00));
        souvenirs.add(new Souvenir("Cute Shark Cat ", new Manufacturer("LKMYHY", "China"), "21.12.2020", 499.99));
        souvenirs.add(new Souvenir("Zombie Reading Newspaper", new Manufacturer("Toyswill", "China"), "04.05.1999", 704.65));
        souvenirs.add(new Souvenir("Wooden Cross", new Manufacturer("CLOVER", "UKRAINE"), "16.10.2019", 335.50));
        souvenirs.add(new Souvenir("Zombie Reading Newspaper", new Manufacturer("JINX", "USA"), "18.06.1845", 666.00));
        souvenirs.add(new Souvenir("Anatomy Lab Human Skeleton", new Manufacturer("Cemetery", "USA"), "27.01.2004", 3547.50));
        souvenirs.add(new Souvenir("Anatomy Lab Human Skeleton", new Manufacturer("Kawada", "Japan"), "20.12.2020", 2998.00));
        souvenirs.add(new Souvenir("Cute Snail", new Manufacturer("Tigres", "UKRAINE"), "05.12.2009", 300.00));
        souvenirs.add(new Souvenir("Cute Pink Axolotl", new Manufacturer("LKMYHY", "China"), "22.09.2021", 515.50));
        souvenirs.add(new Souvenir("Zombie Reading Newspaper", new Manufacturer("McFarlane", "USA"), "02.01.2039", 1000000.00));
        writeObjects(souvenirs);
    }
}
