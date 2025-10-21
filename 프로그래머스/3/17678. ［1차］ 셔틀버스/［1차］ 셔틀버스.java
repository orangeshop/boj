import java.util.*;

class Solution {
    
    static int N,T,M;
    static String answer = "";
    static String[] gT;
    
    static List<Integer> ls = new ArrayList<>();
    
    static Bus[] busTime;
    
    static int busSt = (9 * 60);
    
    static class Bus{
        int maxNum;
        List<Integer> nowNum = new ArrayList<>();
        int time;
        
        Bus(int maxNum, int time){
            this.maxNum = maxNum;
            this.time = time;
        }
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        N = n;
        T = t;
        M = m;
        gT = timetable.clone();
        
        busTime = new Bus[N];
        
        for(int i =0; i < N; i++){
            busTime[i] = new Bus(M,0);
        }
        
        busTime[0].time = busSt;
        
        for(int i =1; i < N; i++){
            busTime[i].time = busTime[i-1].time + t;
        }
        
        makeTimeMinute();
        
        ls.sort((o1, o2) -> {
            return o1 - o2;
        });
        
        ArrayDeque<Integer> q = new ArrayDeque<>(ls);

        for(int i =0; i < N; i++){
            Bus cur = busTime[i];
            
            for(int k =0; k < cur.maxNum; k++){
                if(q.isEmpty()) break;
                if(q.peek() > cur.time) break;
                cur.nowNum.add(q.removeFirst());
            }
        }

        for(int i =0; i < N; i++){
            Bus cur = busTime[i];

            for(int num : cur.nowNum){
                // System.out.println(num);
            }
            System.out.println(cur.time);
        }
        
        Bus lastBus = busTime[N-1];
        
        if(lastBus.nowNum.isEmpty()){
            answer = makeTimeHour(lastBus.time);
        }else{
            lastBus.nowNum.sort((o1, o2) -> {
                return o1 - o2; 
            });
            int target = lastBus.nowNum.get(lastBus.nowNum.size()-1);
            if(lastBus.nowNum.size() == lastBus.maxNum){
                answer = makeTimeHour(target - 1);
            }else{
                answer = makeTimeHour(lastBus.time);
            }
        }
        
        return answer;
    }
    
    static String makeTimeHour(int num){
        int hour = num / 60;
        int minute = num % 60;
        
        String h = "";
        String m = "";
        
        if(hour < 10){
            h = "0" + hour;
        }else{
            h = hour + "";
        }
        
        if(minute < 10){
            m = "0" + minute;
        }else{
            m = minute + "";
        }
        
        return h+":"+m;
    }
    
    static void makeTimeMinute(){
        for(int i =0; i < gT.length; i++){
            String[] str = gT[i].split(":");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            
            ls.add((a * 60) + b);
        }
        
        // for(int num : ls){
        //     System.out.println(num);
        // }
    }
}

/*
버스 시간표를 먼저 만들어야함
그리고 시간을 정렬 한 후 

인원수 대비 가장 마지막 버스를 구해야함

전부 분으로 치환?

내가 도착해야 하는 시간을 넣어야함



*/