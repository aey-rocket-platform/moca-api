package org.aey.common.entities.pagination;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MOCAPagination<T> {
    private Integer totalItems;
    private Integer page;
    private Integer lastPage;
    private List<T> items;

    public static Integer calcLastPage(Integer limit, Integer total) {
        return total % limit == 0 ? total / limit : (total / limit) + 1;
    }

    public static Integer calcPage(Integer limit, Integer offset) {
        return (offset / limit) + 1;
    }
}