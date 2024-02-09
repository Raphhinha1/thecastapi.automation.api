package votes.pojos;

import lombok.*;

@Data
@Builder
public class Votes {
    private String image_id;
    private String sub_id;
    private String value;
}
