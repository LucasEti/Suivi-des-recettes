package projetGL;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

@SuppressWarnings("deprecation")
public class RecetteObserver implements Observer {
	private List<String> recettesValides = new ArrayList<>();  

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Article) {
        	Article article = (Article) o;

            recettesValides.add("La " + article.getNom() + " est d�sormais disponible");
        }
        if (!recettesValides.isEmpty()) {
            String message = String.join("\n", recettesValides);
            JOptionPane.showMessageDialog(null, message, "ALERTE", JOptionPane.WARNING_MESSAGE);
            recettesValides.clear();
        }
    }
}
