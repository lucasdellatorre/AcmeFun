package comparable;

import entretenimento.Entretenimento;
import javafx.scene.control.ComboBox;

import java.util.Comparator;

public class EntretenimentoComparatorTitulo implements Comparator {
    @Override
    public int compare(Object o1, Object o2)
    {
        Entretenimento s1,s2;
        s1 = (Entretenimento) o1;
        s2 = (Entretenimento) o2;
        return s1.getTitulo().compareTo(s2.getTitulo());
    }
}
