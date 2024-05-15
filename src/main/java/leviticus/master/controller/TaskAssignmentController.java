package leviticus.master.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Controller
@RequestMapping(value = "/jobs")
public class TaskAssignmentController {

    private static final Logger LOG = LoggerFactory.getLogger(TaskAssignmentController.class);

    @GetMapping
    public String getJobs() {
        return "jobs";
    }

    @PostMapping(value = "/LBP")
    public String create(Model model) {
        LOG.info("entered into LBP API");
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
                "\"dataset\":\"/app/train/texture_dataset\"," +
                "\"numPoints\":24," +
                "\"radius\":8," +
                "\"C\":89.0" +
                "}";

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8000/train"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                .build();
        LOG.info("prepared API request");
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOG.info("API request done");
        return "redirect:/jobs";

    }
}
