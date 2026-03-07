package com.tebs.user.identity.core.api.dto.input;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdatePersonInput implements Serializable {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String timezoneIana; // e.g., "Africa/Douala"

}
