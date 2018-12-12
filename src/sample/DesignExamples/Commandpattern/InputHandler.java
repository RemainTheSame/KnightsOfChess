package sample.DesignExamples.Commandpattern;



public class InputHandler {

    //Implementation for handling of button presses with suitable abstraction and possibility for change

    private Command buttonX = new FireCommand();
    private Command buttonY = new JumpCommand();

    public void handleInput(int i){
        if(i == 0){
            buttonX.execute();
        }
        else{
            buttonY.execute();
        }
    }


}
