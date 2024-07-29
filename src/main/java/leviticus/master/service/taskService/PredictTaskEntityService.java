package leviticus.master.service.taskService;

import leviticus.master.entity.taskEntity.PredictTaskEntity;
import leviticus.master.exception.ResourceNotFoundException;
import leviticus.master.repository.taskRepository.IPredictTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PredictTaskEntityService extends TaskService<PredictTaskEntity> {
    @Autowired
    private IPredictTaskRepository predictTaskRepository;
    public PredictTaskEntity save(PredictTaskEntity trainTask) {
        return predictTaskRepository.save(trainTask);
    }

    public PredictTaskEntity getPredictTaskEntityById(Long id) {

        Optional<PredictTaskEntity> optionalPredictTaskEntity = predictTaskRepository.findById(id);
        return optionalPredictTaskEntity.orElse(null);

    }

    public PredictTaskEntity updateAccuracy(Long id, Double accuracy) {
        Optional<PredictTaskEntity> optionalPredictTaskEntity = predictTaskRepository.findById(id);
        if (optionalPredictTaskEntity.isPresent()) {
            PredictTaskEntity taskEntity = optionalPredictTaskEntity.get();
            taskEntity.setAccuracy(accuracy);
            return predictTaskRepository.save(taskEntity);
        } else {
            throw new ResourceNotFoundException("Predict Task With ID=" + id + " Not Found");
        }
    }

    public PredictTaskEntity updateComplete(Long id, Boolean isComplete) {
        Optional<PredictTaskEntity> optionalPredictTaskEntity = predictTaskRepository.findById(id);
        if (optionalPredictTaskEntity.isPresent()) {
            PredictTaskEntity taskEntity = optionalPredictTaskEntity.get();
            taskEntity.setComplete(isComplete);
            return predictTaskRepository.save(taskEntity);
        } else {
            throw new ResourceNotFoundException("Predict Task With ID=" + id + " Not Found");
        }

    }

    public Boolean isComplete(Long id) {
        Optional<PredictTaskEntity> optionalPredictTaskEntity = predictTaskRepository.findById(id);
        if (optionalPredictTaskEntity.isPresent()) {
            PredictTaskEntity taskEntity = optionalPredictTaskEntity.get();
            return taskEntity.isComplete();
        } else {
            throw new ResourceNotFoundException("Predict Task With ID=" + id + " Not Found");
        }

    }

    public PredictTaskEntity updatePredictTime(Long id, Double elapsedTime) {
        Optional<PredictTaskEntity> optionalPredictTaskEntity = predictTaskRepository.findById(id);
        if (optionalPredictTaskEntity.isPresent()) {
            PredictTaskEntity taskEntity = optionalPredictTaskEntity.get();
            taskEntity.setTimeElapsed(elapsedTime);
            return predictTaskRepository.save(taskEntity);
        } else {
            throw new ResourceNotFoundException("Predict Task With ID=" + id + " Not Found");
        }

    }
}
