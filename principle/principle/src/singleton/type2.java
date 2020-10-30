package singleton;

import java.util.SplittableRandom;

public class type2 {
    public static void main(String[] args) {

    }
}

class Singleton2{
    private Singleton2() {
    }
    private static Singleton2 singleTon;


    static {
        singleTon = new Singleton2();
    }

    public static Singleton2 instance(){
        return singleTon;
    }
}
