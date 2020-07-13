package programmers.lv1.brute.force.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MockExam {
	public int[] solution(int[] answers) {
        final int STUDENT_SIZE = 3;
        final int STUDENT1_ROUTINE_SIZE = 5;
        final int STUDENT2_ROUTINE_SIZE = 8;
        final int STUDENT3_ROUTINE_SIZE = 10;
            
        int[] student1 = {1, 2, 3, 4, 5};   // rountine: 5
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};  // rountine: 8
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};    //routine: 10
        
        int[] correctAnsCnt = {0, 0, 0};
                
        for(int i=0; i<answers.length; i++) {
            if(student1[i % STUDENT1_ROUTINE_SIZE] == answers[i]) correctAnsCnt[0]++;
            if(student2[i % STUDENT2_ROUTINE_SIZE] == answers[i]) correctAnsCnt[1]++;
            if(student3[i % STUDENT3_ROUTINE_SIZE] == answers[i]) correctAnsCnt[2]++;
        }
        
        int maxScore = Math.max(correctAnsCnt[0], Math.max(correctAnsCnt[1], correctAnsCnt[2]));
        List answerList = new ArrayList<>();
        for(int i=0; i<STUDENT_SIZE; i++) {
            if(maxScore == correctAnsCnt[i]) {
                answerList.add(i+1);
            }
        }
        Collections.sort(answerList);
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = (int)answerList.get(i);
        }
        
        return answer;
    }
}
