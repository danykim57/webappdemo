package com.example.modernjava;

public class MySubClass extends MyAbstractClass implements MyInterfaceClass{
    public void meh() {
        System.out.println("Meh ");
    }

    public void sayBoy() {
        System.out.println("Edited boi");
    }
    @Override
    public void boom(String someWords) {
        System.out.println("Say Boom." + someWords);
    }

    @Override
    public void wham(int num) {
        for (int i = 0; i < num; i++)
            System.out.println("Wham ");
    }
}
