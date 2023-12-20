package edu.bbte.idde.bfim2114.threelayer.domain.model.mapper;

import edu.bbte.idde.bfim2114.threelayer.domain.model.dto.UserSaveDTO;
import edu.bbte.idde.bfim2114.threelayer.domain.model.dto.UserPresentationDTO;
import edu.bbte.idde.bfim2114.threelayer.domain.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User dtoToUser(UserSaveDTO userSaveDTO);

    UserPresentationDTO userToDTo(User user);
}
