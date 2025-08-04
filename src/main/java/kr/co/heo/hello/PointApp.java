package kr.co.heo.hello;

import kr.co.heo.hello.member.Grade;
import kr.co.heo.hello.member.Member;
import kr.co.heo.hello.member.MemberService;
import kr.co.heo.hello.order.Order;
import kr.co.heo.hello.order.OrderService;
import kr.co.heo.hello.point.Point;

public class PointApp {
    
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        Point point = appConfig.point();


        point.get();
        point.use();
        point.gets();



    }
}
