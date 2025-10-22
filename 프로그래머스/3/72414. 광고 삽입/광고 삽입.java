import java.util.*;
import java.time.*;

class Solution {

    static long[] time; 

    public String solution(String play_time, String adv_time, String[] logs) {
        long[] pt = timeCalc(play_time);
        long ptSum = pt[0] + pt[1] + pt[2];
        
        time = new long[(int)ptSum + 1];
        

        for (int i = 0; i < logs.length; i++) {
            String[] stp = logs[i].split("-");
            long[] startArr = timeCalc(stp[0]);
            long[] endArr = timeCalc(stp[1]);
            
            long start = startArr[0] + startArr[1] + startArr[2];
            long end = endArr[0] + endArr[1] + endArr[2];

           

            time[(int)start]++; 
            
            if (end < ptSum) {
                time[(int)end]--;
            }
            
        }
        
        for (int i = 1; i < ptSum; i++) {
            time[i] += time[i - 1];
        }
        
        long[] ad = timeCalc(adv_time);
        long sum = ad[0] + ad[1] + ad[2];
        
        long currentSum = 0; 
        long maxSum = 0;
        long maxIdx = 0;
        
        for (int i = 0; i < sum; i++) {
            currentSum += time[i];
        }
        
        maxSum = currentSum;
        
        for(long i = sum; i < ptSum; i++){
            currentSum += time[(int) i] - time[(int) (i - sum)];
            if(currentSum > maxSum){
                maxSum = currentSum;
                maxIdx = (i - sum + 1);
            }
        }

        return secondsToTimeString(maxIdx);
    }
    
    static long[] timeCalc(String tp) {
        String[] stp = tp.split(":");
        long h = Long.parseLong(stp[0]) * 60 * 60;
        long m = Long.parseLong(stp[1]) * 60;
        long s = Long.parseLong(stp[2]);
        
        return new long[]{h, m, s};
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