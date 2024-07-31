package leviticus.master.repository.modelParamsRepository;

import leviticus.master.entity.modelParamsEntity.CNNModelParamsEntity;

import java.util.Optional;

public interface ICNNModelParamsRepository extends IModelParamsRepository<CNNModelParamsEntity, Long> {
    Optional<CNNModelParamsEntity> findByTrainId(Long trainId);
}
