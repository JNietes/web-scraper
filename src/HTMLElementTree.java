import java.util.ArrayList;
import java.util.Stack;

public class HTMLElementTree {
    private HTMLElement root = null;
    public HTMLElementTree(ArrayList<String> arrayList) {
        addElements(arrayList);
    }
    private void addElements(ArrayList<String> arrayList) {
        Stack<HTMLElement> stack = new Stack<>();
        for (String s : arrayList) {
            if (s.startsWith("<html")) {
                root = new HTMLElement(s);
                stack.push(root);
            }
            else {
                if (s.startsWith("</")) {
                    String a = stack.pop().getValue();
                    String b = "<" + s.substring(2, s.length()-1);
                    while (!a.startsWith(b)) {
                        a = stack.pop().getValue();
                    }
                }
                else if (!s.startsWith("<!")) {
                    HTMLElement temp = new HTMLElement(s);
                    stack.peek().addChild(temp);
                    stack.push(temp);
                }
            }
        }
    }

    public void printTree() {
        System.out.println(root.getChildren());
    }
}
    /*
    HTMLElement currentNode = new HTMLElement();
        for (int i=0; i<nodes.size(); i++) {
        if (nodes.get(i).startsWith("<html")) {
            HTMLHead = new HTMLElement(nodes.get(i));
            currentNode = HTMLHead;
        }
        while (currentNode.getChildren().isEmpty() && i < nodes.size()-1) {
            HTMLElement tempNode = new HTMLElement(nodes.get(++i));
            currentNode.addChild(tempNode);
            currentNode = tempNode;
        }
    }


     */
