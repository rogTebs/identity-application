package com.tebs.user.identity.core.api;

import com.tebs.library.db.mapper.dto.input.PageInput;
import com.tebs.user.identity.core.model.Person;
import com.tebs.user.identity.core.api.dto.input.CreatePersonInput;
import com.tebs.user.identity.core.api.dto.input.PersonFilter;
import com.tebs.user.identity.core.api.dto.input.UpdatePersonInput;
import com.tebs.user.identity.core.api.dto.output.PersonOutput;
import com.tebs.user.identity.core.api.mapper.PersonMapper;
import com.tebs.user.identity.core.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PersonAdapter {
    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonOutput createPerson(CreatePersonInput input) {
        Person person = personMapper.toEntity(input);
        return personMapper.toDto(personService.create(person));
    }

    public PersonOutput updatePerson(UUID id, UpdatePersonInput input) {
        Person person = personMapper.toEntity(input);
        return personMapper.toDto(personService.update(id, person));
    }
    public void deletePerson(UUID id) {
        personService.delete(id);
    }
    public PersonOutput getPerson(UUID id) {
        return personMapper.toDto(personService.findById(id));
    }
    public Page<PersonOutput> getFilterPersons(PersonFilter personFilter, PageInput pageable) {
        return personMapper.toDto(personService.findAllPaged(personFilter,pageable.toPageable()));
    }
}
