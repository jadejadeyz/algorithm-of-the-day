package google;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTimeSolver {
    public String nextClosestTime(String time) {
        Set<Integer> digits = new HashSet<>();
        // parse the digits of the given time
        for (int i = 0; i < 4; i++) {
            String digit = String.valueOf(time.charAt(i));
            digits.add(Integer.parseInt(digit));
        }

        Integer hour = Integer.parseInt(time.substring(0, 2));
        Integer minute = Integer.parseInt(time.substring(3, 5));

        return "not solved yet";
    }
}
