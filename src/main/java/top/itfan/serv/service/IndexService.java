package top.itfan.serv.service;

import java.util.List;
import top.itfan.model.Video;

/**
 * IndexService
 *
 * @Author: ralap
 * @Date: created at 2017/8/16 17:29
 */
public interface IndexService {

    /**
     * 获取轮播视频信息
     */
    List<Video> getCarousel();


    List<Video> getMovies();

    List<Video> getHotTV();

    List<Video> getZY();
}
