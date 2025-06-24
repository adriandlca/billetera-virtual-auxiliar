import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class PanelGrafico extends JPanel {
    private final ArrayList<Double> datos = new ArrayList<>();
    private final Random rand = new Random();

    public void agregarValorAleatorio() {
        double valor = 1 + rand.nextInt(100); // Valor entre 1 y 100
        if (datos.size() >= 50) datos.remove(0);
        datos.add(valor);
        repaint();
    }

    public double getUltimoValor() {
        return datos.isEmpty() ? 0 : datos.get(datos.size() - 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        g.setColor(Color.BLACK);
        g.drawRect(10, 10, width - 20, height - 20);
        //g.drawString("Simulación de procesos (1-100)", 20, 25);

        for (int i = 1; i < datos.size(); i++) {
            int x1 = 10 + (i - 1) * (width - 20) / 50;
            int y1 = 10 + (int)((1 - datos.get(i - 1) / 100.0) * (height - 20));
            int x2 = 10 + i * (width - 20) / 50;
            int y2 = 10 + (int)((1 - datos.get(i) / 100.0) * (height - 20));

            g.setColor(Color.BLUE);
            if(datos.get(i)>90){
                g.setColor(Color.RED);
                g.drawOval(x2, y2, 2, 2);
            }
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
