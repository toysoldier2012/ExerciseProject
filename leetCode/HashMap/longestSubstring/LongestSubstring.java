package leetCode.HashMap.longestSubstring;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {        
        int iteratorPointer = 0, basePointer = 0;
        int max = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        
        while(iteratorPointer < s.length()){
            if(charMap.containsKey(s.charAt(iteratorPointer)))
                basePointer = Math.max(basePointer, charMap.get(s.charAt(iteratorPointer)) + 1);
            max = Math.max(max, iteratorPointer - basePointer +1);
            charMap.put(s.charAt(iteratorPointer), iteratorPointer++);
        }
        return max;
    }
}