package leviticus.master.service;

import leviticus.master.entity.AbstractModelParamsEntity;
import leviticus.master.repository.IModelParamsRepository;
import leviticus.master.repository.IOptimizerParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelParamsEntityService extends BaseService<AbstractModelParamsEntity> {
    @Autowired
    private IModelParamsRepository modelParamsRepository;

}
