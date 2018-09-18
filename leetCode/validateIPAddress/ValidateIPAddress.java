package leetCode.validateIPAddress;

import java.util.regex.*;

class Solution {
    public String validIPAddress(String IP) {
        if(IP.length() == 0) return "Neither";
        
        String[] IPArray ;
        try{
            if(IP.startsWith(".") || IP.endsWith(".")) return "Neither";

            if((IPArray = IP.split("\\.")).length == 4) {
                for(int i = 0; i < 4; i++){
                    if(Integer.valueOf(IPArray[i]) > 255 
                        || Integer.valueOf(IPArray[i]) < 0 
                        || !IPArray[i].equals(String.valueOf(Integer.valueOf(IPArray[i]))))
                        return "Neither";
                }
                return "IPv4";
            }
        } catch (NumberFormatException e) {
            return "Neither";
        }
        
        String regex = ".*[^0-9a-fA-F]+.*";
        Matcher m;
        
        if(IP.startsWith(":") || IP.endsWith(":")) return "Neither";
        
        if((IPArray = IP.split(":")).length == 8) {
            for(int i = 0; i < 8; i++){
                m = Pattern.compile(regex).matcher(IPArray[i]);
                if(IPArray[i].length() == 0
                   || IPArray[i].length() > 4
                   || m.matches())
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }
}
