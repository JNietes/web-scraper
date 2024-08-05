import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Ebay extends WebPage {

    public Ebay(String webPageURL) throws MalformedURLException {
        super(webPageURL);
    }

    public Ebay(String filePath, String webPageURL) {
        super(filePath, webPageURL);
    }
    public ArrayList<String> getItemListings() {
        ArrayList<HTMLElement> listings = this.getElementTree().getElements("<div class=\"s-item__wrapper clearfix\">");
        ArrayList<String> allListingsDetails = new ArrayList<>();
        for (int i=2; i< listings.size(); i++) {
            HTMLElementTree temp = new HTMLElementTree(listings.get(i));

            // Item Name
            allListingsDetails.add(temp.getFirstTextChild(temp.getElements("<span role=heading aria-level=3>").getFirst()));

            // Price
            if (!temp.getTextLeavesFromNode("<span class=s-item__price>").isEmpty()) {
                allListingsDetails.add(temp.getFirstTextLeafFromNode("<span class=s-item__price>"));
            } else {
                allListingsDetails.add("Price Not Found");
            }

            // Seller
            if (!temp.getElements("<span class=s-item__seller-info-text>").isEmpty()) {
                allListingsDetails.add(temp.getFirstTextChild(temp.getElements("<span class=s-item__seller-info-text>").getFirst()));
            }
            else {
                allListingsDetails.add("Seller Not Found");
            }

            // Link
            if (!temp.getElementsWithClass("s-item__link").isEmpty()) {
                String anchor = temp.getElementsWithClass("s-item__link").getLast().getValue();
                StringBuilder buildTillhref = new StringBuilder();
                for (int j=0; j < anchor.length(); j++) {
                    buildTillhref.append(anchor.charAt(j));
                    if (buildTillhref.toString().endsWith("href=")) {
                        allListingsDetails.add(anchor.substring(j+1, anchor.length()-1));
                        break;
                    }
                }
            }
            else {
                allListingsDetails.add("No Link");
            }
            allListingsDetails.add("\n");
        }
        System.out.println("Ebay Listings Scraped " + LocalTime.now());
        return allListingsDetails;
    }

}
