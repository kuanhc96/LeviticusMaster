package leviticus.master.repository.modelParamsRepository;

import leviticus.master.entity.AbstractModelParamsEntity;
import org.springframework.data.repository.CrudRepository;

/** @noinspection checkstyle:LineLength*/
public interface IModelParamsRepository<T extends AbstractModelParamsEntity, Long> extends CrudRepository<T, Long> {
}
