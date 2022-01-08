package com.example.modernjava;

public class RunnableDemo {
    /*모던 자바 예제 1. Functional Interface 예제를 만들어보시오.
    Functional Programming 의의: 주어진 변수값을 그대로 리턴값으로 되돌려주면서
    반복문에서 일어나던 부작용들을 무변성(immutability)로 방지를 해준다.
    멀티 프로세스 환경에서 굉장히 유용하다.
    First Class Object: 다이나믹하게(변화롭게) 생성, 파괴, 함수로 넘겨주기, 리턴값 돌려주기가
    가능한 객체
    */
    public static void main(String[] args) {
        //무명의 이너 클래스를 이용할 경우
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(
                        "inside runnable using an anonymous inner class");
            }
        }).start();


        //람다 함수로 표현할 경우
        //new Thread(() -> System.out.println("inside Thread constructor using lambda")).start();
        //람다 함수를 변수에 저장할 경우
        //Runnable r = () -> System.out.println(
        //    "lambda expression implementing the run method");
        //new Thread(r).start();
    }
}
