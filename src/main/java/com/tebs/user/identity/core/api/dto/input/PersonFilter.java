package com.tebs.user.identity.core.api.dto.input;

import com.tebs.user.identity.core.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PersonFilter {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;


    // filter by any field dynamically
    public Specification<Person> withFilter() {
        return Specification
                .where(hasFirstName(firstName))
                .and(hasLastName(lastName))
                .and(hasEmail(email))
                .and(isActive(active));
    }

    private Specification<Person> hasUserName(String username) {
        return (root, query, cb) -> {
            if (username == null || username.isBlank()) return null; // ignored if null
            return cb.like(cb.lower(root.get("username")), "%" + username.toLowerCase() + "%");
        };
    }

    private Specification<Person> hasEmail(String email) {
        return (root, query, cb) -> {
            if (email == null || email.isBlank()) return null; // ignored if null
            return cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
        };
    }

    private Specification<Person> hasLastName(String lastName) {
        return (root, query, cb) -> {
            if (lastName == null || lastName.isBlank()) return null;
            return cb.equal(root.get("lastName"), lastName);
        };
    }

    private Specification<Person> isActive(Boolean active) {
        return (root, query, cb) -> {
            if (active == null) return null;
            return cb.equal(root.get("active"), active);
        };
    }

    private Specification<Person> hasFirstName(String firstName) {
        return (root, query, cb) -> {
            if (firstName == null) return null;
            return cb.equal(root.get("firstName"), firstName);
        };
    }
}
