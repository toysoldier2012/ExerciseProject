# Problem description
Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.<br>
<br>
IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;<br>
<br>
Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.<br>
<br>
IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).<br>
<br>
However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.<br>
<br>
Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.<br>
<br>
Note: You may assume there is no extra space or special characters in the input string.<br>
<br>
Example 1:<br>
Input: "172.16.254.1"<br>
<br>
Output: "IPv4"<br>
<br>
Explanation: This is a valid IPv4 address, return "IPv4".<br>
<br>
Example 2:<br>
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"<br>
<br>
Output: "IPv6"
<br>
Explanation: This is a valid IPv6 address, return "IPv6".<br>
<br>
Example 3:<br>
Input: "256.256.256.256"<br>
<br>
Output: "Neither"
<br>
Explanation: This is neither a IPv4 address nor a IPv6 address.<br>
<br>
# Tips:
My solution is not quiet simple, so i need to make my mind clear<br>
* For IPv4 address, the situations below is not allowed:
1. Start or end with '.'
2. More or less than 4 parts
3. For each part, can't be empty and contains only the number enter 0-255(include)
* For IPv6 address, the situations below is not allowed:
1. Start or end with ':'
2. More or less than 8 parts
3. For each part, can't be empty and contains only 4 characters a-f/A-F or numbers 0-9
