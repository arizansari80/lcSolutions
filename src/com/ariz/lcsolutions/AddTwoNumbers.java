package com.ariz.lcsolutions;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
	public static void mainFunc(String[] args) {		
		ListNode l1RootS = null, l1RootE = null;
		ListNode l2RootS = null, l2RootE = null;

		for (int i = 0; i < 7; i++) {
			if (l1RootS == null) {
				l1RootS = new ListNode(9, l1RootE);
				l1RootE = l1RootS;
			} else {
				ListNode temp = new ListNode(9);
				l1RootE.next = temp;
				l1RootE = l1RootE.next;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (l2RootS == null) {
				l2RootS = new ListNode(9, l2RootE);
				l2RootE = l2RootS;
			} else {
				ListNode temp = new ListNode(9);
				l2RootE.next = temp;
				l2RootE = l2RootE.next;
			}
		}

		ListNode retVal = addTwoNumbers(l1RootS, l2RootS);
		while (retVal != null) {
			System.out.print(retVal.val + ",");
			retVal = retVal.next;
		}
	}
	
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode retRoot = null;
        ListNode root = null;
        ListNode rootNext = null;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while(node1 != null && node2 != null) {
            int sum = node1.val + node2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (root == null) {
                root = new ListNode(sum,rootNext);
                retRoot = root;
            }
            else {
                rootNext = new ListNode(sum);
                root.next = rootNext;
                root = rootNext;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        while(node1 != null) {
            int sum = node1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (root == null)
                root = new ListNode(sum,rootNext);
            else {
                rootNext = new ListNode(sum);
                root.next = rootNext;
                root = rootNext;
            }
            node1 = node1.next;
        }
        while(node2 != null) {
            int sum = node2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (root == null)
                root = new ListNode(sum,rootNext);
            else {
                rootNext = new ListNode(sum);
                root.next = rootNext;
                root = rootNext;
            }
            node2 = node2.next;
        }
        if (carry > 0) {
        	rootNext = new ListNode(carry);
            root.next = rootNext;
            root = rootNext;
        }
        return retRoot;
    }
}
