class Solution(object):
    def readBinaryWatch(self, turnedOn):
        result =[]
        for hour in range(12):
            for minute in range(60):
                bits = bin(hour).count("1") + bin(minute).count("1")
                if bits == turnedOn :
                    result.append("{}:{:02d}".format(hour, minute))
        return result             
        
