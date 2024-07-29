package leviticus.master.entity.modelParamsEntity;

import jakarta.persistence.Entity;
import leviticus.master.entity.AbstractModelParamsEntity;

@Entity
public class LBPModelParamsEntity extends AbstractModelParamsEntity {
    private Double cValue;

    private Integer numPoints;

    private Integer radius;

    public LBPModelParamsEntity() {
        super();
    }

    public LBPModelParamsEntity(Long trainId) {
        super(trainId);
    }

    public LBPModelParamsEntity(
            Long trainId,
            Double cValue,
            Integer numPoints,
            Integer radius
    ) {
        super(trainId);
        this.cValue = cValue;
        this.numPoints = numPoints;
        this.radius = radius;
    }

    public Double getcValue() {
        return cValue;
    }

    public void setcValue(Double cValue) {
        this.cValue = cValue;
    }

    public Integer getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(Integer numPoints) {
        this.numPoints = numPoints;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
}
