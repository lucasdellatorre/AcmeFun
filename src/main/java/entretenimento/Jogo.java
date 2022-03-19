package entretenimento;

public class Jogo extends Entretenimento
{

    private String tituloOriginal;
    private String genero;
    
    public Jogo(String codigo, String titulo, String dataLancamento, String tituloOriginal, String genero)
    {
        super(codigo, titulo, dataLancamento);
        this.tituloOriginal = tituloOriginal;
        this.genero = genero;
    }

    @Override
    public String toString()
    {
        return super.toString() +
                " | Título Original: " + tituloOriginal +
                " | Gênero: " + genero;
    }

    @Override
    public String toStringCsv()
    {
        return super.toStringCsv() +
                ";" + tituloOriginal +
                ";" + genero;
    }


    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public String getGenero() {
        return genero;
    }

}
