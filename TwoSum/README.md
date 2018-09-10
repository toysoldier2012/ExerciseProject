# Problem description
Given an array of integers, return indices of the two numbers such that they add up to a specific target.<br>
You may assume that each input would have exactly one solution, and you may not use the same element twice.<br>
<br>
Example:<br>
Given nums = [2, 7, 11, 15], target = 9,<br>
Because nums[0] + nums[1] = 2 + 7 = 9,<br>
return [0, 1].<br>

# twoSumSolution1
Time complexity O(n2)
Space complexity O(1)

# twoSumSolution1
Solution with a HashSet, save the left of target minus each number in array, 
and for each left, try to find the same number in array with different index<br>
* Time complexity O(n)
* Space complexity O(n)

# twoSumSolution1
Solution with HashMap, calculate the left of target minus the number in array with index i
save the left in a HashMap<Integer> where if it doesn't exist in, 
otherwise, the result is the index of left in the HashMap and the index i. And HashMap is faster than HashSet<br>
* Time complexity O(n)
* Space complexity O(n)
