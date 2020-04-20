package com.amchis.officewebsite.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author beyond
 * Create at 2020-03-23 10:13
 */

@Data
@ApiModel
public class FileDo {

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer orderNum;

    /**
     * type
     */
    @ApiModelProperty("文件类型 1 图片 2 视频")
    private Integer type;

    /**
     * link
     */
    @ApiModelProperty("当type为2时 转向链接为空")
    private String link;

}