package cinema.manager;

import java.util.Scanner;

public class Cinema {
    private final Scanner input = new Scanner(System.in);
    private final CinemaHall cinemaHall;
    int rowsOfSeats;
    int seatsInRow;
    private boolean exit;

    Cinema() {
        System.out.print("Enter the number of rows:\n> ");
        rowsOfSeats = input.nextInt();

        System.out.print("Enter the number of seats in each row:\n> ");
        seatsInRow = input.nextInt();

        cinemaHall = new CinemaHall(rowsOfSeats, seatsInRow);
        menu();
    }// !! trying to run test with Cube, learn GitAction, maybe some Nana

    /// baagasasg

    private void menu() {
        while (!exit) {
            System.out.print("\n1. Show the seats\n" +
                             "2. Buy a ticket\n" +
                             "3. Statistics\n" +
                             "0. Exit\n" +
                             "> ");
            choices(input.nextInt());
        }
    }

    private void choices(int choice) {
        switch (choice) {
            case 1:
                System.out.println(cinemaHall.showSeats());
                break;
            case 2:
                while (true) {
                    System.out.print("\nEnter a row number:\n> ");
                    int row = input.nextInt();
                    System.out.print("Enter a seat number in that row:\n> ");
                    int seat = input.nextInt();

                    if (row < 1 || row > rowsOfSeats || seat < 1 || seat > seatsInRow) {
                        System.out.println("Wrong input!");
                        continue;
                    }

                    int price = cinemaHall.buyTicket(row, seat);
                    if (price == 0) {
                        System.out.println("\nThat ticket has already been purchased!");
                        continue;
                    }
                    System.out.println("\nTicket price: $" + price);
                    break;
                }
            case 3:
                cinemaHall.showStatistics();
                break;
            case 0:
                exit = true;
                break;
        }
    }

    public static void main(String[] args) {

        new Cinema();
    }
}