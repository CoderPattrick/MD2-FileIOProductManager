package viewer;
import model.Product;
import java.util.ArrayList;
import storage.IOManager;
import controller.*;


public class Main {
    public static ArrayList<Product> listClient = IOManager.readFile();
    public static void main(String[] args) {

        ProductManager.addProduct();
        ProductManager.displayAll();

    }
}
