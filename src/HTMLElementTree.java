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
            } else {
                if (s.startsWith("</")) {
                    String a = stack.pop().getValue();
                    String b = "<" + s.substring(2, s.length() - 1);
                    while (!a.startsWith(b)) {
                        a = stack.pop().getValue();
                    }
                } else if (!s.startsWith("<!") && !s.startsWith("<!--")) {
                    HTMLElement temp = new HTMLElement(s);
                    stack.peek().addChild(temp);
                    stack.push(temp);
                }
            }
        }
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(HTMLElement node, int indent) {
        int numOfIndents = indent;
        for (int i = 0; i < numOfIndents; i++) {
            System.out.print("    ");
        }
        System.out.println(node);
        numOfIndents++;
        for (HTMLElement e : node.getChildren()) {
            printTree(e, numOfIndents);
        }
    }
    public void getLeavesFromNode(String parentNodeValue) {
        getLeavesFromNode(root, parentNodeValue);
    }
    private void getLeavesFromNode(HTMLElement parentNode, String parentNodeValue) {
        for (HTMLElement e: parentNode.getChildren()) {
            if (e.getValue().equals(parentNodeValue)) {
                getLeavesFromNode(e);
            }
            else {
                getLeavesFromNode(e, parentNodeValue);
            }
        }
    }

    private void getLeavesFromNode(HTMLElement node) {
        for (HTMLElement e: node.getChildren()) {
            if (e.getChildren().isEmpty()) {
                System.out.println(e);
            }
            else {
                getLeavesFromNode(e);
            }
        }
    }

    public void getTextLeavesFromNode(String parentNodeValue) {
        getTextLeavesFromNode(root, parentNodeValue);
    }
    private void getTextLeavesFromNode(HTMLElement parentNode, String parentNodeValue) {
        for (HTMLElement e: parentNode.getChildren()) {
            if (e.getValue().equals(parentNodeValue)) {
                getTextLeavesFromNode(e);
            }
            else {
                getTextLeavesFromNode(e, parentNodeValue);
            }
        }
    }

    private void getTextLeavesFromNode(HTMLElement node) {
        for (HTMLElement e: node.getChildren()) {
            if (e.getChildren().isEmpty() && !e.getValue().startsWith("<")) {
                System.out.println(e);
            }
            else {
                getLeavesFromNode(e);
            }
        }
    }
}
