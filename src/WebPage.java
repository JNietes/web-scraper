import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebPage {
    private final ArrayList<String> HTMLAL = new ArrayList<>();
    private final String webPageURL;
    public WebPage(String webPageURL) {
        this.webPageURL = webPageURL;
        createHTMLCharArrayList();
    }

    public ArrayList<String> createElementArrayList() {
        ArrayList<String> nodes = new ArrayList<>();
        StringBuilder element = new StringBuilder();
        StringBuilder text = new StringBuilder();
        for (int i=0; i<HTMLAL.size(); i++) {
            if (HTMLAL.get(i).equals("<")) {
                element.append(HTMLAL.get(i));
                while (!HTMLAL.get(i).equals(">")) {
                    element.append(HTMLAL.get(++i));
                }
                if (!text.isEmpty()) {
                    nodes.add(text.toString());
                    text.setLength(0);
                }
                nodes.add(element.toString());
                element.setLength(0);
            }
            else if (!HTMLAL.get(i).equals(" ")){
                while (!HTMLAL.get(i+1).equals("<") && i < HTMLAL.size() - 1) {
                    text.append(HTMLAL.get(i));
                    i++;
                }
                text.append(HTMLAL.get(i));
            }
        }
        return nodes;
    }


    private void createHTMLCharArrayList() {
        try {
            URL url = new URL(webPageURL);
            Scanner input = new Scanner(url.openStream());
            input.useDelimiter("");
            while(input.hasNext()) {
                String tempStr = input.next();
                if (!tempStr.equals("\n")) {
                    HTMLAL.add(tempStr);
                }
            }
        }
        catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        }
        catch (IOException ex) {
            System.out.println("I/O Errors: no such file");
        }
    }
}
