package ex05;

import java.util.List;

public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Integer> 목록보기() {
        return repository.findAll();
    }

    public int 상세보기() {
        return repository.findById();
    }
}
