package dev.olaore.paymentnetworks.data.common;

public class Result<T> {

    Status status;
    String message;
    T data;

    public Result(Status status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> Result loading() {
        return new Result<T>(Status.LOADING, "", null);
    }

    public static <T> Result error(String message) {
        return new Result<T>(Status.ERROR, message, null);
    }

    public static <T> Result success(T data) {
        return new Result<T>(Status.SUCCESS, "", data);
    }


    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}