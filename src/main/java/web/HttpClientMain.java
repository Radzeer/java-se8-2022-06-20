package web;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientMain {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        var request = HttpRequest.newBuilder().uri(new URI("https://index.hu")).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofLines());
        response.body().forEach(System.out::println);
    }
}
