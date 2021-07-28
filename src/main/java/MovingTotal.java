import java.util.HashSet;

public class MovingTotal {
    private HashSet<Integer> set = new HashSet<>();
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void append(int[] list) {
        for (int i = 0; i < list.length; i++) {
            set.add(list[i]);
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        for (Integer e : set) {
            Integer second = null;
            Integer third = null;
           if (set.contains(e+1)) {
                second = e + 1;
           }
           if (set.contains(e+2)) {
               third = e + 2;
           }

           if (second != null && third != null && second + third + e == total) {
               return true;
           }
        }
        return false;
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3 , 4, 5, 6});

        System.out.println(movingTotal.contains(11));
        System.out.println(movingTotal.contains(9));

        movingTotal.append(new int[] { 4 });

        System.out.println(movingTotal.contains(9));
    }
}