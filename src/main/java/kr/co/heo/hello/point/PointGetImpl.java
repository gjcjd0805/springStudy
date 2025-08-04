package kr.co.heo.hello.point;

import org.springframework.stereotype.Component;

public class PointGetImpl implements PointGet{

    @Override
    public void get() {
        System.out.println("PointGetImpl get");
    }

    @Override
    public void gets() {
        System.out.println("PointGetImpl gets");
    }
}
