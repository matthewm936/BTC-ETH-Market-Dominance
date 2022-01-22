import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {


    public static void main(String[] args) throws IOException {


        FileWriter writer = new FileWriter("CryptoDominanceTracker");
        writer.write(WebsiteData.cryptoDominanceNumbers("https://coinmarketcap.com/"));
        writer.close();
        System.out.println(WebsiteData.cryptoDominanceNumbers("https://coinmarketcap.com/"));

        writer.write(WebsiteData.cryptoDominanceNumbers("https://www.cmegroup.com/markets/cryptocurrencies/bitcoin/bitcoin.html"));
        writer.close();
        System.out.println(WebsiteData.cryptoDominanceNumbers("https://www.cmegroup.com/markets/cryptocurrencies/bitcoin/bitcoin.html"));
    }
}
