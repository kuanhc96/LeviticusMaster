package leviticus.master.service.modelParamsService;

import leviticus.master.entity.modelParamsEntity.CNNModelParamsEntity;
import leviticus.master.repository.modelParamsRepository.ICNNModelParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CNNModelParamsEntityService {
    @Autowired
    private ICNNModelParamsRepository cnnModelParamsRepository;

    public CNNModelParamsEntity save(CNNModelParamsEntity modelEntity) {
        return cnnModelParamsRepository.save(modelEntity);
    }

    public Iterable<CNNModelParamsEntity> findAll() {
        return cnnModelParamsRepository.findAll();
    }

    public CNNModelParamsEntity findByTrainId(Long trainId) {
        Optional<CNNModelParamsEntity> optionalCNNModel = cnnModelParamsRepository.findByTrainId(trainId);
        return optionalCNNModel.orElse(null);
    }
}
