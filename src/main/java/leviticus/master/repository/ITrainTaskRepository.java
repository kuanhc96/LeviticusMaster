package leviticus.master.repository;

import leviticus.master.entity.taskEntity.TrainTaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface ITrainTaskRepository extends CrudRepository<TrainTaskEntity, Long> {
}
