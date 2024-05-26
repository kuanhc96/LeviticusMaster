package leviticus.master.repository;

import leviticus.master.entity.PredictTaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPredictTaskRepository extends CrudRepository<PredictTaskEntity, Long> {
}
