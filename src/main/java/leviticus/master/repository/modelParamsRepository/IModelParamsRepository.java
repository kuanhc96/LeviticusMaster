package leviticus.master.repository;

import leviticus.master.entity.AbstractModelParamsEntity;
import leviticus.master.entity.AbstractTaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface IModelParamsRepository<T extends AbstractModelParamsEntity, Long> extends CrudRepository<AbstractModelParamsEntity, Long> {
}
