# Problem description
Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, <br>
reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­<br>
<br>
You may not modify the values in the list's nodes, only nodes itself may be changed.<br>
<br>
Example 1:<br>
<br>
Given 1->2->3->4, reorder it to 1->4->2->3.<br>
Example 2:<br>
<br>
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.<br>
<br>
# Tips:
* Time complexity: O(n)<br>
* Space complexity: O(1);<br>
<br>
Step.1 split the singly-linked list in two part <br>
Step.2 reverse the second part <br>
Step.3 merge two linked list<br>
All three steps is important<br>