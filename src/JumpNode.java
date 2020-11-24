import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class JumpNode extends Circle {
    private JumpNode parent;
    private JumpNode child;
    private int v;

    public JumpNode(){
        super(10, Color.AQUA);
    }
    public JumpNode(int v){
        super(10, Color.AQUA);
        this.v=v;
    }
    public JumpNode(JumpNode parent){
        super(10, Color.AQUA);
        this.parent=parent;
    }
    public JumpNode(JumpNode parent, int v){
        super(10, Color.AQUA);
        this.parent=parent;
        this.v=v;
    }
    public JumpNode(JumpNode parent, JumpNode child, int v){
        super(10, Color.AQUA);
        this.parent=parent;
        this.child=child;
        this.v=v;
    }
    public JumpNode(JumpNode parent, JumpNode child){
        super(10, Color.AQUA);
        this.parent=parent;
        this.child=child;
    }


    public JumpNode getParentN() {
        return parent;
    }

    public void setParentN(JumpNode parent) {
        this.parent = parent;
    }

    public JumpNode getChild() {
        return child;
    }

    public void setChild(JumpNode child) {
        this.child = child;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
