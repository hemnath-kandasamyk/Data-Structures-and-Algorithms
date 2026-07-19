class Solution(object):
    def maxDistance(self, colors):
        left = start = 0
        right = end = len(colors)-1
        while left<=right and colors[left]==colors[right]:
            left+=1
        while start<=end and colors[start]==colors[end]:
            end-=1
        return max(end-start,right-left)        

        
