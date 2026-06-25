class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            boolean o = true;
            for(int j = 0;j<n;j++){
                if(i!=j && c == s.charAt(j)){
                    o = false;
                    break;
                }
            }
            if(o) return i;
        }
        return -1;
    }
}