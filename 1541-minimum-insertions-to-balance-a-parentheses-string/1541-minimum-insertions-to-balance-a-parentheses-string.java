class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                st.push('(');
            } else {

                // check if we have "))"
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // consume second ')'
                } else {
                    // single ')' => need one more ')'
                    insertions++;
                }

                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    // no matching '('
                    insertions++;
                }
            }
        }

        // each remaining '(' needs "))"
        insertions += st.size() * 2;

        return insertions;
    }
}