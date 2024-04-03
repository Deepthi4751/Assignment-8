import java.util.*;

class BookReview {
    private String title;
    private int rating; // Rating out of 10

    public BookReview(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class BookReviewAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BookReview> bookReviews = new ArrayList<>();

        // Input book review details
        while (true) {
            System.out.print("Enter book title (or 'done' to finish): ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter book rating (out of 10): ");
            int rating = scanner.nextInt();
            scanner.nextLine(); // consume newline

            bookReviews.add(new BookReview(title, rating));
        }

        // Analyze book reviews
        int[] ratingRangeCounts = new int[2]; // 0: 1-5 stars, 1: 6-10 stars
        int[] reviewSentimentCounts = new int[3]; // 0: Positive, 1: Neutral, 2: Negative

        for (BookReview review : bookReviews) {
            int rating = review.getRating();

            // Count books within rating ranges
            if (rating >= 1 && rating <= 5) {
                ratingRangeCounts[0]++;
            } else if (rating >= 6 && rating <= 10) {
                ratingRangeCounts[1]++;
            }

            // Determine review sentiment
            if (rating >= 8) {
                reviewSentimentCounts[0]++; // Positive review
            } else if (rating >= 4) {
                reviewSentimentCounts[1]++; // Neutral review
            } else {
                reviewSentimentCounts[2]++; // Negative review
            }
        }

        // Display analysis results
        System.out.println("Analysis Results:");
        System.out.println("Books reviewed within rating ranges:");
        System.out.println("1-5 stars: " + ratingRangeCounts[0]);
        System.out.println("6-10 stars: " + ratingRangeCounts[1]);
        System.out.println();
        System.out.println("Review Sentiments:");
        System.out.println("Positive reviews: " + reviewSentimentCounts[0]);
        System.out.println("Neutral reviews: " + reviewSentimentCounts[1]);
        System.out.println("Negative reviews: " + reviewSentimentCounts[2]);

        scanner.close();
    }
}
