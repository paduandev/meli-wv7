package br.dh.meli.storage02.service;

import br.dh.meli.storage02.model.Subject;
import br.dh.meli.storage02.repository.SubjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService implements ISubjectService {

    private final SubjectRepo repo;

    @Override
    public Subject findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Subject> findAll() {
        return repo.findAll();
    }

}
