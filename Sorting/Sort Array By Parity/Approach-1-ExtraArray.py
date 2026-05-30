class Solution(object):
    def sortArrayByParity(self, nums):
        result=[0]*len(nums)
        start=0        
        end=len(nums)-1

        for i in nums:
            if i%2==0:
                result[start]=i
                start+=1
            else :
                result[end]=i
                end-=1    

        return result   
