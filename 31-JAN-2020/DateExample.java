import java.util.*;
import java.time.LocalDate;
import java.lang.*;
import java.time.*;

class DateExample{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Year");
		int y = sc.nextInt();
		System.out.println("Enter the month");
		int m = sc.nextInt();
		System.out.println("Enter the day");
		int d = sc.nextInt();
		LocalDate ld = LocalDate.of( y , m , d );
		LocalDate s = LocalDate.now();
		Period diff = Period.between(ld, s);
		System.out.println("The difference between the current date and the date put by you is : ");
		System.out.println(diff.getDays() + " Days");
		System.out.println(diff.getMonths() + " Months");
		System.out.println(diff.getYears() + " Years");
		// System.out.println(y);
	}
}