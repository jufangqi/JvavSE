package net.Crawler;

import java.net.URL;

/**
 * Created by 存 on 2016/6/24.
 */
public class Main implements Runnable {


    public static void main(String[] args){
       // URL url = new URL("http://images.126176.com:8818/allimg/151013/1234293218-0.jpg");
        for (int i = 1; i < 10000; i++) {
            URL url = null;
            try {
                url = new URL("http://images.126176.com:"+i);
                url.getContent();
                System.out.println(i);
            } catch (Exception e) {
                System.out.println("cuowu"+i);
            }
        }


//        //http://15hn.net/zhaifuli/2015/1006/1897.html
//        //http://images.126176.com:8818/allimg/151006/1F5232132-0.jpg
//        HttpURLConnection uc=(HttpURLConnection) url.openConnection();
//        uc.setRequestProperty("referer","http://15hn.net/zhaifuli/2015/1013/1921.html");
//      //  uc.setRequestProperty("cookie", "http://15hn.net/zhaifuli/2015/1013/1921.html");
//          InputStream is= uc.getInputStream();
//        FileOutputStream fos=new FileOutputStream("d://xx.jpg");
//           byte[] bytes=new byte[1024];
//         int length=    is.read(bytes );
//             while(length!=-1){
//                   fos.write(bytes,0,length);
//                 length=is.read(bytes);
//             }
//          fos.flush();
//        fos.close();
//        is.close();


    }

    @Override
    public void run() {

    }
}
