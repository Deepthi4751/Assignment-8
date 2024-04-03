import java.util.*;

public class RestaurantRatingAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> restaurantRatings = new ArrayList<>();

        // Input restaurant ratings
        System.out.println("Enter restaurant ratings (enter -1 to finish):");
        while (true) {
            int rating = scanner.nextInt();
            if (rating == -1) {
                break;
            }
            restaurantRatings.add(rating);
        }

        // Analyze restaurant ratings
        Map<String, Integer> ratingRangeCounts = new HashMap<>();
        Map<String, Integer> ratingRangeTotalRatings = new HashMap<>();

        for (int rating : restaurantRatings) {
            String ratingRange = getRatingRange(rating);
            ratingRangeCounts.put(ratingRange, ratingRangeCounts.getOrDefault(ratingRange, 0) + 1);
            ratingRangeTotalRatings.put(ratingRange, ratingRangeTotalRatings.getOrDefault(ratingRange, 0) + rating);
        }

        // Calculate average rating for each range
        Map<String, Double> ratingRangeAverageRatings = new HashMap<>();
        for (String range : ratingRangeCounts.keySet()) {
            int count = ratingRangeCounts.get(range);
            int totalRating = ratingRangeTotalRatings.get(range);
            double averageRating = (double) totalRating / count;
            ratingRangeAverageRatings.put(range, averageRating);
        }

        // Display analysis results
        System.out.println("Analysis Results:");
        for (String range : ratingRangeCounts.keySet()) {
            System.out.println("Rating Range: " + range);
            System.out.println("Number of restaurants: " + ratingRangeCounts.get(range));
            System.out.println("Average rating: " + ratingRangeAverageRatings.get(range));
            System.out.println();
        }

        scanner.close();
    }

    public static String getRatingRange(int rating) {
        if (rating >= 1 && rating <= 5) {
            return "1-5";
        } else if (rating >= 6 && rating <= 10) {
            return "6-10";
        } else {
            return "Unknown";
        }
    }
}
