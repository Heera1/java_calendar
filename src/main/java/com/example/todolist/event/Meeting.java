package com.example.todolist.event;

import java.time.ZonedDateTime;
import java.util.Set;

public class Meeting extends AbstractEvent{

    private Set<String> participants;
    private String meetingRoom;
    private String agenda;

    public Meeting(int id, String title,
                   ZonedDateTime startAt, ZonedDateTime endAt,
                   Set<String> participants, String meetingRoom, String agenda){
        super(id, title, startAt, endAt); //위로 전달하는 것

        this.participants = participants;
        this.meetingRoom = meetingRoom;
        this.agenda = agenda;
    }

    @Override
    public void print(){
        System.out.printf("[회의] %s : %s%n", getTitle(), agenda);
    }

    @Override
    public boolean support(EventType type) {
        return type == EventType.MEETING;
    }

    @Override
    public boolean support() {
        return false;
    }
}
