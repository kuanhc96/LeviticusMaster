package leviticus.master.repository;

import leviticus.master.entity.AbstractBaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBaseRepository<T extends AbstractBaseEntity, Long> extends CrudRepository<T, Long> {
}
