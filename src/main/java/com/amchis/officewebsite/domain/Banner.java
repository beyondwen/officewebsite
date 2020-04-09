package com.amchis.officewebsite.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author beyond
 * Create at 2020-03-23 10:13
 */
@Entity
@Table(name = "banner")
@Data
@ApiModel
public class Banner {


    /**
     * id
     */
    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 图片id
     */
    @ApiModelProperty("图片id")
    @Column(name = "image_id")
    private Integer imageId;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    @Column(name = "type")
    private Integer type;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 图片链接URL
     */
    @ApiModelProperty("图片链接URL")
    @Column(name = "image_url")
    private String imageUrl;
}