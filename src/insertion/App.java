package insertion;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int count = 0;
        int[] list = new int[count];
        String nextAction = "new";

        while (nextAction.toLowerCase().equals("new") || nextAction.toLowerCase().equals("add")) {
            count = (nextAction.toLowerCase().equals("new")) ? 0 : count;
            System.out.print("Enter List (a, b, c, ...): ");
            String input = in.nextLine() + ", ";

            int newCount = count;
            for (char c : input.toCharArray()) {
                if (c == ',')
                    newCount++;
            }

            if (newCount > 25) {
                System.out.println("Cannot exceed 25 elements");
            } else {
                count = newCount;
                int start;
                if (nextAction.toLowerCase().equals("new")) {
                    start = 0;
                    list = new int[count];
                } else {
                    start = list.length;
                    int[] temp = new int[count];
                    for (int i = 0; i < list.length; i++) {
                        temp[i] = list[i];
                    }
                    list = temp;
                }

                for (int i = start; i < count; i++) {
                    list[i] = Integer.parseInt(input.substring(0, input.indexOf(",")));
                    input = input.substring(input.indexOf(" ") + 1);
                }

                InsertionSort sort = new InsertionSort(list);
                sort.insertionSort(start);
                System.out.println("\n" + Arrays.toString(list));

                StatsReport report = new StatsReport(list);
                System.out.println(report.generate());
            }

            System.out.println("To add more items: \"add\"");
            System.out.println("To reset the list: \"new\"");
            nextAction = in.next();
            in.nextLine();
        }

        in.close();
    }
}
