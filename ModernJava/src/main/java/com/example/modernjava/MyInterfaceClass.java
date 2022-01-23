package com.example.modernjava;

public interface MyInterfaceClass {
    int thisIsConstant = 1; //상수 변수

    public void wham(int num); // 인스턴스 메소드 (static 키워드가 없다)
    public abstract void boom(String someWords); // 추상 메소드 (Abstract가 없어도 서브클래스에서 구현해주어야한다.)
    static void belongHere() {  //스테틱 메소드 스테틱 메소드는 클래스 메소드라고도 불린다.
        System.out.println("This is belongHere method belong MyInterfaceClass");
    }

    default void yee() { //디폴트 메소드
        System.out.println("Say Yeee");
    }

}
