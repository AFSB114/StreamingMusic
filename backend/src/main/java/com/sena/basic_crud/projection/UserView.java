package com.sena.basic_crud.projection;

import java.sql.Date;

public interface UserView {
    int getId();
    String getName();
    String getEmail();
    String getCountry();
    String getProfileImage();
    Date getRegistrationDate();
    boolean isActive();
}
