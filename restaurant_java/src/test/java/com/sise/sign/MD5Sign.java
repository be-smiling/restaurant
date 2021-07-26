package com.sise.sign;
import org.springframework.util.DigestUtils;
import java.util.Map;
import java.util.TreeMap;

public class MD5Sign {
    //签名算法
    static class sign{
        String sign(Map<String, String> map, String key){
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<String,String> entry : map.entrySet()){
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            sb.append("key=").append(key);
            return DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();
        }
    }

    public static void main(String[] args) {
        // 用法示例
        Map<String, String> order = new TreeMap<String,String>();
        order.put("mchid", "1606950891");
        order.put("total_fee", "1");
        order.put("out_trade_no", "123123123123");
        order.put("callback_url", "http://1820cf1c.nat1.nsloop.com");
        order.put("notify_url", "http://79f12864.nat1.nsloop.com/weChat/notify");
        // PAYJS通信密钥
        String key = "mUWnPAdBKo3NMFOg";
        sign s = new sign();
        String sign = s.sign(order,key);
        System.out.println(sign);
    }
}
