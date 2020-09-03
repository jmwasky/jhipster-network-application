package com.shsnc.myapp.service.mapper;


import com.shsnc.myapp.domain.*;
import com.shsnc.myapp.service.dto.NetworkAssignDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link NetworkAssign} and its DTO {@link NetworkAssignDTO}.
 */
@Mapper(componentModel = "spring", uses = {NetworkLayoutMapper.class})
public interface NetworkAssignMapper extends EntityMapper<NetworkAssignDTO, NetworkAssign> {

    @Mapping(source = "networkLayout.id", target = "networkLayoutId")
    NetworkAssignDTO toDto(NetworkAssign networkAssign);

    @Mapping(source = "networkLayoutId", target = "networkLayout")
    NetworkAssign toEntity(NetworkAssignDTO networkAssignDTO);

    default NetworkAssign fromId(Long id) {
        if (id == null) {
            return null;
        }
        NetworkAssign networkAssign = new NetworkAssign();
        networkAssign.setId(id);
        return networkAssign;
    }
}
