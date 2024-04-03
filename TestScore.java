import java.util.*;

public class TestScoreAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> testScores = new ArrayList<>();

        // Input test scores
        System.out.println("Enter student test scores (enter -1 to finish):");
        while (true) {
            int score = scanner.nextInt();
            if (score == -1) {
                break;
            }
            testScores.add(score);
        }

        // Calculate average score
        double averageScore = calculateAverage(testScores);

        // Calculate median score
        double medianScore = calculateMedian(testScores);

        // Analyze test scores
        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;

        for (int score : testScores) {
            if (score > averageScore) {
                aboveAverageCount++;
            } else if (score == averageScore) {
                atAverageCount++;
            } else {
                belowAverageCount++;
            }
        }

        // Display analysis results
        System.out.println("Analysis Results:");
        System.out.println("Number of students who scored above the average: " + aboveAverageCount);
        System.out.println("Median score for students who scored above the average: " + medianScore);
        System.out.println();
        System.out.println("Number of students who scored at the average: " + atAverageCount);
        System.out.println("Median score for students who scored at the average: " + medianScore);
        System.out.println();
        System.out.println("Number of students who scored below the average: " + belowAverageCount);
        System.out.println("Median score for students who scored below the average: " + medianScore);

        scanner.close();
    }

    public static double calculateAverage(List<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    public static double calculateMedian(List<Integer> scores) {
        Collections.sort(scores);
        int size = scores.size();
        if (size % 2 == 0) {
            // Even number of elements
            return (scores.get(size / 2 - 1) + scores.get(size / 2)) / 2.0;
        } else {
            // Odd number of elements
            return scores.get(size / 2);
        }
    }
}
