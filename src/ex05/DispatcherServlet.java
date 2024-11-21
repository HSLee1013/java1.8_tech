package ex05;

public class DispatcherServlet {
    private final Controller controller;
    private final ControllerAdvice controllerAdvice;

    public DispatcherServlet(Controller controller, ControllerAdvice controllerAdvice) {
        this.controller = controller;
        this.controllerAdvice = controllerAdvice;
    }

    public void route(String path) {
        try {
            if (path.equals("/")) {
                controller.list();
            } else if (path.equals("/board")) {
                controller.detail();
            } else {
                System.out.println("404 Not Found");
            }
        } catch (RuntimeException e) {
            // 1. 컴포넌트 스캔 @ControllerAdvice
            // 2. invoke(호출) RuntimeException 매개변수를 가진 친구를 리플렉션으로 찾아냄
            controllerAdvice.process(e);
        }
    }
}
