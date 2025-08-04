package kr.co.heo.hello.point;

import org.springframework.stereotype.Component;

public class PointUseImpl implements PointUse{

    @Override
    public void use() {
        System.out.println("PointUseImpl use");
    }

}
