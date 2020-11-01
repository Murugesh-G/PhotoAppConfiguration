package com.appsdevelperblog.app.ws.userservice;

import com.appsdevelperblog.app.ws.ui.model.reponse.UserRest;
import com.appsdevelperblog.app.ws.ui.model.request.UserDetailsRequestModel;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel updateUserDetailsRequestModel);

}
