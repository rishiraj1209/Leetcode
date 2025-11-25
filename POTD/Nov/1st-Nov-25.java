class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        //1. put all the nums in hashSet
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        //2. traverse head till it becomes suitable for being the head of the answer
        while(head != null && set.contains(head.val)){
            head = head.next;
        };

        //3. now if val is present in set break the link to next else leaving it move the pointer to next
        ListNode temp = head;
        while(temp != null && temp.next != null){
            while(temp.next != null && set.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
