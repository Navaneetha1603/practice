package AngleBetweenHrAndMinHand;

import java.util.Scanner;

/*Write a program to calculate the angle between the hour hand and the minute hand of a clock if the time is given in a string format. 
For example if the time is given as 12:15 the output should be 90 degrees.*/
public class AngleBetweenHrAndMinHand {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter string in the format of hour:minutes");
		String time = sc.next();
		String validTime = validateTime(time);
		int angle = getAngle(validTime);
		System.out.println("angle between hour hand and minute hand:" + angle);

	}

	// get an angle
	private static int getAngle(String validTime) {
		String hour = "";
		hour += validTime.charAt(0);
		hour += validTime.charAt(1);
		// get hour in integer
		int hr = getInt(hour);
		// minute
		String minute = "";
		minute += validTime.charAt(3);
		minute += validTime.charAt(4);
		// get minute in integer
		int min = getInt(minute);
		// calculate the position of the hour
		int hourHandDegree = hr * (360 / 12) + (min * 360) / (12 * 60);
		// calculate the position of minute hand
		int minHandDegree = min * (360 / 60);
		// calculate the angle difference
		int angle = (hourHandDegree > minHandDegree) ? (hourHandDegree - minHandDegree)
				: (minHandDegree - hourHandDegree);
		if (angle > 180) {
			angle = 360 - angle;
		}
		return angle;
	}

	// convert string in to integer
	private static int getInt(String hour) {
		char charArray[] = new char[hour.length()];
		for (int i = 0; i < hour.length(); i++) {
			charArray[i] = hour.charAt(i);
		}
		int sum = 0;
		// ascii value for zero
		int zeroAscii = (int) '0';
		for (char c : charArray) {
			int ascii = (int) c;
			sum = (sum * 10) + (ascii - zeroAscii);
		}
		return sum;
	}

	// validate time
	private static String validateTime(String time) {
		while (!time.matches("([01][0-9]|2[0-3]):(0[0-9]|[1-5][0-9])$")) {
			System.out.println("entered time is invalid.once again enter the time in HH:MM format");
			time = sc.next();
		}
		return time;
	}

}
