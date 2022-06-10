package src.algorithm;

import src.structure.ListNode;

/**
 * @author zjn
 * @date 2022/6/10
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        /*//双指针法
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            //保存下一个节点
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;*/
        //递归法
        return reverse(null, head);
    }

    private static ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        //保存下一个节点
        temp = cur.next;
        //反转
        cur.next = prev;
        /*更新prev、cur位置
        prev = cur;
        cur = temp;*/
        return reverse(cur, temp);
    }

    public static void main(String[] args) {
        ListNode.printLinkedList(ReverseLinkedList.reverseList(ListNode.createLinkedList(new int[] {1, 2, 3, 4, 5})));
    }
}

/**
 *Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */