class Solution {

    private boolean exists(char[][] board, boolean[][] visited, String w, int i, int j, int index) {
        if(index == w.length()) return true;
        if(i < board.length && j < board[0].length && i >= 0 && j >= 0
            && 
            board[i][j] == w.charAt(index) && !visited[i][j]) {
            visited[i][j] = true;
            boolean resp = exists(board, visited, w, i+1, j, index+1)
            || exists(board, visited, w, i-1, j, index+1) 
            || exists(board, visited, w, i, j+1, index+1)
            || exists(board, visited, w, i, j-1, index+1);
            visited[i][j] = false;
            return resp;
        }
        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> response = new ArrayList<>();
        Map<Character, Set<String>> map = new HashMap<>();
        for(String w : words) {
            char ch = w.charAt(0);
            if(!map.containsKey(ch)) {
                map.put(ch, new HashSet<>());
            }
            map.get(ch).add(w);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0 ; j < board[i].length; j++) {
                if(!visited[i][j] && map.containsKey(board[i][j])) {
                    Set<String> remove = new HashSet<>();
                    for(String w : map.get(board[i][j])) {
                        if(exists(board, visited, w, i, j, 0)) {
                            response.add(w);
                            remove.add(w);
                        }
                    }

                    map.get(board[i][j]).removeAll(remove);
                    if(map.get(board[i][j]).size() == 0) {
                        map.remove(board[i][j]);
                    }
            
                }
            }
        }
        
        return response;
    }
}
