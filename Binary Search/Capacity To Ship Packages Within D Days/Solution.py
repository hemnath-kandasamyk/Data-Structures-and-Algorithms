class Solution(object):
    def shipWithinDays(self, weights, days):
        low , high = max(weights) , sum(weights)
        while low < high :
            mid = low + (high - low)/2
            work =0
            workdays = 1

            for weight in weights :
                if(work+weight>mid):
                    work = weight
                    workdays+=1
                else :
                    work+=weight

            if workdays<=days:
                high = mid
            else :
                low = mid+1
        return low                        
        
