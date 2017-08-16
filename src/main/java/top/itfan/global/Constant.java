package top.itfan.global;

/**
 * Created by ralap on 2017/8/15.
 */
public class Constant {

    /**
     * 爱奇艺信息
     */
    public interface IqiyiInfo {

        /**
         * 加密参数
         */
        String ENCRY_PARAM = "/dc/amt/fdeeabb351ccdafaf7842a8e76f8d65b/%s/%s/?qypid=%s&src=03020031010000000000&qdv=1&qdx=n&qdy=x&qds=0&__jsT=sgve&t=%s";

        /**
         * 播放地址
         */
        String APR = "http://cache.m.iqiyi.com%s&vf=%s";
    }

    /**
     * node
     */
    public interface Node {

        /**
         * node服务地址
         */
        String SERVER = "http://localhost:3000/";
    }

    /**
     * user agent
     */
    public interface UA {

        String PHONE = "Mozilla/5.0 (Linux; Android 4.3; Nexus 10 Build/JSS15Q) AppleWebKit/537.36 (KHTML, like Gecko)                  Chrome/48.0.2564.23 Safari/537.36";

        String PC = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";

        String PAD = "Mozilla/5.0 (iPad; CPU OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1";
    }

    /**
     * 乐视信息
     */
    public interface LetvInfo {

        String HOME_PAGE_PC = "http://www.le.com/";
        String HOME_PAGE_PHONE_TV = "http://m.le.com/tv/";
        String HOME_PAGE_PHONE_MOVIE = "http://m.le.com/movie/";
        String HOME_PAGE_PHONE_CARTOON = "http://m.le.com/comic/";
        String HOME_PAGE_PHONE_RECOMMEND = "http://m.le.com/zongyi/";
        String HOME_PAGE_PHONE_TV_HOT = "http://m.le.com/top/tv";
    }

    /**
     * Redis key
     */
    public interface RedisKey {

        String VIDEO_PREFIX_HOME_CAROUSEL_KEY = "HOME_VIDEO_CAROUSEL";
        String VIDEO_PREFIX_HOME_RECOMMEND_KEY = "HOME_VIDEO_RECOMMEND";
        String VIDEO_PREFIX_HOME_TV_KEY = "HOME_VIDEO_TV";
        String VIDEO_PREFIX_HOME_TV_HOT_KEY = "HOME_VIDEO_TV_HOT";
        String VIDEO_PREFIX_HOME_MOVIE_KEY = "HOME_VIDEO_MOVIE";
        String VIDEO_PREFIX_HOME_CARTOON_KEY = "HOME_VIDEO_CARTOON";
        String VIDEO_PREFIx_HOME_LIVE_KEY = "HOME_LIVE";
    }


    /**
     * 视频tag
     */
    public interface VideTag {

        String IQIYI_TAG = "IQIYI";
        String LETV_TAG = "LETV";
    }

    public interface THIS_SERVER_URL{
        String WEB_URL = "https://itfan.top";
    }
    public interface TimeOutInfo{
        int JSOUP = 10*1000;
    }
}
