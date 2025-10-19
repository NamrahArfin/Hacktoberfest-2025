class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        List<List<Integer>> freq = new ArrayList<>(nums.length + 1);
        for(int i = 0; i <= nums.length; i++) {
        	freq.add(new ArrayList<>());
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	int number = entry.getKey();
        	int count = entry.getValue();
        	freq.get(count).add(number);
        }
        
        int[] result = new int[k];
        int write = 0;
        for(int i = nums.length; i > 0 && write < k; i--) {
        	for(int val : freq.get(i)) {
        		result[write++] = val;
        		if(write == k) break;
        	}
        }
        return result;
    }
}
