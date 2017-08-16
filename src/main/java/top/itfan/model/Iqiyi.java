package top.itfan.model;


import com.alibaba.fastjson.JSONObject;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import top.itfan.global.Constant;
import top.itfan.global.Constant.IqiyiInfo;
import top.itfan.global.Constant.Node;
import top.itfan.global.Constant.UA;


public class Iqiyi {


    public Video parse(String url) throws Exception {

        String tvId = null, vId = null;

        Document mainDoc = Jsoup.connect(url).userAgent(UA.PAD).get();

        Matcher matcher = Pattern.compile("tvId:(.*?),").matcher(mainDoc.html());
        if (matcher.find()) {
            tvId = matcher.group(1);
        }

        matcher = Pattern.compile("vid:\"(.*?)\"").matcher(mainDoc.html());
        if (matcher.find()) {
            vId = matcher.group(1);
        }
        Date now = new Date();
        String param = String
                .format(IqiyiInfo.ENCRY_PARAM, tvId, vId, tvId + "_21", now.getTime());

        System.out.println(param);
        String vf = getVf(param);

        String api = String.format(IqiyiInfo.APR, param, vf);

        Document resultDoc = Jsoup.connect(api).ignoreContentType(true).get();

        JSONObject json = JSONObject.parseObject(resultDoc.text());

        String playUrl = json.getJSONObject("data").getString("mu");

        Video video = new Video();
        video.setRealUrl(playUrl);
        return video;
    }


    // 调用 Node 计算 vf 的值
    private static String getVf(String param) throws Exception {
        JSONObject requestBody = new JSONObject();
        requestBody.put("type", "iqiyi");
        requestBody.put("param", param);
        return Jsoup.connect(Node.SERVER).requestBody(requestBody.toJSONString()).post().text();
    }
}
