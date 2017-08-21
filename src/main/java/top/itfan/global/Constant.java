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
        String COOKIE = "ark_uuid=d966d5301be94c5bb8fae78b9cd3038e; vjuids=-8a183d9b7.157666171cd.0.43147ea3e2342; OUTFOX_SEARCH_USER_ID_NCOO=410937176.92591244; tj2_lc=c9b56fa67fdcfb1a73c5fa08ac1cb90f; lb_live_c=105; leBlockOrder=8310%2C8526%2C8527%2C8313%2C8314%2C8315%2C8316%2C8317%2C8318%2C8319%2C8320%2C9471%2C8321%2C8322%2C8323%2C8324%2C8325%2C8326%2C8327%2C8328%2C8329%2C8330; _ga=GA1.2.15673798.1487080015; ws_live_c=84; currentLeft_miniPlayer=825; currentTop_miniPlayer=335; his_vid=27931278-27931200-28044388-27853094-27832999-27832992-27832988-27835220-27827468-27678466; m=letv_541bebab7973e32; sso_tk=102XXXY37RkeUCWkYNfggm1qdBtaOGkslkm3McsOlsyhH0Mm1wp8PzW2x3o7NlSxscm1VWgttK1EgwNCBGbb5vN74WkJm21jIVAoc1S52v8qYizuwm3eOGsm4; sso_nickname=1816xxx7640_108; casflag=1; ssouid=67945963; loginname=18164177640; loginnamecookie=18164177640; sso_picture=https%3A%2F%2Fi0.letvimg.com%2Fimg%2F201207%2F30%2Ftx70.png; sso_icon=https%3A%2F%2Fi1.letvimg.com%2Fimg%2F201207%2F30%2Ftx298.png%2Chttps%3A%2F%2Fi0.letvimg.com%2Fimg%2F201207%2F30%2Ftx200.png%2Chttps%3A%2F%2Fi0.letvimg.com%2Fimg%2F201207%2F30%2Ftx70.png%2Chttps%3A%2F%2Fi3.letvimg.com%2Fimg%2F201207%2F30%2Ftx50.png; utype=101; lfrom=www; u=eyJ1aWQiOiI2Nzk0NTk2MyIsIm5pY2tuYW1lIjoiMTgxNnh4eDc2NDBfMTA4IiwiZW1haWwiOiIiLCJuYW1lIjoibGV0dl81NDFiZWJhYjc5NzNlMzIiLCJzc291aWQiOiI2Nzk0NTk2MyJ9; ui=581fizEM5bz6IZHUOuUZzXSd821BxHUKhXBiwCqR98Aji%2BowYKCNmaTcRvcWZ7usBIkzJJMVKrZfYMtHHkcqZZlkbWujmPibe%2BcuMzJWQJ6tGsAN0bp1fcdccUrpybaG6Gl0eUaLEJsAJ6OinRt4wOROZxGTQdqzHvaaSgzkSStxGyyx7TYudOs; IPX_EX_1=1490575896599; ARK_IPX=27.21.127.215X27.21.6.118; IPX_EX_0=1490575896997; vjlast=1474891445.1490575893.11; _search=%E4%B8%89%E7%94%9F%E4%B8%89%E4%B8%96%2C%E6%96%97%E7%A0%B4%E8%8B%8D%E7%A9%B9%2C%E6%96%97%E6%88%98%E8%83%9C%E4%BD%9B%2C%E7%88%B5%E8%BF%B9%2C%E5%85%B0%E9%99%B5%E7%8E%8B%E5%A6%83%2C%E5%98%BF%E5%AD%A9%E5%AD%90; tj_env=1; bd_xid=178D3CF87F892133E76A7BBEB78C903E70564321; csrf=950b2b7fa61d6b3a2c65; sso_curr_country=CN; language=zh-cn; tj_uuid=14906735156053151055; tj_v2c=-28463173_2; logInPlayTime=1; newVideo=%7B%221%22%3A13%2C%222%22%3A95%2C%223%22%3A147%2C%224%22%3A590%2C%225%22%3A25%2C%228%22%3A8%2C%229%22%3A79%2C%2211%22%3A100%2C%2214%22%3A51%2C%2216%22%3A7%2C%2217%22%3A0%2C%2219%22%3A0%2C%2220%22%3A176%2C%2222%22%3A47%2C%2223%22%3A13%2C%2230%22%3A18473%2C%2232%22%3A0%2C%2233%22%3A0%2C%2234%22%3A7%2C%2235%22%3A0%2C%2236%22%3A2%2C%2238%22%3A0%2C%2239%22%3A23%2C%2240%22%3A0%2C%2242%22%3A0%2C%2243%22%3A0%2C%2245%22%3A18%2C%2246%22%3A0%2C%2247%22%3A0%2C%2248%22%3A0%2C%2249%22%3A0%2C%2250%22%3A0%2C%2251%22%3A0%2C%2252%22%3A0%2C%2253%22%3A0%2C%2254%22%3A0%2C%2255%22%3A0%2C%2256%22%3A1%2C%2260%22%3A0%2C%2261%22%3A0%2C%22200%22%3A1%2C%22333%22%3A0%2C%221009%22%3A1522%2C%221021%22%3A129%2C%221029%22%3A53%2C%221035%22%3A0%7D; tj_lc=178D3CF87F892133E76A7BBEB78C903E70564321; lang=zh_cn; geo=CN_17_223_3; fe_uv=1; _starttips1_=1490673526428; autoOpenApp=1";

        String ROUTE = "http://player-pc.le.com/mms/out/video/playJson.json?platid=3&splatid=304&tss=no&id=%s&detect=1&dvtype=1300&accessyx=1&domain=www.le.com&tkey=%s&devid=178D3CF87F892133E76A7BBEB78C903E70564321&source=1001&lang=cn&region=cn&isHttps=0";
        String VIP_LOCATION = "%s%s&token=%s&uid=67945963&format=1&jsonp=vjs_149067353337651&expect=3&p1=0&p2=06&termid=2&ostype=macos&hwtype=un&uuid=1891087902108532_1&vid=%s&";

        String VIDEOS = "http://d.api.m.le.com/apipccard/dynamic?cid=2&vid=%s&platform=pc&isvip=1&type=episode,Cotherlist";

        String VID_REGEX = "([0-9]+)\\.html";

        String[] DIS_LIST = {"1300", "1000", "350"};
    }

    public interface Provider {

        String LETV = "乐视视频";
        String IQIYI = "爱奇艺";
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

    public interface THIS_SERVER_URL {

        String WEB_URL = "https://itfan.top";
    }

    public interface TimeOutInfo {

        int JSOUP = 10 * 1000;
    }
}
