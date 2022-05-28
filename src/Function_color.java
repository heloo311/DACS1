import java.awt.*;

public class Function_color {
    Nodepad nodepad;
    public Function_color(Nodepad nodepad){
        this.nodepad=nodepad;
    }
    public void doimau(String color){
        switch (color){
            case "White":
                nodepad.window.getContentPane().setBackground(Color.WHITE);
                nodepad.t1.setBackground(Color.white);
                nodepad.t1.setForeground(Color.black);
                break;
            case "Yellow":
                nodepad.window.getContentPane().setBackground(Color.YELLOW);
                nodepad.t1.setBackground(Color.yellow);
                nodepad.t1.setForeground(Color.black);
                break;
            case "Blue":
                nodepad.window.getContentPane().setBackground(Color.BLUE);
                nodepad.t1.setBackground(Color.blue);
                nodepad.t1.setForeground(Color.black);
                break;
        }
    }
}
