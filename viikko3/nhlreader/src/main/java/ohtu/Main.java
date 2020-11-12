package ohtu;

import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        System.out.println("Players from FIN:");

        Arrays.stream(players)
                .filter(player -> player.getNationality().equals("FIN"))
                .sorted(Comparator.comparingInt(Player::getScore).reversed())
                .forEach(player -> System.out.printf("%-30s%s%n", player.getName(), player.toString()));
    }

}