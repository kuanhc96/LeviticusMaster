package leviticus.master.service.modelParamsService;

import leviticus.master.entity.modelParamsEntity.CNNModelParamsEntity;
import leviticus.master.repository.modelParamsRepository.ICNNModelParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
