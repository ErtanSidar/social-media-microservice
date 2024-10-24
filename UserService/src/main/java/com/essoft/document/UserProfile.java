package com.essoft.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data
public class UserProfile {

    String id;
    String authId;
    String username;
    String name;
    String surname;
    String email;
    String phone;
    String avatar;
    String instagram;
    String twitter;
    Boolean isActive;
    Long createAt;

}
