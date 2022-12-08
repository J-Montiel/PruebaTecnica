package com.jmontiel.banking.data.response;

import com.jmontiel.banking.data.JsonModel;
import com.jmontiel.banking.data.entities.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserResponse extends User implements JsonModel {

    public UserResponse(User user){
        super(user);
    }


}
