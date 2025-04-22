package Sim;

import Camera.Camera2;
import Vector.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Sim extends JPanel implements ActionListener, KeyListener{
    int w;
    int h;

    Timer clock;

    Camera2 cam;
    Box2 bounds;

    ArrayList<Particle> particles;

    public Sim(int w, int h) {
        this.w = w;
        this.h = h;

        particles = new ArrayList<>();

        setBackground(Color.black);
        setPreferredSize(new Dimension(this.w, this.h));
        setFocusable(true);
        addKeyListener(this);

        this.cam = new Camera2(new Vector2(0, 0), new Vector2(this.w, this.h));
        this.bounds = new Box2(new Vector2(0, 0), new Vector2(2000, 2000));
        particles.add(new Particle(new Vector2(500, 1000), new Vector2(0, 1), new Vector2(0, 0), 1, 10, true, Color.white));
        particles.add(new Particle(new Vector2(1500, 1000), new Vector2(0, -1), new Vector2(0, 0), 1, 10, true, Color.white));
        particles.add(new Particle(new Vector2(1000, 1000), new Vector2(0, 0), new Vector2(0, 0), 100, 50, true, Color.yellow));

        clock = new Timer(16, this);
        clock.start();
    }

    public void draw (Graphics g) {
        // draw Particles
        for (Particle p : particles) {
            Vector2 realPos = new Vector2(p.pos.x - p.rad, p.pos.y - p.rad);
            Vector2 posOnCam = cam.posOnCam(realPos);
            g.setColor(p.color);
            g.fillOval((int) posOnCam.x, (int) posOnCam.y, 2 * p.rad, 2 * p.rad);
        }

        // draw Bounds
        Vector2 posOnCam = cam.posOnCam(bounds.pos);
        g.setColor(Color.red);
        g.drawRect((int)posOnCam.x, (int)posOnCam.y, (int)bounds.size.x, (int)bounds.size.y);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // update particles
        for (int i = 0; i < particles.size(); i++) {
            Particle particle1 = particles.get(i);
            particle1.update(bounds);
            for (int j = i+1; j < particles.size(); j++) {
                Particle particle2 = particles.get(j);
                particle1.attract(particle2);
            }
        }

        // update camera
        cam.update();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (e.getKeyCode() == KeyEvent.VK_W) {
            cam.vel.y = -10;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            cam.vel.x = -10;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            cam.vel.y = 10;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            cam.vel.x = 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            cam.vel.y = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            cam.vel.x = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            cam.vel.y = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            cam.vel.x = 0;
        }
    }
}
