package com.nnww.word;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestWord {


    public static void main(String[] args) throws Exception {
        TestWord testWord = new TestWord();
//        String path = request.getSession().getServletContext().getRealPath("/exceldemo/关于安排2017年市级机关住房解困资金的报告.docx");//获取模板路径
        String path = "C:\\Users\\zhangjinhao\\Desktop\\送达回证.docx";
        FileInputStream is = new FileInputStream(path);//读入流中
        XWPFDocument xdf = new XWPFDocument(is);//新建一个word文档

        //变量
        Map<String, Object> params = new HashMap<>();
        params.put("ssdr", "家具撒据了解撒旦教啊");

        testWord.replaceText(xdf,params);//替换word中的变量。



    }

    /**
     * 替换文档中的参数（word）
     * @param doc
     * @param params
     */
    public  void replaceText(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            replaceInPara(para, params);
        }
    }

    /**
     * 替换段落中的参数（word）
     * @param para
     * @param params
     */
    public void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs;
        Matcher matcher;
        String paragraphText = para.getParagraphText();
        System.out.println(paragraphText);
        if (matcher(paragraphText).find()) {
            runs = para.getRuns();
            for (int i=0; i<runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                matcher = matcher(runText);
                if (matcher.find()) {
                    while ((matcher = matcher(runText)).find()) {
                        runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                    }
                    para.removeRun(i);
                    //重新插入run里内容格式可能与原来模板的格式不一致
                    para.insertNewRun(i).setText(runText);
                }
            }
        }
    }

    private Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{.+?\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }
}
