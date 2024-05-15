package leviticus.master.app;

import org.springframework.core.ReactiveAdapterRegistry;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TestApplication {

    public static void main(String[] args) {
        String trainTaskPrefix = "TR-";
        Random rand = new Random();
        Long id = rand.nextLong();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HHmmss");
        String now = "-" + LocalDate.now().format(formatDate);
        now += LocalTime.now().format(formatTime);
        String trainTaskId = trainTaskPrefix + id + now;
        String jsonData = "" +
                "{" +
                    "\"taskId\":\"" + trainTaskId + "\"," +
                    "\"trainOnly\":false," +
                    "\"dataset\":\"/app/train/animals\"" +
                "}";

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8001/train"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        // TR--1855078538474181113-20240418211259
//        jsonData = "" +
//                "{" +
//                "\"trainTaskId\":\"" + trainTaskId + "\"," +
//                "\"trainDataset\":\"/app/train/texture_dataset\"," +
//                "\"predictDataset\":\"/app/predict/texture_dataset_not_categorized\"," +
//                "\"numPoints\":24," +
//                "\"radius\":8" +
//                "}";
//
//        httpClient = HttpClient.newHttpClient();
//
//        httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8000/predict"))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
//                .build();
//        try {
//            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//            System.out.println("Response Code: " + response.statusCode());
//            System.out.println("Response Body: " + response.body());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
