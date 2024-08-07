package leviticus.master.service.taskService;

import jakarta.transaction.Transactional;
import leviticus.master.entity.AbstractTaskEntity;
import leviticus.master.exception.ResourceNotFoundException;
import leviticus.master.repository.taskRepository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public abstract class TaskService<T extends AbstractTaskEntity> {

    @Autowired
    private ITaskRepository<T, Long> baseRepository;

    @Transactional
    public T updateLchgTime(Long id) {
        T entity = baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("With ID=" + id + " Not Found"));
        entity.setLchgTime();
        return baseRepository.save(entity);
    }

    @Transactional
    public T updateLchgTime(Long id, Timestamp lchgTime) {
        T entity = baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("With ID=" + id + " Not Found"));
        entity.setLchgTime(lchgTime);
        return baseRepository.save(entity);
    }
}
