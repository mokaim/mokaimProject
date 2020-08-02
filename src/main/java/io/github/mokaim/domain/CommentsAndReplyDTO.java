package io.github.mokaim.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsAndReplyDTO {
    private int comments_id;
    private String comments_content;
    private String _usr_email;
    private int _post_num;
    private String reg_date;

    private int _reply_num;
    private String reply_usr_email;
    private int reply_comments_id;
    private int reply_post_num;
    private String reply_content;
    private String reply_date;
}
