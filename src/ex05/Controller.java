package ex05;

import java.util.List;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void list() {
        List<Integer> models = service.목록보기();
        for (Integer model : models) {
            System.out.println("렌더링: " + model);
        }
    }

    public void detail() {
            int model = service.상세보기();
            System.out.println("렌더링: " + model);
    }
}
