package com.tebs.user.identity.core.api.mapper;

import com.tebs.library.db.mapper.CommonMapstructConfig;
import com.tebs.library.db.mapper.EntityMapper;
import com.tebs.user.identity.core.model.Person;
import com.tebs.user.identity.core.api.dto.input.CreatePersonInput;
import com.tebs.user.identity.core.api.dto.input.UpdatePersonInput;
import com.tebs.user.identity.core.api.dto.output.PersonOutput;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapstructConfig.class)
public interface PersonMapper extends EntityMapper<Person, PersonOutput> {
    Person toEntity(UpdatePersonInput input);

    Person toEntity(CreatePersonInput input);

}
