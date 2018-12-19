package sample;

import javafx.scene.Node;

public class GameObjectView {

    //Visual representation of the GameObject

    private Node view;

    public GameObjectView(Node view){
        this.view = view;
    }

    public void translateView(double tX, double tY){
        view.setTranslateX(tX);
        view.setTranslateY(tY);
    }

    public Node getView() {
        return view;
    }
}
