class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        for(int i=0; i<ans.length; i++){
            int sum = 0;
            HashSet<Integer> set = new HashSet<>();
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int idx = i; idx <= i+k-1; idx++){
                sum += nums[idx];
                set.add(nums[idx]);
                map.put(nums[idx], map.getOrDefault(nums[idx],0)+1);
            }

            if(set.size() < x) ans[i] = sum;
            else{
                // this is just how the priorityQueue should work
                PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                    if(map.get(a) == map.get(b)) return b-a;
                    return map.get(b) - map.get(a);
                });

                for(int elem : set){
                    pq.add(elem);
                }
                int count = x;
                while(count-->0){
                    int top = pq.remove();
                    ans[i] += (top * map.get(top));
                }
            }
        }
        return ans;
    }
}
