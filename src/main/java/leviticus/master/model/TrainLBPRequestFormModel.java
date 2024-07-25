package leviticus.master.model;

import leviticus.master.enums.ClassificationModelType;
import leviticus.master.enums.OptimizerType;

public class TrainLBPRequestFormModel extends TrainRequestFormModel{

    private Integer numPoints;

    private Integer radius;

    private Double C;

    public TrainLBPRequestFormModel() {
        super();
        setModelType(ClassificationModelType.LBP);
    }

    public TrainLBPRequestFormModel(
            OptimizerType optimizerType,
            String dataset,
            Boolean isTrainOnly,
            Boolean isCrossValidated
    ) {
        super(ClassificationModelType.LBP, optimizerType, dataset, isTrainOnly, isCrossValidated);
    }

    public TrainLBPRequestFormModel(
            OptimizerType optimizerType,
            String dataset,
            Boolean isTrainOnly,
            Boolean isCrossValidated,
            Integer numPoints,
            Integer radius,
            Double C
    ) {
        super(ClassificationModelType.LBP, optimizerType, dataset, isTrainOnly, isCrossValidated);
        this.numPoints = numPoints;
        this.radius = radius;
        this.C = C;
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

    public Double getC() {
        return C;
    }

    public void setC(Double c) {
        C = c;
    }
}
