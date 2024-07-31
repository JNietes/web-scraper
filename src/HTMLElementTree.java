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
                    String a = stack.pop().getValue(); // </head>
                    String b = "<" + s.substring(2, s.length() - 1); // < + head>
                    while (!a.startsWith(b)) {
                        a = stack.pop().getValue();
                    }
                }
                else if (selfCLosingTag(s)) {
                    if (s.startsWith("<input ")) {
                        if (arrayList.get(arrayList.indexOf(s)+1).equals("</input>")) {
                            arrayList.set((arrayList.indexOf(s)+1), s + "</input>");
                            continue;
                        }
                    }
                    HTMLElement temp = new HTMLElement(s);
                    stack.peek().addChild(temp);
                }
                else if (!s.startsWith("<!") && !s.startsWith("<!--")) {
                    HTMLElement temp = new HTMLElement(s);
                    stack.peek().addChild(temp);
                    stack.push(temp);
                }
            }
        }
    }

    private boolean selfCLosingTag(String s) {
        String[] weirdElements = {"<meta ", "<link ", "<img ", "<input "};
        boolean boo = false;
        for (String weirdElement : weirdElements) {
            if (s.startsWith(weirdElement)) {
                boo = true;
                break;
            }
        }
        return boo;
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(HTMLElement e) { printTree(e, 0); }
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

    public void printTreeFromNodes(String nodeValue) {
        for (HTMLElement e: getElements(nodeValue)) {
            printTree(e);
        }
    }

    public ArrayList<HTMLElement> getElements(String nodeValue) {
        ArrayList<HTMLElement> temp = new ArrayList<>();
        depthFirstSearch(root, nodeValue, temp);
        return temp;
    }

    private void depthFirstSearch(HTMLElement node, String nodeValue, ArrayList<HTMLElement> temp) {
        if (node.getValue().equals(nodeValue)) {
            temp.add(node);
        }
        else {
            for (HTMLElement e: node.getChildren()) {
                if (e.getValue().equals(nodeValue)) {
                    temp.add(e);
                }
                else {
                    depthFirstSearch(e, nodeValue, temp);
                }
            }
        }
    }

    public void printTextLeavesFromNode(String nodeValue) {
        for (HTMLElement e: getElements(nodeValue)) {
            printTextLeavesFromNode(e);
        }
    }

    private void printTextLeavesFromNode(HTMLElement node) {
        for (HTMLElement e: node.getChildren()) {
            if (e.getChildren().isEmpty() && !e.getValue().startsWith("<")) {
                System.out.println(e);
            }
            else {
                printTextLeavesFromNode(e);
            }
        }
    }
}