# Last updated: 7/8/2026, 5:03:03 PM
class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        hour  = hour % 12

        hour_angle = (hour*30 )+ (minutes*0.5)
        minute_angle  = minutes * 6

        angle =abs(hour_angle - minute_angle)

        return min(angle,360-angle)