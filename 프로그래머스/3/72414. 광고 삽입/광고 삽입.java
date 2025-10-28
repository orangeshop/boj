import java.util.*;
import java.time.*;

class Solution {

    static long[] time; 

    public String solution(String play_time, String adv_time, String[] logs) {
        int ptSum = (int) timeCalc(play_time);
        time = new long[ptSum + 1];
        

        for (int i = 0; i < logs.length; i++) {
            String[] stp = logs[i].split("-");
            int start = (int) timeCalc(stp[0]);
            int end = (int) timeCalc(stp[1]);

            time[start]++; 
            
            if (end <= ptSum) {
                time[end]--;
            }
        }
        
        for (int i = 1; i < ptSum; i++) {
            time[i] += time[i - 1];
        }
        
        int ad = (int) timeCalc(adv_time);
        long currentSum = 0;
        
        for (int i = 0; i < ad; i++) {
            currentSum += time[i];
        }
        long maxSum = currentSum;
        long maxIdx = 0;
        
        for(int i = ad; i < ptSum; i++){
            currentSum += time[i] - time[i - ad];
            if(currentSum > maxSum){
                maxSum = currentSum;
                maxIdx = (i - ad + 1);
            }
        }

        return secondsToTimeString(maxIdx);
    }
    
    static long timeCalc(String tp) {
        String[] stp = tp.split(":");
        long h = Long.parseLong(stp[0]) * 60 * 60;
        long m = Long.parseLong(stp[1]) * 60;
        long s = Long.parseLong(stp[2]);
        
        return h + m + s;
    }

    static String secondsToTimeString(long totalSeconds) {
        long hour = totalSeconds / 3600;
        totalSeconds %= 3600;
        long minute = totalSeconds / 60;
        totalSeconds %= 60;
        long second = totalSeconds;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}