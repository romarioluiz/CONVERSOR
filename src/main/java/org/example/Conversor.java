package org.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Conversor {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/160f9a9ff5b87d6831ad2783/latest/";

    // Códigos de moeda para filtrar
    private static final List<String> CURRENCY_CODES = Arrays.asList("EUR","ARS", "BOB", "BRL", "CLP", "COP", "USD");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                // Exibir menu de opções
                System.out.println("\n**********************************************");
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Conversão de moeda");
                System.out.println("0. Sair");
                System.out.println("\n**********************************************");


                // Capturar a escolha do usuário
                int choice = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer de entrada

                switch (choice) {
                    case 1:
                        performCurrencyConversion(scanner);
                        break;
                    case 0:
                        System.out.println("Obrigado por Utilizar nosso Conversor");
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, selecione 1 ou 0.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static void performCurrencyConversion(Scanner scanner) throws Exception {
        // Solicitar dados de entrada ao usuário
        System.out.println("\nInforme o valor a ser convertido:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de entrada

        System.out.println("Informe a moeda de origem (por exemplo, USD):");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Informe a moeda de destino (por exemplo, EUR):");
        String toCurrency = scanner.nextLine().toUpperCase();

        // Obter a taxa de câmbio e realizar a conversão
        double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
        double result = convertCurrency(amount, exchangeRate);

        // Exibir o resultado da conversão
        System.out.println(amount + " " + fromCurrency + " = " + result + " " + toCurrency);
    }

    public static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    public static double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        String url = API_URL + fromCurrency;
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
        }

        String json = response.body();
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        if (conversionRates.has(toCurrency)) {
            return conversionRates.get(toCurrency).getAsDouble();
        } else {
            throw new RuntimeException("Taxa de câmbio para " + toCurrency + " não encontrada.");
        }
    }
}
