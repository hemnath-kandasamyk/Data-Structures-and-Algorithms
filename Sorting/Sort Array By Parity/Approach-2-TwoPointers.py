class Solution(object):
    def sortArrayByParity(self, nums):
        start=0        
        end=len(nums)-1

        while (start < end) :
            if nums[start]%2==0:
                start+=1
            elif  nums[end]%2!=0:
                end-=1
            else :
                temp=nums[start]
                nums[start]=nums[end]
                nums[end]=temp
                start+=1
                end-=1       
        return nums  
