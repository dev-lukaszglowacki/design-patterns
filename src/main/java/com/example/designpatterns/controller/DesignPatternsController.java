package com.example.designpatterns.controller;

import com.example.designpatterns.abstractfactory.Application;
import com.example.designpatterns.abstractfactory.GUIFactory;
import com.example.designpatterns.abstractfactory.MacOSFactory;
import com.example.designpatterns.abstractfactory.WindowsFactory;
import com.example.designpatterns.adapter.LegacyPrinter;
import com.example.designpatterns.adapter.ModernPrinter;
import com.example.designpatterns.adapter.PrinterAdapter;
import com.example.designpatterns.builder.Computer;
import com.example.designpatterns.decorator.Coffee;
import com.example.designpatterns.decorator.MilkDecorator;
import com.example.designpatterns.decorator.SimpleCoffee;
import com.example.designpatterns.decorator.SugarDecorator;
import com.example.designpatterns.factory.ShapeFactory;
import com.example.designpatterns.observer.BinaryObserver;
import com.example.designpatterns.observer.HexaObserver;
import com.example.designpatterns.observer.OctalObserver;
import com.example.designpatterns.observer.Subject;
import com.example.designpatterns.prototype.ShapeCache;
import com.example.designpatterns.singleton.SingletonService;
import com.example.designpatterns.strategy.CreditCardPayment;
import com.example.designpatterns.strategy.PaypalPayment;
import com.example.designpatterns.strategy.ShoppingCart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DesignPatternsController {

    private final SingletonService singletonService1;
    private final SingletonService singletonService2;
    private final ShapeFactory shapeFactory;

    public DesignPatternsController(SingletonService singletonService1,
        SingletonService singletonService2,
        ShapeFactory shapeFactory) {
        this.singletonService1 = singletonService1;
        this.singletonService2 = singletonService2;
        this.shapeFactory = shapeFactory;
    }

    @GetMapping("/singleton")
    public String singleton() {
        String message1 = singletonService1.getMessage();
        String message2 = singletonService2.getMessage();
        boolean areSame = singletonService1 == singletonService2;
        return message1 + " | " + message2 + " | Are same instance? " + areSame;
    }

    @GetMapping("/factory")
    public String factory() {
        com.example.designpatterns.factory.Shape circle = shapeFactory.getShape("CIRCLE");
        com.example.designpatterns.factory.Shape rectangle = shapeFactory.getShape("RECTANGLE");
        return circle.draw() + " | " + rectangle.draw();
    }

    @GetMapping("/abstract-factory")
    public String abstractFactory() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app.paint();
    }

    @GetMapping("/prototype")
    public String prototype() {
        ShapeCache.loadCache();
        com.example.designpatterns.prototype.Shape clonedShape = ShapeCache.getShape("1");
        com.example.designpatterns.prototype.Shape clonedShape2 = ShapeCache.getShape("2");
        return "Cloned Shape 1: " + clonedShape.getType() + " | Cloned Shape 2: " + clonedShape2.getType();
    }

    @GetMapping("/builder")
    public String builder() {
        Computer comp = new Computer.ComputerBuilder("500GB", "8GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();
        return comp.toString();
    }

    @GetMapping("/adapter")
    public String adapter() {
        ModernPrinter printer = new PrinterAdapter(new LegacyPrinter());
        return printer.print("Hello, Adapter Pattern!");
    }

    @GetMapping("/decorator")
    public String decorator() {
        Coffee coffee = new SimpleCoffee();
        String simpleCoffee = "Cost: " + coffee.getCost() + ", Description: " + coffee.getDescription();

        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        String milkCoffeeStr = "Cost: " + milkCoffee.getCost() + ", Description: " + milkCoffee.getDescription();

        Coffee milkSugarCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        String milkSugarCoffeeStr = "Cost: " + milkSugarCoffee.getCost() + ", Description: " + milkSugarCoffee.getDescription();

        return simpleCoffee + " | " + milkCoffeeStr + " | " + milkSugarCoffeeStr;
    }

    @GetMapping("/observer")
    public List<String> observer() {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        subject.setState(15);
        return subject.notifyAllObservers();
    }

    @GetMapping("/bridge")
    public String bridge() {
        com.example.designpatterns.bridge.Shape redCircle = new com.example.designpatterns.bridge.Circle(100,100, 10, new com.example.designpatterns.bridge.RedCircle());
        com.example.designpatterns.bridge.Shape greenCircle = new com.example.designpatterns.bridge.Circle(100,100, 10, new com.example.designpatterns.bridge.GreenCircle());
        return redCircle.draw() + " | " + greenCircle.draw();
    }

    @GetMapping("/composite")
    public String composite() {
        com.example.designpatterns.composite.Employee CEO = new com.example.designpatterns.composite.Employee("John","CEO", 30000);
        com.example.designpatterns.composite.Employee headSales = new com.example.designpatterns.composite.Employee("Robert","Head Sales", 20000);
        com.example.designpatterns.composite.Employee salesExecutive1 = new com.example.designpatterns.composite.Employee("Richard","Sales", 10000);
        com.example.designpatterns.composite.Employee salesExecutive2 = new com.example.designpatterns.composite.Employee("Rob","Sales", 10000);
        CEO.add(headSales);
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);
        return CEO.toString() + " | " + CEO.getSubordinates().toString();
    }

    @GetMapping("/facade")
    public String facade() {
        com.example.designpatterns.facade.ShapeMaker shapeMaker = new com.example.designpatterns.facade.ShapeMaker();
        return shapeMaker.drawCircle() + " | " + shapeMaker.drawRectangle();
    }

    @GetMapping("/flyweight")
    public String flyweight() {
        String[] colors = {"Red", "Green", "Blue", "White", "Black"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 20; ++i) {
            com.example.designpatterns.flyweight.Circle circle = (com.example.designpatterns.flyweight.Circle) com.example.designpatterns.flyweight.ShapeFactory.getCircle(colors[(int)(Math.random()*colors.length)]);
            circle.setX((int)(Math.random()*100));
            circle.setY((int)(Math.random()*100));
            circle.setRadius(100);
            result.append(circle.draw()).append(" | ");
        }
        return result.toString();
    }

    @GetMapping("/proxy")
    public String proxy() {
        com.example.designpatterns.proxy.Image image = new com.example.designpatterns.proxy.ProxyImage("test.jpg");
        return image.display() + " | " + image.display();
    }

    @GetMapping("/iterator")
    public String iterator() {
        com.example.designpatterns.iterator.NameRepository namesRepository = new com.example.designpatterns.iterator.NameRepository();
        StringBuilder result = new StringBuilder();
        for(com.example.designpatterns.iterator.Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            result.append("Name : " + name + " | ");
        }
        return result.toString();
    }

    @GetMapping("/mediator")
    public String mediator() {
        com.example.designpatterns.mediator.User robert = new com.example.designpatterns.mediator.User("Robert");
        com.example.designpatterns.mediator.User john = new com.example.designpatterns.mediator.User("John");
        return robert.sendMessage("Hi! John!") + " | " + john.sendMessage("Hello! Robert!");
    }

    @GetMapping("/memento")
    public String memento() {
        com.example.designpatterns.memento.Originator originator = new com.example.designpatterns.memento.Originator();
        com.example.designpatterns.memento.CareTaker careTaker = new com.example.designpatterns.memento.CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");
        String result = "Current State: " + originator.getState();
        result += " | First saved State: " + originator.getStateFromMemento(careTaker.get(0));
        result += " | Second saved State: " + originator.getStateFromMemento(careTaker.get(1));
        return result;
    }

    @GetMapping("/state")
    public String state() {
        com.example.designpatterns.state.Context context = new com.example.designpatterns.state.Context();
        com.example.designpatterns.state.StartState startState = new com.example.designpatterns.state.StartState();
        String startStateResult = startState.doAction(context);
        com.example.designpatterns.state.StopState stopState = new com.example.designpatterns.state.StopState();
        String stopStateResult = stopState.doAction(context);
        return startStateResult + " | " + stopStateResult;
    }

    @GetMapping("/template-method")
    public String templateMethod() {
        com.example.designpatterns.templatemethod.Game game = new com.example.designpatterns.templatemethod.Cricket();
        String cricketResult = game.play();
        game = new com.example.designpatterns.templatemethod.Football();
        String footballResult = game.play();
        return cricketResult + " | " + footballResult;
    }

    @GetMapping("/visitor")
    public String visitor() {
        com.example.designpatterns.visitor.ComputerPart computer = new com.example.designpatterns.visitor.Computer();
        return computer.accept(new com.example.designpatterns.visitor.ComputerPartDisplayVisitor());
    }

    @GetMapping("/strategy")
    public String strategy() {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        String ccResult = cart.checkout(100);

        cart.setPaymentStrategy(new PaypalPayment());
        String paypalResult = cart.checkout(50);

        return ccResult + " | " + paypalResult;
    }
}
