import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, B, U;
    static int army = 0;
    static int enemy = 0;
    static int ans = Integer.MAX_VALUE; // 최소 턴을 저장할 변수

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());

        army = N;
        enemy = 0;
        
        for (int t = 1; t <= 20000; t++) {
            
            if (B <= army) {
                int finishTurn = simulateFinish(t, army, enemy);
                if (finishTurn != -1) {
                    ans = Math.min(ans, finishTurn);
                }
            }
            
            Attack();
            
            if (B <= 0) {
                ans = Math.min(ans, t);
                break;
            }
            
            beAttacked();
            
            if (army <= enemy && enemy > 0) {
                break;
            }
            
            if (army <= 0) {
                break;
            }
            
            makeMarin();
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
    
    static void Attack() {
        int canKill = Math.min(army, enemy); 
        int remainPower = army - canKill;   

        enemy -= canKill; 

        
        if (remainPower > 0) {
            B -= remainPower;
        }
    }

    static void makeMarin() {
        if (B > 0) { 
            enemy += U;
        }
    }

    static void beAttacked() {
        if (enemy > 0) {
            army -= enemy;
            army = Math.max(army, 0);
        }
    }


    static int simulateFinish(int currentTurn, int curArmy, int curEnemy) {

        int power = curArmy - B; 
        int killed = Math.min(curEnemy, power); 
        int survivingEnemy = curEnemy - killed;


        if (survivingEnemy > 0) {
            curArmy -= survivingEnemy;
        }

        if (curArmy <= 0) return -1; 
        if (survivingEnemy == 0) return currentTurn; 
        
        while (survivingEnemy > 0) {
            currentTurn++;
            
            survivingEnemy -= curArmy;
            if (survivingEnemy <= 0) return currentTurn;

            
            curArmy -= survivingEnemy;
            if (curArmy <= 0) return -1;
        }
        return currentTurn;
    }
}
