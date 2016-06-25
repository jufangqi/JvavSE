//package org.Bdu;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLConnection;
//import java.nio.charset.Charset;
//
///**
// * Created by 存 on 2016/5/24.
// */
//public class Get {
//
//    public  String sendPost(String url, String param) {
//        PrintWriter out = null;
//        BufferedReader in = null;
//        String result = "";
//        try {
//            URL realUrl = new URL(url);
//            // 打开和URL之间的连接
//            URLConnection conn = realUrl.openConnection();
//            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent",
//                   " Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0) like Gecko");
//                   // "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            HttpURLConnection huc =
//            // 获取URLConnection对象对应的输出流
//            out = new PrintWriter(conn.getOutputStream());
//            // 发送请求参数
//            out.print(param);
//            // flush输出流的缓冲
//            out.flush();
//            // 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream(),Charset.forName("GBK")));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            System.out.println("发送 POST 请求出现异常！"+e);
//            e.printStackTrace();
//        }
//        //使用finally块来关闭输出流、输入流
//        finally{
//            try{
//                if(out!=null){
//                    out.close();
//                }
//                if(in!=null){
//                    in.close();
//                }
//            }
//            catch(IOException ex){
//                ex.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//    public void  test(String temp) throws IOException {
//     //   String temp_in = "https://www.baidu.com/s?wd="+temp+"&rsv_spt=1&rsv_iqid=0xad817f8b00098fa4&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=monline_3_dg&rsv_enter=1&rsv_sug3=2&rsv_sug1=2&rsv_sug7=101&rsv_sug2=0&inputT=1265&rsv_sug4=2238";
//      //  System.out.println(temp_in);
//      //  URL url = new URL(temp_in);
//      //  BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E://Temp/baidu1.html"), Charset.forName("GBK")));
//      //  StringBuffer strr = new StringBuffer();
//       // String str = "";
//       // while ((str=br.readLine())!=null){
//        //    strr.append(str);
//       // }
//        bw.write(temp);
//        bw.flush();
//        bw.close();
//    }
//
//    public static void main(String[] args) throws IOException {
//        Get gg = new Get();
//
//        String paw ="err_no=0&callback=parent.bd__pcbs__m59yzy&codeString=&userName=%E6%84%9A%E4%BA%BA%E7%A0%81%E5%A4%B4523&phoneNumber=&mail=&hao123Param=M0pSV0ZKa1dtTk1lRU4xYUhNNWVINTZjSGMyYTBJd1pXSTVhbmxoWkhaNVJEbFBVSFpvWVZwM1RteG5XRkpZUVZGQlFVRkJKQ1FBQUFBQUFBQUFBQUVBQUFBQVBYWXIwOTdJeThMcnpiYzFNak1BQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBR1gwVEZkbDlFeFhR&u=http://tieba.baidu.com/&tpl=&secstate=&gotourl=&authtoken=&loginproxy=&resetpwd=&vcodetype=&lstr=&ltoken=&bckv=1&bcsync=tPAyUDiDl9mwegkc3mQo1%2FGF7ZuMWdq0DBVePbXv2eWFbxg4qPDBhf8OO27erv6rYZARbpBLCpah7yokXzLxGI4ZjOIkiH%2BTmZ3jvolInRpN%2FYwTPP3X0qx%2F%2BJu8psnHFvNQmzAj9peiUKEbLroDnfBKTQtYSNCuXzU7U0NTGF9PWLt%2Fq10mN8Bnvc3praqJiK0Fr31ko3P54%2By67tINYPEO1RAzOtXO9uC95D0gRwa7%2Fmw0QlYu9qMP%2Flz%2BNgN5lYF%2BOUnXhCrQlxuW5SSEVbafndaFbmEqGZ58yiSYOki0K6%2BSsw4YKznLzRnFN3QuM4PozxvSD64%2FjkjCdTbATA%3D%3D&bcchecksum=1932194795&code=&bdToken=&realnameswitch=0&setpwdswitch=&bctime=1464661094";
//
//       // "username=愚人码头523&passworld=F5omdGRblacTvgjTx/Km4mCNQQHw08tdCb5miDpFO2cZSwSTgqwR1bePrPt0Lw4av4mfkoTO+XPkCLD3ti29oQsBZPOa5S01mtZE7ZwZC/X/N+QIdw5gzJuvRO6fsKAsuuaYzLd6M3dDtc61TIeAGlSJdhaB7pyhQUHCk7DOS9Q=";
//        gg.test(gg.sendPost("http://tieba.baidu.com",paw));
//
////        gg.test("ding");
////        String url = "http://www.baidu.com";
////        String pagr = "1";
////        System.out.println(gg.sendPost(url,pagr));
////        URL url = new URL("http://tieba.baidu.com/i/320657727/forum");
////        URLConnection connection = url.openConnection();
////        connection.setDoOutput(true);
////        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream(),"8859_1");
////        osw.write("aaaaaaaaaaaa");
////        osw.flush();
////        osw.close();
////        InputStream is = connection.getInputStream();
//
//    }
//}
