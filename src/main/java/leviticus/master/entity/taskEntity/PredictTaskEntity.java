package leviticus.master.entity.taskEntity;

import jakarta.persistence.Entity;
import leviticus.master.entity.AbstractTaskEntity;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class PredictTaskEntity extends AbstractTaskEntity {

    // foreign key
    private Long trainId;

    private String results;

    public PredictTaskEntity() {
        super();
    }

    public PredictTaskEntity(Timestamp lchgTime) {
        super(lchgTime);
    }

    public PredictTaskEntity(
            Long trainId,
            String results,
            Double accuracy,
            String classificationReport,
            Double timeElapsed,
            Boolean isComplete,
            String dataset
    ) {
        super(accuracy, classificationReport, timeElapsed, isComplete, dataset);
        this.trainId = trainId;
        this.results = results;
    }


    public PredictTaskEntity(
            Long trainId,
            Double accuracy,
            String classificationReport,
            String results,
            Boolean isComplete,
            String dataset,
            Double timeElapsed,
            Timestamp lchgTime
    ) {
        super(lchgTime, accuracy, classificationReport, timeElapsed, isComplete, dataset);
        this.trainId = trainId;
        this.results = results;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

}

