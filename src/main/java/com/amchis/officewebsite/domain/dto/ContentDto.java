package com.amchis.officewebsite.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author beyond
 * Create at 2020-04-13 10:10
 */
@Data
@ApiModel
public class ContentDto {

    @ApiModelProperty("id 有值为更新")
    private Integer id;

    @ApiModelProperty("一级页面")
    private String firstPage;

    @ApiModelProperty("二级页面")
    private String secondPage;

    @ApiModelProperty("文本内容")
    private String content;
}