package leviticus.master.repository;

import leviticus.master.entity.AbstractModelParamsEntity;
import leviticus.master.entity.AbstractOptimizerParamsEntity;
import org.springframework.data.repository.CrudRepository;

public interface IOptimizerParamsRepository extends IBaseRepository<AbstractOptimizerParamsEntity, Long> {
}
