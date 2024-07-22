
public class Main {
    public static void main(String[] args) {
        WebPage wp1 = new WebPage("https://jnietes.github.io/mine-sweeper-webpage/");
        System.out.println(wp1.getHTMLAL().size());
        //System.out.println(wp1.getHTMLAL());
        //System.out.println(wp1TAL);
        wp1.createHTMLTree();
        //WebPage wp2 = new WebPage("https://www.google.com/search?q=Entry+Level+Software+jobs&oq=google+job+searcher&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIGCAEQRRhA0gEIOTQxNGowajeoAgiwAgE&sourceid=chrome&ie=UTF-8&ibp=htl;jobs&sa=X&ved=2ahUKEwj-q6emi5CHAxUTF1kFHdU1AOMQutcGKAF6BAgiEAQ&sxsrf=ADLYWIK1FoGnD8mo-9Iu6uJnKiBl7mP1HA:1720188974789#fpstate=tldetail&htivrt=jobs&htidocid=gZFgPi8VsYPHYHN7AAAAAA%3D%3D");
        //System.out.println(wp2.getHTMLAL().size());
        //System.out.println(wp2.findTags());
    }
}
