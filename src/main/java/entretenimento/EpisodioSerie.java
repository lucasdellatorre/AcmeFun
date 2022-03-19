package entretenimento;

public class EpisodioSerie extends Entretenimento
{
    private String numTemporada;
    private String numEpisodio;
    private String idSerie;

    public EpisodioSerie(String codigo, String titulo, String dataLancamento, String numTemporada,
                         String numEpisodio, String idSerie)
    {
        super(codigo, titulo, dataLancamento);
        this.numEpisodio = numEpisodio;
        this.numTemporada = numTemporada;
        this.idSerie = idSerie;
    }



    public String toString()
    {
        return super.toString() +
                " | Numero da temporada: " + numTemporada +
                " | Numero do episódio: " + numEpisodio +
                " | Código da série: " + idSerie;
    }

    public String toStringCsv()
    {
        return super.toStringCsv() +
                ";" + numTemporada +
                ";" + numEpisodio +
                ";" + idSerie;
    }

}