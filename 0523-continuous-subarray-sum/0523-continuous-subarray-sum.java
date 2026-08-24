import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 exists before the array starts
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;

            if (map.containsKey(sum)) {
                // Need at least 2 elements
                if (i - map.get(sum) >= 2) {
                    return true;
                }
            } else {
                // Store only the first occurrence
                map.put(sum, i);
            }
        }

        return false;
    }
}
