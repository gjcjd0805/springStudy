package kr.co.heo.hello;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
       HelloLombok helloLombok = new HelloLombok();
       helloLombok.setName("adasd");
       helloLombok.setAge(20);
       System.out.println("helloLombok = " + helloLombok.getName());
    }
}
