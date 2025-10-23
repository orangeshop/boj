import java.util.*;

class Solution {
    static String answer = "";
    
    static class Pair{
        int idx;
        int time;
        String title;
        String code;
        String start;
        
        Pair(int idx, int time, String title, String code, String start){
            this.idx = idx;
            this.time = time;
            this.title = title;
            this.code = code;
            this.start = start;
        }
    }
    
    static int N;
    static Pair[] arr;
    static Map<String, String> m = new HashMap<>();
    
    public String solution(String m, String[] musicinfos) {
        
        N = musicinfos.length;
        arr = new Pair[N];
        
        init();
        
        String tCode = mappingCode(m);
        
        System.out.println(tCode);
        
        for(int i =0; i < N; i++){
            String[] cur = musicinfos[i].split(",");
            int s = toSecond(cur[0], cur[1]);
            // System.out.println(makeCode(s, cur[3]));
            // System.out.println(s);
            arr[i] = new Pair(i, s, cur[2], makeCode(s, cur[3]), cur[0]);
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if(o2.time == o1.time){
                return o1.idx - o2.idx;
            }
            return o2.time - o1.time;
        });
        
        for(int i =0; i < N; i++){
            Pair cur = arr[i];
            System.out.println("cur " + cur.code);
            if(cur.code.contains(tCode)){
                return cur.title;
            }
        }
        
        return "(None)";
    }
    
    static void init(){
        m.put("C", "1");
        m.put("C#", "2");
        m.put("D", "3");
        m.put("D#", "4");
        m.put("E", "5");
        m.put("E#", "&");
        m.put("F", "6");
        m.put("F#", "7");
        m.put("G", "8");
        m.put("G#", "9");
        m.put("A", "!");
        m.put("A#", "@");
        m.put("B", "$");
        m.put("B#", "%");
    }
    
    static String makeCode(int size, String code){
        String mCode = mappingCode(code);
        
        if(mCode.length() < 0) return "";
        
        // System.out.println("mcode " + mCode + " " + size);
        
//         if(code.length() > size){
//             // System.out.println("####");
//             String str = "";
//             for(int i =0; i < size; i++){
//                 str += mCode.charAt(i) + "";
//             }
//             return str;
//         }else{
            
//             String str = "";
//             int idx = 0;
//             for(int i =0; i < size; i++){
//                 str += mCode.charAt(idx) + "";
//                 // System.out.println(size + " " + idx);
//                 idx++;
//                 if(idx >= mCode.length()){
//                     idx = 0;
//                 }
//             }
//             return str;
//         }
        
        StringBuffer sb = new StringBuffer();
        if (mCode.length() == 0) return ""; // 런타임 에러 방어 코드 (중요)

        for (int i = 0; i < size; i++) {
            // i % code.length() 이 한 줄이
            // 1. time이 code.length()보다 길면 -> 반복 (else 로직)
            // 2. time이 code.length()보다 짧으면 -> 잘라내기 (if 로직)
            // 두 가지를 모두 처리합니다.
            sb.append(mCode.charAt(i % mCode.length()));
        }
        return sb.toString();
    }
    
    static String mappingCode(String code){
        String s = "";
        for(int i =0; i < code.length(); i++){
            if(code.charAt(i) == 'C'){
                if(i + 1 < code.length() && code.charAt(i+1) == '#'){
                    s += (m.getOrDefault("C#", "") + "");
                }else{
                    s += (m.getOrDefault("C","") + "");
                }
            }
            
            if(code.charAt(i) == 'D'){
                if(i + 1 < code.length() && code.charAt(i+1) == '#'){
                    s += (m.getOrDefault("D#","") + "");
                }else{
                    s += (m.getOrDefault("D","") + "");
                }
            }
            
            if(code.charAt(i) == 'F'){
                if(i + 1 < code.length() && code.charAt(i+1) == '#'){
                    s += (m.getOrDefault("F#","") + "");
                }else{
                    s += (m.getOrDefault("F","") + "");
                }
            }
            
            if(code.charAt(i) == 'G'){
                if(i + 1 < code.length() && code.charAt(i+1) == '#'){
                    s += (m.getOrDefault("G#","") + "");
                }else{
                    s += (m.getOrDefault("G","") + "");
                }
            }
            
            if(code.charAt(i) == 'A'){
                if(i + 1 < code.length() && code.charAt(i+1) == '#'){
                    s += (m.getOrDefault("A#","") + "");
                }else{
                    s += (m.getOrDefault("A","") + "");
                }
            }
            
            if(code.charAt(i) == 'E'){
                if(i + 1 < code.length() && code.charAt(i+1) == '#'){
                    s += (m.getOrDefault("E#","") + "");
                }else{
                    s += (m.getOrDefault("E","") + "");
                }
            }
            
            if(code.charAt(i) == 'B'){
                
                if(i + 1 < code.length() && code.charAt(i+1) == '#'){
                    s += (m.getOrDefault("B#","") + "");
                }else{
                    s += (m.getOrDefault("B","") + "");
                }
            }
        }
        
        return s;
    }
    
    static int toSecond(String s, String e){
        String[] ssp = s.split(":");
        String[] esp = e.split(":");
        
        int rs = (Integer.parseInt(ssp[0]) * 60) + Integer.parseInt(ssp[1]);
        int re = (Integer.parseInt(esp[0]) * 60) + Integer.parseInt(esp[1]);
        
        int m = (re - rs) / 60;
        int ss = (re - rs) % 60;
        
        // System.out.println("to Secvond " + m + " " + ss);
        
        return re - rs;
    }
}