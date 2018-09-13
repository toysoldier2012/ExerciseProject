package leetCode.wordPattern;

import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || pattern.length() == 0 || str == null || str.length() == 0 ) return false;
        
        HashMap<Character, String> matchMap = new HashMap<>();
        String[] strElement = str.split(" ");
        
        if(pattern.length() != strElement.length) return false;
        
        for(int i = 0; i < pattern.length(); i++){
            char key = pattern.charAt(i);
            String value = strElement[i];
            
            if(!matchMap.containsKey(key)){
                if(matchMap.containsValue(value))
                    return false;
                else matchMap.put(key, value);
            } else {
                if(!matchMap.get(key).equals(value))
                    return false;
            }
        }
        return true;
    }
}