class Solution(object):
    def maxProduct(self, nums):
        n = len(nums)
        prefix = 1
        suffix = 1
        product =nums[0]
        for i in range(n):
            if prefix==0:
                prefix =1
            if suffix == 0:
                suffix = 1
            prefix*=nums[i]
            suffix*=nums[n-1-i]
            product=max(product,suffix,prefix)
        return product            
        
