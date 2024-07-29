package leviticus.master.entity;

import jakarta.persistence.*;
import leviticus.master.enums.ClassificationModelType;

import java.sql.Timestamp;

@MappedSuperclass
public abstract class AbstractTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp lchgTime;

    private ClassificationModelType modelType;

    private Double timeElapsed;

    private Boolean isComplete;

    // default lchgTime = current time
    // default isComplete = false
    // default timeElapsed = 0.0
    // default model type (DEFAULT is only a placeholder and should be modified later)
    public AbstractTaskEntity() {
        this.modelType = ClassificationModelType.DEFAULT;
        this.lchgTime = new Timestamp(System.currentTimeMillis());
        this.timeElapsed = 0.0;
        this.isComplete = false;
    }

    // default lchgTime = current time
    // default isComplete = false
    // default timeElapsed = 0.0
    // model type filled at instantiation
    public AbstractTaskEntity(
        ClassificationModelType modelType
    ) {
        this.modelType = modelType;
        this.lchgTime = new Timestamp(System.currentTimeMillis());
        this.timeElapsed = 0.0;
        this.isComplete = false;
    }

    // manually fill in all needed parameters at instantiation
    public AbstractTaskEntity(
            ClassificationModelType modelType,
            Timestamp lchgTime,
            Double timeElapsed,
            Boolean isComplete
    ) {
        this.modelType = modelType;
        this.lchgTime = lchgTime;
        this.timeElapsed = timeElapsed;
        this.isComplete = isComplete;
    }

    public Double getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Double timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public Boolean isComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getLchgTime() {
        return lchgTime;
    }

    public void setLchgTime(Timestamp lchgTime) {
        this.lchgTime = lchgTime;
    }

    public void setLchgTime() {
        this.lchgTime = new Timestamp(System.currentTimeMillis());
    }

    public ClassificationModelType getModelType() {
        return modelType;
    }

    public void setModelType(ClassificationModelType modelType) {
        this.modelType = modelType;
    }
}

