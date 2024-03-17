package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
    //클라이언트는 주문 생성할때 회원아이디 , 상품명, 상품가격을 반환한다 - 의 인터페이스를 만든 것
}
