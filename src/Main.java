import Sim.Sim;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int Width = 800;
        int Height = 800;

        JFrame frame = new JFrame("SIM");
        frame.setSize(Width, Height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Sim sim = new Sim(Width, Height);
        frame.add(sim);
        frame.pack();

        frame.setVisible(true);

        sim.requestFocus();
    }
}