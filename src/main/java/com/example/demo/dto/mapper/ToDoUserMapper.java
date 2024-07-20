package com.example.demo.dto.mapper;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.dto.response.RoleDTORS;
import com.example.demo.dto.response.UserDTORS;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ToDoUserMapper {

    @Mappings({
            @Mapping(source = "roles", target ="roles", qualifiedByName = "roleSetToList")
    })
    UserDTORS UserToUserDTORS(User user);

    @Named("roleSetToList")
    default List<RoleDTORS> roleSetToList(Set<Role> roles) {
        return roles.stream().map(role -> new RoleDTORS(role.getSlug(), role.getName())).collect(Collectors.toList());
    }
}
