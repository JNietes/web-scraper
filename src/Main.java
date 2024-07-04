import java.util.*;

public class Main {
    public static void main(String[] args) {
        WebPage wp1 = new WebPage("https://jnietes.github.io/mine-sweeper-webpage");
        ArrayList<String> wp1AL = wp1.createHTMLArrayList();
        System.out.println(wp1AL);
    }
}
