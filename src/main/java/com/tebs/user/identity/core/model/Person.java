package com.tebs.user.identity.core.model;

import com.tebs.library.db.model.AbstractIdModel;
import com.tebs.user.identity.core.model.enums.PersonStateEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Table(name = "person")
@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE person SET deleted = true, version = version + 1 WHERE id = ? AND version = ?")
@SQLRestriction("deleted is null OR deleted = false")
@RequiredArgsConstructor
public class Person extends AbstractIdModel {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean active;
    @Enumerated(EnumType.STRING)
    private PersonStateEnum state;
    // store timezone as IANA string
    private String timezoneIana; // e.g., "Africa/Douala"


}
