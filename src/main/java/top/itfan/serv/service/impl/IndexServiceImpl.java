package top.itfan.serv.service.impl;

import java.util.List;
import javafx.scene.media.VideoTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.itfan.global.Constant.LetvInfo;
import top.itfan.global.Constant.RedisKey;
import top.itfan.global.Constant.VideTag;
import top.itfan.model.Video;
import top.itfan.redis.RedisManager;
import top.itfan.serv.service.IndexService;
import top.itfan.source.Letv;

/**
 * IndexServiceImpl
 *
 * @Author: ralap
 * @Date: created at 2017/8/16 17:31
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {

    @Autowired
    private RedisManager redisManager;

    @Override
    public List<Video> getCarousel() {
        return redisManager.getViewList(RedisKey.VIDEO_PREFIX_HOME_CAROUSEL_KEY, VideTag.LETV_TAG);
    }

    @Override
    public List<Video> getMovies() {
        return redisManager.getViewList(RedisKey.VIDEO_PREFIX_HOME_MOVIE_KEY, VideTag.LETV_TAG);
    }

    @Override
    public List<Video> getHotTV() {
        return redisManager.getViewList(RedisKey.VIDEO_PREFIX_HOME_TV_HOT_KEY, VideTag.LETV_TAG);
    }

    @Override
    public List<Video> getZY() {
        return redisManager.getViewList(RedisKey.VIDEO_PREFIX_HOME_RECOMMEND_KEY,VideTag.LETV_TAG);
    }


}
