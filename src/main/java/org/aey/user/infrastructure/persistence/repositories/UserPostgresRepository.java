package org.aey.user.infrastructure.persistence.repositories;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.aey.user.infrastructure.persistence.jpa.UserJpa;

import java.util.List;

@ApplicationScoped
public class UserPostgresRepository implements PanacheRepositoryBase<UserJpa, Long> {

    public Uni<List<UserJpa>> findAllActiveUsers(Integer limit, Integer offset) {
        int pageSize = (limit != null) ? limit : 10;
        int pageNumber = (offset != null) ? offset / pageSize : 0;
        return find("isActive = true")
                .page(Page.of(pageNumber, pageSize))
                .list();
    }
}
