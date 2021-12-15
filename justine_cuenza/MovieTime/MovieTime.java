import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class MovieTime {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Queue<String> movies = new LinkedList<String>();
        Queue<String> snacks = new LinkedList<String>();

        for (int i = 0; i < 3; i++) {
            System.out.format("Enter movie %d of %d: ", i + 1, 3);
            String movie = scanner.nextLine();
            movies.add(movie);
        }

        for (int i = 0; i < 3; i++) {
            System.out.format("Enter snack %d of %d: ", i + 1, 3);
            String snack = scanner.nextLine();
            snacks.add(snack);
        }

        System.out.println("Movies to watch are: deque(" + movies + ")" );
        System.out.println("Snacks available are: deque(" + snacks + ")" );

        System.out.println("Press S each time you will finish a snack");

        while (snacks.size() > 0) {
            char input = scanner.next().toUpperCase().charAt(0);
            if (input == 'S') {
                snacks.poll();
            }

            if(snacks.size() > 0) {
                System.out.println("deque(" + snacks + ")" );
            } else {
                System.out.println("No more snacks");
            }
        }
    }
}
