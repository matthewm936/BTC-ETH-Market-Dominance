import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebsiteData {

    public static String gatherData(String str) throws IOException {
        URL url = new URL(str);
        URLConnection urlConnection = url.openConnection();
        InputStreamReader InputReader = new InputStreamReader(urlConnection.getInputStream());
        BufferedReader BuffReader = new BufferedReader(InputReader);

        String websiteData = BuffReader.readLine();
        String allData = "";
        while (websiteData != null) {
            websiteData = BuffReader.readLine();
            allData += websiteData;
        }
        return allData;
    }

    public static String cryptoDominanceNumbers(String str) throws IOException {
        String rawData = gatherData(str);
        if(rawData.contains("dominance-percentage")) {
            String dominancePercentage = rawData.substring(rawData.indexOf("dominance-percentage"));

            String firstTicker = dominancePercentage.substring(dominancePercentage.indexOf(">") + 1,
                    dominancePercentage.indexOf(">") + 4);

            String firstPercentageValue = dominancePercentage.substring(dominancePercentage.indexOf("%") - 4,
                    (dominancePercentage.indexOf("%") + 1));

            String secondPercentageValue = dominancePercentage.substring(dominancePercentage.indexOf("%") + 39,
                    (dominancePercentage.indexOf("%") + 44));

            String secondTicker = dominancePercentage.substring(dominancePercentage.indexOf("%") + 18,
                    (dominancePercentage.indexOf("%") + 21));

            return  firstTicker + ": " + firstPercentageValue + "\n" + secondTicker + ": " + secondPercentageValue;

        } else {
            return "data not found";
        }
    }

}
