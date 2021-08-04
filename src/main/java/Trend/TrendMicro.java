package Trend;

public class TrendMicro {
    public static int numberOfGames(String start, String end) {
        String[] time = start.split(":");
        Integer startHour = Integer.parseInt(time[0]);
        Integer startMin = Integer.parseInt(time[1]);

        String[] time2 = end.split(":");
        Integer endHour = Integer.parseInt(time2[0]);
        Integer endMin = Integer.parseInt(time2[1]);

        // add 24 hours or not -> end total time less than start
        int totalEnd = endHour * 60 + endMin;
        int totalStart = startHour * 60 + startMin;
        if (totalEnd < totalStart) {
            // end at 1o clock -> ends at 25o clock
            endHour += 24;
        }
        // 把開始分鐘歸類成可開始的時間
        // 0 , 15, 30, 45, 60 -> 60 是下個小時 小時要加一
        if (startMin > 0 && startMin <= 15) {
            startMin = 15;
        } else if (startMin > 15 && startMin <= 30) {
            startMin = 30;
        } else if (startMin > 30 && startMin <= 45) {
            startMin = 45;
        } else if (startMin > 45) {
            startMin = 0;
            startHour++;
        } else {
            startMin = 0;
        }
        totalStart = startHour * 60 + startMin;
        totalEnd = endHour * 60 + endMin;
        int result = 0;

        if (totalEnd != totalStart) {
            while ((totalStart + (result + 1) * 15) <= totalEnd) {
                result++;
            }
        }
        return result;
    }
    public static void main (String[] args) {
        String time1 = "12:45";
        String time2 = "12:44";

        int result = numberOfGames(time1, time2);
        System.out.println(result + " games!");

        String time3 = "20:13";
        String time4 = "06:13";
        int result2 = numberOfGames(time3, time4);
        System.out.println(result2 + " games!");
    }
}
