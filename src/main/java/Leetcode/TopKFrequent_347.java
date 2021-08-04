package Leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent_347 {
    public static int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length) {
            return nums;
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> mostFrequent = new PriorityQueue<Integer>((n1, n2) -> {
            return count.get(n2) - count.get(n1);
        });

        for (Integer e : count.keySet()) {
            mostFrequent.offer(e);
        }
        int[] result = new int[k];
        for (int i = k; i >= 1; i--) {
            result[i - 1] = mostFrequent.poll();
        }
        return result;
    }

    public static void main (String[] args) {
        topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
