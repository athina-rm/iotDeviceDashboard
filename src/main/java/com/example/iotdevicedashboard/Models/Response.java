package com.example.iotdevicedashboard.Models;

public class Response {
    private String response;
    private Boolean status;

    public Response(){}

    public  Response(String response,Boolean status){
        this.response= response;
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
