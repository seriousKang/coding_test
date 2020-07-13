package programmers.lv2.stack.queue;

public class Tower {
	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for(int i=heights.length-1; i>0; i--) {
            int currentHeight = heights[i];
            
            for(int j=i-1; j>=0; j--) {
                int compareHeight = heights[j];
                
                if(compareHeight > currentHeight) {
                    answer[i] = j+1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
