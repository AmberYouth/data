package singleton;

public class type3 {
    public static void main(String[] args) {

    }
}
class Singleton3{
    private static Singleton3 singleton;
    public static Singleton3 getInstance(){
        if (singleton==null){
            singleton = new Singleton3();
        }
                return singleton;
    }
}
