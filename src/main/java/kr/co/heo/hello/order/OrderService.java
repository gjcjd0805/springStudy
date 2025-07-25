package kr.co.heo.hello.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
