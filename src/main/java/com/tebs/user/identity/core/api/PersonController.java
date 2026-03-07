package com.tebs.user.identity.core.api;

import com.tebs.user.identity.core.api.dto.input.CreatePersonInput;
import com.tebs.user.identity.core.api.dto.output.PersonOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/person")
@RequiredArgsConstructor
@Slf4j
public class PersonController {
    private final PersonAdapter adapter;

    @PostMapping
    public PersonOutput createPerson(@RequestBody CreatePersonInput input) {
        return adapter.createPerson(input);
    }
    @PutMapping("/{id}")
    public PersonOutput createPerson(@PathVariable("id") UUID personId,
                                     @RequestBody CreatePersonInput input) {
        return adapter.updatePerson(personId,input);
    }
    @DeleteMapping
    public void deletePerson(@PathVariable("id") UUID personId) {
        adapter.deletePerson(personId);
    }

}
