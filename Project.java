import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Project {
    private String studentName;
    private int completionTime; // in days

    public Project(String studentName, int completionTime) {
        this.studentName = studentName;
        this.completionTime = completionTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getCompletionTime() {
        return completionTime;
    }
}

public class ProjectAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Project> projects = new ArrayList<>();

        // Input project details
        while (true) {
            System.out.print("Enter student name (or 'done' to finish): ");
            String studentName = scanner.nextLine();
            if (studentName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter completion time (in days): ");
            int completionTime = scanner.nextInt();
            scanner.nextLine(); // consume newline

            projects.add(new Project(studentName, completionTime));
        }

        // Analyze projects
        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        int totalDays = 0;

        for (Project project : projects) {
            int completionTime = project.getCompletionTime();
            if (completionTime == 7) { // On time
                onTimeCount++;
            } else if (completionTime < 7) { // Early
                earlyCount++;
            } else { // Late
                lateCount++;
            }
            totalDays += completionTime;
        }

        int totalProjects = projects.size();
        double averageCompletionTime = totalDays / (double) totalProjects;

        // Display analysis results
        System.out.println("Number of projects completed on time: " + onTimeCount);
        System.out.println("Number of projects completed early: " + earlyCount);
        System.out.println("Number of projects completed late: " + lateCount);
        System.out.println("Average completion time: " + averageCompletionTime + " days");

        scanner.close();
    }
}
