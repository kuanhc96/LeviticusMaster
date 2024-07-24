package leviticus.master.dto.trainRequest;

public class TrainMiniVGGRequestDto extends TrainRequestDto {
    private Long taskId;
    private Boolean trainOnly;
    private String dataset;

    public TrainMiniVGGRequestDto() {}

    public TrainMiniVGGRequestDto(Long taskId, Boolean trainOnly, String dataset) {
        super(taskId, trainOnly, dataset);
    }
}
