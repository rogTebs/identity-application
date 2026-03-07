package com.tebs.user.identity.core.service;

import com.tebs.library.core.exceptions.ApiError;
import com.tebs.library.db.mapper.EntityMapper;
import com.tebs.library.db.repository.BaseRepository;
import com.tebs.library.db.repository.impl.JpaRepositoryAdapter;
import com.tebs.library.db.service.BaseService;
import com.tebs.user.identity.core.model.Person;
import com.tebs.user.identity.core.api.dto.input.PersonFilter;
import com.tebs.user.identity.core.api.dto.output.PersonOutput;
import com.tebs.user.identity.core.api.mapper.PersonMapper;
import com.tebs.user.identity.core.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService extends BaseService<Person, UUID> {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    protected BaseRepository<Person, UUID> repository() {
        return new JpaRepositoryAdapter<>(personRepository);
    }

    @Override
    protected ApiError notFoundError() {
        return null;
    }

    @Override
    protected EntityMapper<Person, PersonOutput> entityMapper() {
        return personMapper;
    }

    public Page<Person> findAllPaged(PersonFilter filter, Pageable pageable) {
        Specification<Person> spec = filter.withFilter();
        return personRepository.findAll(spec, pageable);
    }
}
