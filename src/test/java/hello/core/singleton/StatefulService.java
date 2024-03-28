package hello.core.singleton;

public class StatefulService {
    // 이름이 stateful service인 서비스를 만들었다.

    public int order(String name, int price){
        return price;
    }

    /*
    private int price; // 상태를 유지하는 필드
    //주문을 해서 값을 여기 저장하고 getPrice을 통해서 꺼내고 싶음

    public void order(String name, int price){
        //주문할 때 가격을 저장해둔다.
        System.out.println("name: "+name+" price: "+price);
        this.price =price; //여기가 문제!
    }

    public int getPrice(){
        return price;
    } */

}
