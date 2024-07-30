package leviticus.master.service;

import leviticus.master.repository.optimizerParamsRepository.IOptimizerParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptimizerParamsEntityService {
    @Autowired
    private IOptimizerParamsRepository optimizerParamsRepository;
}
