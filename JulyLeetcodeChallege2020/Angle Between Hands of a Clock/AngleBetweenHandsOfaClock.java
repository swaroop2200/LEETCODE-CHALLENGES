/*
    LEETCODE - 1344. Angle Between Hands of a Clock
    Approach - simple math
*/

class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour==12)
            hour = 0;
        double hourAngle = (hour * 30 + (minutes * 0.5));
        double minAngle = minutes * 6;
        double angleBtw = Math.abs(hourAngle - minAngle);
        return angleBtw <= 180.0 ? angleBtw : 360 - angleBtw;
    }
}

// TC-0(1)
// SC=0(1)