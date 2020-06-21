import java.io.IOException;

public class ScanApp {
    public static void main(String args[]) throws IOException {
        Crawler crawler = new Crawler(args[0], Integer.parseInt(args[1]));
        crawler.Scan();
        System.out.println("Depth: " + Integer.parseInt(args[1]));
        crawler.Show();
    }
}
