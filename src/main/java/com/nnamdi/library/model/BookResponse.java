package com.nnamdi.library.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BookResponse {
    private boolean success;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object error;

    private Object payload;

    public BookResponse(boolean success, Object error, Object payload) {
        this.success = success;
        this.error = error;
        this.payload = payload;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Object getPayload() {
        return payload;
    }



    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
