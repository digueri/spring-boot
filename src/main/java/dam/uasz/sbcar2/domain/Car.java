package dam.uasz.sbcar2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand, model, color, registredNumber;
    @Column(name = "`year`")
    private int year;
    private int price;
    public Car() {}
    public Car(String  brand, String color, String model, int price,  String registredNumber, int year, Owner owner){
        super();
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
        this.registredNumber = registredNumber;
        this.year = year;
        this.owner = owner; 
    }
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "owner")
        private Owner owner;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getRegistredNumber() {
        return registredNumber;
    }
    public void setRegistredNumber(String registredNumber) {
        this.registredNumber = registredNumber;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
 
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
}

