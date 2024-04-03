import java.util.*;

class Movie {
    private String title;
    private String category;
    private double rating;

    public Movie(String title, String category, double rating) {
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }
}

public class MovieRatingsAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();

        // Input movie details
        while (true) {
            System.out.print("Enter movie title (or 'done' to finish): ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter movie category: ");
            String category = scanner.nextLine();

            System.out.print("Enter movie rating: ");
            double rating = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            movies.add(new Movie(title, category, rating));
        }

        // Analyze movie ratings
        Map<String, Integer> categoryCounts = new HashMap<>();
        Map<String, Double> categoryTotalRatings = new HashMap<>();

        for (Movie movie : movies) {
            String category = movie.getCategory();
            double rating = movie.getRating();

            // Update category counts
            categoryCounts.put(category, categoryCounts.getOrDefault(category, 0) + 1);

            // Update total ratings for each category
            categoryTotalRatings.put(category, categoryTotalRatings.getOrDefault(category, 0.0) + rating);
        }

        // Calculate average rating for each category
        Map<String, Double> categoryAverageRatings = new HashMap<>();
        for (String category : categoryCounts.keySet()) {
            int count = categoryCounts.get(category);
            double totalRating = categoryTotalRatings.get(category);
            double averageRating = totalRating / count;
            categoryAverageRatings.put(category, averageRating);
        }

        // Display analysis results
        System.out.println("Analysis Results:");
        for (String category : categoryCounts.keySet()) {
            int count = categoryCounts.get(category);
            double averageRating = categoryAverageRatings.get(category);
            System.out.println("Category: " + category);
            System.out.println("Number of movies rated: " + count);
            System.out.println("Average rating: " + averageRating);
            System.out.println();
        }

        scanner.close();
    }
}
