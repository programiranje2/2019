/*
 * Created on Dec 15, 2019
 *
 */
package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import util.Nationality;
import util.Sex;

import javax.swing.JTabbedPane;

import movies.Actor;
import movies.Director;
import movies.Movie;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class NewMovieDialog extends JDialog {
    private JPanel panelSouth;
    private JTabbedPane tabbedPane;
    private JPanel panelMovie;
    private JPanel panelActors;
    private JButton btnOk;
    private JButton btnCancel;
    
    private Movie movie = null;
    private Director director = null;
    private Actor actor = null;
    private ArrayList<Actor> actors = new ArrayList<Actor>();
    
    private NewMovieDialog thisDialog = this;
    private JLabel lblTitle;
    private JTextField textFieldTitle;
    private JLabel lblReleaseDate;
    private JTextField textFieldDay;
    private JTextField textFieldMonth;
    private JTextField textFieldYear;
    private JLabel lblDirectornameAge;
    private JTextField textFieldDirectorName;
    private JComboBox comboBoxDirectorNationality;
    private JComboBox comboBoxAlive;
    private JLabel lblName;
    private JLabel lblSex;
    private JLabel lblAge;
    private JLabel lblNationality;
    private JTextField textFieldActorName;
    private JComboBox comboBoxSex;
    private JTextField textFieldAge;
    private JComboBox comboBoxActorNationality;
    private JButton btnAdd;
    private JButton btnClear;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewMovieDialog dialog = new NewMovieDialog();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the dialog.
     */
    public NewMovieDialog() {
        setTitle("New movie");
        setBounds(200, 200, 722, 263);
        getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
        getContentPane().add(getTabbedPane(), BorderLayout.CENTER);

    }

    public NewMovieDialog(JFrame owner, boolean modal) {
        super(owner, modal);
        setTitle("New movie");
        setBounds(200, 200, 722, 501);
        getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
        getContentPane().add(getTabbedPane(), BorderLayout.CENTER);

    }
    
    public Movie showDialog() {
        this.setVisible(true);
        dispose();
        return movie;
    }

    private void clearActorData() {
        textFieldActorName.setText("");
        textFieldAge.setText("");
        comboBoxSex.setSelectedIndex(0);
        comboBoxActorNationality.setSelectedIndex(0);
    }
    
    private JPanel getPanelSouth() {
        if (panelSouth == null) {
        	panelSouth = new JPanel();
        	panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        	panelSouth.add(getBtnOk());
        	panelSouth.add(getBtnCancel());
        }
        return panelSouth;
    }
    private JTabbedPane getTabbedPane() {
        if (tabbedPane == null) {
        	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        	tabbedPane.addTab("Movie", null, getPanelMovie(), null);
        	tabbedPane.addTab("Actors", null, getPanelActors(), null);
        }
        return tabbedPane;
    }
    private JPanel getPanelMovie() {
        if (panelMovie == null) {
        	panelMovie = new JPanel();
        	panelMovie.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][][][]"));
        	panelMovie.add(getLblTitle(), "cell 0 0");
        	panelMovie.add(getTextFieldTitle(), "cell 0 1 3 1,growx");
        	panelMovie.add(getLblReleaseDate(), "cell 0 2");
        	panelMovie.add(getTextFieldDay(), "cell 0 3,growx");
        	panelMovie.add(getTextFieldMonth(), "cell 1 3,growx");
        	panelMovie.add(getTextFieldYear(), "cell 2 3,growx");
        	panelMovie.add(getLblDirectornameAge(), "cell 0 4");
        	panelMovie.add(getTextFieldDirectorName(), "cell 0 5,growx");
        	panelMovie.add(getComboBoxAlive(), "cell 1 5,growx");
        	panelMovie.add(getComboBoxDirectorNationality(), "cell 2 5,growx");
        }
        return panelMovie;
    }
    private JPanel getPanelActors() {
        if (panelActors == null) {
        	panelActors = new JPanel();
        	panelActors.setLayout(new MigLayout("", "[][grow][grow]", "[][][][]"));
        	panelActors.add(getLblName(), "cell 0 0,alignx left");
        	panelActors.add(getTextFieldActorName(), "cell 1 0,growx");
        	panelActors.add(getBtnAdd(), "cell 2 0,growx");
        	panelActors.add(getLblSex(), "cell 0 1,alignx left");
        	panelActors.add(getComboBoxSex(), "cell 1 1,growx");
        	panelActors.add(getBtnClear(), "cell 2 1,growx");
        	panelActors.add(getLblAge(), "cell 0 2,alignx left");
        	panelActors.add(getTextFieldAge(), "cell 1 2,growx");
        	panelActors.add(getLblNationality(), "cell 0 3,alignx trailing");
        	panelActors.add(getComboBoxActorNationality(), "cell 1 3,growx");
        }
        return panelActors;
    }
    private JButton getBtnOk() {
        if (btnOk == null) {
        	btnOk = new JButton("OK");
        	btnOk.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        movie = null;
        	        thisDialog.setVisible(false);
        	    }
        	});
        }
        return btnOk;
    }
    private JButton getBtnCancel() {
        if (btnCancel == null) {
        	btnCancel = new JButton("Cancel");
        	btnCancel.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    movie = null;
                    thisDialog.setVisible(false);
        	    }
        	});
        }
        return btnCancel;
    }
    private JLabel getLblTitle() {
        if (lblTitle == null) {
        	lblTitle = new JLabel("Title");
        }
        return lblTitle;
    }
    private JTextField getTextFieldTitle() {
        if (textFieldTitle == null) {
        	textFieldTitle = new JTextField();
        	textFieldTitle.setColumns(10);
        }
        return textFieldTitle;
    }
    private JLabel getLblReleaseDate() {
        if (lblReleaseDate == null) {
        	lblReleaseDate = new JLabel("Release date (day, month, year)");
        }
        return lblReleaseDate;
    }
    private JTextField getTextFieldDay() {
        if (textFieldDay == null) {
        	textFieldDay = new JTextField();
        	textFieldDay.setColumns(10);
        }
        return textFieldDay;
    }
    private JTextField getTextFieldMonth() {
        if (textFieldMonth == null) {
        	textFieldMonth = new JTextField();
        	textFieldMonth.setColumns(10);
        }
        return textFieldMonth;
    }
    private JTextField getTextFieldYear() {
        if (textFieldYear == null) {
        	textFieldYear = new JTextField();
        	textFieldYear.setColumns(10);
        }
        return textFieldYear;
    }
    private JLabel getLblDirectornameAge() {
        if (lblDirectornameAge == null) {
        	lblDirectornameAge = new JLabel("Director (name, alive / passed away, nationality)");
        }
        return lblDirectornameAge;
    }
    private JTextField getTextFieldDirectorName() {
        if (textFieldDirectorName == null) {
        	textFieldDirectorName = new JTextField();
        	textFieldDirectorName.setColumns(10);
        }
        return textFieldDirectorName;
    }
    private JComboBox getComboBoxDirectorNationality() {
        if (comboBoxDirectorNationality == null) {
        	comboBoxDirectorNationality = new JComboBox();
            for (Nationality n : Arrays.asList(Nationality.values())) {
                comboBoxDirectorNationality.addItem(n.toString());
            }
        }
        return comboBoxDirectorNationality;
    }
    private JComboBox getComboBoxAlive() {
        if (comboBoxAlive == null) {
        	comboBoxAlive = new JComboBox();
        	comboBoxAlive.addItem("ALIVE");
        	comboBoxAlive.addItem("PASSED AWAY");
        }
        return comboBoxAlive;
    }
    private JLabel getLblName() {
        if (lblName == null) {
        	lblName = new JLabel("Name");
        }
        return lblName;
    }
    private JLabel getLblSex() {
        if (lblSex == null) {
        	lblSex = new JLabel("Sex");
        }
        return lblSex;
    }
    private JLabel getLblAge() {
        if (lblAge == null) {
        	lblAge = new JLabel("Age");
        }
        return lblAge;
    }
    private JLabel getLblNationality() {
        if (lblNationality == null) {
        	lblNationality = new JLabel("Nationality");
        }
        return lblNationality;
    }
    private JTextField getTextFieldActorName() {
        if (textFieldActorName == null) {
        	textFieldActorName = new JTextField();
        	textFieldActorName.setColumns(10);
        }
        return textFieldActorName;
    }
    private JComboBox getComboBoxSex() {
        if (comboBoxSex == null) {
        	comboBoxSex = new JComboBox();
        	comboBoxSex.addItem("FEMALE");
        	comboBoxSex.addItem("MALE");
        }
        return comboBoxSex;
    }
    private JTextField getTextFieldAge() {
        if (textFieldAge == null) {
        	textFieldAge = new JTextField();
        	textFieldAge.setColumns(10);
        }
        return textFieldAge;
    }
    private JComboBox getComboBoxActorNationality() {
        if (comboBoxActorNationality == null) {
        	comboBoxActorNationality = new JComboBox();
        	for (Nationality n : Arrays.asList(Nationality.values())) {
                comboBoxActorNationality.addItem(n.toString());
            }
        }
        return comboBoxActorNationality;
    }
    private JButton getBtnAdd() {
        if (btnAdd == null) {
        	btnAdd = new JButton("Add");
        	btnAdd.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        actor = new Actor();
        	        actor.setName(textFieldActorName.getText());
        	        actor.setAge(Integer.parseInt(textFieldAge.getText()));
        	        if (((String) comboBoxSex.getSelectedItem()).equals("FEMALE")) {
        	            actor.setSex(Sex.FEMALE);
        	        } else {
        	            actor.setSex(Sex.MALE);
        	        }
        	        for (Nationality n : Arrays.asList(Nationality.values())) {
                        if (n.toString().equals((String) comboBoxActorNationality.getSelectedItem())) {
                            actor.setNationality(n);
                            break;
                        }
                    }
        	        actors.add(actor);
        	        JOptionPane.showMessageDialog(thisDialog,
        	                "Actor added to cast.");
        	        // Clear everything after adding an actor
        	        clearActorData();
        	    }
        	});
        }
        return btnAdd;
    }
    private JButton getBtnClear() {
        if (btnClear == null) {
        	btnClear = new JButton("Clear");
        	btnClear.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        clearActorData();
        	    }
        	});
        }
        return btnClear;
    }
}
