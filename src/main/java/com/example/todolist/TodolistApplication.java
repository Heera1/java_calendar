package com.example.todolist;

import com.example.todolist.event.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class TodolistApplication {

    public static void main(String[] args) {
        List<AbstractEvent> list = new ArrayList<>();
        HashSet<String> participants = new HashSet<>();
        participants.add("danny.kim");

        Meeting meeting1 = new Meeting(1, "meeting1", ZonedDateTime.now(), ZonedDateTime.now().plusHours(1),
                participants, "meetingRoomA", "스터디"
        );

        list.add(meeting1);

        Todo todo1 = new Todo(
                2, "todo1", ZonedDateTime.now(), ZonedDateTime.now().plusHours(2),
                "할 일 적기"
        );
        list.add(todo1);

        list.forEach(Event::print);

        list.stream()
                .filter(each -> each.support(EventType.MEETING))
                .forEach(Event::print);
    }
}
