/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = { -1, -1 };

        int minDistance = Integer.MAX_VALUE;
        ListNode prev = head;
        ListNode curr = head.next;

        int currIndex = 1;
        int prevCriticalIndex = 0;
        int firstCriticalIndex = 0;

        while (curr.next != null) {

            if ((curr.val < prev.val && curr.val < curr.next.val) || (curr.val > prev.val && curr.val > curr.next.val)) {

                if (prevCriticalIndex == 0) {
                    prevCriticalIndex = currIndex;
                    firstCriticalIndex = currIndex;

                } else {
                    minDistance = Math.min(minDistance, currIndex - prevCriticalIndex);

                    prevCriticalIndex = currIndex;
                }
            }

            currIndex++;
            prev = curr;
            curr = curr.next;

        }

        if(minDistance != Integer.MAX_VALUE){
            int maxDistance = prevCriticalIndex - firstCriticalIndex;
            ans = new int[]{minDistance , maxDistance};
        }

        return ans;

    }
}