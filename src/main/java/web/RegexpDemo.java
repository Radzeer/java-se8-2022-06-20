package web;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegexpDemo {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        var request = HttpRequest.newBuilder().uri(new URI("https://index.hu")).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofLines());

        var start = System.currentTimeMillis();

        response
                .body()
                .parallel()
                .flatMap(line -> getLinks(line))
                .filter(link -> link.startsWith("https://"))
                .distinct()
                .limit(100)
                .filter(link -> statusNotOk(link))
                .forEach(System.out::println);

        System.out.println(System.currentTimeMillis()-start);

    }

    private static boolean statusNotOk(String link) {
        try {
            var request = HttpRequest.newBuilder().uri(new URI(link)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofLines());
            return response.statusCode()!=200;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static Stream<String> getLinks(String line){
        var pattern = Pattern.compile("href=\"([^\"]*)\"");
        var matcher = pattern.matcher(line);
        return matcher.results().map(r -> r.group(1));
    }
}
