class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        vector<int>temp;

        for(int num:nums ){
            if(num!=0){
            temp.push_back(num);
            }
        }
        //copy the temp back to nums
        int i=0;
        for(;i<temp.size();i++){
            nums[i]=temp[i];
        }

        //fill the rest with zero
        for(;i<nums.size();i++){
            nums[i]=0;
        }


    }
};