package dev.olaore.paymentnetworks.data.common;

public class Response<T> {

    Status status;
    String message;
    T data;

    public Response(Status status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> Response loading() {
        return new Response<T>(Status.LOADING, "", null);
    }

    public static <T> Response error(String message) {
        return new Response<T>(Status.ERROR, message, null);
    }

    public static <T> Response success(T data) {
        return new Response<T>(Status.SUCCESS, "", data);
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

enum Status {
    LOADING, SUCCESS, ERROR
}