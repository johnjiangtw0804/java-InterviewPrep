import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (max <= list.get(i)) {
                max = list.get(i);
            }
        }
        list.remove(new Integer(max));

        int secondMax = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (secondMax <= list.get(0)) {
                secondMax = list.get(i);
            }
        }
        return max + secondMax;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 9, 7, 11));
        System.out.println(findMaxSum(list));
    }
}