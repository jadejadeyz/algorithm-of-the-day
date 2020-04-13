package google;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-2147483648,2147483647};

        MissingRangesSolver solver = new MissingRangesSolver();
        solver.findMissingRanges(nums, nums[0], nums[1]);
    }
}
