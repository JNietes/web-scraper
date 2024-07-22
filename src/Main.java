
public class Main {
    public static void main(String[] args) {
        WebPage wp1 = new WebPage("https://jnietes.github.io/mine-sweeper-webpage/");
        System.out.println(wp1.getHTMLAL().size());
        wp1.createHTMLTree();
    }
}
