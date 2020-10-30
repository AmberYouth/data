package singleton;

public class type6 {
    public static void main(String[] args) {
        Singleton6 sin = Singleton6.Singleton6Instance.getInstance();
        System.out.println(sin);
    }
}
class Singleton6{
    public Singleton6() {
    }
    public static class Singleton6Instance{
        private static final Singleton6 INSTANCE = new Singleton6();
        public static Singleton6 getInstance(){
            return INSTANCE;
        }
    }
}
