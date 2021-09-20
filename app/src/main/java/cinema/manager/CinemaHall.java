package cinema.manager;


public class CinemaHall {

    private static final String VACANT_SEAT = "S";
    private static final String BOOKED_SEAT = "B";
    private static final int PRICE_FRONT_ROW = 10;
    private static final int PRICE_BACK_ROW = 8;

    private final int rowsOfSeats;
    private final int seatsInRow;

    private final int totalIncome;
    private int boughtTickets = 0;
    private int currentIncome = 0;

    private final boolean[][] allSeats;


    public CinemaHall(int rowsOfSeats, int seatsInRow) {
        this.rowsOfSeats = rowsOfSeats;
        this.seatsInRow = seatsInRow;
        this.totalIncome = totalIncome();

        allSeats = new boolean[rowsOfSeats][seatsInRow];
    }

    private int totalIncome() {
        int totalSeats = rowsOfSeats * seatsInRow;

        if (totalSeats <= 60) {
            return totalSeats * PRICE_FRONT_ROW;
        } else {
            int frontRows = rowsOfSeats / 2;
            int frontRowsIncome = frontRows * seatsInRow * PRICE_FRONT_ROW;

            int backRows = rowsOfSeats - frontRows;
            int backRowsIncome = backRows * seatsInRow * PRICE_BACK_ROW;

            return backRowsIncome + frontRowsIncome;
        }
    }


    public int buyTicket(int row, int seat) {
        if (allSeats[--row][--seat])
            return 0;
        allSeats[row][seat] = true;
        boughtTickets++;
        int price = getPrice(++row);
        currentIncome += price;

        return price;
    }

    private int getPrice(int row) {
        if (row <= (rowsOfSeats / 2) || (rowsOfSeats * seatsInRow) <= 60)
            return PRICE_FRONT_ROW;
        else
            return PRICE_BACK_ROW;
    }


    public void showStatistics() {
        System.out.println("\nNumber of purchased tickets: " + boughtTickets);
        System.out.printf("Percentage: %.2f%%\n", ((boughtTickets * 100.0) / (rowsOfSeats * seatsInRow)));
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    // StringBuilder ~10 times faster than just print or Arrays.deepToString. I measured.
    public StringBuilder showSeats() {
        StringBuilder seats = new StringBuilder("\nCinema:\n  ");

        for (int i = 1; i <= seatsInRow; i++) {
            seats.append(i).append(" ");
        }
        seats.append("\b\n");

        for (int i = 0; i < rowsOfSeats; i++) {
            seats.append(i + 1).append(" ");
            for (int j = 0; j < seatsInRow; j++) {
                seats.append(allSeats[i][j] ? BOOKED_SEAT : VACANT_SEAT).append(" ");
            }
            seats.append("\b\n");
        }
        return seats;
    }
}