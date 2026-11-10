
package com.java;

import java.util.Scanner;

public class moive {

    static boolean[][] seats = new boolean[5][5];

    static Scanner sc = new Scanner(System.in);

    static double ticketPrice = 150;

    // Display Available Seats
    static void showSeats() {

        System.out.println("\n===== AVAILABLE SEATS =====");

        for (int i = 0; i < seats.length; i++) {

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j]) {
                    System.out.print("[ X ] ");
                } else {
                    System.out.print("[ " + (i * 5 + j + 1) + " ] ");
                }
            }

            System.out.println();
        }
    }

    // Book Ticket
    static void bookTicket() {

        showSeats();

        System.out.print("\nEnter Seat Number (1-25): ");
        int seat = sc.nextInt();

        if (seat < 1 || seat > 25) {
            System.out.println("Invalid Seat Number!");
            return;
        }

        int row = (seat - 1) / 5;
        int col = (seat - 1) % 5;

        if (seats[row][col]) {
            System.out.println("Seat Already Booked!");
            return;
        }

        double price = ticketPrice;

        // Weekend Pricing
        System.out.print("Is Today Weekend? (yes/no): ");
        String weekend = sc.next();

        if (weekend.equalsIgnoreCase("yes")) {
            price += 50;
            System.out.println("Weekend Extra Charge: Rs.50");
        }

        // Discount Coupon
        System.out.print("Apply Coupon? (yes/no): ");
        String coupon = sc.next();

        if (coupon.equalsIgnoreCase("yes")) {

            System.out.print("Enter Coupon Code: ");
            String code = sc.next();

            if (code.equalsIgnoreCase("MOVIE10")) {
                price = price - (price * 0.10);
                System.out.println("10% Discount Applied!");
            } else {
                System.out.println("Invalid Coupon Code!");
            }
        }

        // Confirm Booking
        seats[row][col] = true;

        System.out.println("\n===== BOOKING SUCCESSFUL =====");
        System.out.println("Seat Number: " + seat);
        System.out.println("Ticket Price: Rs." + price);
    }

    // Cancel Ticket
    static void cancelTicket() {

        System.out.print("\nEnter Seat Number to Cancel: ");
        int seat = sc.nextInt();

        if (seat < 1 || seat > 25) {
            System.out.println("Invalid Seat Number!");
            return;
        }

        int row = (seat - 1) / 5;
        int col = (seat - 1) % 5;

        if (seats[row][col]) {
            seats[row][col] = false;
            System.out.println("Ticket Cancelled Successfully!");
        } else {
            System.out.println("Seat is Not Booked!");
        }
    }

    // Movie Rating
    static void movieRating() {

        System.out.print("\nEnter Movie Rating (1-5): ");
        int rating = sc.nextInt();

        if (rating >= 1 && rating <= 5) {
            System.out.println("Thank You for Rating: " + rating + "/5");
        } else {
            System.out.println("Invalid Rating! Enter 1 to 5.");
        }
    }

    // Available Seats Count
    static void availableSeatsCount() {

        int count = 0;

        for (int i = 0; i < seats.length; i++) {

            for (int j = 0; j < seats[i].length; j++) {

                if (!seats[i][j]) {
                    count++;
                }
            }
        }

        System.out.println("Total Available Seats: " + count);
        System.out.println("Total Booked Seats: " + (25 - count));
    }

    // Main Method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("    MOVIE TICKET BOOKING SYSTEM");
            System.out.println("================================");

            System.out.println("1. Show Available Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Movie Rating");
            System.out.println("5. Available Seats Count");
            System.out.println("6. Exit");

            System.out.print("\nEnter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showSeats();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelTicket();
                    break;

                case 4:
                    movieRating();
                    break;

                case 5:
                    availableSeatsCount();
                    break;

                case 6:
                    System.out.println("Thank You! Visit Again.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
