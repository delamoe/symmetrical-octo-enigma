public class PrintTime {
    public static void main(String[] args){
        long allTime = System.currentTimeMillis();
        long allTimeSeconds = allTime / 1000;
        long currentSeconds = allTimeSeconds % 60;
        long allTimeMinutes = allTime / 1000 / 60;
        long currentMinutes = allTimeMinutes % 60;
        long allTimeHours = allTime / 1000 / 60 / 60;
        long currentHours = allTimeHours % 60;
        // long allTimeDays = allTime / 1000 / 60 / 60 / 24;
        // long currentDays = allTimeDays % 365;
        // long allTimeWeeks = allTimeDays / 7;
        // long currentWeeks = allTimeWeeks % 7;
        // double allTimeMonths = allTimeDays / 31;
        // double currentMonths = allTimeDays % 31;
    System.out.printf(
            //   "%nallSeconds: \t\t" + allTimeSeconds
            // + "%ncurrentSeconds: \t" + currentSeconds
            // + "%nallTimeMinutes: \t" + allTimeMinutes
            // + "%ncurrentMinutes: \t" + currentMinutes
            // + "%nallTimeHours: \t\t" + allTimeHours
            // + "%ncurrentHours: \t\t" + currentHours
            // + "%nallTimeDays: \t\t" + allTimeDays
            // + "%ncurrentDays: \t\t" + currentDays
            // + "%nallTimeWeeks: \t\t" + allTimeWeeks
            // + "%ncurrentWeeks: \t\t" + currentWeeks 
            // + "%nallTimeMonths: \t\t" + allTimeMonths
            // + "%ncurrentMonths: \t\t" + currentMonths
            // + 
            "%nThe time now is: %02d:%02d:%02d UTC.%n",currentHours,currentMinutes,currentSeconds);
    }

}