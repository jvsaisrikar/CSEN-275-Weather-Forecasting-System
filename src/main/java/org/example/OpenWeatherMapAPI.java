import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;


public class OpenWeatherMapAPI {

    private static final String API_KEY = "2f61d4b600974f67a95235409243001";
    //https://api.weatherapi.com/v1/current.json?q=94568&key=2f61d4b600974f67a95235409243001
    private static final String BASE_URL = "https://api.weatherapi.com/v1/current.json";

    public static void getCurrentWeatherByCity(String city) {
        HttpClient client = HttpClient.newHttpClient();
        String url = BASE_URL + "?q=" + city + "&key=" + API_KEY;
        System.out.printf("Formatted Url: %s%n", url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            System.out.println(jsonResponse.toString(4));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getCurrentWeatherByCity("Santa%20Clara%20California");
    }
}
