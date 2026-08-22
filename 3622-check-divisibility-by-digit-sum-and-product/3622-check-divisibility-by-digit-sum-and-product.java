class Solution {
    public boolean checkDivisibility(int n) {
        int ori = n;
        int sum = 0;
        int prod = 1;
        while(ori > 0){
            int last = ori % 10;
            sum += last;
            prod *= last;
            ori = ori/10;
        }
        return n % (prod + sum) == 0;
    }
}