package programmers.lv1.basic;

public class GCDAndLCM {
	public int[] solution(int n, int m) {     
        int[] answer = new int[2];
        
        answer[0] = getGCD(n, m);
        answer[1] = getLCM(n, m);
        
        return answer;
    }
    
    public int getGCD(int n, int m) {
        int big = n;
        int small = m;
        
        if(n < m) { 
            big = m;
            small = n;
        }
        
        int GCD = small;
        while(GCD != 1) {
            if(big%GCD == 0 && small%GCD == 0) 
                break;
            
            GCD--;
        }
        
        //System.out.println("GCD:" + GCD);
        return GCD;
    }
    
    public int getLCM(int n, int m) {
        int big = n;
        int small = m;
        
        if(n < m) {
            big = m;
            small = n;
        }
        
        int lcm = m;
        while(true) {
            if(lcm%big==0 && lcm%small==0) 
                break;
            
            lcm++;
        }
        
        //System.out.println("LCM:" + lcm);
        return lcm; 
    }
}
