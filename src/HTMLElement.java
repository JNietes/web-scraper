import java.util.LinkedList;
public class HTMLElement {
    private final LinkedList<HTMLElement> children;
    private final String value;

    public HTMLElement(String value) {
        this.value = value;
        this.children = new LinkedList<>();
    }

    public void addChild(HTMLElement child) {
        this.children.add(child);
    }

    public String getValue() {
        return value;
    }

    public LinkedList<HTMLElement> getChildren() {
        return children;
    }

    public String toString() {
        return value;
    }

}
