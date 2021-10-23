package algo;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pairs {

    public static List<Pair<Integer, Integer>> pairs(int[] list, int target) {
        Arrays.sort(list);
        System.out.println("Sorted Date: " + list);
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        int l = 0;
        int r = list.length - 1;
        while (l < r) {
            int sum = list[l] + list[r];
            if (sum == target) {
                result.add(new Pair(list[l], list[r]));
                r--;
                l++;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return result;
    }

    public static void main(String... args) {
        int target = 10;
        int[] data = {3, 7, 9, 1, 6, 7, 4};
        System.out.println(pairs(data, target));
    }
}
