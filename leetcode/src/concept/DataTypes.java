package concept;

public class DataTypes {
    public static void swap(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
    }

    public static int[] generate(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = i + 10;

        System.out.print(result.toString());
        return result;
    }
}
