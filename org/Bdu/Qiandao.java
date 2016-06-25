package org.Bdu;

/**
* Created by 存 on 2016/5/31.
*/
public class Qiandao {

    private String auth = null;
    private String uid = null;
    private String ssid = null;

    public boolean login(String user,String pwd) {
        String html = Http.post("http://wappass.baidu.com/passport/", "login_username="+user+"&login_loginpass="+pwd+"&aaa=%E7%99%BB%E5%BD%95&login=yes&can_input=0&u=http%3A%2F%2Fwapp.baidu.com%2F&login_start_time="+this.baiduTime() / 1000 +"&tpl=tb&tn=bdIndex&pu=&ssid=&from=&bd_page_type=1&uid=wapp_" + this.baiduTime()+"_623&login_username_input=0&type=","UTF-8");
        auth = Http.mid(html, "auth=","&");
        uid = Http.mid(html, "uid=", "&");
        ssid = Http.mid(html, "ssid=", "\"");

        System.out.println("auth="+auth);
        System.out.println("uid="+uid);
        System.out.println("ssid="+ssid);
        System.out.println("@@@@@@@@@@@@@@@@@@2");
        return  auth != null  && uid !=null && ssid !=null;

    }


    public boolean qiandao(String kw) {
        String str  = "http://wapp.baidu.com/f/q-" + ssid + "--" +  uid + "--1-3-0-" +  auth + "-" +uid +"/m?kw=" + kw;
        System.out.println("***********"+str);

        String tbs = Http.get(str, "UTF-8");
        tbs = Http.mid(tbs, "tbs\" value=\"","\"");

        System.out.println("tbs= "+tbs);

        if(tbs == null) {
            return false;
        }

        String html = Http.get("http://wapp.baidu.com/f/q-" + ssid + "--" + uid + "--1-1-0-" +  auth + "-" +  uid + "/sign?tbs=" +  tbs + "&kw=" +  kw, "UTF-8");

        //	System.out.println(html);

        return html.indexOf("签到成功") != -1;

    }

    /**
     * @return 取百度官方时间
     */
    public long baiduTime(){
        return  Long.valueOf(System.currentTimeMillis());
        //return Long.valueOf(Http.mid(Http.get("http://open.baidu.com/special/time/","GBK"), "window.baidu_time(", ")"));
    }


    public static void main(String[] args) {
        Qiandao qd = new Qiandao();
        qd.login("愚人码头523", "dingcun123");
        System.out.println(qd.qiandao("丁存"));
    }
}

