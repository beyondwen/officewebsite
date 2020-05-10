package com.amchis.officewebsite.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author beyond
 * Create at 2020-03-23 10:13
 */
@Data
@ApiModel(value = "文章状态更新")
public class ArticleUpdate {



    @ApiModelProperty("id")
    private Integer id;



    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer bodyStatus;


}