import java.util.LinkedList;
public class HTMLElement {
    private final LinkedList<HTMLElement> children;
    private final String value;

    private final String HTMLClass;

    public HTMLElement(String value) {
        this.value = value;
        HTMLClass = findHTMLClass();
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

    private String findHTMLClass() {
        StringBuilder temp = new StringBuilder();
        String HTMLClass = "No Class";
        for(int i=0; i<value.length(); i++) {
            temp.append(value.charAt(i));
            if (temp.toString().endsWith("class=")) {
                HTMLClass = value.substring(i+1, value.length()-1);
            }
        }
        return HTMLClass;
    }

    public String getHTMLClass() {
        return HTMLClass;
    }

    public String toString() {
        return value;
    }

}
