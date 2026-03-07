package com.tebs.user.identity.core.api;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.tebs.library.db.mapper.dto.input.PageInput;
import com.tebs.user.identity.core.api.dto.input.PersonFilter;
import com.tebs.user.identity.core.api.dto.output.PersonOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@DgsComponent
public class PersonGraphql {
    private final PersonAdapter adapter;

    @DgsQuery
    public PersonOutput getPerson(@InputArgument UUID personId) {
        return adapter.getPerson(personId);
    }
    @DgsQuery
    public Page<PersonOutput> getFilterPersons(@InputArgument PersonFilter filter,
                                               @InputArgument PageInput pageable) {
        return adapter.getFilterPersons(filter,pageable);
    }

}
