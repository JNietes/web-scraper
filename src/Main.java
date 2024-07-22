
public class Main {
    public static void main(String[] args) {
        WebPage wp1 = new WebPage("https://jnietes.github.io/mine-sweeper-webpage/");
        System.out.println(wp1.createElementArrayList().size());
        System.out.println(wp1.createElementArrayList());

        HTMLElementTree tree = new HTMLElementTree(wp1.createElementArrayList());
        tree.printTree();

        WebPage wp2 = new WebPage("https://google.com");
        HTMLElementTree tree1 = new HTMLElementTree(wp2.createElementArrayList());
        tree1.printTree();
    }
}
