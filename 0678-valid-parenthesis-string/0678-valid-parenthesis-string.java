class Solution {
    public boolean checkValidString(String s) {
        int i = 0;
        int j = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                i++;
                j++;
            }else if(c == ')'){
                i--;
                j--;
            }else{
                i--;
                j++;
            }
            if(j < 0) return false;
            i = Math.max(0,i);
        }
        return i == 0;
    }
}