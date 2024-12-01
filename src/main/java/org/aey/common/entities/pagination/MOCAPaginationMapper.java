package org.aey.common.entities.pagination;

import jakarta.ws.rs.core.Response;

import java.util.List;

public class MOCAPaginationMapper {

    public static <T> MOCAPagination<T> toEntity(List<T> items, Integer limit, Integer offset) {
        return MOCAPagination.<T>builder()
                .totalItems(items.size())
                .page(MOCAPagination.calcPage(limit, offset))
                .lastPage(MOCAPagination.calcLastPage(limit, items.size()))
                .items(items)
                .build();
    }

    public static <T> Response toResponse(MOCAPagination<T> mocaPagination) {
        return Response.status(Response.Status.OK)
                .entity(mocaPagination)
                .build();
    }
}
