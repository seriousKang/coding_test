package programmers.lv2.stack.queue;

import java.util.ArrayList;
import java.util.List;

class Task {
    private int num;
    private int priority;
    
    public Task(int num, int priority) {
        this.num = num;
        this.priority = priority;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public int getNum() {
        return num;
    }
    
    public String toString() {
        return String.format("%d(p:%d)", num, priority);
    }
}

class Printer { 
    public int solution(int[] priorities, int location) {
        List taskList = new ArrayList<Task>();        
        List printOrder = new ArrayList<>();
        
        for(int i=0; i<priorities.length; i++) {
            Task task = new Task(i, priorities[i]);
            taskList.add(task);
        }
        
        while(true) {
            //System.out.println(taskList);
            Task currentTask = (Task)taskList.get(0);
            if(taskList.size() == 1) {
                printOrder.add(currentTask.getNum());
                break;
            }
            
            boolean orderChange = false;
            for(int j=1; j<taskList.size(); j++) {
                Task compareTask = (Task)taskList.get(j);
                    
                if(currentTask.getPriority() < compareTask.getPriority()) {
                    orderChange = true;
                    break;
                }
            }
            
            if(orderChange) {
                taskList.remove(0);
                taskList.add(currentTask);
            } else {
                taskList.remove(0);
                printOrder.add(currentTask.getNum());
            }
        }
        //System.out.println(printOrder);
        
        return printOrder.indexOf(location) + 1;
    }
}