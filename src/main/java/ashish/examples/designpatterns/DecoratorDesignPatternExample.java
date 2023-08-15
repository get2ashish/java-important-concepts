package ashish.examples.designpatterns;


public class DecoratorDesignPatternExample {

    /**
     * A decorator design pattern is used to modify the functionality of an object at runtime without changing it.
     * Other instances of the same class will not be effected by this, so individual objects get the modified behavior
     * Its a structural design pattern
     * It uses composition
     */

    public static void main(String[] args) {
        Desktop gamingDesktop = new GamingDesktop(new BasicDesktop());
        gamingDesktop.assemble();

        Desktop serverDesktop = new ServerDesktop(new BasicDesktop());
        serverDesktop.assemble();
    }

}

interface Desktop {
    public void assemble();
}

class BasicDesktop implements Desktop {

    @Override
    public void assemble() {
        System.out.println("Assembling the computer");
    }
}

class ComputerDecorator implements Desktop {

    protected Desktop computer;

    public ComputerDecorator(Desktop computer){
        this.computer = computer;
    }
    @Override
    public void assemble() {
        this.computer.assemble();
    }
}

class GamingDesktop extends ComputerDecorator{

    public GamingDesktop(Desktop computer) {
        super(computer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Gaming Desktop Features(RGB Lights+Extra RAM+RTX 4080 Super)");
    }
}

class ServerDesktop extends ComputerDecorator{

    public ServerDesktop(Desktop computer) {
        super(computer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Server Desktop Features(Extra RAM+Storage+Xeon Processor)");
    }
}

