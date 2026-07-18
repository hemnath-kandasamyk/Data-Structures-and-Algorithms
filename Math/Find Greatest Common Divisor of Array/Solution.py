class Solution(object):
    def findGCD(self, nums):
        maximum = max(nums)
        minimum = min(nums)
        return self.gcd(maximum,minimum)
    def gcd(self,a,b):
        if b==0:
            return a
        return self.gcd(b,a%b)    
        
