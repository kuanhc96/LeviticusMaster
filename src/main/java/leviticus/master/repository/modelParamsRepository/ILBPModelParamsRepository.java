package leviticus.master.repository.modelParamsRepository;

import leviticus.master.entity.modelParamsEntity.LBPModelParamsEntity;

import java.util.Optional;

public interface ILBPModelParamsRepository extends IModelParamsRepository<LBPModelParamsEntity, Long> {
    Optional<LBPModelParamsEntity> findByTrainId(Long trainId);
}
