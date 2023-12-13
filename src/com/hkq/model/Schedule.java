package com.hkq.model;

/**
 * @author LP
 */
public class Schedule {
    private String id;
    private String user_id;
    private String create_time;
    private String schedule_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    public Schedule(String id, String user_id, String schedule_date, String create_time) {
        this.id = id;
        this.user_id = user_id;

        this.schedule_date = schedule_date;
        this.create_time = create_time;
    }
}
