import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Nodepad implements ActionListener {
    Connection connection;
    Statement stm;
    ResultSet rst;



    boolean Wrapon=false;
        JFrame window;
    JTextArea t1;
        JScrollPane s;
        JMenuBar menuBar;
        JMenu file;
        JMenuItem New,open,Save,Saveas,tempsave,reload,deletetemp;

        JMenu edit;
        JMenuItem undo,redo;

        JMenu format;
        JMenuItem wrap;
        JMenu font,fontsize;
        JMenuItem fontA,fontB,fontC,fontsize15,fontsize20,fontsize25,fontsize30;

        JMenu color;
        JMenuItem color1,color2,color3;

        Function_file function__file = new Function_file(this);
        Function_format function_format=new Function_format(this);
        Function_color function_color=new Function_color(this);
        Function_edit function_edit=new Function_edit(this);
        UndoManager undoManager=new UndoManager();
    public void tempsave(){
        try {
            String a =t1.getText();
            String sql="Insert into Nodepad(text)values('" + a + "')";
            stm.execute(sql);

        }
        catch (Exception e){
        e.printStackTrace();
        }



    }
    public void reload(){
        try {
          //  t1.setText(" ");
            ResultSet rst = stm.executeQuery("select text from Nodepad");
                  ResultSetMetaData rstmeta = rst.getMetaData();
            int num_column = rstmeta.getColumnCount();
             StringBuilder c=new StringBuilder();
            String b=null;
                while(rst.next()){
                    for (int i = 1; i <= num_column; i++) {
                        b=rst.getString(i);
                      //  c.append(b);

                        t1.append(b);
                    }



                }
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deletetemp(){
        try {
            stm.executeQuery("DELETE FROM Nodepad");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public Nodepad(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-POGVG9P5:1433;databaseName =LOC", "sa", "123");
            stm = connection.createStatement();
            System.out.println("ghg");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        taokhung();
        taotext();
        taomenu();
        taofilemenu();
        taoedimenu();
        taoformatmenu();
        taomenumau();
        function_format.taofont(15);
        function_format.Wrap();
        function_format.datfont("Arial");
        function_color.doimau("White");
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new Nodepad();
    }
    public void taokhung(){
        window=new JFrame("Nodepad");
        window.setSize(600,500);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public void taotext(){
        t1=new JTextArea();
        t1.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
       s=new JScrollPane(t1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

       // this.add(t1);

        window.add(s);

    }
    public void taomenu(){
        menuBar =new JMenuBar();
        window.setJMenuBar(menuBar);
        file=new JMenu("File");
        menuBar.add(file);
        edit=new JMenu("Edit");
        menuBar.add(edit);
        format=new JMenu("Format");
        menuBar.add(format);
        color=new JMenu("Color");
        menuBar.add(color);
    }
    public void taofilemenu(){

        New =new JMenuItem("New");
        New.addActionListener(this);
        New.setActionCommand("New");
        file.add(New);

        open =new JMenuItem("Open");
        open.addActionListener(this);
        open.setActionCommand("Open");
        file.add(open);

        Save =new JMenuItem("Save");
        Save.addActionListener(this);
        Save.setActionCommand("Save");
        file.add(Save);

        Saveas =new JMenuItem("Save as");
        Saveas.addActionListener(this);
        Saveas.setActionCommand("Save as");
        file.add(Saveas);

        tempsave=new JMenuItem("Temp save");
        tempsave.addActionListener(this);
        tempsave.setActionCommand("Temp save");
        file.add(tempsave);

        reload=new JMenuItem("Reload");
        reload.addActionListener(this);
        reload.setActionCommand("Reload");
        file.add(reload);

        deletetemp=new JMenuItem("Delele temp");
        deletetemp.addActionListener(this);
        deletetemp.setActionCommand("Delele temp");
        file.add(deletetemp);

    }
    public void taoedimenu(){
        undo=new JMenuItem("Undo");
        undo.addActionListener(this);
        undo.setActionCommand("Undo");
        edit.add(undo);

        redo=new JMenuItem("Redo" );
        redo.addActionListener(this);
        redo.setActionCommand("Redo");
        edit.add(redo);


    }

    public void taoformatmenu(){
        wrap=new JMenuItem("Word Wrap:Off");
        wrap.addActionListener(this);
        wrap.setActionCommand("Word Wrap");
        format.add(wrap);

        font=new JMenu("Font");
        format.add(font);
        fontsize=new JMenu("Font Size");
        format.add(fontsize);
        fontA=new JMenuItem("Arial");
        fontA.addActionListener(this);
        fontA.setActionCommand("Arial");
        font.add(fontA);

        fontB=new JMenuItem("Comic Sans MS");
        fontB.addActionListener(this);
        fontB.setActionCommand("Comic Sans MS");
        font.add(fontB);

        fontC=new JMenuItem("Times New Roman");
        fontC.addActionListener(this);
        fontC.setActionCommand("Times New Roman");
        font.add(fontC);

        fontsize15=new JMenuItem(" 15");
        fontsize15.addActionListener(this);
        fontsize15.setActionCommand("15");
        fontsize.add(fontsize15);

        fontsize20=new JMenuItem("20");
        fontsize20.addActionListener(this);
        fontsize20.setActionCommand("20");
        fontsize.add(fontsize20);

        fontsize25=new JMenuItem("25");
        fontsize25.addActionListener(this);
        fontsize25.setActionCommand("25");
        fontsize.add(fontsize25);

        fontsize30=new JMenuItem("30");
        fontsize30.addActionListener(this);
        fontsize30.setActionCommand("30");
        fontsize.add(fontsize30);


    }
        public void taomenumau(){
        color1=new JMenuItem("White");
        color1.addActionListener(this);
        color1.setActionCommand("White");
        color.add(color1);
        color2=new JMenuItem("Yellow");
        color2.addActionListener(this);
        color2.setActionCommand("Yellow");
        color.add(color2);
        color3=new JMenuItem("Blue");
        color3.addActionListener(this);
        color3.setActionCommand("Blue");
        color.add(color3);

        }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        switch (command){
            case "New":function__file.newfile();break;
            case "Temp save":tempsave();break;
            case "Reload":reload();break;
            case "Delele temp":deletetemp();break;
            case "Open":function__file.open();break;
            case"Save as":function__file.saveas();break;
            case"Save":function__file.save();break;
            case"Undo":function_edit.Undo();break;
            case"Redo":function_edit.Redo();break;
            case"Word Wrap":function_format.Wrap();break;
            case"Arial":function_format.datfont(command);break;
            case"Comic Sans MS":function_format.datfont(command);break;
            case"Times New Roman":function_format.datfont(command);break;
            case "15":function_format.taofont(15);break;
            case "20":function_format.taofont(20);break;
            case "25":function_format.taofont(25);break;
            case "30":function_format.taofont(30);break;
            case"White":function_color.doimau(command);break;
            case"Yellow":function_color.doimau(command);break;
            case"Blue":function_color.doimau(command);break;
        }
    }
}
