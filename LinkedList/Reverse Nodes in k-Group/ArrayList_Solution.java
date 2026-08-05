class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int count =0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        int[] nums = new int[count];
        temp = head;
        int index =0;

        while(temp!=null){
            nums[index++]=temp.val;
            temp = temp.next;
        }

        for(int i=0;i<=count-k;i+=k){
            reverse(nums,i,i+k-1);
        }
        temp = head;
        index =0;

        while(temp!=null){
            temp.val = nums[index++];
            temp = temp.next;
        }
        return head;
    }

    public void reverse(int[] nums,int s,int e){
        while(s<e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
