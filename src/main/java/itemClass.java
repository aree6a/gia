public class itemClass {
    private String name;
    private double price;
    private boolean availability;

    public itemClass(String name, double price, boolean availability) {
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public boolean getAvailability(){
        return availability;
    }
    public void setInStock(boolean availability) {
        this.availability = availability;
    }

}
