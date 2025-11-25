class Solution {
    long sum = 0;
    TreeSet<int[]> main;
    TreeSet<int[]> sec;
    Map<Integer,Integer> freq;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        sum = 0;
        freq = new HashMap<>();

        // Comparator to sort by freq first and then by val
        Comparator<int[]> comp = (a,b)->{
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1],b[1]);
        };

        main = new TreeSet<>(comp);
        sec = new TreeSet<>(comp);

        List<Long> resultList = new ArrayList<>();

        int i=0; int j=0;

        while(j < n){
            int num = nums[j];

            // if already present remove the old(freq, val)
            if(freq.getOrDefault(num, 0) > 0){
                removeFromSet(new int[]{freq.get(num), num}, x);
            }

            // increase the freq in map
            freq.put(num, freq.getOrDefault(num,0)+1);

            // Insert the updated pair
            insertInSet(new int[]{freq.get(num), num}, x);

            // now if length of subarray = k 
            // 1. add the sum to the result 
            // 2. remove the i and add the j in the next subarray
            if(j-i+1 == k){
                resultList.add(sum);

                // remove the outgoing elment
                int outNum = nums[i];
                removeFromSet(new int[]{freq.get(outNum), outNum}, x);
                freq.put(outNum, freq.get(outNum) - 1);

                if(freq.get(outNum) == 0){ // if became zero than don't insert back in the sets
                    freq.remove(outNum);
                }else{
                    insertInSet(new int[]{freq.get(outNum), outNum}, x);
                }

                i++;
            }

            j++;
        }

        // convert List<Long> to Long[]
        long[] result = new long[resultList.size()];
        for(int idx=0; idx < resultList.size(); idx++){
            result[idx] = resultList.get(idx);
        }
        return result;
    }

    void insertInSet(int[] p, int x){
        if(main.size() < x || comparePairs(p, main.first()) > 0){
            sum += 1L * p[0] * p[1];
            main.add(p);

            if(main.size() > x){
                int[] smallest = main.first();
                sum -= 1L * smallest[0] * smallest[1];
                main.remove(smallest);
                sec.add(smallest);
            }
        }else{
            sec.add(p);
        }
    }

    void removeFromSet(int[] p, int x){
        if(main.contains(p)){
            sum -= 1L * p[0] * p[1];
            main.remove(p);
            
            if(!sec.isEmpty()){
                int[] largest = sec.last();
                sec.remove(largest);
                main.add(largest);
                sum += 1L* largest[0] * largest[1];
            }
        }else{
            sec.remove(p);
        }
    }


    // Helper comparison to compare pairs to decide in which we have to put main or sec
    int comparePairs(int[] a, int[] b){
        if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
        return Integer.compare(a[1],b[1]);
    }
}
