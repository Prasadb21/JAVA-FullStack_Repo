public class Customer {

    private int id;

    private String name;

    private String phone;

    private Car car;


    public Customer( String phone, String name, Car car) {

        this.phone = phone;
        this.name = name;
        this.car = car;
    }


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Car getCar() {
        return car;
    }
}
