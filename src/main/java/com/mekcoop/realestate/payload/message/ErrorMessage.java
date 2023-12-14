package com.mekcoop.realestate.payload.message;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ErrorMessage {
    public static final String ALREADY_REGISTER_MESSAGE_SSN = "Error: User with ssn/tax number %s is already registered.";
    public static final String ALREADY_REGISTER_MESSAGE_PHONE_NUMBER = "Error: User with phone number %s is already registered.";
    public static final String ALREADY_REGISTER_MESSAGE_EMAIL = "Error: User with email %s is already registered.";



    public static final String NOT_FOUND_USER_SSN_MESSAGE ="Error: User not found with ssn %s";
    public static final String NOT_FOUND_USER_ID_MESSAGE ="Error: User not found with id %s";
    public static final String NOT_FOUND_USER_USERNAME_MESSAGE ="Error: User not found with username %s";




    public static final String NOT_FOUND_REAL_ESTATE_EMAIL_MESSAGE ="Error: Real estate not found with email %s";
    public static final String NOT_FOUN_REAL_ESTATE ="Error: Real Estate not found with id %s";


    public static final String ROLE_NOT_FOUND="Error: There is no role like that, check the database";
    public static final String ROLE_ALREADY_EXISTS ="Error: Role already exists in DB";


    public static final String NOT_FOUND_ESTATE ="Error: Estate not found with id %s";


}
