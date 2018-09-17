package leetCode.linkedList.reorderList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public void reorderList(ListNode head) {
		if (head == null)
			return;

		// Step.1
		ListNode l1 = null, l2 = null;
		ListNode mid = findMid(head);
		l2 = mid.next;
		mid.next = null;
		l1 = head;

		// Step.2
		l2 = reverse(l2);

		// Step.3
		while (l1 != null && l2 != null) {
			ListNode next = l1.next;
			l1.next = l2;
			l2 = l2.next;
			l1.next.next = next;
			l1 = next;
		}
	}

	public ListNode findMid(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}