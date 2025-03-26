package com.fullstack.discuss_hub.common.util;

import com.fullstack.discuss_hub.common.dto.AuditEntity;
import com.fullstack.discuss_hub.common.dto.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class Pagination {
    public <T extends AuditEntity> PageResponse getPagination(Page<T> entity){
        PageResponse pageResponse = new PageResponse();
        pageResponse.setPageNo(entity.getNumber());
        pageResponse.setPageSize(entity.getSize());
        pageResponse.setTotalElements(entity.getTotalElements());
        pageResponse.setTotalPages(entity.getTotalPages());
        pageResponse.setLast(entity.isLast());
        return pageResponse;
    }
}
