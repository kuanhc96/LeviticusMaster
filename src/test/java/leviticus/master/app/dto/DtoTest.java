package leviticus.master.app.dto;

import leviticus.master.dto.TrainDto;
import leviticus.master.dto.TrainLBPDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class DtoTest {

    private static final Logger LOG = LoggerFactory.getLogger(DtoTest.class);

    @Test
    public void testDto() {
        TrainDto trainDto = new TrainDto();
        trainDto.setDataset("fakeDataset");
        trainDto.setTaskId(1L);
        trainDto.setTrainOnly(true);
        assertNotNull(trainDto.toString());
        LOG.info(trainDto.toString());

        TrainLBPDto trainLBPDto = new TrainLBPDto();
        trainLBPDto.setTrainOnly(true);
        trainLBPDto.setTaskId(2L);
        trainLBPDto.setDataset("fakeLBPDataset");
        trainLBPDto.setC(89.0);
        trainLBPDto.setNumPoints(8);
        trainLBPDto.setRadius(24);
        assertNotNull(trainLBPDto.toString());
        LOG.info(trainLBPDto.toString());

    }

}
