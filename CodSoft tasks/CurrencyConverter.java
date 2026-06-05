import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Currency Converter =====");

        System.out.print("Enter Base Currency (USD, INR, EUR, GBP): ");
        String fromCurrency = sc.next().toUpperCase();

        System.out.print("Enter Target Currency (USD, INR, EUR, GBP): ");
        String toCurrency = sc.next().toUpperCase();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        try {

            String apiKey = "YOUR_API_KEY";

            String url =
                "https://v6.exchangerate-api.com/v6/"
                + apiKey
                + "/latest/"
                + fromCurrency;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request,
                            HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Pattern pattern = Pattern.compile(
                    "\"" + toCurrency + "\":([0-9.]+)");

            Matcher matcher = pattern.matcher(json);

            if (matcher.find()) {

                double exchangeRate =
                        Double.parseDouble(matcher.group(1));

                double convertedAmount =
                        amount * exchangeRate;

                System.out.println("\n===== RESULT =====");
                System.out.println("From Currency : "
                        + fromCurrency);

                System.out.println("To Currency   : "
                        + toCurrency);

                System.out.println("Amount        : "
                        + amount);

                System.out.println("Exchange Rate : "
                        + exchangeRate);

                System.out.println("Converted Amount : "
                        + convertedAmount);

            } else {

                System.out.println(
                        "Currency not found.");
            }

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }

        sc.close();
    }
}