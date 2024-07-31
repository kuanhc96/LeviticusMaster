package leviticus.master.service.modelParamsService;

import leviticus.master.entity.modelParamsEntity.LBPModelParamsEntity;
import leviticus.master.repository.modelParamsRepository.ILBPModelParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LBPModelParamsEntityService {
    @Autowired
    private ILBPModelParamsRepository lbpModelParamsRepository;

    public LBPModelParamsEntity save(LBPModelParamsEntity modelEntity) {
        return lbpModelParamsRepository.save(modelEntity);
    }

    public Iterable<LBPModelParamsEntity> findAll() {
        return lbpModelParamsRepository.findAll();
    }

    public LBPModelParamsEntity findByTrainId(Long trainId) {
        return lbpModelParamsRepository.findByTrainId(trainId).orElse(null);
    }

}
