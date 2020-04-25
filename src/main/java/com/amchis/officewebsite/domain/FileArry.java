package com.amchis.officewebsite.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class FileArry {

    @ApiModelProperty("文件id")
    private Integer fileId;

    @ApiModelProperty("链接")
    private String link;

    @ApiModelProperty("type  1 图片  2 视频")
    private Integer type;

    @ApiModelProperty("order")
    private Integer order;
}
