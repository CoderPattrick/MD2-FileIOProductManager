package storage;

import model.Product;

import java.io.*;
import java.util.ArrayList;

public class IOManager {
    public static final String productListPath = "storage\\productList.dat";
    public static ArrayList<Product> listProduct = readFile();
    public static void writeFile(ArrayList<Product> list) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(productListPath));
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            oos.close();
        }
    }
    public static ArrayList<Product> readFile(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(productListPath));
            Object listObject = ois.readObject();
            return (ArrayList<Product>) listObject;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
