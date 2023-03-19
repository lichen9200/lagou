package com.lagou.domain;

public class ResponseResult {
    private boolean success;
    private Integer state;//int32啥意思

    private String message;

    private Object content;

    public ResponseResult(boolean success, Integer state, String message, Object content) {
        this.success = success;
        this.state = state;
        this.message = message;
        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "success=" + success +
                ", state=" + state +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
