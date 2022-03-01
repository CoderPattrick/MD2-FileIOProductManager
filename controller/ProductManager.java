package controller;
import model.Product;
import java.io.IOException;
import java.util.Scanner;

import static storage.IOManager.writeFile;
import static viewer.Main.listClient;

public class ProductManager {
    public static void addProduct(){
        Scanner input2 = new Scanner(System.in);
        System.out.print("\nID của sản phẩm: ");
        String id = input2.nextLine();

        Scanner input3 = new Scanner(System.in);
        System.out.print("\nTên của sản phẩm: ");
        String name = input3.nextLine();

        Scanner input4 = new Scanner(System.in);
        System.out.print("\nNơi sản xuất của sản phẩm: ");
        String from = input4.nextLine();

        Scanner input5 = new Scanner(System.in);
        System.out.print("\nGiá của sản phẩm: ");
        double price = input5.nextDouble();

        Scanner input6 = new Scanner(System.in);
        System.out.print("\nGhi chú cho sản phẩm: ");
        String etc = input6.nextLine();

        Product target =new Product(id,name,from,price,etc);
        listClient.add(target);
        try {
            writeFile(listClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void removeProduct(Product product){
        listClient.remove(product);
        try {
            writeFile(listClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int indexOfProductById(String id){
        for (int i = 0; i < listClient.size(); i++) {
            String elementId =(listClient.get(i)).getId();
            if(elementId.equals(id)) return i;
        }
        return -1;
    }
    public static Product getProductById(String id){
        int index = indexOfProductById(id);
        return listClient.get(index);
    }
    public static void setProductById() {
        Scanner input = new Scanner(System.in);
        System.out.println("Id của sản phẩm bạn muốn sửa");
        String id = input.nextLine();
        Product target = getProductById(id);
        boolean check = true;
        while (check) {
            System.out.println("1. Tên");
            System.out.println("2. Nơi sản xuất");
            System.out.println("3. Giá");
            System.out.println("4. Ghi chú thêm");
            System.out.print("Chọn mục bạn muốn sửa hoặc gõ số '0' để thoát: ");
            Scanner inputC = new Scanner(System.in);
            int choice = inputC.nextInt();
            switch(choice){
                case 1:
                    Scanner input3 = new Scanner(System.in);
                    System.out.print("\nTên mới của sản phẩm: ");
                    String name = input3.nextLine();
                    target.setName(name);
                    System.out.println("\nHoàn tất!");
                    break;
                case 2:
                    Scanner input4 = new Scanner(System.in);
                    System.out.print("\nNơi sản xuất của sản phẩm: ");
                    String from = input4.nextLine();
                    target.setMadeIn(from);
                    System.out.println("\nHoàn tất!");
                    break;
                case 3:
                    Scanner input5 = new Scanner(System.in);
                    System.out.print("\nGiá mới của sản phẩm: ");
                    double price = input5.nextDouble();
                    target.setPrice(price);
                    System.out.println("\nHoàn tất!");
                    break;
                case 4:
                    Scanner input6 = new Scanner(System.in);
                    System.out.print("\nGhi chú cho sản phẩm: ");
                    String etc = input6.nextLine();
                    target.setName(etc);
                    System.out.println("\nHoàn tất!");
                    break;
                case 0:
                    check=false;
            }
            System.out.println("Thông tin sản phẩm đã sửa: \n"+target);
        }
    }
}
