package other.multiplicationTable;

public class MultiplicationTable {

    /**
     * Prints the multiplication table to the console up until and including the given limit.
     * @param limit The limit
     */
    public static void printTable(int limit) {
        StringBuilder builder = new StringBuilder();
        int x = 1;
        int y = 1;

        while (x <= limit) {
            while (y <= limit) {
                builder.append(x * y).append(" ");
                y++;
            }
            builder.append("\n");
            y = 1;
            x++;
        }

        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        printTable(12);
    }
}
