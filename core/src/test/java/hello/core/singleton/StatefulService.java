package hello.core.singleton;

public class StatefulService {

    private int price; //상태 유지 필드
    public int order(String name, int price) {
        System.out.println("name = " + name + " price= " + price);
//        this.price = price; //문제 발생 -> 클래스의 필드 값을 바꾸지 않으면 문제 터지지 않음
        return price;
    }
    public int getPrice() {
        return price;
    }
}
