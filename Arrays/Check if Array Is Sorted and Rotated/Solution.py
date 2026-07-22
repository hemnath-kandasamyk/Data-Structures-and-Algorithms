class Solution(object):
    def check(self, nums):
        n = len(nums)
        for i in range(1,n):
            if nums[i]<nums[i-1]:
                for j in range(0,n-1):
                    if nums[(j+i)%n] > nums[(j+i+1)%n]:
                        return False
                break
        return True            
        
