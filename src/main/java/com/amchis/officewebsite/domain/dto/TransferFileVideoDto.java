package com.amchis.officewebsite.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author beyond
 * Create at 2020-03-23 10:13
 */

@Data
@ApiModel
public class TransferFileVideoDto {


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

    /**
     * 缩略图url
     */
    @ApiModelProperty("缩略图url")
    private Integer videoCoverId;

    /**
     * 缩略图url
     */
    @ApiModelProperty("关联id")
    private Integer relatedId;


    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer coverId;

    /**
     * 文件路径
     */
    @ApiModelProperty("文件路径")
    private String coverFileUrl;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer coverOrderNum;

    /**
     * type
     */
    @ApiModelProperty("文件类型 1 图片 2 视频")
    private Integer coverType;

    /**
     * link
     */
    @ApiModelProperty("当type为2时 转向链接为空")
    private String coverLink;

    /**
     * 缩略图url
     */
    @ApiModelProperty("缩略图url")
    private Integer coverVideoCoverId;

    /**
     * 缩略图url
     */
    @ApiModelProperty("关联id")
    private Integer coverRelatedId;


    @ApiModelProperty("创建人")
    private String createUsername;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private String createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private String updateTime;
}