package vacation;

import java.util.ArrayList;
import java.util.Collections; 
import java.util.Comparator;
import java.util.List;

public class MeuDiarioDeFerias {
    private List<AtividadeDeFerias> atividades = new ArrayList<>();

    public void adicionarAtividade(AtividadeDeFerias atividade) {
        atividades.add(atividade);
    }

    public List<AtividadeDeFerias> listarAtividades() {
        if (atividades.isEmpty()) {
            throw new IllegalStateException("O diário está vazio.");
        }
        return new ArrayList<>(atividades);
    }

    public List<AtividadeDeFerias> listarAtividadesNota() {
        if (atividades.isEmpty()) {
            throw new IllegalStateException("O diário está vazio.");
        }
        
        List<AtividadeDeFerias> listaOrdenada = new ArrayList<>(atividades);
        
        // Substituição do método de ordenação.
        Collections.sort(listaOrdenada, Comparator.comparingDouble(AtividadeDeFerias::getNota).reversed());
        
        return listaOrdenada;
    }

    public List<AtividadeDeFerias> pesquisarPorTag(String tag) {
        if (atividades.isEmpty()) {
            throw new IllegalStateException("O diário está vazio.");
        }
        List<AtividadeDeFerias> resultados = new ArrayList<>();
        for (AtividadeDeFerias at : atividades) {
            if (at.getTag().equalsIgnoreCase(tag)) {
                resultados.add(at);
            }
        }
        return resultados;
    }
}
