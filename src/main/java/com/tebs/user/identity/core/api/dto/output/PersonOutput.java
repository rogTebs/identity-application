package com.tebs.user.identity.core.api.dto.output;

import com.tebs.library.db.mapper.dto.output.AbstractIdModelOutput;
import lombok.Data;

@Data
public class PersonOutput extends AbstractIdModelOutput {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    // store timezone as IANA string
    private String timezoneIana; // e.g., "Africa/Douala"

}
