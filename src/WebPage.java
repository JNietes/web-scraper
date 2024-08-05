import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class WebPage {
    private final ArrayList<String> HTMLAL = new ArrayList<>();
    private ArrayList<String> nodes = new ArrayList<>();
    private final String webPageURL;
    private final HTMLElementTree elementTree;
    public WebPage(String webPageURL) throws MalformedURLException {
        this.webPageURL = webPageURL;
        createHTMLCharArrayList();
        createElementArrayList();
        elementTree = new HTMLElementTree(nodes);
    }

    public WebPage(String filePath, String webPageURL) { // For HTMLElement.txt
        this.webPageURL = webPageURL;
        nodes = Main.readFile(filePath, "\n");
        elementTree = new HTMLElementTree(nodes);
    }

    public void createElementArrayList() {
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
                if (element.toString().startsWith("<!--")) { // Omitting HTML comments
                    while (!element.toString().endsWith("-->")) {
                        element.append(HTMLAL.get(++i));
                    }
                    element.setLength(0);
                    continue;
                }
                if (element.toString().startsWith("<script")) { // Omitting JavaScript
                    while (!element.toString().endsWith("/script>")) {
                        element.append(HTMLAL.get(++i));
                    }
                    element.setLength(0);
                    continue;
                }
                if (element.toString().startsWith("<style")) { // Omitting CSS
                    while (!element.toString().endsWith("/style>")) {
                        element.append(HTMLAL.get(++i));
                    }
                    element.setLength(0);
                    continue;
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
        System.out.println("Elements Created " + LocalTime.now());
    }


    private void createHTMLCharArrayList() throws MalformedURLException {
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
            System.out.println("HTML Downloaded " + LocalTime.now());
        }
        catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
            throw ex;
        }
        catch (IOException ex) {
            System.out.println("I/O Errors: no such file");
        }
    }

    protected void createCSV(ArrayList<String> arrayList, String fileName) throws FileNotFoundException {
        File csv = new File(fileName + ".csv");
        try (PrintWriter output = new PrintWriter(csv)){
            for (String s : arrayList) {
                if (s.equals("\n")) {
                    output.print(s);
                }
                else {
                    output.print("\"" + s + "\",");
                }
            }
        } catch (Exception e) {
            System.out.println("CSV Error");
        }
    }

    public HTMLElementTree getElementTree() {
        return elementTree;
    }

    public ArrayList<String> getNodes() {
        return nodes;
    }
}
