class Solution(object):
    def removeElement(self, nums, val):
        length=len(nums)
        k=0
        for i in range(length):
            if nums[i]!=val:
                nums[k]=nums[i]
                k=k+1
        return k
