import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        Car[] cars = new Car[] {
            new Car("Nissan", 5000, 2020, "red", new String[] {"tires", "keys"}),
            new Car("Dodge", 8500, 2019, "blue", new String[] {"tires", "keys"}),
            new Car("Nissan", 5000, 2017, "yellow", new String[] {"tires", "filter"}),
            new Car("Honda", 7000, 2019, "orange", new String[] {"tires", "filter"}),
            new Car("Mercedes", 12000, 2015, "jet black", new String[] {"tires", "filter", "transmission"})
        };
        
        Dealership dealership = new Dealership(cars);
        
        // get user desired manufacturer & budget
        System.out.println("\n ****** JAVA DEALERSHIP! ****** \n");

        System.out.print("Welcome! Enter the type of car you're looking for: ");
        String make = scan.nextLine();

        System.out.print("\nEnter your budget: ");
        int budget = scan.nextInt();

        // call the search method from Dealership class 
        int search = dealership.search(make, budget);

        // if the manufacturer & budget didn't match 
        if (search == 404) {
            System.out.println("Feel free to browse through our collection of cars.\n");
            System.out.println(dealership);

            System.out.print("Any interest? Let us know the parking spot: "); // give a chance to take another pick

            int pickSpot = scan.nextInt();

            try {
                Car pickCar = dealership.getCar(pickSpot);

                if (pickCar != null) {
                    dealership.sell(pickSpot);
                } else {
                    System.out.println("That car is sold.");
                }

            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("\nWe have no car on that Parking Spot.\n");
            }

        } else {
            dealership.sell(search); // sell the car
        }

        // Task 6 – Ignore letter cases.

        scan.close();

    }
}

