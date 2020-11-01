package com.appsdevelperblog.app.ws.ui.model.response;

import java.util.Date;

public class ErrorMessage {

    private Date date;
    private String description;

    public ErrorMessage(Date date, String errorMessageDescription) {
        this.date = date;
        this.description = errorMessageDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
