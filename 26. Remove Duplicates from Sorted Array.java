class Solution {
    public int removeDuplicates(int[] nums) {
        // Handle the edge case of an empty array
        if (nums.length == 0) {
            return 0;
        }
        
        // k tracks the position for the next unique element.
        // It starts at 1 because the first element (index 0) is always unique.
        int k = 1; 
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous one, it's a new unique element
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]; // Place the unique element at the k-th position
                k++;               // Increment the unique elements count
            }
        }
        
        return k; // Return the number of unique elements
    }
}
