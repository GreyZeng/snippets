package leetcode;

// https://leetcode.com/problems/add-two-numbers/
public class LeetCode_0002_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // l1 和 l2 的长度一定一样
        int sum = l1.val + l2.val;
        int val = getValue(sum);
        int move = getMove(sum);
        ListNode result = new ListNode(val);
        ListNode c = result;
        ListNode t1 = l1.next;
        ListNode t2 = l2.next;
        while (t1 != null || t2 != null || move != 0) {
            sum = valOrDefault(t1) + valOrDefault(t2) + move;
            c.next = new ListNode(getValue(sum));
            move = getMove(sum);
            c = c.next;
            if (t1 != null) {
                t1 = t1.next;
            }
            if (t2 != null) {
                t2 = t2.next;
            }
        }
        return result;
    }

    public static int valOrDefault(ListNode t) {
        return t == null ? 0 : t.val;
    }

    public static int getMove(int sum) {
        return sum / 10;
    }

    public static int getValue(int sum) {
        return sum % 10;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


