package vacation;
import java.util.Objects;

public class AtividadeDeFerias {
    private String descricao;
    private String tag;
    private double nota;

    public AtividadeDeFerias(String descricao, String tag, double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve ser entre 0 e 10");
        }
        this.descricao = descricao;
        this.tag = tag;
        this.nota = nota;
    }

    public String getDescricao() { return descricao; }
    public String getTag() { return tag; }
    public double getNota() { return nota; }

    @Override
    public String toString() {
        return String.format("Atividade: %s | Tag: %s | Nota: %.1f", descricao, tag, nota);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtividadeDeFerias that = (AtividadeDeFerias) o;
        return Double.compare(that.nota, nota) == 0 && Objects.equals(descricao, that.descricao) && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, tag, nota);
    }
}