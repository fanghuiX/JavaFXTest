package sample.GraphViz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class bean {

    public String getGcolor() throws Exception{
        return getvalue("nodecolor");
    }

    public String getGsides() throws Exception {
        return getvalue("nodeshape");
    }

    public String getGstyle() throws Exception {
        return getvalue("nodestyle");
    }

    public String getGlightcolor() throws Exception {
        return getvalue("linecolor");
    }

    public String getGhead() throws Exception {
        return getvalue("linehead");
    }

    public void setGcolor(String gcolor) throws Exception {
        setvalue("nodecolor",gcolor);
    }

    public void setGsides(String gsides) throws Exception {
        setvalue("nodeshape",gsides);
    }

    public void setGstyle(String gstyle) throws Exception {
        setvalue("nodestyle",gstyle);
    }

    public void setGlightcolor(String glightcolor) throws Exception {
        setvalue("linecolor",glightcolor);
    }

    public void setGhead(String ghead) throws Exception {
        setvalue("linehead",ghead);
    }


    /*public static void main(String[] args) throws Exception{
        setvalue("nodecolor","yellow");
        System.out.println(getvalue("nodecolor"));
    }*/

    public static String getvalue(String key) throws Exception {
        Properties props=new Properties();//使用Properties类来加载属性文件
        FileInputStream iFile = new FileInputStream("src/sample/GraphViz/setting.properties");
        props.load(iFile);
        String str=props.getProperty(key);
        iFile.close();
        return str;
    }

    public static void setvalue(String key, String value) throws Exception {
        Properties props=new Properties();//使用Properties类来加载属性文件
        File file = new File("src/sample/GraphViz/setting.properties");
        FileInputStream iFile = new FileInputStream(file.getAbsolutePath().replace('\\','/'));
        //System.out.println(file.getAbsolutePath().replace('\\','/'));
        props.load(iFile);
        props.setProperty(key,value);
        FileOutputStream fos = new FileOutputStream(file.getAbsolutePath().replace('\\','/'));
        // 将Properties集合保存到流中
        props.store(fos, "change  properties");
        fos.close();
        iFile.close();
    }
}
