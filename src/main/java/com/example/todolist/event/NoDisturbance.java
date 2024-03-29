package com.example.todolist.event;

import java.time.ZonedDateTime;

public class NoDisturbance extends AbstractEvent{
    public NoDisturbance(int id, String title,
                         ZonedDateTime startAt, ZonedDateTime endAt){
        super(id, title, startAt, endAt);
    }

    @Override
    public boolean support() {
        return false;
    }

    @Override
    public void print(){
    }

    @Override
    public boolean support(EventType type){
        return type == EventType.NO_DISTURBANCE;
    }
}
