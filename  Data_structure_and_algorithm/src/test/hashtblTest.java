package test;


public class hashtblTest {
    String s ;
    public static void main(String[] args) {
        Phone iphone = new Phone(new XiaoMi()) {};
        iphone.brand.call();
    }

}
abstract class Phone{
    Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}

interface Brand{
    public void call();
}

 class XiaoMi implements Brand{
    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}
