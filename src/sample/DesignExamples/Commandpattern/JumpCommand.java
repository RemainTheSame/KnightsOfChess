package sample.DesignExamples.Commandpattern;

public class JumpCommand implements Command{

    @Override
    public void execute(){
        System.out.println("Jump");
    }

}
