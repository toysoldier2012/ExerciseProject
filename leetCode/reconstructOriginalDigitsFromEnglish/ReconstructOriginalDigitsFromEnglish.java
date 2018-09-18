package leetCode.reconstructOriginalDigitsFromEnglish;

class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'z') count[0]++;
            if(s.charAt(i) == 'g') count[8]++;
            if(s.charAt(i) == 'u') count[4]++;
            if(s.charAt(i) == 'w') count[2]++;
            if(s.charAt(i) == 'h') count[3]++;
            if(s.charAt(i) == 'f') count[5]++;
            if(s.charAt(i) == 'v') count[7]++;
            if(s.charAt(i) == 's') count[6]++;
            if(s.charAt(i) == 'o') count[1]++;
            if(s.charAt(i) == 'i') count[9]++;
        }

        count[3] -= count[8];
        count[5] -= count[4];
        count[7] -= count[5];
        count[6] -= count[7];
        count[1] -= (count[2] + count[4] + count[0]);
        count[9] -= (count[8] + count[6] + count[5]);
        
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < 10; j++){
            while(count[j] != 0){
                sb.append(j);
                count[j]--;
            }
        }
        return sb.toString();
    }
}