
public class Main {
    public static void main(String[] args) {

        System.out.println("\nhttps://jnietes.github.io/mine-sweeper-webpage/");
        WebPage wp1 = new WebPage("https://jnietes.github.io/mine-sweeper-webpage/\n");
        HTMLElementTree tree0 = new HTMLElementTree(wp1.createElementArrayList());
        System.out.println("getTextLeavesFromNode(\"<div id=\\\"boardMenu\\\">\");");
        tree0.getTextLeavesFromNode("<div id=\"boardMenu\">");
        System.out.println("\n");


        WebPage wp2 = new WebPage("https://www.scrapethissite.com/pages/simple/");
        HTMLElementTree tree1 = new HTMLElementTree(wp2.createElementArrayList());

        System.out.println("https://www.scrapethissite.com/pages/simple/");
        System.out.println("getTextLeavesFromNode(\"<h3 class=\\\"country-name\\\">\");\n");
        System.out.println("Countries:");
        tree1.getTextLeavesFromNode("<h3 class=\"country-name\">");
    }
}
