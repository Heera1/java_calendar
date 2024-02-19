package com.example.todolist.event;

import com.example.todolist.exception.InvalidEventException;

import java.time.Duration;
import java.time.ZonedDateTime;

public abstract class AbstractEvent implements Event {
    //공통으로 사용하는 변수, 메소드들을 정의
    private final int id; //한번 만들어두면 변하지 않기 때문에 final로 둬도 됨
    private String title;

    private ZonedDateTime startAt; //시작시간
    private ZonedDateTime endAt; //끝나는시간
    private Duration duration; //startAt과 endAt 의 차이

    private final ZonedDateTime createdAt; //이벤트가 생성된 날짜
    private ZonedDateTime modifiedAt; //이벤트 수정날짜

    private boolean deletedYn; //이벤트가 삭제되어서 조회가 가능한지, 불가능한지


    //생성자
    protected AbstractEvent(int id, String title,
                            ZonedDateTime startAt, ZonedDateTime endAt){
        //startAt, endAt을 잘못넣는 경우에
        if(startAt.isAfter(endAt)){
            throw new InvalidEventException(
                    String.format("시작일은 종료일보다 이전이어야 합니다. 시작일=%s, 종료일=%s", startAt, endAt)
            );
        }

        this.id = id;
        this.title = title;
        this.startAt = startAt;
        this.endAt = endAt;
        this.duration = Duration.between(startAt, endAt);

        ZonedDateTime now = ZonedDateTime.now();
        this.createdAt = now;
        this.modifiedAt = now;

        this.deletedYn = false;

    }

    public String getTitle(){
        return this.title;
    }

    public abstract boolean support();
}
