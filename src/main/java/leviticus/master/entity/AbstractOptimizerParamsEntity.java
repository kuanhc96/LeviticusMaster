package leviticus.master.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@MappedSuperclass
public abstract class AbstractOptimizerParamsEntity extends AbstractEntity {

    private Long trainId;

    public AbstractOptimizerParamsEntity() {
        super();
    }

    public AbstractOptimizerParamsEntity(Timestamp lchgTime) {
        super(lchgTime);
    }

    public AbstractOptimizerParamsEntity(Long trainId) {
        super();
        this.trainId = trainId;
    }

    public AbstractOptimizerParamsEntity(Long trainId, Timestamp lchgTime) {
        super(lchgTime);
        this.trainId = trainId;
    }

    public Long getTrainId() {
        return trainId;
    }
}
