import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a URL and the desired name of the CSV: ");
        String[] inputs = {input.next(), input.next()};

        boolean valid = false;
        while (!valid) {
            try {
                Ebay ebay = new Ebay(inputs[0]);
                ebay.createCSV(ebay.getItemListings(), inputs[1]);
                valid = true;
                System.out.println("File Created");
            }
            catch (MalformedURLException ex) {
                System.out.print("Enter another URL: ");
                inputs[0] = input.next();
            }
            catch (FileNotFoundException ex) {
                System.out.println("Invalid File Name");
                System.out.print("Enter another file name (without .csv): ");
                inputs[1] = input.next();
            }
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
