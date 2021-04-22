package Marathon;

import java.util.HashMap;

public class Main {
    /*
        Many player participated Auckland Marathon 2021.
        Everyone completed the race except one person. When participant and completion lists are given.
        How should we find the last person who didn't completed the race?

        - condition -
        * Number of marathoners are 1 to 100000
        * Participant size is 1 larger tha completion
        * Racer's names are compose with 1 to 20 alphabet
        * People might have same name
     */
    public static void main(String[] args) {
        //dummy data
        String[] participant = new String[4];
        participant[0] = "leo";
        participant[1] = "kiki";
        participant[2] = "eden";
        participant[3] = "eden";


        //dummy data
        String[] completion = new String[3];
        completion[0] = "kiki";
        completion[1] = "leo";
        completion[2] = "eden";


        HashMap<String, Integer> result = new HashMap<>();
        for (String player : participant) {
            int count = 0;
            Integer value = result.get(player);
            if (value != null) {
                count = value;
            }
            result.put(player, ++count);
        }
        for (String player : completion) {
            Integer count = result.get(player);
            if (count == null) {
                System.out.println("Unknown player found " + player);
            } else if (count == 1) {
                result.remove(player);
            }
        }
        String answer = result.keySet().iterator().next();
        System.out.println(answer);
    }
}
