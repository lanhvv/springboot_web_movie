package com.example.demo.dto.mapper;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.dto.response.UserDTORS;
import org.mapstruct.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ToDoUserMapper {

    @Mappings({
            @Mapping(source = "roles", target ="roles", qualifiedByName = "roleSetToMap")
    })
    UserDTORS UserToUserDTORS(User user);

    @Named("roleSetToMap")
    default Map<String, String> roleSetToMap(Set<Role> roles) {
        return roles.stream().collect(Collectors.toMap(Role::getSlug, Role::getName));
    }
}
