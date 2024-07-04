import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebPage {
    private final String webPageURL;
    public WebPage(String webPageURL) {
        this.webPageURL = webPageURL;
    }

    public ArrayList<String> createHTMLArrayList() {
        return createHTMLArrayList(webPageURL);
    }
    public ArrayList<String> createHTMLArrayList(String urlString) {
        ArrayList<String> WPAL = new ArrayList<>();
        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            input.useDelimiter("\n");
            while(input.hasNext()) {
                String tempStr = input.next();
                WPAL.add(tempStr);
            }
        }
        catch (java.net.MalformedURLException ex) {
            System.out.println("Invalid URL");
        }
        catch (java.io.IOException ex) {
            System.out.println("I/O Errors: no such file");
        }
        return WPAL;
    }

}
