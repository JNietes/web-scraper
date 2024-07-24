
public class Main {
    public static void main(String[] args) {

        System.out.println("https://jnietes.github.io/mine-sweeper-webpage/\n");
        WebPage wp1 = new WebPage("https://jnietes.github.io/mine-sweeper-webpage/");
        HTMLElementTree tree = new HTMLElementTree(wp1.createElementArrayList());
        tree.printTree();

        System.out.println("\n\n\n");

        System.out.println("https://google.com\n");
        WebPage wp2 = new WebPage("https://google.com");
        HTMLElementTree tree1 = new HTMLElementTree(wp2.createElementArrayList());
        tree1.printTree();
    }
}
