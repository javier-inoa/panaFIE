package panafie.fie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter @Setter
public class CreatePasanakuDTO {

    private Long id;

    private String name;

    private String description;

    private Boolean state;

    private Boolean gameStarted;

    private Long userId;

    private Long dateId;

    private Long rulesId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date finishDate;

    private Integer amountOfPeople;

    private Float amount;

    private String duration;

    private String typeOfDraw;
}
