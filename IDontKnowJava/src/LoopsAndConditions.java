import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class LoopsAndConditions {

	public static void main(String[] args) {
		//print numbers from 1 to 10
		System.out.println("---- using for loop ----");
		for(int i=1; i<=10; i++)
			System.out.println(i);

		System.out.println("---- using while loop ----");
		int j = 1;
		while(j<=10)
			System.out.println(j++);
	
		System.out.println("---- using do...while loop ----");
		int k=1;
		do {
			System.out.println(k++);
		}
		while(k<=10);
		
		System.out.println("---- writing conditions ----");
		LocalTime time = LocalTime.now();
		if(time.getHour() >= 4 && time.getHour() < 12)
			System.out.println("Good Morning!");
		else if(time.getHour() >= 12 && time.getHour() < 16)
			System.out.println("Good Afternoon!");
		else if(time.getHour() >= 16 && time.getHour() < 21)
			System.out.println("Good Evening!");
		else
			System.out.println("Good Night!");
		
		
		LocalDate date = LocalDate.now();
		DayOfWeek day = date.getDayOfWeek();
		switch(day) {
		case MONDAY:
			System.out.println("Monday blues");
			break;
		case TUESDAY:
			System.out.println("Still trying to wakeup");
			break;
		case WEDNESDAY:
			System.out.println("Back in some energy");
			break;
		case THURSDAY:
			System.out.println("Feeling lazy, when will weekend come?");
			break;
		case FRIDAY:
			System.out.println("When will the day end?");
			break;			
		case SATURDAY:
			System.out.println("...............zzzzzzzzzzzzz");
			break;
		case SUNDAY:
			System.out.println("...............zzzzzzzzzzzzz");
			break;			
		default:
			System.out.println("Well, it seems you are an Alien for sure!");
		}
	}
}
