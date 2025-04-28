package com.example.order_online.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Comment {
    @JsonProperty("commentId")
    private Integer commentId;
    @JsonProperty("uId")
    private Integer uId;
    @JsonProperty("uName")
    private String uName;
    @JsonProperty("uAvatar")
    private String uAvatar;
    @JsonProperty("menuId")
    private Integer menuId;
    @JsonProperty("menuName")
    private String menuName;
    @JsonProperty("imagePath")
    private String imagePath;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("commentText")
    private String commentText;
    @JsonProperty("commentTime")
    private String commentTime;
}
