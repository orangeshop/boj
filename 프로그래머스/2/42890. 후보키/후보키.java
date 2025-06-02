import java.util.*;

/*
case1: [['a',1,'aaa','c','ng'],['b',1,'bbb','c','g'],['c',1,'aaa','d','ng'],['d',2,'bbb','d','ng']] 답 : 3 (0,23,134)
case2: [["a","1","aaa","c","ng"],["a","1","bbb","e","g"],["c","1","aaa","d","ng"],["d","2","bbb","d","ng"]] 답: 5 (02, 03, 04, 13, 23)




*/


class Solution {
    
    static List<List<Integer>> ls = new ArrayList<>();
    
    
    static List<List<Integer>> tmp = new ArrayList<>();
    
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static boolean[] vis;
    
    static boolean[] key;
    
    static void cStr(List<Integer> arr){
        
        for(int i =0; i < ls.size(); i++){
            int cnt = 0;
            for(int k =0; k < ls.get(i).size(); k++){
                if(arr.contains(ls.get(i).get(k))) cnt++;
            }
            
            if(cnt == ls.get(i).size()) return;
        }
        
        List<String> result = new ArrayList<>();
        
        for(int i =0; i < N; i++){
            String str = "";
            for(int k =0; k < arr.size(); k++){
                str += board[i][arr.get(k)];
                str += " ";
            }
            // System.out.println(str);
            if(result.contains(str)){
                return;
            }else{
                result.add(str);
            }
        }
        
        System.out.println(arr);
        ls.add(arr);
        
    }
    
    static void dfs(int depth, ArrayDeque<Integer> q){
        List<Integer> l = new ArrayList<>(q);
        // cStr(l);
        tmp.add(l);
        if(depth == M){
            return;
        }
        
        for(int i = depth; i < M; i++){
            if(vis[i]) continue;
            q.add(i);
            vis[i] = true;
            dfs(depth + 1, q);
            q.removeLast();
            vis[i] = false;
        }
    }
    
    static int N, M;
    static String[][] board;
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        N = relation.length;
        M = relation[0].length;
        board = relation;
        
        vis = new boolean[M];
        key = new boolean[M];
        
        dfs(0,q);
        /*
        0 
        1
        2
        3
        
        0 1
        0 2
        0 3
        
        1 2
        1 3
        
        2 3
        
        */
        
        tmp.sort(Comparator.comparingInt(List::size));
        
        for(int i =0; i < tmp.size(); i++){
            // System.out.println(tmp.get(i));
            cStr(tmp.get(i));
        }
        
        
        answer = ls.size();
        
        return answer;
    }
    
    
    // 조합을 돌려서 해당 값이 있는 지 판단 
    // 이거 배열에 다 넣으면 터 질 것 같은데
}