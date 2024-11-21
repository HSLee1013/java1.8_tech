package ex05;

public class App {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Service service = new Service(repository);
        Controller controller = new Controller(service);
        ControllerAdvice controllerAdvice = new ControllerAdvice();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(controller, controllerAdvice);

        dispatcherServlet.route("/board");
    }
}
