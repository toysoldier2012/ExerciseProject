package leetCode.addTwoNumbers;

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode resLn = new ListNode(0);
		ListNode nextLn = resLn;

        if(l1 == null && l2 == null)
            throw new IllegalArgumentException("Please enter two right numbers, u idiot!");
        
		while (true) {
			int addend1 = l1 == null ? 0 : l1.val;
			int addend2 = l2 == null ? 0 : l2.val;
			int sum = addend1 + addend2 + carry;
			nextLn.val = sum % 10;
			carry = sum / 10;

			if (l1.next == null && l2.next == null && carry == 0)
				return resLn;
			nextLn.next = new ListNode(0);
			l1 = l1.next == null ? new ListNode(0) : l1.next;
			l2 = l2.next == null ? new ListNode(0) : l2.next;
			nextLn = nextLn.next;
		}
	}
}