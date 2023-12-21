package edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.mapper;

import edu.bbte.idde.bfim2114.hexagonal.adapter.in.web.dto.UserPresentationDTO;
import edu.bbte.idde.bfim2114.hexagonal.adapter.in.web.dto.UserSaveDTO;
import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.jpaentity.UserJpaEntity;
import edu.bbte.idde.bfim2114.hexagonal.application.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User dtoToUser(UserSaveDTO userSaveDTO);

    UserPresentationDTO userToDTo(User user);

    User userJpaEntityToUser(UserJpaEntity entity);

    UserJpaEntity userToUserJpaEntity(User user);
}
