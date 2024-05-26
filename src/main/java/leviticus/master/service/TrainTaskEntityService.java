package leviticus.master.service;

import leviticus.master.repository.IPredictTaskRepository;
import leviticus.master.repository.ITrainTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskEntityService {
    @Autowired
    private ITrainTaskRepository trainTaskRepository;

    @Autowired
    private IPredictTaskRepository predictTaskRepository;
}
