package kr.co.heo.hello.point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class PointImpl implements Point{

    private final PointUse pointUse;

    private final PointGet pointGet;

    public PointImpl(PointUse pointUse, PointGet pointGet) {
        this.pointUse = pointUse;
        this.pointGet = pointGet;
    }

    @Override
    public void get() {
        pointUse.use();
    }

    @Override
    public void gets() {

    }

    @Override
    public void use() {

    }
}
