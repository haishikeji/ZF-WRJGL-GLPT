package com.px.task.enums;

public enum TaskCalendarType {

    /**
     * 立即
     */
    NOW(1),
    /**
     * 定时
     */
    TIMING(2),
    /**
     * 循环
     */
    CYCLE(3);

    int type;

    TaskCalendarType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
