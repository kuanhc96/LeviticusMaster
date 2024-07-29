package leviticus.master.model;

import leviticus.master.enums.ClassificationModelType;
import leviticus.master.enums.OptimizerType;

public class TrainMiniVGGRequestFormModel extends TrainRequestFormModel {

    private OptimizerType optimizerType;

    public TrainMiniVGGRequestFormModel() {
        super(ClassificationModelType.MINIVGG);
        optimizerType = OptimizerType.DEFAULT;
    }

    public TrainMiniVGGRequestFormModel(
            OptimizerType optimizerType,
            String dataset,
            Boolean isTrainOnly
    ) {
        super(ClassificationModelType.MINIVGG, dataset, isTrainOnly);
        this.optimizerType = optimizerType;
    }

    public OptimizerType getOptimizerType() {
        return optimizerType;
    }

    public void setOptimizerType(OptimizerType optimizerType) {
        this.optimizerType = optimizerType;
    }
}
