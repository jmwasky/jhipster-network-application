package com.shsnc.myapp.service.mapper;


import com.shsnc.myapp.domain.*;
import com.shsnc.myapp.service.dto.NetworkLayoutDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link NetworkLayout} and its DTO {@link NetworkLayoutDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface NetworkLayoutMapper extends EntityMapper<NetworkLayoutDTO, NetworkLayout> {


    @Mapping(target = "networkAssigns", ignore = true)
    @Mapping(target = "removeNetworkAssign", ignore = true)
    @Mapping(target = "networkAssignModifies", ignore = true)
    @Mapping(target = "removeNetworkAssignModify", ignore = true)
    NetworkLayout toEntity(NetworkLayoutDTO networkLayoutDTO);

    default NetworkLayout fromId(Long id) {
        if (id == null) {
            return null;
        }
        NetworkLayout networkLayout = new NetworkLayout();
        networkLayout.setId(id);
        return networkLayout;
    }
}
