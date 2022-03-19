package entretenimento;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Entretenimento
{
    protected String codigo;
    protected String titulo;
    protected String dataLancamento;

    public Entretenimento(String codigo, String titulo, String dataLancamento)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public String toString()
    {
        return  "Código: " + codigo +
                " | Título: " + titulo +
                " | Data de lançamento: " + dataLancamento;
    }

    public String toStringCsv()
    {
        return codigo + ";" + titulo + ";" + dataLancamento;
    }
}
