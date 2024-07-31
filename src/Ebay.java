import java.io.File;
import java.util.ArrayList;

public class Ebay extends WebPage {

    public Ebay(String webPageURL) {
        super(webPageURL);
    }

    public Ebay(String filePath, String webPageURL) {
        super(filePath, webPageURL);
    }
    public ArrayList<String> getGraphicsCardListings() {
        ArrayList<HTMLElement> listings = this.getElementTree().getElements("<div class=\"s-item__wrapper clearfix\">");
        ArrayList<String> cardPriceSellerArrayList = new ArrayList<>();
        for (int i=2; i< listings.size(); i++) {
            HTMLElementTree temp = new HTMLElementTree(listings.get(i));
            cardPriceSellerArrayList.add(temp.getFirstTextChild(temp.getElements("<span role=heading aria-level=3>").getFirst()));
            cardPriceSellerArrayList.add(temp.getFirstTextChild(temp.getElements("<span class=s-item__price>").getFirst()));
            if (!temp.getElements("<span class=s-item__seller-info-text>").isEmpty()) {
                cardPriceSellerArrayList.add(temp.getFirstTextChild(temp.getElements("<span class=s-item__seller-info-text>").getFirst()));
            }
            else {
                cardPriceSellerArrayList.add("No Seller Listed");
            }
            if (!temp.getElementsWithClass("s-item__link").isEmpty()) {
                String anchor = temp.getElementsWithClass("s-item__link").getLast().getValue();
                StringBuilder buildTillhref = new StringBuilder();
                for (int j=0; j < anchor.length(); j++) {
                    buildTillhref.append(anchor.charAt(j));
                    if (buildTillhref.toString().endsWith("href=")) {
                        cardPriceSellerArrayList.add(anchor.substring(j+1, anchor.length()-1));
                        break;
                    }
                }
            }
            else {
                cardPriceSellerArrayList.add("No Link");
            }
            cardPriceSellerArrayList.add("\n");
        }

        return cardPriceSellerArrayList;
    }

    public void createGraphicsCardCSV() {
        createCSV(getGraphicsCardListings(), "EbayGraphicsCards.csv");
    }
}
