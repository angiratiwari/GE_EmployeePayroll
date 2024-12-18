import java.util.Random;

public class UC8_CompanyEmployeeWage {
    public static final int FULL_DAY_HOUR = 8;
    public static final int PART_TIME_HOUR = 4;

    public int computeEmployeeWageForCompany(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        int totalHours = 0, totalDays = 0, totalWage = 0;

        while (totalHours <= maxWorkingHours && totalDays < maxWorkingDays) {
            totalDays++;
            int empType = new Random().nextInt(3); // 0: Absent, 1: Full-Time, 2: Part-Time
            int empHours = (empType == 1) ? FULL_DAY_HOUR : (empType == 2) ? PART_TIME_HOUR : 0;

            totalHours += empHours;
            totalWage += wagePerHour * empHours;

            if (totalHours > maxWorkingHours) {
                break;
            }
        }

        System.out.println("=== Employee Wage Computation for " + company + " ===");
        System.out.println("Total Working Days: " + totalDays);
        System.out.println("Total Working Hours: " + totalHours);
        System.out.println("Total Wage Earned: " + totalWage);

        return totalWage;
    }
}
