import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class GarageBillingApp {

    public static void main(String[] args) {
        GarageService garageService = new GarageService();
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------- Jay Bhavani Car Services ---------------");

        while(true)
        {

            System.out.println("1. Add Customer ");
            System.out.println("2. Display Services ");
            System.out.println("3. Exit ");
            System.out.println("Enter Your choice: ");

            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter the Customer Name: ");
                    String name = sc.next();
                    System.out.println("Enter the Phone Number: ");
                    String phone = sc.next();
                    System.out.println("Enter the Car Number: ");
                    String carNumber = sc.next();
                    System.out.println("Enter car Model: ");
                    String model = sc.next();

                    garageService.addCustomers(name , phone , carNumber , model);
                    break;

                case 2:

                    System.out.println("Enter car number: ");
                    String carNo = sc.next();
                    garageService.createInvoice(carNo);
                    break;

                case 3:

                    System.out.println("Exiting..... Thank You !!!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice..... Try Again!!!");

            }
        }
    }
}
