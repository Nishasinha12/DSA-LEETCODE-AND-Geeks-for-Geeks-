class Solution {
    public int dayneeded(int[]weights,int capacity){
        int day=1;
        int load=0;
        for(int w:weights){
            if(load+w >capacity){
                day=day+1;
                load=w;
            }
            else{
                load+=w;
            }
    }
    return day;
    }

    public int shipWithinDays(int[] weights, int days) {//binary search
        int low=Arrays.stream(weights).max().getAsInt();//10is maxweight is array
        int high=Arrays.stream(weights).sum();//total sum of all weight
        while(low<=high){
            int mid=low+(high-low)/2;
            int nedded=dayneeded(weights,mid);
            if(nedded<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}