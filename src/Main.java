import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WebPage wp3 = new WebPage("https://www.ebay.com/sch/i.html?_from=R40&_nkw=graphics+card&_sacat=0");
        wp3.getElementTree().getTextLeavesFromNode("<div class=s-item__title>");

        File HTMLElements = new File ("HTMLElements.txt");
        if (!HTMLElements.exists()) {
            createHTMLElementFile(wp3);
        }
    }

    // Can aid in finding elements
    public static void createHTMLElementFile(WebPage webPage) {
        createFile("HTMLElements.txt", webPage.getNodes(), "\n");
    }
    public static void createFile(String fileName, ArrayList<String> arrayList, String delimiter) {
        try {
            File htmlStringArr = new File(fileName);
            PrintWriter output = new PrintWriter(htmlStringArr);

            for (String e: arrayList) {
                output.print(e + delimiter);
            }
            output.close();
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }

    public static ArrayList<String> readFile(String filePath, String delimiter) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner input = new Scanner(file);
            input.useDelimiter(delimiter);
            while (input.hasNext()) {
                String tempStr = input.next();
                if (!tempStr.equals("\n") && !tempStr.equals("\r")) {
                    arrayList.add(tempStr);
                }
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return arrayList;
    }
}
