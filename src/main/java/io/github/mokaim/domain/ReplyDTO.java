package io.github.mokaim.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDTO {

    private String _usr_email;
    private int comments_id;
    private int _post_num;
    private String reply_content;
    private String reply_date;
}
