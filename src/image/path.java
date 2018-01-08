package image;

public class path {
    public static void main(String[] args) {
        path t = new path();
        System.out.println(t.getClass().getClassLoader().getResource(""));
        
        System.out.println(t.getClass().getClassLoader().getResource("1.properties"));
        System.out.println(t.getClass().getClassLoader().getResource("testpackage/2.properties"));
        System.out.println(t.getClass().getClassLoader().getResource("testpackage/subpackage/3.properties"));
    }
}