package comparable;

import entretenimento.Entretenimento;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;

public class EntretenimentoComparatorData implements Comparator
{
    @Override
    public int compare(Object o1, Object o2)
    {
        Entretenimento s1,s2;
        s1 = (Entretenimento) o1;
        s2 = (Entretenimento) o2;
        String a1 = s1.getDataLancamento();
        String a2 = s2.getDataLancamento();

        int r = a1.compareTo(a2);

        if (r > 0)
            r = -1;
        else if (r < 0)
            r = 1;
        return r;

    }
}
