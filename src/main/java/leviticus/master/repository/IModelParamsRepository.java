package leviticus.master.repository;

import leviticus.master.entity.AbstractModelParamsEntity;
import org.springframework.data.repository.CrudRepository;

public interface IModelParamsRepository<T extends AbstractModelParamsEntity> extends CrudRepository<T, Long> {
}
