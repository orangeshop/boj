import java.util.*;

class Solution {
    
    static List<List<String>> ans = new ArrayList<>();
    static boolean[] vis;
    static int N;
    static String[][] T;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        N = tickets.length;
        T = tickets;
        vis = new boolean[N];
        
        for(int i =0; i < N; i++){
            if(tickets[i][0].equals("ICN")){
                ArrayDeque<String> sq = new ArrayDeque<>();
                sq.add(tickets[i][0]);
                sq.add(tickets[i][1]);
                vis[i] = true;
                Solution(0, sq);
                vis[i] = false;
            }
        }
        
        // for(List<String> nxt : ans){
        //     System.out.println(nxt);
        // }
        
        Collections.sort(ans, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> list1, List<String> list2) {
                // 두 리스트 중 더 짧은 길이만큼만 비교
                int minSize = Math.min(list1.size(), list2.size());

                for (int i = 0; i < minSize; i++) {
                    String s1 = list1.get(i);
                    String s2 = list2.get(i);

                    // 현재 인덱스의 문자열 비교
                    int cmp = s1.compareTo(s2);
                    if (cmp != 0) {
                        // 다르면 바로 비교 결과 반환
                        return cmp;
                    }
                }

                // 모든 공통 요소가 같을 경우, 길이가 짧은 리스트가 먼저 오도록 정렬
                return Integer.compare(list1.size(), list2.size());
            }
        });
        
//         System.out.println();
        
//         for(List<String> nxt : ans){
//             System.out.println(nxt);
//         }
        answer = new String[N+1];
        for(int i =0; i < ans.get(0).size(); i++){
            answer[i] = ans.get(0).get(i);
        }
        return answer;
    }
    
    public static void Solution(int depth, ArrayDeque<String> arr){
        // System.out.println(arr + " " + depth);
        if(depth == N-1){
            if(arr.size() == N+1){
                ans.add(new ArrayList<>(arr));
            }
            return;
        }
        
        for(int i =0; i < N; i++){
            if(vis[i] == false && T[i][0].equals(arr.getLast() ) ) {
                vis[i] = true;
                arr.add(T[i][1]);
                
                Solution(depth + 1, arr);
                
                arr.removeLast();
                vis[i] = false;
            }
        }
        
    }
    
    static class Pair{
        String a;
        String b;
        
        Pair(String a, String b){
            this.a = a;
            this.b = b;
        }
    }
}