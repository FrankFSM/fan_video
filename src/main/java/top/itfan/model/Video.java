package top.itfan.model;

import lombok.Data;

/**
 * Created by ralap on 2017/8/14.
 */
@Data
public class Video {

    /**
     * 标题
     */
    private String title;
    /**
     * 原生视频地址
     */
    private String rawUrl;
    /**
     * 视频封面
     */
    private String imageUrl;

    /**
     * 视屏真实地址
     */
    private String realUrl;

    /**
     * 视频类型
     */
    private String type;

}
