package leviticus.master.entity.optimizerParamsEntity;

import jakarta.persistence.Entity;
import leviticus.master.entity.AbstractOptimizerParamsEntity;
import leviticus.master.enums.OptimizerType;

import java.sql.Timestamp;

@Entity
public class SGDOptimizerParamsEntity extends AbstractOptimizerParamsEntity {
    private Double learningRate;
    private Double momentum;
    private Double decayRate;
    public Boolean nesterov;

    public SGDOptimizerParamsEntity() {
        super();
    }

    public SGDOptimizerParamsEntity(Long trainId) {
        super(trainId, OptimizerType.SGD);
    }

    public SGDOptimizerParamsEntity(Long trainId, Timestamp lchgTime) {
        super(trainId, OptimizerType.SGD, lchgTime);
    }

    public SGDOptimizerParamsEntity(
            Long trainId,
            Double learningRate,
            Double momentum,
            Double decayRate,
            Boolean nesterov
    ) {
        super(trainId, OptimizerType.SGD);
        this.learningRate = learningRate;
        this.momentum = momentum;
        this.decayRate = decayRate;
        this.nesterov = nesterov;
    }


    public SGDOptimizerParamsEntity(
            Long trainId,
            Timestamp lchgTime,
            Double learningRate,
            Double momentum,
            Double decayRate,
            Boolean nesterov
    ) {
        super(trainId, OptimizerType.SGD, lchgTime);
        this.learningRate = learningRate;
        this.momentum = momentum;
        this.decayRate = decayRate;
        this.nesterov = nesterov;
    }

    public Double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(Double learningRate) {
        this.learningRate = learningRate;
    }

    public Double getMomentum() {
        return momentum;
    }

    public void setMomentum(Double momentum) {
        this.momentum = momentum;
    }

    public Double getDecayRate() {
        return decayRate;
    }

    public void setDecayRate(Double decayRate) {
        this.decayRate = decayRate;
    }

    public Boolean isNesterov()  {
        return  nesterov;
    }

    public void setNesterov(Boolean nesterov) {
        this.nesterov = nesterov;
    }
}
