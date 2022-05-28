import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_file {
    Nodepad nodepad;
    String fileName;
    String fileAddress;
    public Function_file (Nodepad nodepad){

        this.nodepad=nodepad;
    }

    public void newfile(){
        nodepad.t1.setText("");
        nodepad.window.setTitle("New");
        fileName=null;
        fileAddress=null;

    }
    public void open(){
        FileDialog fd=new FileDialog(nodepad.window,"Open",FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress=fd.getDirectory();
            nodepad.window.setTitle(fileName);
        }
        try{
            BufferedReader br=new BufferedReader(new FileReader(fileAddress+fileName));
            nodepad.t1.setText("");
            String  line=null;
            while ((line=br.readLine())!=null){
                nodepad.t1.append(line+"\n");
            }
            br.close();
    }
        catch (Exception e){
            System.out.println("gggggg");
        }
}
        public void saveas(){
        FileDialog fd1=new FileDialog(nodepad.window,"Save",FileDialog.SAVE);
        fd1.setVisible(true);
        if(fd1.getFile()!=null){
            fileName=fd1.getFile();
            fileAddress=fd1.getDirectory();
            nodepad.window.setTitle(fileName);
        }
        try{
            FileWriter fw=new FileWriter(fileAddress+fileName);
            fw.write(nodepad.t1.getText());
            fw.close();
        }
        catch (Exception e){
            System.out.println("ffffffffffff");
        }

}
        public void save(){
        if(fileName==null){
            saveas();
        }
        try {
            FileWriter fw1=new FileWriter(fileAddress+fileName);
            fw1.write(nodepad.t1.getText());
            nodepad.window.setTitle(fileName);
            fw1.close();
        }
        catch (Exception e){

        }
        }
}
