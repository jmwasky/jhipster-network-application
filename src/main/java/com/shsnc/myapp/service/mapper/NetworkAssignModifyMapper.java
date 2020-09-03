package com.shsnc.myapp.service.mapper;


import com.shsnc.myapp.domain.*;
import com.shsnc.myapp.service.dto.NetworkAssignModifyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link NetworkAssignModify} and its DTO {@link NetworkAssignModifyDTO}.
 */
@Mapper(componentModel = "spring", uses = {NetworkLayoutMapper.class})
public interface NetworkAssignModifyMapper extends EntityMapper<NetworkAssignModifyDTO, NetworkAssignModify> {

    @Mapping(source = "networkLayout.id", target = "networkLayoutId")
    NetworkAssignModifyDTO toDto(NetworkAssignModify networkAssignModify);

    @Mapping(source = "networkLayoutId", target = "networkLayout")
    NetworkAssignModify toEntity(NetworkAssignModifyDTO networkAssignModifyDTO);

    default NetworkAssignModify fromId(Long id) {
        if (id == null) {
            return null;
        }
        NetworkAssignModify networkAssignModify = new NetworkAssignModify();
        networkAssignModify.setId(id);
        return networkAssignModify;
    }
}
