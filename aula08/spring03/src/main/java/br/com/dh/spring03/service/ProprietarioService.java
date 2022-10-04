package br.com.dh.spring03.service;

import br.com.dh.spring03.model.Proprietario;
import br.com.dh.spring03.model.Veiculo;
import br.com.dh.spring03.repository.ProprietarioRepo;
import br.com.dh.spring03.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProprietarioService implements IProprietario {

    @Autowired
    private VeiculoRepo veiculoRepo;

    @Autowired
    private ProprietarioRepo proprietarioRepo;

    @Override
    public List<Proprietario> getAll() {
        List<Veiculo> veiculoList = new ArrayList<>(veiculoRepo.getAll());
        List<Proprietario> proprietarioList = new ArrayList<>(proprietarioRepo.getAll());

        proprietarioList.stream()
                .forEach(proprietario -> {
//                    for (int i = 0; i < veiculoList.size(); i++) {
//                        if(veiculoList.get(i).getId_proprietario() == proprietario.getId()){
////                            proprietario.addVeiculo(veiculoList.get(i));
//                            proprietario.addVeiculo(veiculoList.remove(i));
//                            i--;
//                        }
//                    }

                    // outra solução: mais elegante, menor desempenho (imperceptível em listas pequenas/médias)

                    List<Veiculo> veiculosDoProp = veiculoList.stream()
                            .filter(v->v.getId_proprietario()== proprietario.getId())
                            .collect(Collectors.toList());
                    proprietario.setVeiculos( veiculosDoProp );
                    veiculoList.removeAll(veiculosDoProp);
                });

        return proprietarioList;
    }
}
