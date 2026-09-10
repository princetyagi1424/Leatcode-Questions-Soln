class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int total = 0;
        for(int y = 1971; y < year; y++) {
            if(y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
                total += 366;
            else
                total += 365;
        }
        for(int m = 0; m < month - 1; m++)
            total += days[m];
        if(month > 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            total++;
        total += day - 1;
        String[] week = {"Friday","Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday"};
        return week[total % 7];
    }
}