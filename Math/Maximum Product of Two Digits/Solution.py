class Solution(object):
    def maxProduct(self, n):
        max1 = 0
        max2 = 0
        temp=n
        while temp!=0:
            rem = temp%10
            temp//=10
            if rem>max1:
                max2=max1
                max1=rem
            elif rem>max2:
                max2=rem 
        return max1*max2           
        
