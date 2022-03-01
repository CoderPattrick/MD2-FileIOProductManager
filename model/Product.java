package model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String madeIn;
    private double price;
    private String etc;

    @Override
    public String toString() {
        return "model.Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", madeIn='" + madeIn + '\'' +
                ", price=" + price +
                ", etc='" + etc + '\'' +
                '}';
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public Product(String id, String name, String madeIn, double price, String etc) {
        this.id = id;
        this.name = name;
        this.madeIn = madeIn;
        this.price = price;
        this.etc = etc;
    }
}
