package leviticus.master.service;

import leviticus.master.entity.AbstractOptimizerParamsEntity;
import leviticus.master.repository.IOptimizerParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptimizerParamsEntityService extends BaseService<AbstractOptimizerParamsEntity> {
    @Autowired
    private IOptimizerParamsRepository optimizerParamsRepository;
}
