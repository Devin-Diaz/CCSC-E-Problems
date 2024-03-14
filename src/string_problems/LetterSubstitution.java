package string_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    This program substitutes certain letters with a given input String. However, the subs are a odd, in our
    second given input String, let's say we are given the following,

    1. Hello world!
    2. HmdT

    In this case we would sub all letter H's in (1) with a letter m from (2). So after one iteration our
    (1) String would look like the following,

    1. mello world!

    On the next iteration, we check if our (1) String contains an M, and if so we replace it with a T from
    our (2) String. After the next iteration our (1) String looks like so,

    1. mello worlt

    Our output String for this phrase is mello worlt
    -------------------------------------------------------------------------------------------------------------------

    Another case is checking if our sub string is even or odd. In the example above we were given
    HmdT for our substitution string, in this case we had 4 chars in the string so its valid, however let's
    say we are given an odd ammount like Hdmtf. Then we would return "Wut" for that iteration.

*/




public class LetterSubstitution {

    public static void letterSub(String[] input) {
        List<String> outputList = new ArrayList<>();

        for (int i = 0; i < input.length; i += 2) {
            String originalWord = input[i];
            String subs = input[i + 1].toLowerCase();

            if (subs.length() % 2 != 0) {
                outputList.add("Wut");
                continue;
            }

            Map<Character, Character> subMap = new HashMap<>();

            for (int j = 0; j < subs.length(); j += 2) {
                // Store lowercase to lowercase mapping based on subs
                subMap.put(subs.charAt(j), subs.charAt(j + 1));
            }

            StringBuilder transformedPhrase = new StringBuilder();

            for (char letter : originalWord.toCharArray()) {
                char lowerLetter = Character.toLowerCase(letter);
                if (subMap.containsKey(lowerLetter)) {
                    char obtainedChar = subMap.get(lowerLetter);
                    // Check if original letter was uppercase; if so, convert obtainedChar to uppercase
                    transformedPhrase.append(Character.isUpperCase(letter) ? Character.toUpperCase(obtainedChar) : obtainedChar);
                } else {
                    // If there's no substitution, append the original letter
                    transformedPhrase.append(letter);
                }
            }

            outputList.add(transformedPhrase.toString());
        }

        System.out.println(outputList);
    }

    public static void main(String[] args) {
        // Example input
        String[] input = {
                "Four score and seven years ago", "fyrvea",
                "Hello world", "HmdT",
                "Every day, you must say, \"So how do I feel about my life?\"", "yiio",
                "A strong smell of petroleum prevails throughout", "aiouq"
        };

        letterSub(input);
    }
}