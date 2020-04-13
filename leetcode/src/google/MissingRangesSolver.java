package google;

import java.util.ArrayList;
import java.util.List;

public class MissingRangesSolver {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missings = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper)
                missings.add(String.valueOf(lower));
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(lower);
                sb.append("->");
                sb.append(upper);
                missings.add(sb.toString());
            }
            return missings;
        }

        if (nums[0] - lower == 1) {
            missings.add(String.valueOf(lower));
        }
        if (nums[0] - lower >= 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(lower);
            sb.append("->");
            sb.append(nums[0]-1);
            missings.add(sb.toString());
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 2)
                missings.add(String.valueOf(nums[i]-1));
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i-1]+1);
                sb.append("->");
                sb.append(nums[i]-1);
                missings.add(sb.toString());
            }
        }

        if (upper - nums[nums.length-1] == 1)
            missings.add(String.valueOf(upper));
        if (upper - nums[nums.length-1] >= 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[nums.length-1]+1);
            sb.append("->");
            sb.append(upper);
            missings.add(sb.toString());
        }

        return missings;
    }
}
