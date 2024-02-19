package com.example.todolist.event;

public interface Event {
    void print(); //이벤트를 상속받아 구현하는 구현체들은 각각 출력하는 기능들이 필요하기 때문에

    boolean support(EventType type);
}
