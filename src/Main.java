import java.util.*;

public class Main {
    public static void main(String[] args) {
        WebPage wp1 = new WebPage("https://jnietes.github.io/mine-sweeper-webpage/");
        ArrayList<String> wp1AL = wp1.createHTMLArrayList();
        ArrayList<String> wp1TAL = wp1.findTags(wp1AL);
        System.out.println(wp1AL);
        System.out.println(wp1TAL);
    }
}
