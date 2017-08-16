package top.itfan.redis;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import top.itfan.model.Video;

/**
 * RedisVideoInfo
 * 视频信息缓存
 *
 * @Author: ralap
 * @Date: created at 2017/8/15 21:46
 */
@Component
@AllArgsConstructor
public class RedisManager {

    private final StringRedisTemplate stringRedisTemplate;

    public void cacheVideos(String key, List<Video> videoList) {
        String jsonStr = JSONObject.toJSONString(videoList);
        stringRedisTemplate.opsForValue().set(key, jsonStr);
    }

    public List<Video> getViewList(String key, String tag) {
        key = key + "_" + tag;
        String jsonStr = stringRedisTemplate.opsForValue().get(key);
        return JSONObject.parseArray(jsonStr, Video.class);
    }

}
