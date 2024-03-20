package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //자기 자신을 내부에 private static으로 가짐
    //이렇게 하면 클래스레벨에 올라가서 하나만 가능
    //static이므로 자바가 뜰때 바로 내부적으로 실행해서 객체를 생성해서 참조를 instance에 넣어놓는다.

    public static SingletonService getInstance(){
        return instance;
        //조회 시 사용
    }
    private SingletonService(){
        //못하게 막기
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }



}
