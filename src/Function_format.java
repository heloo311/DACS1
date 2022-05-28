import java.awt.*;

public class Function_format {
    Nodepad nodepad;
    Font A,B,C;
    String selectedfont;

    public Function_format(Nodepad nodepad) {
        this.nodepad = nodepad;
    }

    public void Wrap() {
        if (nodepad.Wrapon==false) {
            nodepad.Wrapon=true;
            nodepad.t1.setLineWrap(true);
            nodepad.t1.setWrapStyleWord(true);
            nodepad.wrap.setText("Word wrap:On");

        }
        else if(nodepad.Wrapon==true){
            nodepad.Wrapon=false;
            nodepad.t1.setLineWrap(false);
            nodepad.t1.setWrapStyleWord(false);
            nodepad.wrap.setText("Word wrap:Off");
        }
    }
    public void taofont(int fontsize ){
        A=new Font("Arial",Font.PLAIN,fontsize);
        nodepad.t1.setFont(A);
        B=new Font("Comic Sans MS",Font.PLAIN,fontsize);
        nodepad.t1.setFont(B);
        C=new Font("Times New Roman",Font.PLAIN,fontsize);
        nodepad.t1.setFont(C);

    //   datfont(selectedfont);
    }
    public void datfont(String font){
        selectedfont=font;
        switch (selectedfont){
            case "Arial":
                nodepad.t1.setFont(A);
                break;
            case "Comic Sans MS":
                nodepad.t1.setFont(B);
                break;
            case "Times New Roman":
                nodepad.t1.setFont(C);
                break;
        }
    }
}
