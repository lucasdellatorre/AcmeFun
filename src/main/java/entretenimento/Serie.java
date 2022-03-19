package entretenimento;

import java.time.LocalDate;
import java.util.ArrayList;

public class Serie extends Entretenimento
{
    private String anoConclusao;

    public Serie(String codigo, String titulo, String dataLancamento, String anoConclusao)
    {
        super(codigo, titulo, dataLancamento);
        this.anoConclusao = anoConclusao;
    }


    @Override
    public String toString() {
        return super.toString() +
                " | Ano conclusao: " + anoConclusao;
    }




    @Override
    public String toStringCsv()
    {
        return super.toStringCsv() +
                ";" + anoConclusao;
    }

}
