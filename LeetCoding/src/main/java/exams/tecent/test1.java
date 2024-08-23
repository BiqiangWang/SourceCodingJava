package exams.tecent;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/8/23 19:01
 */

public class test1 {
    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public int merge (ListNode a) {
        boolean isZero = false;
        int ans = 0;
        if (a.val == 0) isZero = true;
        a = a.next;
        while (a != null) {
            if (isZero) {
                if (a.val == 0) ans++;
                else {
                    isZero = false;
                }
            } else {
                if (a.val == 0) {
                    isZero = true;
                } else {
                    ans++;
                }
            }
            a = a.next;
        }
        return ans;
    }
}
