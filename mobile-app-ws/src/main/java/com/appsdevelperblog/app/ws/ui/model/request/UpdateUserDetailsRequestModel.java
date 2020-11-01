package com.appsdevelperblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

    @NotNull(message = "First name cannot be null")
    @Size(min = 3, max = 5, message = "firstName must be min 3 and max 5")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 3, max = 5, message = "lastName must be min 3 and max 5")
    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
