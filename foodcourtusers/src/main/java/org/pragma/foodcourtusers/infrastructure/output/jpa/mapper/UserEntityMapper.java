package org.pragma.foodcourtusers.infrastructure.output.jpa.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.pragma.foodcourtusers.domain.model.User;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.RoleEntity;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.UserEntity;
import java.util.List;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    UserEntity toEntity(User user);
    @Mapping(target = "name", source = "userEntity.name")
    @Mapping(target = "roleId", source = "userEntity.roleEntity.id")
    User toUser(UserEntity userEntity);
    @Mapping(target = "id", source = "roleId")
    RoleEntity map(Long roleId);
    List<User> toUserList(List<UserEntity> userEntityList);
}
