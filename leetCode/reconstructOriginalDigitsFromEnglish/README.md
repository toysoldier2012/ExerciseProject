# Problem description
Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.<br>
<br>
Note:<br>
Input contains only lowercase English letters.<br>
Input is guaranteed to be valid and can be transformed to its original digits. 
That means invalid inputs such as "abc" or "zerone" are not permitted.<br>
Input length is less than 50,000.<br>
Example 1:<br>
Input: "owoztneoer"<br>
<br>
Output: "012"<br>
Example 2:<br>
Input: "fviefuro"<br>
<br>
Output: "45"<br>
<br>
# Tips:
* Time complexity: O(n);
* Space complexity: O(1);
<br>
Need to find my own alphabet corresponding to each number 0-9<br>