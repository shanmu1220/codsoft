package org.example;

import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException
    {
        /* Currency Type supported by API
            1. USD - United States Dollar       2. CAD - Canadian Dollar
            3. EUR - Euro                       4. JPY - Japanese Yen
            5. CNY - Chinese Yuan	            6. GBP - British Pound
            7. CHF - Swiss Franc	            8. NZD - New Zealand Dollar
            9. AUD - Australian Dollar	       10. KRW - South Korean Won
           11. PLN - Polish Zloty	           12. DKK - Danish Krone
           13. TRY - Turkish New Lira          14. HKD - Hong Kong Dollar
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Base Currency Type: ");
        String base = scanner.nextLine().toUpperCase();
        System.out.print("Target Currency Type: ");
        String target = scanner.nextLine().toUpperCase();
        System.out.print("Amount to convert: ");
        Double amount = scanner.nextDouble();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-ninjas.com/v1/convertcurrency?have="+base+"&want="+target+"&amount="+amount))
                .header("X-Api-Key", "dEKIsta6nHAJ3teuR+MyYw==Rq9KW7LDy4YnHsxf")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String stringResponse = response.body();
        JSONObject jsonObject = new JSONObject(stringResponse);
        Double result = jsonObject.getDouble("new_amount");

        System.out.println("\nConverting "+ base +" to "+ target);
        System.out.println(amount + " " + base + " = " + result + " " + target);
    }
}