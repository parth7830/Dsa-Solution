class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> ws = new HashSet<>(wordList);
        if(!ws.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        ws.remove(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                String word = q.poll();
                char[] ch = word.toCharArray();
                for(int j = 0;j<ch.length;j++){
                    char o = ch[j];
                    for(char c = 'a';c<='z';c++){
                        if(c == o) continue;
                        ch[j] = c;
                        String n = new String(ch);
                        if(n.equals(endWord))return steps+1;
                        if(ws.contains(n)){
                            ws.remove(n);
                            q.offer(n);
                        }
                    }
                    ch[j] = o;
                }
            }
            steps++;
        }
        return 0;
    }
}