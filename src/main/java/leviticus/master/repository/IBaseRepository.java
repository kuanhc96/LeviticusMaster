package leviticus.master.repository;

import leviticus.master.entity.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBaseRepository<T extends AbstractEntity, Long> extends CrudRepository<T, Long> {
}
