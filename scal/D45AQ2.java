package scal;
import  java.util.*;
/* 10m+12m+10m
 A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]
 1       5    7  8 => (1,7) and (7,8) => 2
 sort by starting times, if first job is 1,10 and 2,5 5,10 exits then it won't work
 sort by finishing times (2,5) (1,10) (5,10) => works
 think of more corner cases (2,5) (4,6) (1,7)
 (2,5) (6,10) (7,10)
 */
public class D45AQ2 {

    class Job implements  Comparable<Job> {

       int startTime;
       int endTime;

       public Job(int startTime, int endTime){
           this.startTime = startTime;
           this.endTime   = endTime;
       }

       @Override
       public int compareTo(Job other) {
           return this.endTime-other.endTime;
       }
   }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A==null || A.size()==0)
            return 0;
        int noOfJobs=1,N=A.size();
        //iterate over inputs and create jobs list
        List<Job> jobsList = new ArrayList<>();
        for(int i=0;i<N;i++){
            jobsList.add(new Job(A.get(i),B.get(i)));
        }
        Collections.sort(jobsList);
        int prevEndTime = jobsList.get(0).endTime;
        Job current = null;
        //iterate over jobs now and find ans
        //(2,5) (4,7) (6,9)
        for(int i=1;i<N;i++){
            current = jobsList.get(i);
            if(prevEndTime<=current.startTime) {
                noOfJobs++;
                prevEndTime = current.endTime;
                int d1 = 0;
            }
        }
        return noOfJobs;
    }

    public static void main(String[] args){
        D45AQ2 test = new D45AQ2();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 4, 5, 6));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(4, 5, 6, 7));
        int res = test.solve(A,B);
        System.out.println(res);
    }
}
