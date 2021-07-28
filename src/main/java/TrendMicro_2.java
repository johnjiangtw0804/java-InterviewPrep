import java.util.PriorityQueue;

public class TrendMicro_2 {
    public static int minMovePositiveRevenue(int[] revenues) throws Exception {
        int currentSum = 0;
        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int moved = 0;
        for (int i = 0; i < revenues.length; i++) {
            // 這樣可以取的當前最小值
            pq.add(revenues[i]);
            currentSum += revenues[i];
            // 如果有最小值了 跟 我們revenue變負的時候
            if (currentSum < 0 && pq.size() > 0) {
                // 移動步數加一
                result++;
                // 拿出當前經歷過之最小值移到後面
                int currSmallest = pq.poll();
                currentSum -= currSmallest;
                moved += currSmallest;
            }
        }

        int afterSum = currentSum + moved;
        if (afterSum < 0) {
            throw new Exception("Bug");
        }
        return result;
    }
    public static void main (String[] args) {
        int[] revenues = new int[]{-100, -200, 300, -700, 120000};
        try {
            int result = minMovePositiveRevenue(revenues);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}