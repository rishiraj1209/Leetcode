class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> a[1] == b[1]? a[0] - b[0]: a[1] - b[1]);
        ArrayList<Integer> set = new ArrayList<>();
        set.add(intervals[0][1]-1);
        set.add(intervals[0][1]);
        for(int i=1; i<n; i++){
            int first = intervals[i][0];
            int second = intervals[i][1];
            int size = set.size();
            int last = set.get(size-1);
            int secondL = set.get(size-2);

            if(first > last){
                set.add(second-1);
                set.add(second);
            }else if(first == last){
                set.add(second);
            }
            else if(first > secondL){
                set.add(second);
            }
        }
        return set.size();
    }
}
