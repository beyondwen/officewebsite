package com.amchis.officewebsite.domain.dto;

import com.amchis.officewebsite.domain.FileArry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class BannerDto {

    @ApiModelProperty("一级页面")
    private String firstPage;

    @ApiModelProperty("banner 文件信息")
    private FileArry[] fileArries;

}
