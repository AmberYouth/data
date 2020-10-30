package singleton;

public class type5 {
}
class Singleton5{
    private static volatile Singleton5 singleton;
    public static Singleton5 getInstance(){
        if (singleton==null){
            synchronized (Singleton5.class){
                if (singleton==null){
                    singleton = new Singleton5();
                }
            }
        }
        return singleton;
    }
}
