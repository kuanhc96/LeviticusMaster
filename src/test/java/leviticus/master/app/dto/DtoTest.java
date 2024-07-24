package leviticus.master.app.dto;

import leviticus.master.dto.trainRequest.TrainRequestDto;
import leviticus.master.dto.trainRequest.TrainLBPRequestDto;
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
        TrainRequestDto trainRequestDto = new TrainRequestDto();
        trainRequestDto.setDataset("fakeDataset");
        trainRequestDto.setTaskId(1L);
        trainRequestDto.setTrainOnly(true);
        assertNotNull(trainRequestDto.toString());
        LOG.info(trainRequestDto.toString());

        TrainLBPRequestDto trainLBPDto = new TrainLBPRequestDto();
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
