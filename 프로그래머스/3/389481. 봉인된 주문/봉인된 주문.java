import java.util.*;
import java.util.function.Function;


class Solution {
    static String answer = "";
    
    static ArrayDeque<Long> ls = new ArrayDeque<>();
    
    static Map<Long, String> m = new HashMap<>();
    
    static String[] gBan;
    
    static class Pair{
        int len;
        String v;
        int idx;
        
        Pair(int len, String v, int idx){
            this.len = len;
            this.v = v;
            this.idx = idx;
        }
    }
    
    public String solution(long n, String[] bans) {
        gBan = bans.clone();
        init();
        long[] result = to26bit(n);
        
        // System.out.println("arr " + Arrays.toString(result));
        
        test(result);
        
        // makeString(new long[]{26,27});
        
        return answer;
    }
    
    static void init(){
        m.put(1L, "a");
        m.put(2L, "b");
        m.put(3L, "c");
        m.put(4L, "d");
        m.put(5L, "e");
        m.put(6L, "f");
        m.put(7L, "g");
        m.put(8L, "h");
        m.put(9L, "i");
        m.put(10L, "j");
        m.put(11L, "k");
        m.put(12L, "l");
        m.put(13L, "m");
        m.put(14L, "n");
        m.put(15L, "o");
        m.put(16L, "p");
        m.put(17L, "q");
        m.put(18L, "r");
        m.put(19L, "s");
        m.put(20L, "t");
        m.put(21L, "u");
        m.put(22L, "v");
        m.put(23L, "w");
        m.put(24L, "x");
        m.put(25L, "y");
        m.put(26L, "z");
    }
    
    static long[] to26bit(long n) {
        ArrayDeque<Long> tq = new ArrayDeque<>();

        while (n > 0) {
            long rem = n % 26;

            if (rem == 0) {
                // 나머지가 0이면 (26의 배수) 'z' (26)을 추가
                tq.addFirst(26L);
                // 몫에서 1을 빼줘야 함
                n = (n / 26) - 1; 
            } else {
                // 나머지가 0이 아니면
                tq.addFirst(rem);
                n = n / 26;
            }
        }

        long[] tempLong = new long[tq.size()];
        for (int i = 0; i < tempLong.length; i++) {
            tempLong[i] = tq.removeFirst();
        }
        return tempLong;
    }
    
    static void test(long[] arr){
        
        
        ArrayList<Pair> bls = new ArrayList<>();
        
        for(int i =0; i < gBan.length; i++){
            bls.add(new Pair(gBan[i].length() ,gBan[i], i));
        }
        
        String result = makeString(arr);
        
        // System.out.println(result);
        
        // bls.add(new Pair(result.length(), result, -1));
        
        bls.sort((o1, o2) -> {
            if(o1.len == o2.len){
                if(o1.v.equals(o2.v)){
                    return o1.idx - o2.idx;
                }
                return o1.v.compareTo(o2.v);
            }
            return o1.len - o2.len;
        });
        
        
        ArrayDeque<Pair> q = new ArrayDeque<>(bls);
        
        while(!q.isEmpty()){
            Pair cur = q.removeFirst();
            // System.out.println(cur.v + " " + cur.idx);

            
            if(cur.len < result.length() || (cur.len == result.length() && result.compareTo(cur.v) >= 0)){
                // System.out.println("asdasd");
                arr[arr.length-1]++;
                arr = calcArr(arr);
                result = makeString(arr);
            }
            
            
        }
        
        answer = makeString(arr);
    }
    
    static long[] calcArr(long[] arr) {
        ArrayList<Long> tls = new ArrayList<>();

        
        tls.add(0L); 
        for (long val : arr) {
            tls.add(val);
        }

        for (int i = tls.size() - 1; i > 0; i--) {
            if (tls.get(i) > 26) {
                tls.set(i, tls.get(i) - 26L);
                tls.set(i - 1, tls.get(i - 1) + 1L); 
            }
        }


        ArrayList<Long> sls = new ArrayList<>();
        if (tls.get(0) != 0L) { 
            sls.add(tls.get(0));
        }
        for (int i = 1; i < tls.size(); i++) {
            sls.add(tls.get(i));
        }

        long[] rarr = new long[sls.size()];
        for (int i = 0; i < sls.size(); i++) {
            rarr[i] = sls.get(i);
        }

        return rarr;
    }
    
    static String makeString(long[] arr){
        int size = arr.length;
        String result = "";
        
        for(int i =0; i < size; i++){
            result += m.getOrDefault(arr[i],"");
        }
        
        return result;
    }
    
}