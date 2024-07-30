package leviticus.master.repository.taskRepository;

import leviticus.master.entity.AbstractTaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository<T extends AbstractTaskEntity, Long> extends CrudRepository<T, Long> {
}
