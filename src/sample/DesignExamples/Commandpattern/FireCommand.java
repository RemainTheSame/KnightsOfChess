package sample.DesignExamples.Commandpattern;

public class FireCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Fire");
    }
}
