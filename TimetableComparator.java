
import java.util.*;

class FacultyTimetable {
    String facultyName;
    String day;
    int startHour;
    int endHour;

    FacultyTimetable(String facultyName, String day, int startHour, int endHour) {
        this.facultyName = facultyName;
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    // Method to check if two timetables overlap
    public boolean clashesWith(FacultyTimetable other) {
        if (!this.day.equalsIgnoreCase(other.day)) {
            return false; // Different day → no clash
        }
        return (this.startHour < other.endHour && this.endHour > other.startHour);
    }

    @Override
    public String toString() {
        return facultyName + " → " + day + " (" + startHour + ":00 - " + endHour + ":00)";
    }
}

public class TimetableComparator {
    public static void main(String[] args) {
        // Example faculty schedules
        FacultyTimetable t1 = new FacultyTimetable("Dr. Smith", "Monday", 9, 11);
        FacultyTimetable t2 = new FacultyTimetable("Prof. Johnson", "Monday", 10, 12);
        FacultyTimetable t3 = new FacultyTimetable("Dr. Brown", "Tuesday", 9, 11);

        // Print schedules
        System.out.println("Faculty Timetables:");
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        // Compare
        System.out.println("\nChecking clashes:");
        System.out.println(t1.facultyName + " vs " + t2.facultyName + ": " + 
                           (t1.clashesWith(t2) ? "Clash" : "No Clash"));
        System.out.println(t1.facultyName + " vs " + t3.facultyName + ": " + 
                           (t1.clashesWith(t3) ? "Clash" : "No Clash"));
    }
}