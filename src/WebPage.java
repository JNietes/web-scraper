import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebPage {
    private final ArrayList<String> HTMLAL = new ArrayList<>();
    private final String webPageURL;
    
    private final HTMLElement HTMLHead = new HTMLElement(); 
    public WebPage(String webPageURL) {
        this.webPageURL = webPageURL;
        createHTMLArrayList();
    }

    public void createHTMLTree() {
        ArrayList<String> nodes = new ArrayList<>();
        StringBuilder element = new StringBuilder();
        StringBuilder text = new StringBuilder();
        int endOfLastTag = 0;
        for (int i = 0; i<HTMLAL.size(); i++) {
            if (HTMLAL.get(i).equals("<")) {
                element.append("<");
                while (!HTMLAL.get(i).equals(">")) {
                    element.append(HTMLAL.get(++i));
                }
                if (element.toString().startsWith("</") && !HTMLAL.get(endOfLastTag + 1).equals(" ") &&  !HTMLAL.get(endOfLastTag + 1).equals("<")) {
                    for (int j = endOfLastTag+1; j <= i - element.length(); j++) {
                        text.append(HTMLAL.get(j));
                    }
                    nodes.add(text.toString());
                    text.setLength(0);
                }
                endOfLastTag = i;
                nodes.add(element.toString());
                element.setLength(0);
            }
        }
        System.out.println(nodes);
    }

    private void createHTMLArrayList() {
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

    public ArrayList<String> getHTMLAL() {
        return HTMLAL;
    }
}
