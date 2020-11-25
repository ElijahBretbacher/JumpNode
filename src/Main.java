import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    ArrayList<JumpNode> nodes=new ArrayList<>();
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane main_root=new GridPane();
        main_root=initGrid(main_root);

        //shows that parents and children are actually correctly set#
        System.out.println("\nNode " + nodes.get(11).getV() + " Parent and Child:");
        try {
            System.out.println(nodes.get(11).getParentN().getV());
        }catch(Exception e){
            System.out.println("Parent = null");
        }
        try {
            System.out.println(nodes.get(11).getChild().getV());
        }catch(Exception e){
            System.out.println("Child = null");
        }

        Scene primScene=new Scene(main_root);
        stage.setScene(primScene);
        stage.setTitle("Jumping Nodes");
        stage.show();
    }

    GridPane initGrid(GridPane pane){
        JumpNode parent=null;
        JumpNode current;

        int circleCount=15;

        Random random=new Random();
        for (int i = 0; i < circleCount; i++) {
            boolean isSet=false;
            while (!isSet) {
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                if (getNodeFromGridPane(pane, x, y) == null) {
                    if (parent!=null && i<circleCount-1) {
                        current=new JumpNode(parent, i);
                        parent.setChild(current);
                        System.out.println("Node " + parent.getV() + " Child ID: " + current.getV());
                        System.out.println("Node " + current.getV() + " Parent ID: " + parent.getV());
                    }else if (parent!=null && i==circleCount-1){
                        current=new JumpNode(parent, i);
                        System.out.println("Node " + current.getV() + " is the last Node with the Parent ID: " + parent.getV());
                    }else{
                        current=new JumpNode(i);
                        System.out.println("Node " + current.getV() + " is the first Node");
                    }
                    nodes.add(current);
                    pane.add(current, x, y);
                    parent=current;
                    isSet = true;
                }
            }
        }
        return pane;
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
