import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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

        Scene primScene=new Scene(main_root);
        stage.setScene(primScene);
        stage.setTitle("Jumping Nodes");
        stage.show();
    }

    GridPane initGrid(GridPane pane){
        JumpNode parent=null;
        JumpNode child=null;
        Random random=new Random();
        for (int i = 0; i < 15; i++) {
            boolean isSet=false;
            while (!isSet) {
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                if (getNodeFromGridPane(pane, x, y) == null) {
                    if (parent!=null) {
                        JumpNode current=new JumpNode(parent, i);
                        pane.add(current, x, y);
                        System.out.println("Node " + current.getV() + " Parent ID: " + parent.getV());
                        parent=current;
                    }else{
                        JumpNode current=new JumpNode(i);
                        pane.add(current, x, y);
                        System.out.println("Node " + current.getV() + " is the first Node");
                        parent=current;
                    }
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
