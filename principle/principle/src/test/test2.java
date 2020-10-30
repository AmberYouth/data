package test;

import java.util.HashSet;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        jicheng ji = new jicheng(set);
        Set<String> set2 = ji.getSet();
        set.add("2");
        System.out.println(ji.getSet());
    }
}
