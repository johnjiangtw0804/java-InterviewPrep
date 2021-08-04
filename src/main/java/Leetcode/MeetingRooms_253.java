package Leetcode;

import java.util.PriorityQueue;

public class MeetingRooms_253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1) {
            return 1;
        }
        // sort according to start time
        PriorityQueue<int[]> pq = new PriorityQueue<>((array, array2) -> {
            return array[0] - array2[0];
        });

        // sort according to end time
        PriorityQueue<Integer> endTime = new PriorityQueue<>();

        for (int[] interval : intervals) {
            pq.add(interval);
        }

        endTime.add(pq.poll()[1]);
        int result = 1;

        for (int i = 1; i < intervals.length; i++) {
            int[] meeting = pq.poll();
            int start = meeting[0];
            int end = meeting[1];

            // 給他這個房
            if (endTime.peek() <= start) {
                endTime.poll();
            }
            // 開間新房
            else if (endTime.peek() > start){
                result++;
            }
            // 加入新加入的meeting
            endTime.offer(end);
        }
        return result;
    }
}
