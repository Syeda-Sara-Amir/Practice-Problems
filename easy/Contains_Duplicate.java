// QUESTION: Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

class Contains_Duplicate {
    public boolean hasDuplicate(int[] nums) {

        // ================= MY SOLUTION =============================  //
        for(int i = 0; i < nums.length; i++){ // goes through all the numbers

        // edge case: when i is on the last index of array nums, in the second loop "j" would give index out of bounds error
        // if (i == (nums.lenght-1)){
        //     return false; 
        // }
        // this is not a good approch cause we are comparing every loop, which is unnecesaary. anything unnecessary isnt good
        // Also, When i is on the last index, j starts at i+1 which is out of bounds — so the condition j < nums.length is immediately false, and the inner loop just never executes. No crash, no error.

            for(int j = i+1; j < nums.length; j++){ // loops over the array to check for duplicates of ith index number
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        // if the whole loop runs and we werent able to find any duplicates. 
        // the loop will end and this line would be executed, otherwise it wont be executed.
        return false;

        // memory complexity: O(1) -> since we dont need to make any new variables or save anything. We are just comparing.
        // time complexity: O(n squared)  -> why? cause we have n number of indexs that we are comparing yet again to the array. so two arrays 

        // ==================== MOST EFFICIENT SOLUTION ============================== //
        // somtimes we have to sacrifice some space/time to make an overall good solution 

        Set <Integer> checked = new HashSet<>();
        for(int num : nums) {
            if(checked.contains(num)){ 
                return true;
            }
            checked.add(num); 
        }
        return false;

        // time complexity:  O(n) -> we are only looping on the array once
        // space compexity: O(n) -> in worst case senerio the whole array could be saved in the hashset
    }

}
