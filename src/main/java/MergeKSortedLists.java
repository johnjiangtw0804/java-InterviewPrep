import java.util.PriorityQueue;

public class MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((n1, n2) -> {
            return n1.val - n2.val;
        });

        for (int i = 0; i < lists.length; i++) {
            pq.offer(lists[i]);
        }

        while (!pq.isEmpty()) {
            ListNode currBig = pq.poll();
            if (currBig.next != null) {
                pq.offer(currBig.next);
            }

            tail.next = currBig;
            tail = tail.next;
        }

        return dummy.next;
    }
}
