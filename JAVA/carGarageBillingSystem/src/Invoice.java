import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private Customer customer;

    private List<Service> serviceList;

    private double totalAMount;


    public Invoice(Customer customer) {
        this.customer = customer;
        this.serviceList = new ArrayList<>();
        this.totalAMount = 0;
    }

    public void addService(Service service)
    {
        serviceList.add(service);
        totalAMount += service.getPrice(); // adding price in total amount as per service is added

    }

    public void printInvoice()
    {
        System.out.println("-----------------Invoice-----------------");
        System.out.println();
        System.out.println("Customer: " + customer.getName() + " | Phone Number: " + customer.getPhone() + " | Car: " + customer.getCar().getModel() + " | Car Number: " + customer.getCar().getNumber());
        System.out.println("Services: ");
        for (int i = 0; i < serviceList.size() ; i++)
        {
            System.out.println((i+1) + " " + serviceList.get(i).getName() + ": $" + serviceList.get(i).getPrice());
        }


        System.out.println("Total Amount: $" + totalAMount);

        System.out.println("-----------------------------------------");

    }

}
