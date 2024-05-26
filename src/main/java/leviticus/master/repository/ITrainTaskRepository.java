package leviticus.master.repository;

import leviticus.master.entity.TrainTaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface ITrainTaskRepository extends CrudRepository<TrainTaskEntity, Long> {
}
