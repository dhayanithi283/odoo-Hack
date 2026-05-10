// ODOO HACKATHON PROJECT
// TRAVELOOP - SMART TRAVEL PLANNING SYSTEM

import java.util.*;

// Trip class
class Trip {

    int tripId;
    String userName;
    String destination;
    int days;
    double budget;

    Trip(int tripId, String userName, String destination, int days, double budget) {

        this.tripId = tripId;
        this.userName = userName;
        this.destination = destination;
        this.days = days;
        this.budget = budget;
    }

    void displayTrip() {

        System.out.println("\n========== TRIP DETAILS ==========");

        System.out.println("Trip ID       : " + tripId);
        System.out.println("User Name     : " + userName);
        System.out.println("Destination   : " + destination);
        System.out.println("Travel Days   : " + days);
        System.out.println("Trip Budget   : ₹" + budget);

        System.out.println("==================================");
    }
}

public class Main {

    static ArrayList<Trip> trips = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("      WELCOME TO TRAVELOOP");
        System.out.println(" Smart Travel Planning System");
        System.out.println("======================================");

        while (true) {

            System.out.println("\n1. Create Trip");
            System.out.println("2. View All Trips");
            System.out.println("3. Search Trip");
            System.out.println("4. Delete Trip");
            System.out.println("5. Total Budget");
            System.out.println("6. Exit");

            System.out.print("\nEnter Your Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createTrip();
                    break;

                case 2:
                    viewTrips();
                    break;

                case 3:
                    searchTrip();
                    break;

                case 4:
                    deleteTrip();
                    break;

                case 5:
                    totalBudget();
                    break;

                case 6:
                    System.out.println("\nThank You For Using Traveloop!");
                    System.exit(0);

                default:
                    System.out.println("\nInvalid Choice!");
            }
        }
    }

    static void createTrip() {

        sc.nextLine();

        System.out.print("\nEnter Trip ID : ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter User Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Destination : ");
        String destination = sc.nextLine();

        System.out.print("Enter Number of Days : ");
        int days = sc.nextInt();

        System.out.print("Enter Budget : ");
        double budget = sc.nextDouble();

        Trip trip = new Trip(id, name, destination, days, budget);

        trips.add(trip);

        System.out.println("\nTrip Created Successfully!");
    }

    static void viewTrips() {

        if (trips.isEmpty()) {

            System.out.println("\nNo Trips Available!");
            return;
        }

        System.out.println("\n===== ALL TRIPS =====");

        for (Trip t : trips) {

            t.displayTrip();
        }
    }

    static void searchTrip() {

        System.out.print("\nEnter Trip ID to Search : ");

        int id = sc.nextInt();

        boolean found = false;

        for (Trip t : trips) {

            if (t.tripId == id) {

                t.displayTrip();

                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("\nTrip Not Found!");
        }
    }

    static void deleteTrip() {

        System.out.print("\nEnter Trip ID to Delete : ");

        int id = sc.nextInt();

        boolean removed = false;

        Iterator<Trip> iterator = trips.iterator();

        while (iterator.hasNext()) {

            Trip t = iterator.next();

            if (t.tripId == id) {

                iterator.remove();

                removed = true;

                System.out.println("\nTrip Deleted Successfully!");

                break;
            }
        }

        if (!removed) {

            System.out.println("\nTrip Not Found!");
        }
    }

    static void totalBudget() {

        double total = 0;

        for (Trip t : trips) {

            total += t.budget;
        }

        System.out.println("\nTotal Budget of All Trips : ₹" + total);
    }
}
