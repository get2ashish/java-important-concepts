package ashish.examples.designpatterns;

public class DecoratorDesignPatternExample {

    public static void main(String[] args) {
        Computer gamingDesktop = new GamingDesktop(new BasicComputer());
        gamingDesktop.assemble();

        Computer serverDesktop = new ServerDesktop(new BasicComputer());
        serverDesktop.assemble();
    }

}

interface Computer{
    public void assemble();
}

class BasicComputer implements Computer{

    @Override
    public void assemble() {
        System.out.println("Assembling the computer");
    }
}

class ComputerDecorator implements Computer{

    protected Computer computer;

    public ComputerDecorator(Computer computer){
        this.computer = computer;
    }
    @Override
    public void assemble() {
        this.computer.assemble();
    }
}

class GamingDesktop extends ComputerDecorator{

    public GamingDesktop(Computer computer) {
        super(computer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Gaming Desktop Features(RGB Lights+Extra RAM+RTX 4080 Super)");
    }
}

class ServerDesktop extends ComputerDecorator{

    public ServerDesktop(Computer computer) {
        super(computer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Server Desktop Features(Extra RAM+Storage+Xeon Processor)");
    }
}

