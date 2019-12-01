/*
 * Created on Dec 1, 2019
 *
 */
package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainAppWindow {

    private JFrame frame;
    private JPanel panelNorth;
    private JPanel panelWest;
    private JPanel panelSouth;
    private JPanel panelEast;
    private JPanel panelCenter;
    private JLabel lblMovies;
    private JSplitPane splitPane;
    private JScrollPane scrollPaneLeft;
    private JScrollPane scrollPaneRight;
    private JTextArea textAreaLeft;
    private JLabel label;
    private JLabel lblMovies_1;
    private JComboBox comboBoxMovies;
    private JLabel lblYear;
    private JTextField textFieldYear;
    private JLabel lblDirector;
    private JTextField textFieldDirector;
    private JButton btnSelectIllustration;
    private JButton btnSaveMovie;
    private JLabel lblActors;
    private JComboBox comboBoxActors;
    private JButton btnNewActor;
    private JButton btnDeleteActor;
    private JLabel lblDetails;
    private JRadioButton rdbtnBasic;
    private JRadioButton rdbtnStandard;
    private JRadioButton rdbtnAll;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainAppWindow window = new MainAppWindow();
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
    public MainAppWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1019, 496);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(getPanelNorth(), BorderLayout.NORTH);
        frame.getContentPane().add(getPanelWest(), BorderLayout.WEST);
        frame.getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
        frame.getContentPane().add(getPanelEast(), BorderLayout.EAST);
        frame.getContentPane().add(getPanelCenter(), BorderLayout.CENTER);
    }

    private JPanel getPanelNorth() {
        if (panelNorth == null) {
        	panelNorth = new JPanel();
        	panelNorth.add(getLblMovies());
        }
        return panelNorth;
    }
    private JPanel getPanelWest() {
        if (panelWest == null) {
        	panelWest = new JPanel();
        	panelWest.setPreferredSize(new Dimension(150, 10));
        	panelWest.setLayout(new MigLayout("", "[grow]", "[][][][][][][grow][][]"));
        	panelWest.add(getLblMovies_1(), "cell 0 0");
        	panelWest.add(getComboBoxMovies(), "cell 0 1,growx");
        	panelWest.add(getLblYear(), "cell 0 2");
        	panelWest.add(getTextFieldYear(), "cell 0 3,growx");
        	panelWest.add(getLblDirector(), "cell 0 4");
        	panelWest.add(getTextFieldDirector(), "cell 0 5,growx");
        	panelWest.add(getBtnSelectIllustration(), "cell 0 7,growx");
        	panelWest.add(getBtnSaveMovie(), "cell 0 8,growx");
        }
        return panelWest;
    }
    private JPanel getPanelSouth() {
        if (panelSouth == null) {
        	panelSouth = new JPanel();
        	panelSouth.setLayout(new MigLayout("", "[grow][][][][grow]", "[][]"));
        	panelSouth.add(getLblDetails(), "cell 1 0 3 1,alignx center");
        	panelSouth.add(getRdbtnBasic(), "cell 1 1,alignx right,aligny top");
        	panelSouth.add(getRdbtnStandard(), "cell 2 1");
        	panelSouth.add(getRdbtnAll(), "cell 3 1");
        }
        return panelSouth;
    }
    private JPanel getPanelEast() {
        if (panelEast == null) {
        	panelEast = new JPanel();
        	panelEast.setPreferredSize(new Dimension(150, 10));
        	panelEast.setLayout(new MigLayout("", "[grow]", "[][][grow][][]"));
        	panelEast.add(getLblActors(), "cell 0 0");
        	panelEast.add(getComboBoxActors(), "cell 0 1,growx");
        	panelEast.add(getBtnNewActor(), "cell 0 3,growx");
        	panelEast.add(getBtnDeleteActor(), "cell 0 4,growx");
        }
        return panelEast;
    }
    private JPanel getPanelCenter() {
        if (panelCenter == null) {
        	panelCenter = new JPanel();
        	panelCenter.setLayout(new MigLayout("", "[grow]", "[grow]"));
        	panelCenter.add(getSplitPane(), "cell 0 0,grow");
        }
        return panelCenter;
    }
    private JLabel getLblMovies() {
        if (lblMovies == null) {
        	lblMovies = new JLabel("Movies");
        	lblMovies.setFont(new Font("Tahoma", Font.BOLD, 15));
        	lblMovies.setForeground(new Color(0, 51, 153));
        }
        return lblMovies;
    }
    private JSplitPane getSplitPane() {
        if (splitPane == null) {
        	splitPane = new JSplitPane();
        	splitPane.setLeftComponent(getScrollPaneLeft());
        	splitPane.setRightComponent(getScrollPaneRight());
        	splitPane.setDividerLocation(350);
        }
        return splitPane;
    }
    private JScrollPane getScrollPaneLeft() {
        if (scrollPaneLeft == null) {
        	scrollPaneLeft = new JScrollPane();
        	scrollPaneLeft.setViewportView(getTextAreaLeft());
        }
        return scrollPaneLeft;
    }
    private JScrollPane getScrollPaneRight() {
        if (scrollPaneRight == null) {
        	scrollPaneRight = new JScrollPane();
        	scrollPaneRight.setViewportView(getLabel());
        }
        return scrollPaneRight;
    }
    private JTextArea getTextAreaLeft() {
        if (textAreaLeft == null) {
        	textAreaLeft = new JTextArea();
        }
        return textAreaLeft;
    }
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("");
        	label.setHorizontalAlignment(SwingConstants.CENTER);
        	label.setIcon(new ImageIcon("M:\\Vladan\\Courses\\P2\\My Java Programs\\Eclipse Workspace\\Easy Rider\\resources\\Easy Rider.jpg"));
        }
        return label;
    }
    private JLabel getLblMovies_1() {
        if (lblMovies_1 == null) {
        	lblMovies_1 = new JLabel("Movies");
        }
        return lblMovies_1;
    }
    private JComboBox getComboBoxMovies() {
        if (comboBoxMovies == null) {
        	comboBoxMovies = new JComboBox();
        }
        return comboBoxMovies;
    }
    private JLabel getLblYear() {
        if (lblYear == null) {
        	lblYear = new JLabel("Year");
        }
        return lblYear;
    }
    private JTextField getTextFieldYear() {
        if (textFieldYear == null) {
        	textFieldYear = new JTextField();
        	textFieldYear.setColumns(10);
        }
        return textFieldYear;
    }
    private JLabel getLblDirector() {
        if (lblDirector == null) {
        	lblDirector = new JLabel("Director");
        }
        return lblDirector;
    }
    private JTextField getTextFieldDirector() {
        if (textFieldDirector == null) {
        	textFieldDirector = new JTextField();
        	textFieldDirector.setColumns(10);
        }
        return textFieldDirector;
    }
    private JButton getBtnSelectIllustration() {
        if (btnSelectIllustration == null) {
        	btnSelectIllustration = new JButton("Select illustration");
        }
        return btnSelectIllustration;
    }
    private JButton getBtnSaveMovie() {
        if (btnSaveMovie == null) {
        	btnSaveMovie = new JButton("Save movie");
        }
        return btnSaveMovie;
    }
    private JLabel getLblActors() {
        if (lblActors == null) {
        	lblActors = new JLabel("Actors");
        }
        return lblActors;
    }
    private JComboBox getComboBoxActors() {
        if (comboBoxActors == null) {
        	comboBoxActors = new JComboBox();
        }
        return comboBoxActors;
    }
    private JButton getBtnNewActor() {
        if (btnNewActor == null) {
        	btnNewActor = new JButton("New actor");
        }
        return btnNewActor;
    }
    private JButton getBtnDeleteActor() {
        if (btnDeleteActor == null) {
        	btnDeleteActor = new JButton("Delete actor");
        }
        return btnDeleteActor;
    }
    private JLabel getLblDetails() {
        if (lblDetails == null) {
        	lblDetails = new JLabel("Details");
        	lblDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
        }
        return lblDetails;
    }
    private JRadioButton getRdbtnBasic() {
        if (rdbtnBasic == null) {
        	rdbtnBasic = new JRadioButton("Basic");
        	rdbtnBasic.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
        	        panelCenter.setVisible(false);
        	        lblActors.setVisible(false);
        	        comboBoxActors.setVisible(false);
        	        btnDeleteActor.setVisible(false);
        	        btnNewActor.setVisible(false);
        	    }
        	});
        	buttonGroup.add(rdbtnBasic);
        }
        return rdbtnBasic;
    }
    private JRadioButton getRdbtnStandard() {
        if (rdbtnStandard == null) {
        	rdbtnStandard = new JRadioButton("Standard");
        	rdbtnStandard.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    panelCenter.setVisible(true);
                    lblActors.setVisible(false);
                    comboBoxActors.setVisible(false);
                    btnDeleteActor.setVisible(false);
                    btnNewActor.setVisible(false);
        	    }
        	});
        	buttonGroup.add(rdbtnStandard);
            getPanelCenter().setVisible(true);
            getLblActors().setVisible(false);
            getComboBoxActors().setVisible(false);
            getBtnDeleteActor().setVisible(false);
            getBtnNewActor().setVisible(false);
        	rdbtnStandard.setSelected(true);
        }
        return rdbtnStandard;
    }
    private JRadioButton getRdbtnAll() {
        if (rdbtnAll == null) {
        	rdbtnAll = new JRadioButton("All");
        	rdbtnAll.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    panelCenter.setVisible(true);
                    lblActors.setVisible(true);
                    comboBoxActors.setVisible(true);
                    btnDeleteActor.setVisible(true);
                    btnNewActor.setVisible(true);
        	    }
        	});
        	buttonGroup.add(rdbtnAll);
        }
        return rdbtnAll;
    }
}