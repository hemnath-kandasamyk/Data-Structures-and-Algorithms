#788. Rotated Digits
class Solution(object):
    def isGood(self,i):
        change=False
        temp=i
        while(temp>0): 
            digit=temp%10
            if digit in [3,4,7]:
                return False
            if digit in [2,5,6,9]:
                change=True
            temp//=10
        return change            
    def rotatedDigits(self, n):
        count=0
        for i in range(1,n+1):
            if self.isGood(i):
                count+=1
        return count        


        
