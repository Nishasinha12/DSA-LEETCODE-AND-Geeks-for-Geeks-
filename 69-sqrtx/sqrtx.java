class Solution {
    public int mySqrt(int x) {
        int low=1,high=x, ans=1;
        while(low<=high){
            long mid=low+(high-low)/2;
            long val=mid*mid;
            if(val <=x){
                ans=(int)mid;
                low=(int)mid+1;
            }
            else{
                high=(int)mid-1;
            }
        }
        return high;
    }
}