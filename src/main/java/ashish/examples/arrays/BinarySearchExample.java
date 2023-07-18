package ashish.examples.arrays;

import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] arr = {5, 66, 0, 56, 94, 88, 7};
        int key = 5;
        Arrays.sort(arr);
        BinarySearchExample obj = new BinarySearchExample();
        int location = obj.binarySearch(arr, key);
        if (location < 0) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Element present at " + location);
        }
    }

    public int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            int midValue = arr[mid];
            if (midValue == key) {
                return mid;
            }
            if (midValue < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
