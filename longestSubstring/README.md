# Problem description
Given a string, find the length of the longest substring without repeating characters.<br>
<br>
Example 1:<br>
<br>
Input: "abcabcbb"<br>
Output: 3 <br>
Explanation: The answer is "abc", with the length of 3. <br>
Example 2:<br>
<br>
Input: "bbbbb"<br>
Output: 1<br>
Explanation: The answer is "b", with the length of 1.<br>
Example 3:<br>
<br>
Input: "pwwkew"<br>
Output: 3<br>
Explanation: The answer is "wke", with the length of 3. <br>
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.<br>
<br>
# Solution
There are two way to solve this problem, 1. Brute Force, 2. Dynamic Programming<br>
First solution need to enumerate every substring, check the repeating characters. Time complexity: O(n3), space complexity: O(min(m, n))*<br>
Second solution, save the characters in a HashMap, then check the repeating of next character, iterate once. time complexity: O(n), space complexity: O(min(m, n))<br>
<br>
Tips: m means the size of string, n means the size of character<br>
<br>
# Tips
**Always create algorithm first!**
