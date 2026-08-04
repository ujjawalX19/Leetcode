class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        int expected = nums[0];      // Start from the smallest element

        for (int num : nums) {
            while (expected < num) {
                ans.add(expected);
                expected++;
            }
            expected = num + 1;
        }

        return ans;
        
    }
}