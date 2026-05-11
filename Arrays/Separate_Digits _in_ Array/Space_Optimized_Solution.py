class Solution(object):
    def separateDigits(self, nums):
     n=0
     for i in nums:
        temp=i
        if temp==0:
            n=n+1
        while temp!=0:
            n=n+1
            temp=temp//10

     result=[0]*n
     n=n-1
     for i in range(len(nums)-1,-1,-1):
        temp=nums[i]
        if temp==0:
            result[n]=0
            n=n-1
        while temp!=0:
            result[n]=temp%10
            n=n-1
            temp=temp//10
     return result                           
        
