import java.util.Random;

public class EmployeePayroll {
    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOUR = 8;
    public static final int PART_TIME_HOUR = 4;
    public static final int WORKING_DAYS_PER_MONTH = 20;
    public static final int MAX_WORKING_HOURS= 100;
    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program!");

        // UC 1: Check Employee is Present or Absent
        checkEmployeeAttendance();

        // UC 2: Calculate Daily Employee Wage
        calculateDailyWage();

        // UC 3: Add Part Time Employee Wage
        calculatePartTimeWage();

        // UC 4: Solve using Switch Case
        solveUsingSwitchCase();

        // UC 5: Calculate Wages for a Month
        calculateMonthlyWages();

        // UC 6: Calculate Wages till Condition is Reached
        calculateWagesTillCondition();

        // UC 7: Using Class Method to Compute Employee Wage
        int totalWage = computeEmployeeWage(WORKING_DAYS_PER_MONTH, MAX_WORKING_HOURS);
        System.out.println("Total Wage Calculated using Class Method: " + totalWage);

        // UC 8: Compute Wages for Multiple Companies using a separate file
        UC8_CompanyEmployeeWage companyWageCalculator = new UC8_CompanyEmployeeWage();

        int totalWageForCompanyA = companyWageCalculator.computeEmployeeWageForCompany("Company A", 20, 20, 100);
        System.out.println("Total Wage for Company A: " + totalWageForCompanyA);

        int totalWageForCompanyB = companyWageCalculator.computeEmployeeWageForCompany("Company B", 25, 22, 120);
        System.out.println("Total Wage for Company B: " + totalWageForCompanyB);

        int totalWageForCompanyC = companyWageCalculator.computeEmployeeWageForCompany("Company C", 18, 25, 110);
        System.out.println("Total Wage for Company C: " + totalWageForCompanyC);
    }
    // UC 1: Check Employee Attendance
    private static void checkEmployeeAttendance() {
        int attendance = new Random().nextInt(2); // Random 0 or 1
        if (attendance == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }
    // UC 2: Calculate Daily Employee Wage
    private static void calculateDailyWage() {
        int dailyWage = WAGE_PER_HOUR * FULL_DAY_HOUR;
        System.out.println("Daily Employee Wage: " + dailyWage);
    }
    // UC 3: Add Part Time Employee Wage
    private static void calculatePartTimeWage() {
        int partTimeWage = WAGE_PER_HOUR * PART_TIME_HOUR;
        System.out.println("Part Time Employee Wage: " + partTimeWage);
    }
    // UC 4: Solve using Switch Case
    private static void solveUsingSwitchCase() {
        int empType = new Random().nextInt(3); // 0: Absent, 1: Full-Time, 2: Part-Time
        int empHours;

        switch (empType) {
            case 1:
                empHours = FULL_DAY_HOUR;
                System.out.println("Employee is Full-Time");
                break;
            case 2:
                empHours = PART_TIME_HOUR;
                System.out.println("Employee is Part-Time");
                break;
            default:
                empHours = 0;
                System.out.println("Employee is Absent");
        }

        int wage = WAGE_PER_HOUR * empHours;
        System.out.println("Wage for the Day: " + wage);
    }
    // UC 5: Calculate Monthly Wages
    private static void calculateMonthlyWages() {
        int totalWage = 0;

        for (int day = 1; day <= WORKING_DAYS_PER_MONTH; day++) {
            int empType = new Random().nextInt(3); // 0: Absent, 1: Full-Time, 2: Part-Time
            int empHours = (empType == 1) ? FULL_DAY_HOUR : (empType == 2) ? PART_TIME_HOUR : 0;

            totalWage += WAGE_PER_HOUR * empHours;
        }

        System.out.println("Total Wage for the Month: " + totalWage);
    }
    // UC 6: Calculate Wages till Condition is Reached
    private static void calculateWagesTillCondition() {
        int totalHours = 0, totalDays = 0, totalWage = 0;

        while (totalHours <= MAX_WORKING_HOURS && totalDays < WORKING_DAYS_PER_MONTH) {
            totalDays++;
            int empType = new Random().nextInt(3); // 0: Absent, 1: Full-Time, 2: Part-Time
            int empHours = (empType == 1) ? FULL_DAY_HOUR : (empType == 2) ? PART_TIME_HOUR : 0;

            totalHours += empHours;
            totalWage += WAGE_PER_HOUR * empHours;

            if (totalHours > MAX_WORKING_HOURS) {
                break;
            }
        }

        System.out.println("Total Working Days: " + totalDays);
        System.out.println("Total Working Hours: " + totalHours);
        System.out.println("Total Wage Earned: " + totalWage);
    }

    // UC 7: Refactor Code to Write a Class Method to Compute Employee Wage
    private static int computeEmployeeWage(int totalWorkingDays, int maxWorkingHours) {
        int totalHours = 0, totalDays = 0, totalWage = 0;

        while (totalHours <= maxWorkingHours && totalDays < totalWorkingDays) {
            totalDays++;
            int empType = new Random().nextInt(3); // 0: Absent, 1: Full-Time, 2: Part-Time
            int empHours = (empType == 1) ? FULL_DAY_HOUR : (empType == 2) ? PART_TIME_HOUR : 0;

            totalHours += empHours;
            totalWage += WAGE_PER_HOUR * empHours;

            if (totalHours > maxWorkingHours) {
                break;
            }
        }

        System.out.println("=== Employee Wage Computation Summary ===");
        System.out.println("Total Working Days: " + totalDays);
        System.out.println("Total Working Hours: " + totalHours);
        System.out.println("Total Wage Earned: " + totalWage);

        return totalWage;
    }

}

