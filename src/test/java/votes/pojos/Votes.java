package votes.pojos;

import lombok.*;

@Data
@Builder
public class Votes {
    private Object image_id;
    private Object sub_id;
    private String value;
}
