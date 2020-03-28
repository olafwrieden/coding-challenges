package Clock;

/**
 * Problem: Clock Angle Problem
 * 
 * Description: Find the angle between the hands of an analog clock.
 *
 * Calculation:
 * Minute hand moves 360° in 60 minutes. 360/60 = 6° per minute.
 * Hour hand moves 360° in 12 hours (720 minutes). 360/720 = 0.5° per minute.
 * Minute Hand Movement: (hour * 60 + minute) * 6
 * Hour Hand Movement: (hour * 60 + minute) * 0.5
 */
public class ClockAngleProblem {

  /**
   * Program entry point.
   * 
   * @param args program input parameters
   */
  public static void main(String[] args) {
    System.out.println(angleBetween(12, 0));
    System.out.println(angleBetween(6, 30));
    System.out.println(angleBetween(0, 1));
    System.out.println(angleBetween(0, -3));
  }

  /**
   * Calculates the angle between hour and minute hands on a clock.
   * 
   * @param hour   clock's hour
   * @param minute clock's minute
   * @return smallest angle between hour and minute
   */
  static double angleBetween(double hour, double minute) {
    // Check if valid input
    if (hour < 0 || hour > 12 || minute < 0 || minute > 60) {
      System.out.println("Invalid input provided.");
      return -1;
    }

    // Fix edge cases
    if (hour == 12) {
      hour = 0;
    }
    if (minute == 60) {
      hour++;
      minute = 0;
    }

    // Calculate angles respective to 12.00

    // (Current hour in minutes + current minute) x 5° per minute
    double hourAngle = (double) (hour * 60 + minute) * 0.5;
    // (current minute x 6° per minute) - Minutes are always in respect to 12.00
    double minuteAngle = (double) (minute * 6);

    // Subtract angles to find their difference
    double angle = Math.abs(hourAngle - minuteAngle); // abs() flip negatives created by reflex angles

    // Return smaller angle
    return Math.min(360 - angle, angle);
  }
}