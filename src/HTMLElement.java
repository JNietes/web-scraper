import java.util.LinkedList;
import java.util.List;
public class HTMLElement {
    private LinkedList<HTMLElement> children = new LinkedList<>();
    private String value = "";

    public HTMLElement() {}

    public HTMLElement(String value) {
        this.value = value;
        this.children = new LinkedList<>();
    }

    public void addChild(HTMLElement child) {
        this.children.add(child);
    }

    public String value() {
        return value;
    }

    public List<HTMLElement> getChildren() {
        return children;
    }

}
