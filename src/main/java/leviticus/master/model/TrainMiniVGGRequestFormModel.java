package leviticus.master.model;

import leviticus.master.enums.ClassificationModelType;
import leviticus.master.enums.OptimizerType;

public class TrainMiniVGGRequestFormModel extends TrainRequestFormModel {
    public TrainMiniVGGRequestFormModel() {
        super();
        setModelType(ClassificationModelType.MINIVGG);
    }

    public TrainMiniVGGRequestFormModel(
            OptimizerType optimizerType,
            String dataset,
            Boolean isTrainOnly,
            Boolean isCrossValidated
    ) {
        super(ClassificationModelType.MINIVGG, optimizerType, dataset, isTrainOnly, isCrossValidated);
    }
}
