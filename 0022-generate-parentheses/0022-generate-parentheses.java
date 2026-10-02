class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> al = new ArrayList<>();
        generate(n, 0, 0, "", al);
        return al;
    }
    public void generate(int n,int open,int close,String current, List<String> al){
        if(current.length() == 2*n){
            al.add(current);
            return;
        }
        if(open < n){
            generate(n,open + 1,close,current + "(",al);
        }
        if(close < open){
            generate(n,open,close+1,current + ")",al);
        }
    }
}