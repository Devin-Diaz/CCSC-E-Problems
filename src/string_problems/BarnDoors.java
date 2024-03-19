package string_problems;

/*
    A “barn door” can be drawn from text characters as follows:
    Width 3
    +-+
    |X|
    +-+
    Width 5
    +---+
    |\ /|
    | X |
    |/ \|
    +---+
    Width 7
    +-----+
    |\ /|
    | \ / |
    | X |
    | / \ |
    |/ \|
    +-----+
    Write a program that generates barn door figures of arbitrary widths. Each line of
    input will specify an integer value. For all of the odd inputs that are 3 or greater, the
    program should print the barn door figure of that width. For all non-negative even inputs,
    the program should print a single line with a message of the form
    N is even
    where N is the input value. If the input is 1, the program should print a single line with
    the message
    Too small
    As a special case, if the input value is less than 0, the program should exit immediately.
    You can assume that the input will be terminated by a line with a negative input value.
*/


public class BarnDoors {

    public static void createBarnDoor(int N) {
        if (N < 0) {
            System.exit(0);
        }
        else if (N == 1) {
            System.out.println("Too small");
        }
        else if (N % 2 == 0) {
            System.out.println(N + " is even");
        }
        else if (N >= 3) {
            String top = constructTopBottom(N - 2);
            System.out.println(top);
            constructBody(N - 2, top.length());
            System.out.println(top);
        }
    }

    private static String constructTopBottom(int N) {
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for (int i = 0; i < N; i++) {
            sb.append('-');
        }
        sb.append('+');
        return sb.toString();
    }

    private static void constructBody(int N, int totalLen) {
        int spaces = (totalLen - 3) / 2;

        for (int i = 0; i < N; i++) {
            if (i == N / 2) {
                System.out.print("|");
                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }
                System.out.print("X");
                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }
                System.out.println("|");
            } else {
                System.out.println("|   |");
            }
        }
    }

    public static void main(String[] args) {
        int[] n = {3, 2, 5, 7, 1, -1};
        for (int value : n) {
            createBarnDoor(value);
        }
    }

}