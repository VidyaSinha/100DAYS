//today i solved the ques for Find Missing Observations in dice roll where we only know the mean of n+m rolls and dont know the mth rolls.


class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
       int m= rolls.length;
        int total= mean*(n+m);
        int obssum=0;

        for(int roll: rolls){
            obssum+= roll;
        }
        int missingsum = total - obssum;
        if (missingsum<n || missingsum>6*n){
            return new int[0];
        }
        int q= missingsum/n;
        int r=missingsum%n;
        int[]res= new int[n];
        for(int i=0; i<n; i++){
            res[i]=q;
        }
        for(int i=0; i<r;i++){
            res[i]++;

        }
        return res;
    }
}   