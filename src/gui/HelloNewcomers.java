/*
 * Created on Dec 1, 2019
 *
 */
package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HelloNewcomers {

    private JFrame frame;
    private JPanel panel;
    private JButton btnStart;
    private JLabel lblEasyRider;
    private JLabel label;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HelloNewcomers window = new HelloNewcomers();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public HelloNewcomers() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 892, 499);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(getPanel(), BorderLayout.NORTH);
        frame.getContentPane().add(getLabel(), BorderLayout.CENTER);
    }

    private JPanel getPanel() {
        if (panel == null) {
        	panel = new JPanel();
        	panel.add(getBtnStart());
        	panel.add(getLblEasyRider());
        }
        return panel;
    }
    private JButton getBtnStart() {
        if (btnStart == null) {
        	btnStart = new JButton("Start");
        	btnStart.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
        	        lblEasyRider.setVisible(true);
        	        label.setVisible(true);
        	        btnStart.setVisible(false);
        	    }
        	});
        }
        return btnStart;
    }
    private JLabel getLblEasyRider() {
        if (lblEasyRider == null) {
        	lblEasyRider = new JLabel("Easy Rider");
        	lblEasyRider.setForeground(new Color(0, 102, 204));
        	lblEasyRider.setFont(new Font("Tahoma", Font.BOLD, 15));
        	lblEasyRider.setVisible(false);
        }
        return lblEasyRider;
    }
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("");
        	label.setHorizontalAlignment(SwingConstants.CENTER);
        	label.setIcon(new ImageIcon("M:\\Vladan\\Courses\\P2\\My Java Programs\\Eclipse Workspace\\Easy Rider\\resources\\Easy Rider.jpg"));
        	label.setVisible(false);
        }
        return label;
    }
}
