package com.amchis.officewebsite.domain.viewdo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ViewTransferFile {

    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 文件路径
     */
    @ApiModelProperty("文件路径")
    private String fileUrl;
}
