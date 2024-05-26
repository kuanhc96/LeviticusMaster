package leviticus.master.service;

import leviticus.master.entity.taskEntity.TrainTaskEntity;
import leviticus.master.exception.ResourceNotFoundException;
import leviticus.master.repository.ITrainTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainTaskEntityService {
    @Autowired
    private ITrainTaskRepository trainTaskRepository;

    public TrainTaskEntity save(TrainTaskEntity trainTask) {
        return trainTaskRepository.save(trainTask);
    }

    public TrainTaskEntity getTrainTaskEntityById(Long id) {

        Optional<TrainTaskEntity> optionalTrainTaskEntity = trainTaskRepository.findById(id);
        return optionalTrainTaskEntity.orElse(null);

    }

    public TrainTaskEntity updateWeightsFile(Long id, String weightsFile) {
        Optional<TrainTaskEntity> optionalTrainTaskEntity = trainTaskRepository.findById(id);
        if (optionalTrainTaskEntity.isPresent()) {
            TrainTaskEntity taskEntity = optionalTrainTaskEntity.get();
            taskEntity.setWeightsFile(weightsFile);
            return trainTaskRepository.save(taskEntity);
        } else {
            throw new ResourceNotFoundException("Train Task With ID=" + id + " Not Found");
        }
    }

    public TrainTaskEntity updateComplete(Long id, Boolean isComplete) {
        Optional<TrainTaskEntity> optionalTrainTaskEntity = trainTaskRepository.findById(id);
        if (optionalTrainTaskEntity.isPresent()) {
            TrainTaskEntity taskEntity = optionalTrainTaskEntity.get();
            taskEntity.setComplete(isComplete);
            return trainTaskRepository.save(taskEntity);
        } else {
            throw new ResourceNotFoundException("Train Task With ID=" + id + " Not Found");
        }

    }

    public Boolean isComplete(Long id) {
        Optional<TrainTaskEntity> optionalTrainTaskEntity = trainTaskRepository.findById(id);
        if (optionalTrainTaskEntity.isPresent()) {
            TrainTaskEntity taskEntity = optionalTrainTaskEntity.get();
            return taskEntity.isComplete();
        } else {
            throw new ResourceNotFoundException("Train Task With ID=" + id + " Not Found");
        }

    }

}
