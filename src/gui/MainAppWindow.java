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
import util.Nationality;
import util.Sex;
import util.Utility;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import movies.Actor;
import movies.Cast;
import movies.Director;
import movies.Movie;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainAppWindow {

    private JFrame frmEasyRider;
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
    
    private JMenuBar menuBarMain;
    private JMenu mnFile;
    private JMenu mnEdit;
    private JMenu mnView;
    private JMenu mnTest;
    private JMenu mnHelp;
    private JMenuItem mntmNew;
    private JMenuItem mntmOpen;
    private JMenuItem mntmSave;
    private JMenuItem mntmExit;
    private JSeparator mnFileSeparator;
    private JMenuItem mntmCreateTestData;
    private JMenuItem mntmReadTestData;
    private JMenuItem mntmClearTestData;

    private Actor actor;
    private ArrayList<Actor> actors;
    private Director director;
    private ArrayList<Director> directors;
    private Movie movie;
    private ArrayList<Movie> movies;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainAppWindow window = new MainAppWindow();
                    window.frmEasyRider.setVisible(true);
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
        frmEasyRider = new JFrame();
        frmEasyRider.setTitle("Easy Rider");
        frmEasyRider.setBounds(100, 100, 1019, 496);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frmEasyRider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmEasyRider.getContentPane().add(getPanelNorth(), BorderLayout.NORTH);
        frmEasyRider.getContentPane().add(getPanelWest(), BorderLayout.WEST);
        frmEasyRider.getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
        frmEasyRider.getContentPane().add(getPanelEast(), BorderLayout.EAST);
        frmEasyRider.getContentPane().add(getPanelCenter(), BorderLayout.CENTER);
        frmEasyRider.setJMenuBar(getMenuBarMain());
        
        deserialize("Test data.serialized");
        addMovieTitles(getComboBoxMovies(), movies);
        
    }

    private void serialize(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(Utility.getResourcesDir() + filename)))) {
            out.writeObject(actors);
            out.writeObject(directors);
            out.writeObject(movies);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private void deserialize(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(Utility.getResourcesDir() + filename)))) {
            actors = (ArrayList<Actor>) in.readObject(); 
            directors = (ArrayList<Director>) in.readObject(); 
            movies = (ArrayList<Movie>) in.readObject(); 
        } catch (FileNotFoundException e) {
            // Do nothing if movies.serialized is not found
            // e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private void addMovieTitles(JComboBox<String> cb, ArrayList<Movie> m) {
        for (Movie movie : m) {
            cb.addItem(movie.getTitle());
        }
    }

    private void addActorNames(JComboBox<String> cb, Actor[] a) {
        for (Actor actor : a) {
            cb.addItem(actor.getName());
        }
    }

    private void emptyMovieTitles(JComboBox<String> cb) {
        cb.removeAllItems();
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
        	comboBoxMovies.addItemListener(new ItemListener() {
        	    public void itemStateChanged(ItemEvent arg0) {
        	        if (arg0.getStateChange() == ItemEvent.SELECTED) {
        	            String title = (String) comboBoxMovies.getSelectedItem();
        	            for (Movie m : movies) {
                            if (m.getTitle().equals(title)) {
                                textFieldDirector.setText(m.getDirector().getName());
                                textFieldYear.setText(String.valueOf(m.getYear()));
//                                comboBoxActors.removeAll();
//                                System.out.println(comboBoxActors.getItemCount());
                                DefaultComboBoxModel d = (DefaultComboBoxModel) comboBoxActors.getModel();
                                d.removeAllElements();
                                addActorNames(comboBoxActors, m.getActors());
                                break;
                            }
                        }
        	        }
        	    }
        	});
//            comboBoxMovies.addItem("Easy Rider");
//            comboBoxMovies.addItem("Blade Runner");
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
        	btnNewActor.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        
        	    }
        	});
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
    
    private void createTestData() {
        Actor dennisHopper = new Actor("Dennis Hopper", Sex.MALE, -1, Nationality.USA);
        Actor peterFonda = new Actor("Peter Fonda", Sex.MALE, -1, Nationality.USA);
        Actor jackNicholson = new Actor("Jack Nicholson", Sex.MALE, 82, Nationality.USA);
        Director dHopper = new Director("Dennis Hopper", false, Nationality.USA);
        Actor[] actors1 = {dennisHopper, peterFonda, jackNicholson};
        Movie easyRider = new Movie("Easy Rider", 1969, dHopper, actors1);

        Actor benAffleck = new Actor("Ben Affleck", Sex.MALE, 47, Nationality.USA);
        Actor anaKendrick = new Actor("Ana Kendrick", Sex.FEMALE, 34, Nationality.USA);
        Director gavinOConnor = new Director("Gavin O'Connor", true, Nationality.USA);
        Actor[] actors2 = {benAffleck, anaKendrick};
        Movie theAccountant = new Movie("The Accountant", 2016, gavinOConnor, actors2);

        Actor harrisonFord = new Actor("Harrison Ford", Sex.MALE, 77, Nationality.USA);
        Actor rutgerHauer = new Actor("Rutger Hauer", Sex.MALE, -1, Nationality.USA);
        Director ridleyScott = new Director("Ridley Scott", true, Nationality.USA);
        Actor[] actors3 = {harrisonFord, rutgerHauer};
        Movie bladeRunner = new Movie("Blade Runner", 1982, ridleyScott, actors3);
        
        actors = new ArrayList<Actor>();
        actors.add(peterFonda);
        actors.add(dennisHopper);
        actors.add(jackNicholson);
        actors.add(benAffleck);
        actors.add(anaKendrick);
        actors.add(harrisonFord);
        actors.add(rutgerHauer);
        
        directors = new ArrayList<Director>();
        directors.add(dHopper);
        directors.add(gavinOConnor);
        directors.add(ridleyScott);
        
        movies = new ArrayList<Movie>();
        movies.add(easyRider);
        movies.add(theAccountant);
        movies.add(bladeRunner);

    }
    
    private JMenuBar getMenuBarMain() {
        if (menuBarMain == null) {
        	menuBarMain = new JMenuBar();
        	menuBarMain.add(getMnFile());
        	menuBarMain.add(getMnEdit());
        	menuBarMain.add(getMnView());
        	menuBarMain.add(getMnTest());
        	menuBarMain.add(getMnHelp());
        }
        return menuBarMain;
    }
    private JMenu getMnFile() {
        if (mnFile == null) {
        	mnFile = new JMenu("File");
        	mnFile.add(getMntmNew());
        	mnFile.add(getMntmOpen());
        	mnFile.add(getMntmSave());
        	mnFile.add(getMnFileSeparator());
        	mnFile.add(getMntmExit());
        }
        return mnFile;
    }
    private JMenu getMnEdit() {
        if (mnEdit == null) {
        	mnEdit = new JMenu("Edit");
        }
        return mnEdit;
    }
    private JMenu getMnView() {
        if (mnView == null) {
        	mnView = new JMenu("View");
        }
        return mnView;
    }
    private JMenu getMnTest() {
        if (mnTest == null) {
        	mnTest = new JMenu("Test");
        	mnTest.add(getMntmCreateTestData());
        	mnTest.add(getMntmReadTestData());
        	mnTest.add(getMntmClearTestData());
        }
        return mnTest;
    }
    private JMenu getMnHelp() {
        if (mnHelp == null) {
        	mnHelp = new JMenu("Help");
        }
        return mnHelp;
    }
    private JMenuItem getMntmNew() {
        if (mntmNew == null) {
        	mntmNew = new JMenuItem("New...");
        }
        return mntmNew;
    }
    private JMenuItem getMntmOpen() {
        if (mntmOpen == null) {
        	mntmOpen = new JMenuItem("Open...");
        }
        return mntmOpen;
    }
    private JMenuItem getMntmSave() {
        if (mntmSave == null) {
        	mntmSave = new JMenuItem("Save...");
        }
        return mntmSave;
    }
    private JMenuItem getMntmExit() {
        if (mntmExit == null) {
        	mntmExit = new JMenuItem("Exit");
        }
        return mntmExit;
    }
    private JSeparator getMnFileSeparator() {
        if (mnFileSeparator == null) {
        	mnFileSeparator = new JSeparator();
        }
        return mnFileSeparator;
    }
    private JMenuItem getMntmCreateTestData() {
        if (mntmCreateTestData == null) {
        	mntmCreateTestData = new JMenuItem("Create test data");
        	mntmCreateTestData.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
        	        createTestData();
        	        serialize("Test data.serialized");
        	        JOptionPane.showMessageDialog(frmEasyRider, "Test data created.");
        	    }
        	});
        }
        return mntmCreateTestData;
    }
    private JMenuItem getMntmReadTestData() {
        if (mntmReadTestData == null) {
        	mntmReadTestData = new JMenuItem("Read test data");
        	mntmReadTestData.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent arg0) {
        	        deserialize("Test data.serialized");
        	        addMovieTitles(getComboBoxMovies(), movies);
        	    }
        	});
        }
        return mntmReadTestData;
    }
    private JMenuItem getMntmClearTestData() {
        if (mntmClearTestData == null) {
        	mntmClearTestData = new JMenuItem("Clear test data");
        	mntmClearTestData.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        actors = null;
        	        directors = null;
        	        movies = null;
        	        emptyMovieTitles(getComboBoxMovies());
        	    }
        	});
        }
        return mntmClearTestData;
    }
}
