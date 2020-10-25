//package com.test;
//
//import com.chenglong.Application;
//import com.chenglong.mapper.ItemsImgMapper;
//import com.chenglong.mapper.ItemsMapper;
//import com.chenglong.pojo.Items;
//import com.chenglong.pojo.ItemsImg;
//import com.chenglong.service.StuService;
//import com.chenglong.service.TestTransService;
//import com.chenglong.util.DownloadFileFromURLUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.File;
//import java.util.List;
//
///**
// * @Author: 程龙
// * @Date: 2020-10-16 10:04
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class TransTest {
//
////    @Autowired
////    private StuService stuService;
//
//    @Autowired
//    private TestTransService testTransService;
//
//    @Autowired
//    private ItemsMapper itemsMapper;
//
//    @Autowired
//    private ItemsImgMapper itemsImgMapper;
//
////    @Test
////    public void testProgagationTrans(){
////        testTransService.testProgagationTrans();
////    }
//
//    /**
//     * 从数据库中查询blob数据转成url,然后用此url下载图片，并从url地址中获取文件夹名和文件名下载到电脑的指定位置
//     */
//    @Test
//    public void queryItemImg(){
//        List<Items> itemsList =  itemsMapper.selectAll();
////        List<ItemsImg> itemsImgList = itemsImgMapper.selectAll();
////        System.out.println(itemsImgList);
////        System.out.println(itemsList);
//
//        String url1=null;
//        String url2=null;
//        String url3=null;
//        String path1=null;
//        String path2 = null;
//        String path3=null;
//
//        File file1 = null;
//        File file2 = null;
//        File file3 = null;
//        for (Items items:itemsList){
//            System.out.println(items.getContent());
//
//            if (items.getContent().contains("img3.png")){
//                url1 = items.getContent().substring(items.getContent().indexOf("http"),items.getContent().indexOf("img1.png")+8);
//                String url2StrByUrl1 = items.getContent().substring(items.getContent().indexOf(url1),items.getContent().indexOf("img2.png")+8);
//
//
//                url2 = url2StrByUrl1.substring(url2StrByUrl1.lastIndexOf("http"),url2StrByUrl1.indexOf("img2.png")+8);
//                url3 = items.getContent().substring(items.getContent().lastIndexOf("http"),items.getContent().lastIndexOf("img3")+8);
//
//                path1="d:"+url1.substring(url1.indexOf(":88")+3);
//                path2="d:"+url2.substring(url2.indexOf(":88")+3);
//                path3="d:"+url3.substring(url3.indexOf(":88")+3);
//
//
//
////                DownloadFileFromURLUtil.saveUrlAs(url1,path1,"GET");
////                DownloadFileFromURLUtil.saveUrlAs(url2,path2,"GET");
////                DownloadFileFromURLUtil.saveUrlAs(url3,path3,"GET");
//
//
//
//            }else{
//                url1 = items.getContent().substring(items.getContent().indexOf("http"),items.getContent().indexOf("img1.png")+8);
//                url2 = items.getContent().substring(items.getContent().lastIndexOf("http"),items.getContent().lastIndexOf("img2.png")+8);
//
//                path1="d:"+url1.substring(url1.indexOf(":88")+3);
//                path2="d:"+url2.substring(url2.indexOf(":88")+3);
//
////                DownloadFileFromURLUtil.saveUrlAs(url1,path1,"GET");
////                DownloadFileFromURLUtil.saveUrlAs(url2,path2,"GET");
//            }
//
//
//        }
//
////        Items items = itemsMapper.selectByPrimaryKey("bingan-1001");
////        System.out.println("----------------------"+items.getContent());
//    }
//}
