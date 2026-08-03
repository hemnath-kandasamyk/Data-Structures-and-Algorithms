class Solution(object):
    def minEatingSpeed(self, piles, h):
        low,high = 1,max(piles)
        while low<=high:
            mid = low + (high-low)//2
            work = 0

            for pile in piles :
                work = work + pile//mid 
                if pile%mid !=0:
                    work+=1

            if work<=h:
                high = mid -1
            else :
                low = mid+1
        return low                    
        
