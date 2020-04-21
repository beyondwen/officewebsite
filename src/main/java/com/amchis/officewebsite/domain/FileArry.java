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

    @ApiModelProperty("order")
    private Integer order;
}
