package string_problems;

/*
How old are you and your friends in dog years? Let’s find out! One human year is
equal to seven dog years.

Your program should read lines of input consisting of a name and an integer age in
human years. For each input name and human age, the program should print a message
of the form name, you are age in dog years when name is the input name and age is the
input age converted to dog years. You can assume that the name will not contain any spaces,
and that at least one space character will separate the name and the human age. As a special case,
if an input line consists of the text quit, then the program should exit immediately. You can assume
that the overall input will always be terminated by a quit line.
*/

public class DogYears {
    public static void converter(String[] input) {

        for(String s : input) {
            StringBuilder name = new StringBuilder();

            int i = 0;

            try {
                while(s.charAt(i) != ' ') {
                    name.append(s.charAt(i));
                    i++;
                }

            } catch (StringIndexOutOfBoundsException e) {
                break;
            }

            i++;

            StringBuilder age = new StringBuilder();
            while(i < s.length()) {
                age.append(s.charAt(i));
                i++;
            }

            String newAge = age.toString();
            int dogYears = Integer.parseInt(newAge) * 7;
            System.out.println(name + ", you are " + dogYears + " in dog years");

        }
    }

    public static void main(String[] args) {

        String[] input = {"Devin 19",
                          "Bruno 24",
                          "quit",
                          "William 33",
                          "Klaudio 21"};

        converter(input);

        /*
        Devin, you are 133 in dog years
        Bruno, you are 168 in dog years
        William, you are 231 in dog years
        Klaudio, you are 147 in dog years
        */
    }
}
