class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> al = new ArrayList<>();
        generate(n,0,0,"",al);
        return al;   
    }
    private static void generate(int n, int i, int j, String s, List<String> al){
        if(s.length() == 2*n){
            al.add(s);
            return;
        }
        if(i < n){
            generate(n,i+1,j,s+'(',al);
        }
        if(j < i){
            generate(n,i,j+1,s+')',al);
        }
    }
}