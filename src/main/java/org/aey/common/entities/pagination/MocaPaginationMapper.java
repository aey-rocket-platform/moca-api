package org.aey.common.entities.pagination;

import jakarta.ws.rs.core.Response;

import java.util.List;

public class MocaPaginationMapper {

    public static <T> MocaPagination<T> toEntity(List<T> items, Integer limit, Integer offset) {
        return MocaPagination.<T>builder()
                .totalItems(items.size())
                .page(MocaPagination.calcPage(limit, offset))
                .lastPage(MocaPagination.calcLastPage(limit, items.size()))
                .items(items)
                .build();
    }

    public static <T> Response toResponse(MocaPagination<T> mocaPagination) {
        return Response.status(Response.Status.OK)
                .entity(mocaPagination)
                .build();
    }
}
