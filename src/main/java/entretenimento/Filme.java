package entretenimento;

public class Filme extends Entretenimento
{
    private String duracaoMinutos;

    public Filme(String codigo, String titulo, String dataLancamento, String duracaoMinutos)
    {
        super(codigo, titulo, dataLancamento);
        this.duracaoMinutos = duracaoMinutos;

    }

    public String getDuracaoMinutos() {
        return duracaoMinutos;
    }


    @Override
    public String toString()
    {
        return  super.toString() +
                " | Duracao em minutos: " + duracaoMinutos;
    }

    @Override
    public String toStringCsv()
    {
        return super.toStringCsv() + ";" + duracaoMinutos;
    }

}
