
public class Main {
    public static void main(String[] args) {

        //WebPage wp1 = new WebPage("https://jnietes.github.io/mine-sweeper-webpage/\n");
        //System.out.println("\nhttps://jnietes.github.io/mine-sweeper-webpage/");
        //System.out.println("getTextLeavesFromNode(\"<div id=\\\"boardMenu\\\">\");\n");
        //wp1.getElementTree().getTextLeavesFromNode("<div id=\"boardMenu\">");
        //System.out.println("\n");
//
//
        //WebPage wp2 = new WebPage("https://www.scrapethissite.com/pages/simple/");
        //System.out.println("https://www.scrapethissite.com/pages/simple/");
        //System.out.println("getTextLeavesFromNode(\"<h3 class=\\\"country-name\\\">\");\n");
        //System.out.println("Countries:");
        //wp2.getElementTree().getTextLeavesFromNode("<h3 class=\"country-name\">");

        WebPage wp3 = new WebPage("https://www.ebay.com/sch/i.html?_from=R40&_nkw=graphics+card&_sacat=0");
        wp3.getElementTree().printTree();
        wp3.getElementTree().getTextLeavesFromNode("<span role=\"heading\" aria-level=\"3\">");
    }
}
