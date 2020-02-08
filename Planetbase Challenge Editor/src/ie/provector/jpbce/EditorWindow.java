package ie.provector.jpbce;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.Gson;

import ie.provector.jpbce.Challenge.NLHLevel;
import ie.provector.jpbce.Challenge.PlanetClass;
import ie.provector.jpbce.CheckedComboBox.CheckableItem;
import ie.provector.jpbce.CheckedComboBox.CheckedComboBox;
import ie.provector.jpbce.struct.Entities;
import ie.provector.jpbce.struct.HSL;
import ie.provector.jpbce.struct.RGB;
import ie.provector.jpbce.struct.Vector;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class EditorWindow {
	

	JFrame editorFrame;
	private JTextField infoField;
	private JTextField challengeNameField;
	private JTextField challengeFilenameField;
	private JTextField lightColorDayField;
	private JTextField lightColorNightField;
	private JTextField lightColorTwilightField;
	private JTextField ambientColorDayField;
	private JTextField ambientColorNightField;
	private JTextField ambientColorTwilightField;
	private JTextField horizonColorDayField;
	private JTextField horizonColorNightField;
	private JTextField horizonColorTwilightField;
	private JTextField skyColorDayField;
	private JTextField skyColorNightField;
	private JTextField skyColorTwilightField;
	private JTextField liquidColorField;
	private JTextField hslFlat1Field;
	private JTextField ttFlat1Field;
	private JTable resourcesTable;
	private JTable structuresTable;
	private JTable componentsTable;
	private JTable characterTable;
	private JTable specializationTable;
	
	private JComboBox<String> componentsBox;
	private JComboBox<String> resourcesBox;
	private JComboBox<String> specializationsBox;
	private JComboBox<String> difficultyComboBox;
	private JComboBox<PlanetClass> planetClassComboBox;
	private JSpinner startWorkerSpinner;
	private JSpinner startBiologistSpinner;
	private JSpinner startEngineerSpinner;
	private JSpinner startMedicSpinner;
	private JSpinner startConstructorSpinner;
	private JSpinner startCarrierSpinner;
	private JSpinner startDrillerSpinner;
	private JSpinner latitudeSpinner;
	private JSpinner longtitudeSpinner;
	private JSpinner startMetalSpinner;
	private JSpinner startMealSpinner;
	private JSpinner startSparesSpinner;
	private JSpinner startMedicalSuppliesSpinner;
	private JSpinner startSemiconductorsSpinner;
	private JSpinner startGunSpinner;
	private JSpinner startAlcoholicDrinkSpinner;
	private JComboBox<NLHLevel> sandstormRiskComboBox;
	private JComboBox<NLHLevel> meteorRiskComboBox;
	private JComboBox<NLHLevel> solareFlareRiskComboBox;
	private JComboBox<NLHLevel> thunderstormRiskComboBox;
	private JComboBox<NLHLevel> blizzardRiskComboBox;
	private JComboBox<NLHLevel> atmosphereDensityComboBox;
	private JComboBox<NLHLevel> lightDensityComboBox;
	private JCheckBox disableColonistShipsCheckBox;
	private JCheckBox disableTraderTechsCheckBox;
	private JCheckBox disableVisitorRequirementsCheckBox;
	private JCheckBox disableVisitorShipsCheckBox;
	private JCheckBox disableTradingShipsCheckBox;
	private JCheckBox disableShipRecyclingCheckBox;
	private JCheckBox disableWorkerMiningCheckBox;
	private JCheckBox disableNoMedicalSuppliesWarningCheckBox;
	private JCheckBox infiniteTraderBotsCheckBox;
	private JSpinner disasterFrequencySpinner;
	private JSpinner shipFrequencySpinner;
	private JSpinner intruderMinPrestigeSpinner;
	private JSpinner extraIntrudersSpinner;
	private CheckedComboBox<CheckableItem> disableInteriorStructuresCheckedComboBox;
	private CheckedComboBox<CheckableItem> disableExteriorStructuresCheckedComboBox;
	private CheckedComboBox<CheckableItem> disableComponentsCheckedComboBox;
	private CheckedComboBox<CheckableItem> disableStructureRequirementCheckedComboBox;
	private CheckedComboBox<CheckableItem> restrictedColonistShipsCheckedComboBox;
	private CheckedComboBox<CheckableItem> restrictedTradingShipsCheckedComboBox;
	private CheckedComboBox<CheckableItem> unlockTechCheckedComboBox;
	private JCheckBox disasterFrequencyCheckBox;
	private JCheckBox shipFrequencyCheckBox;
	private JCheckBox intruderMinPrestigeCheckBox;
	private JCheckBox extraIntrudersCheckBox;
	private JSpinner tradingShipFrequencySpinner;
	
	private JSpinner dayHoursSpinner;
	private JCheckBox removeSatellitesCheckBox;
	private JSpinner nightHoursSpinner;
	private JSpinner fogIntensityPercentageDaySpinner;
	private JComboBox<PlanetClass> environmentComboBox;
	private JComboBox<PlanetClass> sunComboBox;
	private JComboBox<PlanetClass> backdropsComboBox;
	private JCheckBox sandstormRiskCheckBox;
	private JCheckBox meteorRiskCheckBox;
	private JCheckBox thunderstormRiskCheckBox;
	private JCheckBox solareFlareRiskCheckBox;
	private JCheckBox blizzardRiskCheckBox;
	private JCheckBox atmosphereDensityCheckBox;
	private JCheckBox lightDensityCheckBox;
	private JCheckBox dayHoursCheckBox;
	private JCheckBox nightHoursCheckBox;
	private JCheckBox fogIntensityPercentageDayCheckBox;
	private JCheckBox lightColorDayCheckBox;
	private JCheckBox lightColorNightCheckBox;
	private JCheckBox lightColorTwilightCheckBox;
	private JCheckBox ambientColorDayCheckBox;
	private JCheckBox ambientColorNightCheckBox;
	private JCheckBox ambientColorTwilightCheckBox;
	private JCheckBox horizonColorDayCheckBox;
	private JCheckBox horizonColorNightCheckBox;
	private JCheckBox horizonColorTwilightCheckBox;
	private JCheckBox skyColorDayCheckBox;
	private JCheckBox skyColorNightCheckBox;
	private JCheckBox skyColorTwilightCheckBox;
	private JSpinner fogIntensityPercentageTwilightSpinner;
	private JSpinner fogIntensityPercentageNightSpinner;
	private JCheckBox fogIntensityPercentageNightCheckBox;
	private JCheckBox fogIntensityPercentageTwilightCheckBox;
	private JCheckBox environmentCheckBox;
	private JCheckBox sunCheckBox;
	private JCheckBox backdropsCheckBox;
	private JCheckBox hslFlat1CheckBox;
	private JCheckBox backdropScaleCheckBox;
	private JCheckBox heightMultiplierPercentageCheckBox;
	private JSpinner heightMultiplierPercentageSpinner;
	private JCheckBox craterDensityPercentageCheckBox;
	private JSpinner craterDensityPercentageSpinner;
	private JCheckBox distantHeightOffsetPercentageCheckBox;
	private JSpinner distantHeightOffsetPercentageSpinner;
	private JCheckBox liquidPercentageCheckBox;
	private JSpinner liquidPercentageSpinner;
	private JSpinner xSpinner;
	private JSpinner ySpinner;
	private JSpinner zSpinner;
	private JSpinner heightOffsetSpinner;
	private JCheckBox heightOffsetCheckBox;
	private JCheckBox liquidColorCheckBox;
	private JCheckBox ttFlat1CheckBox;
	private JSpinner timeLimitSpinner;
	private JSpinner survivalTimeSpinner;
	private JSpinner reachWelfareSpinner;
	private JSpinner reachPrestigeSpinner;
	private JSpinner reachBotsSpinner;
	private JSpinner reachPopulationSpinner;
	private JCheckBox reachPopulationCheckBox;
	private JCheckBox reachBotsCheckBox;
	private JCheckBox reachPrestigeCheckBox;
	private JCheckBox reachWelfareCheckBox;
	private JCheckBox survivalTimeCheckBox;
	private JCheckBox timeLimitCheckBox;
	
	private Challenge _CC;
	private JSpinner startBioplasticSpinner;
	private JSpinner startCoinsSpinner;
	private JTextArea missionDescriptionTextArea;
	private JCheckBox tradingShipFrequencyCheckBox;
	private JLabel xLabel;
	private JLabel yLabel;
	private JLabel zLabel;
	
	private File selectedFile;
	
	private JMenuItem mntmSaveChallenge;
	private JTextField colonyNameField;
	private JTextArea objectiveDoneTextArea;
	private JTextField objectiveDescriptionField;
	private JTextField ttFlat2Field;
	private JTextField hslFlat2Field;
	private JTextField ttSlopeField;
	private JTextField hslSlopeField;
	private JTextField ttFoundationsField;
	private JTextField hslFoundationsField;
	private JTextField detailRocksField;
	private JTextField centralRocksField;
	private JTextField sideRocksField;
	private JCheckBox ttFlat2CheckBox;
	private JCheckBox ttSlopeCheckBox;
	private JCheckBox ttFoundationsCheckBox;
	private JCheckBox hslSlopeCheckBox;
	private JCheckBox hslFoundationsCheckBox;
	private JCheckBox detailRocksCheckBox;
	private JCheckBox centralRocksCheckBox;
	private JCheckBox sideRocksCheckBox;
	private JCheckBox hslFlat2CheckBox;
	
	private About aboutDialog;
	private JSpinner startGuardSpinner;
	private JLabel lblGuard;
	private JTextField languageField;
	private JCheckBox languageCheckBox;
	
	private String lastSaveToPath;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public EditorWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		editorFrame = new JFrame();
		editorFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exitMenu();
			}
		});
		editorFrame.setResizable(false);
		editorFrame.setTitle("Plentbase Challenge Editor ["+PBCE._VERSION_STRING+"]");
		editorFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(EditorWindow.class.getResource("/ie/provector/jpbce/icons/icon16.png")));
		editorFrame.setBounds(100, 100, 724, 658);
		editorFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		editorFrame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSaveas = new JMenuItem("Save Editor File As...");
		mntmSaveas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveEditorFileAs();				
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Load Editor File...");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadEditorFileMenu();
			}
		});
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		mnFile.add(mntmNew);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmSaveChallengeAs = new JMenuItem("Save Challenge To...");
		mntmSaveChallengeAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveChallengeToMenu();
			}
		});
		
		mntmSaveChallenge = new JMenuItem("Save Challenge");
		mntmSaveChallenge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveChallengeMenu();
			}
		});
		mnFile.add(mntmSaveChallenge);
		mnFile.add(mntmSaveChallengeAs);
		
		JSeparator separator_2 = new JSeparator();
		mnFile.add(separator_2);
		mnFile.add(mntmNewMenuItem_1);
		
		JMenuItem mntmSaveEditorFile = new JMenuItem("Save Editor File");
		mntmSaveEditorFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveEditorFileMenu();
			}
		});
		mnFile.add(mntmSaveEditorFile);
		mnFile.add(mntmSaveas);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exitMenu();
			}
		});
		mnFile.add(mntmNewMenuItem);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(aboutDialog==null) {
					aboutDialog = new About();
					aboutDialog.setLocationRelativeTo(editorFrame);
					aboutDialog.setModal(true);
					aboutDialog.setVisible(true);
				}else {
					aboutDialog.setLocationRelativeTo(editorFrame);
					aboutDialog.setModal(true);
					aboutDialog.setVisible(true);
				}
			}
		});
		mnHelp.add(mntmAbout);
		
		componentsBox = new JComboBox<>();
		componentsBox.setModel(new DefaultComboBoxModel<String>(Entities.AllComponentsString));
		
		resourcesBox = new JComboBox<>();
		resourcesBox.setModel(new DefaultComboBoxModel<String>(Entities.ResourcesString));
		
		specializationsBox = new JComboBox<>();
		specializationsBox.setModel(new DefaultComboBoxModel<String>(Entities.SpecializationsString));
		
		infoField = new JTextField();
		infoField.setText("Just Initialized. Welcome and thank you for using :) If you like this editor please consider donating a cup of coffee.");
		infoField.setEnabled(false);
		infoField.setEditable(false);
		editorFrame.getContentPane().add(infoField, BorderLayout.SOUTH);
		infoField.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFocusCycleRoot(true);
		tabbedPane.setDoubleBuffered(true);
		editorFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JInternalFrame internalFrame = new JInternalFrame("General Settings");
		internalFrame.setFrameIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/settings16.png")));
		tabbedPane.addTab("General", null, internalFrame, null);
		SpringLayout springLayout = new SpringLayout();
		internalFrame.getContentPane().setLayout(springLayout);
		
		JLabel lblChallengeName = new JLabel("Challenge Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblChallengeName, 10, SpringLayout.NORTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblChallengeName, 10, SpringLayout.WEST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(lblChallengeName);
		
		challengeNameField = new JTextField();
		challengeNameField.setText("jPBCE Editor Challenge");
		springLayout.putConstraint(SpringLayout.WEST, challengeNameField, 6, SpringLayout.EAST, lblChallengeName);
		challengeNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String text = challengeNameField.getText();
				challengeFilenameField.setText("challenge_"+text.replaceAll(" ","_")+".xml");
			}
		});
		internalFrame.getContentPane().add(challengeNameField);
		challengeNameField.setColumns(10);
		
		challengeFilenameField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, challengeNameField, -10, SpringLayout.WEST, challengeFilenameField);
		springLayout.putConstraint(SpringLayout.NORTH, challengeFilenameField, 10, SpringLayout.NORTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, challengeFilenameField, 342, SpringLayout.WEST, internalFrame.getContentPane());
		challengeFilenameField.setEnabled(false);
		challengeFilenameField.setEditable(false);
		challengeFilenameField.setText("challenge_jpbce_editor_challenge.xml");
		challengeFilenameField.setColumns(10);
		internalFrame.getContentPane().add(challengeFilenameField);
		
		difficultyComboBox = new JComboBox<>();
		springLayout.putConstraint(SpringLayout.SOUTH, challengeNameField, -6, SpringLayout.NORTH, difficultyComboBox);
		springLayout.putConstraint(SpringLayout.EAST, difficultyComboBox, -378, SpringLayout.EAST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, difficultyComboBox, 36, SpringLayout.NORTH, internalFrame.getContentPane());
		difficultyComboBox.setModel(new DefaultComboBoxModel<String>(Entities.DifficultyString));
		internalFrame.getContentPane().add(difficultyComboBox);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		springLayout.putConstraint(SpringLayout.WEST, difficultyComboBox, 6, SpringLayout.EAST, lblDifficulty);
		springLayout.putConstraint(SpringLayout.NORTH, lblDifficulty, 12, SpringLayout.SOUTH, lblChallengeName);
		springLayout.putConstraint(SpringLayout.EAST, lblDifficulty, 0, SpringLayout.EAST, lblChallengeName);
		internalFrame.getContentPane().add(lblDifficulty);
		
		planetClassComboBox = new JComboBox<>();
		springLayout.putConstraint(SpringLayout.NORTH, planetClassComboBox, 6, SpringLayout.SOUTH, difficultyComboBox);
		planetClassComboBox.setModel(new DefaultComboBoxModel<>(PlanetClass.values()));
		internalFrame.getContentPane().add(planetClassComboBox);
		
		JLabel lblPlanetClass = new JLabel("Planet Class:");
		springLayout.putConstraint(SpringLayout.WEST, planetClassComboBox, 6, SpringLayout.EAST, lblPlanetClass);
		springLayout.putConstraint(SpringLayout.NORTH, lblPlanetClass, 10, SpringLayout.SOUTH, lblDifficulty);
		springLayout.putConstraint(SpringLayout.EAST, lblPlanetClass, 0, SpringLayout.EAST, lblChallengeName);
		internalFrame.getContentPane().add(lblPlanetClass);
		
		latitudeSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.EAST, challengeFilenameField, 131, SpringLayout.EAST, latitudeSpinner);
		springLayout.putConstraint(SpringLayout.NORTH, latitudeSpinner, -1, SpringLayout.NORTH, planetClassComboBox);
		springLayout.putConstraint(SpringLayout.WEST, latitudeSpinner, 517, SpringLayout.WEST, internalFrame.getContentPane());
		latitudeSpinner.setModel(new SpinnerNumberModel(0, -180, 180, 1));
		internalFrame.getContentPane().add(latitudeSpinner);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		springLayout.putConstraint(SpringLayout.EAST, planetClassComboBox, -130, SpringLayout.WEST, lblLatitude);
		springLayout.putConstraint(SpringLayout.NORTH, lblLatitude, 2, SpringLayout.NORTH, planetClassComboBox);
		springLayout.putConstraint(SpringLayout.EAST, lblLatitude, -6, SpringLayout.WEST, latitudeSpinner);
		internalFrame.getContentPane().add(lblLatitude);
		
		JLabel lblLongtitude = new JLabel("Longtitude:");
		springLayout.putConstraint(SpringLayout.EAST, latitudeSpinner, -6, SpringLayout.WEST, lblLongtitude);
		springLayout.putConstraint(SpringLayout.NORTH, lblLongtitude, 2, SpringLayout.NORTH, planetClassComboBox);
		internalFrame.getContentPane().add(lblLongtitude);
		
		longtitudeSpinner = new JSpinner();
		longtitudeSpinner.setModel(new SpinnerNumberModel(0, -180, 180, 1));
		springLayout.putConstraint(SpringLayout.WEST, longtitudeSpinner, 644, SpringLayout.WEST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, longtitudeSpinner, -10, SpringLayout.EAST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblLongtitude, -6, SpringLayout.WEST, longtitudeSpinner);
		springLayout.putConstraint(SpringLayout.NORTH, longtitudeSpinner, -1, SpringLayout.NORTH, planetClassComboBox);
		internalFrame.getContentPane().add(longtitudeSpinner);
		
		JLabel lblStartingSpecializations = new JLabel("STARTING SPECIALIZATIONS:");
		springLayout.putConstraint(SpringLayout.NORTH, lblStartingSpecializations, 18, SpringLayout.SOUTH, lblPlanetClass);
		springLayout.putConstraint(SpringLayout.WEST, lblStartingSpecializations, 0, SpringLayout.WEST, lblChallengeName);
		internalFrame.getContentPane().add(lblStartingSpecializations);
		
		JLabel lblWorker = new JLabel("Worker:");
		springLayout.putConstraint(SpringLayout.NORTH, lblWorker, 6, SpringLayout.SOUTH, lblStartingSpecializations);
		springLayout.putConstraint(SpringLayout.EAST, lblWorker, -596, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(lblWorker);
		
		JLabel lblBiologist = new JLabel("Biologist:");
		springLayout.putConstraint(SpringLayout.NORTH, lblBiologist, 15, SpringLayout.SOUTH, lblWorker);
		springLayout.putConstraint(SpringLayout.WEST, lblBiologist, 52, SpringLayout.WEST, lblChallengeName);
		springLayout.putConstraint(SpringLayout.EAST, lblBiologist, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblBiologist);
		
		JLabel lblEngineer = new JLabel("Engineer:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEngineer, 12, SpringLayout.SOUTH, lblBiologist);
		springLayout.putConstraint(SpringLayout.EAST, lblEngineer, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblEngineer);
		
		JLabel lblMedic = new JLabel("Medic:");
		springLayout.putConstraint(SpringLayout.NORTH, lblMedic, 12, SpringLayout.SOUTH, lblEngineer);
		springLayout.putConstraint(SpringLayout.EAST, lblMedic, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblMedic);
		
		startWorkerSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, startWorkerSpinner, 6, SpringLayout.SOUTH, lblStartingSpecializations);
		springLayout.putConstraint(SpringLayout.WEST, startWorkerSpinner, 120, SpringLayout.WEST, internalFrame.getContentPane());
		startWorkerSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		internalFrame.getContentPane().add(startWorkerSpinner);
		
		startBiologistSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, startBiologistSpinner, 6, SpringLayout.SOUTH, startWorkerSpinner);
		springLayout.putConstraint(SpringLayout.EAST, startBiologistSpinner, -531, SpringLayout.EAST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, startWorkerSpinner, 0, SpringLayout.EAST, startBiologistSpinner);
		springLayout.putConstraint(SpringLayout.WEST, startBiologistSpinner, 120, SpringLayout.WEST, internalFrame.getContentPane());
		startBiologistSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		internalFrame.getContentPane().add(startBiologistSpinner);
		
		startEngineerSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, startEngineerSpinner, 6, SpringLayout.SOUTH, startBiologistSpinner);
		springLayout.putConstraint(SpringLayout.WEST, startEngineerSpinner, 120, SpringLayout.WEST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, startEngineerSpinner, -531, SpringLayout.EAST, internalFrame.getContentPane());
		startEngineerSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		internalFrame.getContentPane().add(startEngineerSpinner);
		
		startMedicSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, startMedicSpinner, 6, SpringLayout.SOUTH, startEngineerSpinner);
		springLayout.putConstraint(SpringLayout.WEST, startMedicSpinner, 120, SpringLayout.WEST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, startMedicSpinner, -531, SpringLayout.EAST, internalFrame.getContentPane());
		startMedicSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		internalFrame.getContentPane().add(startMedicSpinner);
		
		startConstructorSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, startConstructorSpinner, -3, SpringLayout.NORTH, lblWorker);
		startConstructorSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		internalFrame.getContentPane().add(startConstructorSpinner);
		
		JLabel lblConstructorBot = new JLabel("Constructor Bot:");
		springLayout.putConstraint(SpringLayout.WEST, startConstructorSpinner, 7, SpringLayout.EAST, lblConstructorBot);
		springLayout.putConstraint(SpringLayout.NORTH, lblConstructorBot, 0, SpringLayout.NORTH, lblWorker);
		springLayout.putConstraint(SpringLayout.EAST, lblConstructorBot, 0, SpringLayout.EAST, challengeNameField);
		internalFrame.getContentPane().add(lblConstructorBot);
		
		JLabel lblCarrierBot = new JLabel("Carrier Bot:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCarrierBot, 0, SpringLayout.NORTH, lblBiologist);
		springLayout.putConstraint(SpringLayout.EAST, lblCarrierBot, 0, SpringLayout.EAST, challengeNameField);
		internalFrame.getContentPane().add(lblCarrierBot);
		
		JLabel lblDrillerBot = new JLabel("Driller Bot:");
		springLayout.putConstraint(SpringLayout.NORTH, lblDrillerBot, 0, SpringLayout.NORTH, lblEngineer);
		springLayout.putConstraint(SpringLayout.EAST, lblDrillerBot, 0, SpringLayout.EAST, challengeNameField);
		internalFrame.getContentPane().add(lblDrillerBot);
		
		startCarrierSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, startCarrierSpinner, -3, SpringLayout.NORTH, lblBiologist);
		springLayout.putConstraint(SpringLayout.WEST, startCarrierSpinner, 7, SpringLayout.EAST, lblCarrierBot);
		startCarrierSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		internalFrame.getContentPane().add(startCarrierSpinner);
		
		startDrillerSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.WEST, startDrillerSpinner, 7, SpringLayout.EAST, lblDrillerBot);
		startDrillerSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		springLayout.putConstraint(SpringLayout.NORTH, startDrillerSpinner, -3, SpringLayout.NORTH, lblEngineer);
		internalFrame.getContentPane().add(startDrillerSpinner);
		
		JLabel lblStartingResources = new JLabel("STARTING RESOURCES:");
		springLayout.putConstraint(SpringLayout.NORTH, lblStartingResources, 24, SpringLayout.SOUTH, startMedicSpinner);
		springLayout.putConstraint(SpringLayout.EAST, lblStartingResources, 0, SpringLayout.EAST, lblStartingSpecializations);
		internalFrame.getContentPane().add(lblStartingResources);
		
		startMetalSpinner = new JSpinner();
		startMetalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		springLayout.putConstraint(SpringLayout.NORTH, startMetalSpinner, 6, SpringLayout.SOUTH, lblStartingResources);
		springLayout.putConstraint(SpringLayout.WEST, startMetalSpinner, 120, SpringLayout.WEST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, startMetalSpinner, -531, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(startMetalSpinner);
		
		startBioplasticSpinner = new JSpinner();
		startBioplasticSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		springLayout.putConstraint(SpringLayout.NORTH, startBioplasticSpinner, 6, SpringLayout.SOUTH, startMetalSpinner);
		springLayout.putConstraint(SpringLayout.EAST, startBioplasticSpinner, -531, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(startBioplasticSpinner);
		
		startMealSpinner = new JSpinner();
		startMealSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		springLayout.putConstraint(SpringLayout.NORTH, startMealSpinner, 6, SpringLayout.SOUTH, startBioplasticSpinner);
		springLayout.putConstraint(SpringLayout.EAST, startMealSpinner, -531, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(startMealSpinner);
		
		startSparesSpinner = new JSpinner();
		startSparesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		springLayout.putConstraint(SpringLayout.NORTH, startSparesSpinner, 6, SpringLayout.SOUTH, startMealSpinner);
		springLayout.putConstraint(SpringLayout.EAST, startSparesSpinner, -531, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(startSparesSpinner);
		
		startMedicalSuppliesSpinner = new JSpinner();
		startMedicalSuppliesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		springLayout.putConstraint(SpringLayout.NORTH, startMedicalSuppliesSpinner, 6, SpringLayout.SOUTH, startSparesSpinner);
		springLayout.putConstraint(SpringLayout.EAST, startMedicalSuppliesSpinner, -531, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(startMedicalSuppliesSpinner);
		
		JLabel lblMetial = new JLabel("Metal:");
		springLayout.putConstraint(SpringLayout.EAST, lblMetial, -596, SpringLayout.EAST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblMetial, 3, SpringLayout.NORTH, startMetalSpinner);
		internalFrame.getContentPane().add(lblMetial);
		
		JLabel lblBioplastic = new JLabel("Bioplastic:");
		springLayout.putConstraint(SpringLayout.WEST, startBioplasticSpinner, 6, SpringLayout.EAST, lblBioplastic);
		springLayout.putConstraint(SpringLayout.NORTH, lblBioplastic, 3, SpringLayout.NORTH, startBioplasticSpinner);
		springLayout.putConstraint(SpringLayout.EAST, lblBioplastic, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblBioplastic);
		
		JLabel lblMeal = new JLabel("Meal:");
		springLayout.putConstraint(SpringLayout.WEST, startMealSpinner, 6, SpringLayout.EAST, lblMeal);
		springLayout.putConstraint(SpringLayout.NORTH, lblMeal, 3, SpringLayout.NORTH, startMealSpinner);
		springLayout.putConstraint(SpringLayout.EAST, lblMeal, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblMeal);
		
		JLabel lblSpares = new JLabel("Spares:");
		springLayout.putConstraint(SpringLayout.WEST, startSparesSpinner, 6, SpringLayout.EAST, lblSpares);
		springLayout.putConstraint(SpringLayout.NORTH, lblSpares, 3, SpringLayout.NORTH, startSparesSpinner);
		springLayout.putConstraint(SpringLayout.EAST, lblSpares, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblSpares);
		
		JLabel lblMedical = new JLabel("Medical:");
		springLayout.putConstraint(SpringLayout.WEST, startMedicalSuppliesSpinner, 6, SpringLayout.EAST, lblMedical);
		springLayout.putConstraint(SpringLayout.NORTH, lblMedical, 3, SpringLayout.NORTH, startMedicalSuppliesSpinner);
		springLayout.putConstraint(SpringLayout.EAST, lblMedical, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblMedical);
		
		startCoinsSpinner = new JSpinner();
		startCoinsSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		springLayout.putConstraint(SpringLayout.NORTH, startCoinsSpinner, 6, SpringLayout.SOUTH, startMedicalSuppliesSpinner);
		springLayout.putConstraint(SpringLayout.EAST, startCoinsSpinner, -531, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(startCoinsSpinner);
		
		startSemiconductorsSpinner = new JSpinner();
		startSemiconductorsSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		springLayout.putConstraint(SpringLayout.NORTH, startSemiconductorsSpinner, 6, SpringLayout.SOUTH, startCoinsSpinner);
		springLayout.putConstraint(SpringLayout.EAST, startSemiconductorsSpinner, -531, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(startSemiconductorsSpinner);
		
		startGunSpinner = new JSpinner();
		startGunSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		springLayout.putConstraint(SpringLayout.NORTH, startGunSpinner, 6, SpringLayout.SOUTH, startSemiconductorsSpinner);
		springLayout.putConstraint(SpringLayout.WEST, startGunSpinner, 120, SpringLayout.WEST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, startGunSpinner, 0, SpringLayout.EAST, startWorkerSpinner);
		internalFrame.getContentPane().add(startGunSpinner);
		
		JLabel lblCredits = new JLabel("Credits:");
		springLayout.putConstraint(SpringLayout.WEST, startCoinsSpinner, 6, SpringLayout.EAST, lblCredits);
		springLayout.putConstraint(SpringLayout.NORTH, lblCredits, 3, SpringLayout.NORTH, startCoinsSpinner);
		springLayout.putConstraint(SpringLayout.EAST, lblCredits, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblCredits);
		
		JLabel lblSemiconductors = new JLabel("Semiconductors:");
		springLayout.putConstraint(SpringLayout.WEST, startSemiconductorsSpinner, 6, SpringLayout.EAST, lblSemiconductors);
		springLayout.putConstraint(SpringLayout.NORTH, lblSemiconductors, 3, SpringLayout.NORTH, startSemiconductorsSpinner);
		springLayout.putConstraint(SpringLayout.EAST, lblSemiconductors, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblSemiconductors);
		
		JLabel lblGuns = new JLabel("Guns:");
		springLayout.putConstraint(SpringLayout.NORTH, lblGuns, 12, SpringLayout.SOUTH, lblSemiconductors);
		springLayout.putConstraint(SpringLayout.EAST, lblGuns, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblGuns);
		
		startAlcoholicDrinkSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, startAlcoholicDrinkSpinner, 6, SpringLayout.SOUTH, startGunSpinner);
		springLayout.putConstraint(SpringLayout.EAST, startAlcoholicDrinkSpinner, 0, SpringLayout.EAST, startWorkerSpinner);
		startAlcoholicDrinkSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		internalFrame.getContentPane().add(startAlcoholicDrinkSpinner);
		
		JLabel lblAlcohol = new JLabel("Alcohol:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAlcohol, 12, SpringLayout.SOUTH, lblGuns);
		springLayout.putConstraint(SpringLayout.WEST, startAlcoholicDrinkSpinner, 6, SpringLayout.EAST, lblAlcohol);
		springLayout.putConstraint(SpringLayout.EAST, lblAlcohol, 0, SpringLayout.EAST, lblWorker);
		internalFrame.getContentPane().add(lblAlcohol);
		
		JLabel lblHazards = new JLabel("HAZARDS RISK:");
		springLayout.putConstraint(SpringLayout.NORTH, lblHazards, 0, SpringLayout.NORTH, lblStartingSpecializations);
		springLayout.putConstraint(SpringLayout.EAST, lblHazards, -188, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(lblHazards);
		
		JLabel lblSandstormRisk = new JLabel("");
		springLayout.putConstraint(SpringLayout.EAST, startConstructorSpinner, -161, SpringLayout.WEST, lblSandstormRisk);
		springLayout.putConstraint(SpringLayout.NORTH, lblSandstormRisk, 0, SpringLayout.NORTH, lblWorker);
		internalFrame.getContentPane().add(lblSandstormRisk);
		
		sandstormRiskComboBox = new JComboBox<>();
		sandstormRiskComboBox.setEnabled(false);
		sandstormRiskComboBox.setToolTipText("Specifies the risk of sandstorms ");
		springLayout.putConstraint(SpringLayout.WEST, sandstormRiskComboBox, 558, SpringLayout.WEST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, sandstormRiskComboBox, -10, SpringLayout.EAST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblSandstormRisk, -6, SpringLayout.WEST, sandstormRiskComboBox);
		springLayout.putConstraint(SpringLayout.NORTH, sandstormRiskComboBox, -2, SpringLayout.NORTH, lblWorker);
		sandstormRiskComboBox.setModel(new DefaultComboBoxModel<>(NLHLevel.values()));
		internalFrame.getContentPane().add(sandstormRiskComboBox);
		
		meteorRiskComboBox = new JComboBox<>();
		meteorRiskComboBox.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, meteorRiskComboBox, 558, SpringLayout.WEST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, meteorRiskComboBox, -10, SpringLayout.EAST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, startCarrierSpinner, -167, SpringLayout.WEST, meteorRiskComboBox);
		meteorRiskComboBox.setToolTipText("Specifies the risk of meteors ");
		meteorRiskComboBox.setModel(new DefaultComboBoxModel<>(NLHLevel.values()));
		internalFrame.getContentPane().add(meteorRiskComboBox);
		
		solareFlareRiskComboBox = new JComboBox<>();
		solareFlareRiskComboBox.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, solareFlareRiskComboBox, 558, SpringLayout.WEST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, solareFlareRiskComboBox, -10, SpringLayout.EAST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, startDrillerSpinner, -167, SpringLayout.WEST, solareFlareRiskComboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, meteorRiskComboBox, -6, SpringLayout.NORTH, solareFlareRiskComboBox);
		solareFlareRiskComboBox.setModel(new DefaultComboBoxModel<>(NLHLevel.values()));
		internalFrame.getContentPane().add(solareFlareRiskComboBox);
		
		thunderstormRiskComboBox = new JComboBox<>();
		thunderstormRiskComboBox.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, thunderstormRiskComboBox, 167, SpringLayout.EAST, startDrillerSpinner);
		springLayout.putConstraint(SpringLayout.EAST, thunderstormRiskComboBox, -10, SpringLayout.EAST, internalFrame.getContentPane());
		thunderstormRiskComboBox.setToolTipText("Specifies the risk of thunderstorms");
		springLayout.putConstraint(SpringLayout.SOUTH, solareFlareRiskComboBox, -6, SpringLayout.NORTH, thunderstormRiskComboBox);
		thunderstormRiskComboBox.setModel(new DefaultComboBoxModel<>(NLHLevel.values()));
		internalFrame.getContentPane().add(thunderstormRiskComboBox);
		
		JLabel lblEnergySources = new JLabel("ENERGY SOURCES:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEnergySources, 0, SpringLayout.NORTH, lblStartingResources);
		springLayout.putConstraint(SpringLayout.EAST, lblEnergySources, -188, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(lblEnergySources);
		
		atmosphereDensityComboBox = new JComboBox<>();
		atmosphereDensityComboBox.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, atmosphereDensityComboBox, 379, SpringLayout.EAST, startMetalSpinner);
		springLayout.putConstraint(SpringLayout.EAST, atmosphereDensityComboBox, -10, SpringLayout.EAST, internalFrame.getContentPane());
		atmosphereDensityComboBox.setToolTipText("Specifies whether Wind Turbines work properly or not at all in this planet");
		springLayout.putConstraint(SpringLayout.NORTH, atmosphereDensityComboBox, 1, SpringLayout.NORTH, startMetalSpinner);
		atmosphereDensityComboBox.setModel(new DefaultComboBoxModel<>(NLHLevel.values()));
		internalFrame.getContentPane().add(atmosphereDensityComboBox);
		
		lightDensityComboBox = new JComboBox<>();
		lightDensityComboBox.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, lightDensityComboBox, 379, SpringLayout.EAST, startBioplasticSpinner);
		springLayout.putConstraint(SpringLayout.EAST, lightDensityComboBox, -10, SpringLayout.EAST, internalFrame.getContentPane());
		lightDensityComboBox.setToolTipText("Specifies whether Solar Panels work properly or not at all in this planet");
		springLayout.putConstraint(SpringLayout.NORTH, lightDensityComboBox, 1, SpringLayout.NORTH, startBioplasticSpinner);
		lightDensityComboBox.setModel(new DefaultComboBoxModel<>(NLHLevel.values()));
		internalFrame.getContentPane().add(lightDensityComboBox);
		
		blizzardRiskComboBox = new JComboBox<>();
		blizzardRiskComboBox.setEnabled(false);
		blizzardRiskComboBox.setToolTipText("Specifies the risk of blizzards");
		springLayout.putConstraint(SpringLayout.NORTH, blizzardRiskComboBox, 222, SpringLayout.NORTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, blizzardRiskComboBox, -10, SpringLayout.EAST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, thunderstormRiskComboBox, -6, SpringLayout.NORTH, blizzardRiskComboBox);
		blizzardRiskComboBox.setModel(new DefaultComboBoxModel<>(NLHLevel.values()));
		internalFrame.getContentPane().add(blizzardRiskComboBox);
		
		JLabel lblBlizzard = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, blizzardRiskComboBox, 6, SpringLayout.EAST, lblBlizzard);
		springLayout.putConstraint(SpringLayout.NORTH, lblBlizzard, 2, SpringLayout.NORTH, blizzardRiskComboBox);
		springLayout.putConstraint(SpringLayout.EAST, lblBlizzard, 0, SpringLayout.EAST, lblSandstormRisk);
		internalFrame.getContentPane().add(lblBlizzard);
		
		JLabel lblMissionText = new JLabel("MISSION DESCRIPTION TEXT:");
		springLayout.putConstraint(SpringLayout.WEST, lblMissionText, 5, SpringLayout.EAST, startCoinsSpinner);
		internalFrame.getContentPane().add(lblMissionText);
		
		missionDescriptionTextArea = new JTextArea();
		missionDescriptionTextArea.setWrapStyleWord(true);
		springLayout.putConstraint(SpringLayout.SOUTH, lblMissionText, -6, SpringLayout.NORTH, missionDescriptionTextArea);
		springLayout.putConstraint(SpringLayout.NORTH, missionDescriptionTextArea, 428, SpringLayout.NORTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, missionDescriptionTextArea, -9, SpringLayout.SOUTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, missionDescriptionTextArea, 6, SpringLayout.EAST, startSparesSpinner);
		springLayout.putConstraint(SpringLayout.EAST, missionDescriptionTextArea, -10, SpringLayout.EAST, internalFrame.getContentPane());
		missionDescriptionTextArea.setText("Created with jPBCE");
		internalFrame.getContentPane().add(missionDescriptionTextArea);
		
		sandstormRiskCheckBox = new JCheckBox("Sandstorm:");
		sandstormRiskCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sandstormRiskCheckBox.isSelected()) {
					sandstormRiskComboBox.setEnabled(true);
				}else{
					sandstormRiskComboBox.setEnabled(false);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, sandstormRiskCheckBox, -4, SpringLayout.NORTH, lblWorker);
		springLayout.putConstraint(SpringLayout.EAST, sandstormRiskCheckBox, 0, SpringLayout.EAST, lblSandstormRisk);
		sandstormRiskCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame.getContentPane().add(sandstormRiskCheckBox);
		
		meteorRiskCheckBox = new JCheckBox("Meteor:");
		meteorRiskCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(meteorRiskCheckBox.isSelected()) {
					meteorRiskComboBox.setEnabled(true);
				}else{
					meteorRiskComboBox.setEnabled(false);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, meteorRiskCheckBox, -2, SpringLayout.NORTH, meteorRiskComboBox);
		springLayout.putConstraint(SpringLayout.EAST, meteorRiskCheckBox, 0, SpringLayout.EAST, lblSandstormRisk);
		meteorRiskCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame.getContentPane().add(meteorRiskCheckBox);
		
		solareFlareRiskCheckBox = new JCheckBox("Solare Flare:");
		solareFlareRiskCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(solareFlareRiskCheckBox.isSelected()) {
					solareFlareRiskComboBox.setEnabled(true);
				}else{
					solareFlareRiskComboBox.setEnabled(false);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, solareFlareRiskCheckBox, -2, SpringLayout.NORTH, solareFlareRiskComboBox);
		springLayout.putConstraint(SpringLayout.EAST, solareFlareRiskCheckBox, 0, SpringLayout.EAST, lblSandstormRisk);
		solareFlareRiskCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame.getContentPane().add(solareFlareRiskCheckBox);
		
		thunderstormRiskCheckBox = new JCheckBox("Thunderstorm:");
		thunderstormRiskCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(thunderstormRiskCheckBox.isSelected()) {
					thunderstormRiskComboBox.setEnabled(true);
				}else{
					thunderstormRiskComboBox.setEnabled(false);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, thunderstormRiskCheckBox, -2, SpringLayout.NORTH, thunderstormRiskComboBox);
		springLayout.putConstraint(SpringLayout.EAST, thunderstormRiskCheckBox, 0, SpringLayout.EAST, lblSandstormRisk);
		thunderstormRiskCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame.getContentPane().add(thunderstormRiskCheckBox);
		
		blizzardRiskCheckBox = new JCheckBox(" Blizzard:");
		blizzardRiskCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(blizzardRiskCheckBox.isSelected()) {
					blizzardRiskComboBox.setEnabled(true);
				}else{
					blizzardRiskComboBox.setEnabled(false);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, blizzardRiskCheckBox, -6, SpringLayout.NORTH, lblEnergySources);
		springLayout.putConstraint(SpringLayout.EAST, blizzardRiskCheckBox, 0, SpringLayout.EAST, lblSandstormRisk);
		blizzardRiskCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame.getContentPane().add(blizzardRiskCheckBox);
		
		atmosphereDensityCheckBox = new JCheckBox("Atmosphere:");
		atmosphereDensityCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(atmosphereDensityCheckBox.isSelected()) {
					atmosphereDensityComboBox.setEnabled(true);
				}else{
					atmosphereDensityComboBox.setEnabled(false);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, atmosphereDensityCheckBox, -1, SpringLayout.NORTH, startMetalSpinner);
		springLayout.putConstraint(SpringLayout.EAST, atmosphereDensityCheckBox, 0, SpringLayout.EAST, lblSandstormRisk);
		atmosphereDensityCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame.getContentPane().add(atmosphereDensityCheckBox);
		
		lightDensityCheckBox = new JCheckBox("Light:");
		lightDensityCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lightDensityCheckBox.isSelected()) {
					lightDensityComboBox.setEnabled(true);
				}else{
					lightDensityComboBox.setEnabled(false);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, lightDensityCheckBox, -1, SpringLayout.NORTH, startBioplasticSpinner);
		springLayout.putConstraint(SpringLayout.EAST, lightDensityCheckBox, 0, SpringLayout.EAST, lblSandstormRisk);
		lightDensityCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame.getContentPane().add(lightDensityCheckBox);
		
		JLabel lblBaseName = new JLabel("Colony Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblBaseName, 6, SpringLayout.SOUTH, challengeFilenameField);
		springLayout.putConstraint(SpringLayout.WEST, lblBaseName, 0, SpringLayout.WEST, challengeFilenameField);
		internalFrame.getContentPane().add(lblBaseName);
		
		colonyNameField = new JTextField();
		colonyNameField.setText("JPBCE Colony");
		colonyNameField.setToolTipText("Name of your base");
		springLayout.putConstraint(SpringLayout.WEST, colonyNameField, 17, SpringLayout.EAST, lblBaseName);
		springLayout.putConstraint(SpringLayout.SOUTH, colonyNameField, -5, SpringLayout.NORTH, latitudeSpinner);
		springLayout.putConstraint(SpringLayout.EAST, colonyNameField, 1, SpringLayout.EAST, challengeFilenameField);
		internalFrame.getContentPane().add(colonyNameField);
		colonyNameField.setColumns(10);
		
		objectiveDoneTextArea = new JTextArea();
		objectiveDoneTextArea.setText("Made with jPBCE");
		objectiveDoneTextArea.setWrapStyleWord(true);
		objectiveDoneTextArea.setToolTipText("What player will see upon completing objectives");
		springLayout.putConstraint(SpringLayout.NORTH, objectiveDoneTextArea, 3, SpringLayout.NORTH, startMealSpinner);
		springLayout.putConstraint(SpringLayout.WEST, objectiveDoneTextArea, 6, SpringLayout.EAST, startSparesSpinner);
		springLayout.putConstraint(SpringLayout.SOUTH, objectiveDoneTextArea, -25, SpringLayout.SOUTH, startMedicalSuppliesSpinner);
		springLayout.putConstraint(SpringLayout.EAST, objectiveDoneTextArea, 0, SpringLayout.EAST, challengeFilenameField);
		internalFrame.getContentPane().add(objectiveDoneTextArea);
		
		JLabel lblObjectiveCompletedText = new JLabel("OBJECTIVE COMPLETED TEXT:");
		springLayout.putConstraint(SpringLayout.NORTH, lblObjectiveCompletedText, 3, SpringLayout.NORTH, startBioplasticSpinner);
		springLayout.putConstraint(SpringLayout.WEST, lblObjectiveCompletedText, 6, SpringLayout.EAST, startBioplasticSpinner);
		internalFrame.getContentPane().add(lblObjectiveCompletedText);
		
		JLabel lblShortObjectiveDescription = new JLabel("OBJECTIVE DESCRIPTION:");
		lblShortObjectiveDescription.setToolTipText("Keep it short");
		springLayout.putConstraint(SpringLayout.WEST, lblShortObjectiveDescription, 0, SpringLayout.WEST, lblMissionText);
		springLayout.putConstraint(SpringLayout.SOUTH, lblShortObjectiveDescription, 0, SpringLayout.SOUTH, lblStartingResources);
		internalFrame.getContentPane().add(lblShortObjectiveDescription);
		
		objectiveDescriptionField = new JTextField();
		objectiveDescriptionField.setText("Open Ended");
		objectiveDescriptionField.setToolTipText("Keep it short");
		springLayout.putConstraint(SpringLayout.NORTH, objectiveDescriptionField, 6, SpringLayout.SOUTH, lblShortObjectiveDescription);
		springLayout.putConstraint(SpringLayout.WEST, objectiveDescriptionField, 6, SpringLayout.EAST, startMetalSpinner);
		springLayout.putConstraint(SpringLayout.EAST, objectiveDescriptionField, 0, SpringLayout.EAST, startConstructorSpinner);
		internalFrame.getContentPane().add(objectiveDescriptionField);
		objectiveDescriptionField.setColumns(10);
		
		startGuardSpinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.WEST, startGuardSpinner, -3, SpringLayout.WEST, challengeFilenameField);
		springLayout.putConstraint(SpringLayout.SOUTH, startGuardSpinner, 0, SpringLayout.SOUTH, startMedicSpinner);
		springLayout.putConstraint(SpringLayout.EAST, startGuardSpinner, 0, SpringLayout.EAST, startConstructorSpinner);
		internalFrame.getContentPane().add(startGuardSpinner);
		
		lblGuard = new JLabel("Guard:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblGuard, 0, SpringLayout.SOUTH, lblMedic);
		springLayout.putConstraint(SpringLayout.EAST, lblGuard, 0, SpringLayout.EAST, challengeNameField);
		internalFrame.getContentPane().add(lblGuard);
		
		languageCheckBox = new JCheckBox("Generate Additional Langugage Desc File:");
		languageCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(languageCheckBox.isSelected()) {
					languageField.setEnabled(true);
				}else {
					languageField.setEnabled(false);
				}
			}
		});
		languageCheckBox.setToolTipText("If you are using translation please specify two country letter code (IE,US,UK,RU,PL etc.) to generate additional description file");
		springLayout.putConstraint(SpringLayout.NORTH, languageCheckBox, -4, SpringLayout.NORTH, lblMissionText);
		springLayout.putConstraint(SpringLayout.WEST, languageCheckBox, 6, SpringLayout.EAST, lblMissionText);
		languageCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame.getContentPane().add(languageCheckBox);
		
		languageField = new JTextField();
		languageField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(Tools.isAlpha(languageField.getText())==false || (languageField.getText().length()>2)) {
					JOptionPane.showMessageDialog(editorFrame, "Country code can't have more than 2 letters!", "Form validation error",JOptionPane.ERROR_MESSAGE);
					String text = languageField.getText();
					text = text.substring(0,text.length()-1);
					languageField.setText(text);
				}
			}
		});
		languageField.setToolTipText("Here insert two letter country language prefix\\n (PL,IE.UK,RU,IT, etc..)");
		languageField.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, languageField, 275, SpringLayout.EAST, lblMissionText);
		springLayout.putConstraint(SpringLayout.SOUTH, languageField, -4, SpringLayout.NORTH, missionDescriptionTextArea);
		springLayout.putConstraint(SpringLayout.EAST, languageField, -9, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(languageField);
		languageField.setColumns(10);
		
		JInternalFrame internalFrame_4 = new JInternalFrame("Objective Settings");
		internalFrame_4.setFrameIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/objectives16.png")));
		tabbedPane.addTab("Objectives", null, internalFrame_4, null);
		SpringLayout springLayout_4 = new SpringLayout();
		internalFrame_4.getContentPane().setLayout(springLayout_4);
		
		reachPopulationCheckBox = new JCheckBox("Reach Population:");
		reachPopulationCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reachPopulationCheckBox.isSelected()) {
					reachPopulationSpinner.setEnabled(true);
				}else {
					reachPopulationSpinner.setEnabled(false);
				}
			}
		});
		reachPopulationCheckBox.setToolTipText("Reach a certain population. ");
		springLayout_4.putConstraint(SpringLayout.NORTH, reachPopulationCheckBox, 10, SpringLayout.NORTH, internalFrame_4.getContentPane());
		springLayout_4.putConstraint(SpringLayout.WEST, reachPopulationCheckBox, 10, SpringLayout.WEST, internalFrame_4.getContentPane());
		internalFrame_4.getContentPane().add(reachPopulationCheckBox);
		
		survivalTimeSpinner = new JSpinner();
		survivalTimeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		survivalTimeSpinner.setToolTipText("Survive a certain amount of time value: indicates the time in game days.");
		survivalTimeSpinner.setEnabled(false);
		springLayout_4.putConstraint(SpringLayout.EAST, survivalTimeSpinner, 72, SpringLayout.EAST, reachPopulationCheckBox);
		internalFrame_4.getContentPane().add(survivalTimeSpinner);
		
		reachBotsCheckBox = new JCheckBox("Reach Bots:");
		reachBotsCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reachBotsCheckBox.isSelected()) {
					reachBotsSpinner.setEnabled(true);
				}else {
					reachBotsSpinner.setEnabled(false);
				}
			}
		});
		reachBotsCheckBox.setToolTipText("Reach a certain number of bots. ");
		springLayout_4.putConstraint(SpringLayout.NORTH, reachBotsCheckBox, 6, SpringLayout.SOUTH, reachPopulationCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, reachBotsCheckBox, 0, SpringLayout.WEST, reachPopulationCheckBox);
		internalFrame_4.getContentPane().add(reachBotsCheckBox);
		
		reachPrestigeCheckBox = new JCheckBox("Reach Prestige:");
		reachPrestigeCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reachPrestigeCheckBox.isSelected()) {
					reachPrestigeSpinner.setEnabled(true);
				}else {
					reachPrestigeSpinner.setEnabled(false);
				}
			}
		});
		reachPrestigeCheckBox.setToolTipText("Reach a certain prestige.");
		springLayout_4.putConstraint(SpringLayout.NORTH, reachPrestigeCheckBox, 6, SpringLayout.SOUTH, reachBotsCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, reachPrestigeCheckBox, 0, SpringLayout.WEST, reachPopulationCheckBox);
		internalFrame_4.getContentPane().add(reachPrestigeCheckBox);
		
		reachWelfareCheckBox = new JCheckBox("Reach Welfare:");
		reachWelfareCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reachWelfareCheckBox.isSelected()) {
					reachWelfareSpinner.setEnabled(true);
				}else {
					reachWelfareSpinner.setEnabled(false);
				}
			}
		});
		reachWelfareCheckBox.setToolTipText("Reach a certain level of welfare.");
		springLayout_4.putConstraint(SpringLayout.NORTH, reachWelfareCheckBox, 7, SpringLayout.SOUTH, reachPrestigeCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, reachWelfareCheckBox, 0, SpringLayout.WEST, reachPopulationCheckBox);
		internalFrame_4.getContentPane().add(reachWelfareCheckBox);
		
		survivalTimeCheckBox = new JCheckBox("Survival Time (Days):");
		survivalTimeCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(survivalTimeCheckBox.isSelected()) {
					survivalTimeSpinner.setEnabled(true);
				}else {
					survivalTimeSpinner.setEnabled(false);
				}
			}
		});
		survivalTimeCheckBox.setToolTipText("Survive a certain amount of time value: indicates the time in game days.");
		springLayout_4.putConstraint(SpringLayout.NORTH, survivalTimeSpinner, 1, SpringLayout.NORTH, survivalTimeCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, survivalTimeSpinner, 6, SpringLayout.EAST, survivalTimeCheckBox);
		springLayout_4.putConstraint(SpringLayout.NORTH, survivalTimeCheckBox, 6, SpringLayout.SOUTH, reachWelfareCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, survivalTimeCheckBox, 0, SpringLayout.WEST, reachPopulationCheckBox);
		internalFrame_4.getContentPane().add(survivalTimeCheckBox);
		
		timeLimitCheckBox = new JCheckBox("Time Limit (Days):");
		timeLimitCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(timeLimitCheckBox.isSelected()) {
					timeLimitSpinner.setEnabled(true);
				}else {
					timeLimitSpinner.setEnabled(false);
				}
			}
		});
		timeLimitCheckBox.setToolTipText("Specifies a time limit for the challenge. value: indicates the time in game days.");
		springLayout_4.putConstraint(SpringLayout.NORTH, timeLimitCheckBox, 6, SpringLayout.SOUTH, survivalTimeCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, timeLimitCheckBox, 0, SpringLayout.WEST, reachPopulationCheckBox);
		internalFrame_4.getContentPane().add(timeLimitCheckBox);
		
		timeLimitSpinner = new JSpinner();
		timeLimitSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		timeLimitSpinner.setToolTipText("Specifies a time limit for the challenge. value: indicates the time in game days.");
		timeLimitSpinner.setEnabled(false);
		springLayout_4.putConstraint(SpringLayout.WEST, timeLimitSpinner, 0, SpringLayout.WEST, survivalTimeSpinner);
		springLayout_4.putConstraint(SpringLayout.SOUTH, timeLimitSpinner, 0, SpringLayout.SOUTH, timeLimitCheckBox);
		springLayout_4.putConstraint(SpringLayout.EAST, timeLimitSpinner, 0, SpringLayout.EAST, survivalTimeSpinner);
		internalFrame_4.getContentPane().add(timeLimitSpinner);
		
		reachWelfareSpinner = new JSpinner();
		reachWelfareSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		reachWelfareSpinner.setToolTipText("Reach a certain level of welfare. value: indicates the amount, in the range [0, 100]");
		reachWelfareSpinner.setEnabled(false);
		springLayout_4.putConstraint(SpringLayout.NORTH, reachWelfareSpinner, 0, SpringLayout.NORTH, reachWelfareCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, reachWelfareSpinner, 0, SpringLayout.WEST, survivalTimeSpinner);
		springLayout_4.putConstraint(SpringLayout.EAST, reachWelfareSpinner, 0, SpringLayout.EAST, survivalTimeSpinner);
		internalFrame_4.getContentPane().add(reachWelfareSpinner);
		
		reachPrestigeSpinner = new JSpinner();
		reachPrestigeSpinner.setToolTipText("Reach a certain prestige.");
		reachPrestigeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		reachPrestigeSpinner.setEnabled(false);
		springLayout_4.putConstraint(SpringLayout.NORTH, reachPrestigeSpinner, 0, SpringLayout.NORTH, reachPrestigeCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, reachPrestigeSpinner, 0, SpringLayout.WEST, survivalTimeSpinner);
		springLayout_4.putConstraint(SpringLayout.EAST, reachPrestigeSpinner, 0, SpringLayout.EAST, survivalTimeSpinner);
		internalFrame_4.getContentPane().add(reachPrestigeSpinner);
		
		reachBotsSpinner = new JSpinner();
		reachBotsSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		reachBotsSpinner.setToolTipText("Reach a certain number of bots. ");
		reachBotsSpinner.setEnabled(false);
		springLayout_4.putConstraint(SpringLayout.NORTH, reachBotsSpinner, 0, SpringLayout.NORTH, reachBotsCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, reachBotsSpinner, 0, SpringLayout.WEST, survivalTimeSpinner);
		springLayout_4.putConstraint(SpringLayout.EAST, reachBotsSpinner, 0, SpringLayout.EAST, survivalTimeSpinner);
		internalFrame_4.getContentPane().add(reachBotsSpinner);
		
		reachPopulationSpinner = new JSpinner();
		reachPopulationSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		reachPopulationSpinner.setToolTipText("Reach a certain population. ");
		reachPopulationSpinner.setEnabled(false);
		springLayout_4.putConstraint(SpringLayout.NORTH, reachPopulationSpinner, 0, SpringLayout.NORTH, reachPopulationCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, reachPopulationSpinner, 0, SpringLayout.WEST, survivalTimeSpinner);
		springLayout_4.putConstraint(SpringLayout.EAST, reachPopulationSpinner, 0, SpringLayout.EAST, survivalTimeSpinner);
		internalFrame_4.getContentPane().add(reachPopulationSpinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Accumulate a certain amount of resources. param: indicates the type of resource. value: indicates the amount.\t\t ");
		springLayout_4.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, internalFrame_4.getContentPane());
		springLayout_4.putConstraint(SpringLayout.SOUTH, scrollPane, -199, SpringLayout.SOUTH, internalFrame_4.getContentPane());
		springLayout_4.putConstraint(SpringLayout.EAST, scrollPane, -373, SpringLayout.EAST, internalFrame_4.getContentPane());
		internalFrame_4.getContentPane().add(scrollPane);
		
		JLabel lblAccumulateResources = new JLabel("Accumulate Resources:");
		springLayout_4.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblAccumulateResources);
		springLayout_4.putConstraint(SpringLayout.NORTH, lblAccumulateResources, 6, SpringLayout.SOUTH, timeLimitCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, lblAccumulateResources, 0, SpringLayout.WEST, reachPopulationCheckBox);
		
		resourcesTable = new JTable();
		resourcesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		resourcesTable.setModel(new DefaultTableModel(
			null,
			new String[] {
				"Resource", "Amount"
			}
		) {
			Class<?>[] columnTypes = new Class[] {
				Object.class, Integer.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		resourcesTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(resourcesBox));
		
		scrollPane.setViewportView(resourcesTable);
		internalFrame_4.getContentPane().add(lblAccumulateResources);
		
		JLabel lblBuildStructures = new JLabel("Build Structures:");
		springLayout_4.putConstraint(SpringLayout.NORTH, lblBuildStructures, 4, SpringLayout.NORTH, reachPopulationCheckBox);
		springLayout_4.putConstraint(SpringLayout.WEST, lblBuildStructures, 14, SpringLayout.EAST, reachPopulationSpinner);
		internalFrame_4.getContentPane().add(lblBuildStructures);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("<html>Build a certain amount of structures. param: indicates the type of structure. <br> nvalue: indicates the amount. size: indicates the size of the structures to be built,<br> means any size, values in the range [1, 5] indicate a particular size. </html>");
		springLayout_4.putConstraint(SpringLayout.NORTH, scrollPane_1, 6, SpringLayout.SOUTH, lblBuildStructures);
		springLayout_4.putConstraint(SpringLayout.WEST, scrollPane_1, 14, SpringLayout.EAST, survivalTimeSpinner);
		springLayout_4.putConstraint(SpringLayout.SOUTH, scrollPane_1, 0, SpringLayout.SOUTH, timeLimitCheckBox);
		springLayout_4.putConstraint(SpringLayout.EAST, scrollPane_1, -10, SpringLayout.EAST, internalFrame_4.getContentPane());
		internalFrame_4.getContentPane().add(scrollPane_1);
		
		structuresTable = new JTable();
		structuresTable.setModel(new DefaultTableModel(
			null,
			new String[] {
				"Structure", "Size", "Number"
			}
		) {
			Class<?>[] columnTypes = new Class[] {
				Object.class, Integer.class, Object.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		TableColumn structuresColumn = structuresTable.getColumnModel().getColumn(0);
		scrollPane_1.setViewportView(structuresTable);
		TableColumn sizeColumn = structuresTable.getColumnModel().getColumn(1);
		
		JLabel lblBuildComponents = new JLabel("Build Components:");
		springLayout_4.putConstraint(SpringLayout.NORTH, lblBuildComponents, 0, SpringLayout.NORTH, lblAccumulateResources);
		internalFrame_4.getContentPane().add(lblBuildComponents);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		springLayout_4.putConstraint(SpringLayout.WEST, lblBuildComponents, 0, SpringLayout.WEST, scrollPane_2);
		
				scrollPane_2.setToolTipText("\t\t\tBuild a certain amount of components. param: indicates the type of component. value: indicates the amount.");
				springLayout_4.putConstraint(SpringLayout.WEST, scrollPane_2, 10, SpringLayout.EAST, scrollPane);
				springLayout_4.putConstraint(SpringLayout.EAST, scrollPane_2, -10, SpringLayout.EAST, internalFrame_4.getContentPane());
				internalFrame_4.getContentPane().add(scrollPane_2);
				
				componentsTable = new JTable();
				componentsTable.setModel(new DefaultTableModel(
					null,
					new String[] {
						"Component", "Amount"
					}
				) {
					Class<?>[] columnTypes = new Class[] {
						Object.class, Integer.class
					};
					public Class<?> getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				componentsTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(componentsBox));
				
				scrollPane_2.setViewportView(componentsTable);
				
				JLabel lblKeepCharacterAlive = new JLabel("Keep Character Alive:");
				springLayout_4.putConstraint(SpringLayout.NORTH, lblKeepCharacterAlive, 6, SpringLayout.SOUTH, scrollPane);
				springLayout_4.putConstraint(SpringLayout.WEST, lblKeepCharacterAlive, 0, SpringLayout.WEST, reachPopulationCheckBox);
				internalFrame_4.getContentPane().add(lblKeepCharacterAlive);
				
				JLabel lblReachSpecialization = new JLabel("Reach Specialization:");
				springLayout_4.putConstraint(SpringLayout.NORTH, lblReachSpecialization, 6, SpringLayout.SOUTH, scrollPane_2);
				springLayout_4.putConstraint(SpringLayout.WEST, lblReachSpecialization, 0, SpringLayout.WEST, lblBuildComponents);
				internalFrame_4.getContentPane().add(lblReachSpecialization);
				
				JScrollPane scrollPane_3 = new JScrollPane();
				scrollPane_3.setToolTipText("<html>This will fail the challenge if a particular character dies.<br>param: indicates the character name, must be exact.</html>");
				springLayout_4.putConstraint(SpringLayout.NORTH, scrollPane_3, 6, SpringLayout.SOUTH, lblKeepCharacterAlive);
				springLayout_4.putConstraint(SpringLayout.WEST, scrollPane_3, 10, SpringLayout.WEST, internalFrame_4.getContentPane());
				springLayout_4.putConstraint(SpringLayout.SOUTH, scrollPane_3, -10, SpringLayout.SOUTH, internalFrame_4.getContentPane());
				springLayout_4.putConstraint(SpringLayout.EAST, scrollPane_3, 0, SpringLayout.EAST, scrollPane);
				internalFrame_4.getContentPane().add(scrollPane_3);
				
				characterTable = new JTable();
				characterTable.setModel(new DefaultTableModel(
					null,
					new String[] {
						"Name"
					}
				) {
					Class<?>[] columnTypes = new Class[] {
						String.class
					};
					public Class<?> getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				scrollPane_3.setViewportView(characterTable);
				
				JScrollPane scrollPane_4 = new JScrollPane();
				springLayout_4.putConstraint(SpringLayout.SOUTH, scrollPane_4, -10, SpringLayout.SOUTH, internalFrame_4.getContentPane());
				scrollPane_4.setToolTipText("Reach a certain number of characters of a particular specialization.");
				springLayout_4.putConstraint(SpringLayout.WEST, scrollPane_4, 0, SpringLayout.WEST, scrollPane_2);
				springLayout_4.putConstraint(SpringLayout.EAST, scrollPane_4, -10, SpringLayout.EAST, internalFrame_4.getContentPane());
				internalFrame_4.getContentPane().add(scrollPane_4);
				
				specializationTable = new JTable();
				specializationTable.setModel(new DefaultTableModel(
					null,
					new String[] {
						"Specialization", "Number"
					}
				) {
					Class<?>[] columnTypes = new Class[] {
						Object.class, Integer.class
					};
					public Class<?> getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				specializationTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(specializationsBox));
				scrollPane_4.setViewportView(specializationTable);
				
				JButton btnNewButton = new JButton("");
				btnNewButton.setToolTipText("Add New Objective");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						DefaultTableModel model = (DefaultTableModel) structuresTable.getModel();
						model.addRow(new Object[][] {null,null});
					}
				});
				springLayout_4.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, reachPopulationCheckBox);
				springLayout_4.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, scrollPane_1);
				btnNewButton.setIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/tree_collapsed_14x14.png")));
				internalFrame_4.getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.setToolTipText("Remove LAST Objective on the list");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) structuresTable.getModel();
						if(model.getRowCount()>0) model.removeRow(model.getRowCount()-1); //remove Last
					}
				});
				springLayout_4.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, reachPopulationCheckBox);
				springLayout_4.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, btnNewButton);
				btnNewButton_1.setIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/tree_expanded_14x14.png")));
				internalFrame_4.getContentPane().add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("");
				btnNewButton_2.setToolTipText("Add New Objective");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) resourcesTable.getModel();
						model.addRow(new Object[][] {null,null});
					}
				});
				btnNewButton_2.setIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/tree_collapsed_14x14.png")));
				springLayout_4.putConstraint(SpringLayout.NORTH, btnNewButton_2, -4, SpringLayout.NORTH, lblAccumulateResources);
				springLayout_4.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, scrollPane);
				internalFrame_4.getContentPane().add(btnNewButton_2);
				
				JButton btnNewButton_3 = new JButton("");
				btnNewButton_3.setToolTipText("Remove LAST Objective on the list");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) resourcesTable.getModel();
						if(model.getRowCount()>0) model.removeRow(model.getRowCount()-1);
					}
				});
				btnNewButton_3.setIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/tree_expanded_14x14.png")));
				springLayout_4.putConstraint(SpringLayout.NORTH, btnNewButton_3, -4, SpringLayout.NORTH, lblAccumulateResources);
				springLayout_4.putConstraint(SpringLayout.EAST, btnNewButton_3, -6, SpringLayout.WEST, btnNewButton_2);
				internalFrame_4.getContentPane().add(btnNewButton_3);
				
				JButton btnNewButton_4 = new JButton("");
				springLayout_4.putConstraint(SpringLayout.NORTH, scrollPane_2, 4, SpringLayout.SOUTH, btnNewButton_4);
				btnNewButton_4.setToolTipText("Add New Objective");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) componentsTable.getModel();
						model.addRow(new Object[][] {null,null});
					}
				});
				btnNewButton_4.setIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/tree_collapsed_14x14.png")));
				springLayout_4.putConstraint(SpringLayout.NORTH, btnNewButton_4, -4, SpringLayout.NORTH, lblAccumulateResources);
				springLayout_4.putConstraint(SpringLayout.EAST, btnNewButton_4, 0, SpringLayout.EAST, scrollPane_1);
				internalFrame_4.getContentPane().add(btnNewButton_4);
				
				JButton btnNewButton_5 = new JButton("");
				btnNewButton_5.setToolTipText("Remove LAST Objective on the list");
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) componentsTable.getModel();
						if(model.getRowCount()>0) model.removeRow(model.getRowCount()-1);
					}
				});
				btnNewButton_5.setIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/tree_expanded_14x14.png")));
				springLayout_4.putConstraint(SpringLayout.NORTH, btnNewButton_5, -4, SpringLayout.NORTH, lblAccumulateResources);
				springLayout_4.putConstraint(SpringLayout.EAST, btnNewButton_5, -6, SpringLayout.WEST, btnNewButton_4);
				internalFrame_4.getContentPane().add(btnNewButton_5);
				
				JButton btnNewButton_6 = new JButton("");
				btnNewButton_6.setToolTipText("Add New Objective");
				btnNewButton_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) characterTable.getModel();
						model.addRow(new Object[][] {null,null});
					}
				});
				btnNewButton_6.setIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/tree_collapsed_14x14.png")));
				springLayout_4.putConstraint(SpringLayout.NORTH, btnNewButton_6, -4, SpringLayout.NORTH, lblKeepCharacterAlive);
				springLayout_4.putConstraint(SpringLayout.EAST, btnNewButton_6, 0, SpringLayout.EAST, scrollPane);
				internalFrame_4.getContentPane().add(btnNewButton_6);
				
				JButton btnNewButton_7 = new JButton("");
				btnNewButton_7.setToolTipText("Remove LAST Objective on the list");
				btnNewButton_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) characterTable.getModel();
						if(model.getRowCount()>0) model.removeRow(model.getRowCount()-1);
					}
				});
				btnNewButton_7.setIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/tree_expanded_14x14.png")));
				springLayout_4.putConstraint(SpringLayout.NORTH, btnNewButton_7, -4, SpringLayout.NORTH, lblKeepCharacterAlive);
				springLayout_4.putConstraint(SpringLayout.EAST, btnNewButton_7, -6, SpringLayout.WEST, btnNewButton_6);
				internalFrame_4.getContentPane().add(btnNewButton_7);
				
				JButton btnNewButton_8 = new JButton("");
				springLayout_4.putConstraint(SpringLayout.NORTH, scrollPane_4, 4, SpringLayout.SOUTH, btnNewButton_8);
				springLayout_4.putConstraint(SpringLayout.SOUTH, scrollPane_2, -2, SpringLayout.NORTH, btnNewButton_8);
				btnNewButton_8.setToolTipText("Add New Objective");
				btnNewButton_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) specializationTable.getModel();
						model.addRow(new Object[][] {null,null});
					}
				});
				btnNewButton_8.setIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/tree_collapsed_14x14.png")));
				springLayout_4.putConstraint(SpringLayout.NORTH, btnNewButton_8, -4, SpringLayout.NORTH, lblKeepCharacterAlive);
				springLayout_4.putConstraint(SpringLayout.EAST, btnNewButton_8, 0, SpringLayout.EAST, scrollPane_1);
				internalFrame_4.getContentPane().add(btnNewButton_8);
				
				JButton btnNewButton_9 = new JButton("");
				btnNewButton_9.setToolTipText("Remove LAST Objective on the list");
				btnNewButton_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) specializationTable.getModel();
						if(model.getRowCount()>0) model.removeRow(model.getRowCount()-1);
					}
				});
				btnNewButton_9.setIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/tree_expanded_14x14.png")));
				springLayout_4.putConstraint(SpringLayout.NORTH, btnNewButton_9, -4, SpringLayout.NORTH, lblKeepCharacterAlive);
				springLayout_4.putConstraint(SpringLayout.EAST, btnNewButton_9, 0, SpringLayout.EAST, btnNewButton_5);
				internalFrame_4.getContentPane().add(btnNewButton_9);
				internalFrame_4.setVisible(true);
		
		JInternalFrame internalFrame_1 = new JInternalFrame("Gameplay Modifiers");
		internalFrame_1.setFrameIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/modifiers16.png")));
		tabbedPane.addTab("Modifiers", null, internalFrame_1, null);
		SpringLayout springLayout_1 = new SpringLayout();
		internalFrame_1.getContentPane().setLayout(springLayout_1);
		
		JLabel lblDisableInteriorStructures = new JLabel("Disable Interior Structures:");
		internalFrame_1.getContentPane().add(lblDisableInteriorStructures);
		
		JLabel lblDisableComponents = new JLabel("Disable Components:");
		springLayout_1.putConstraint(SpringLayout.EAST, lblDisableComponents, 0, SpringLayout.EAST, lblDisableInteriorStructures);
		internalFrame_1.getContentPane().add(lblDisableComponents);
		
		JLabel lblDisableStructureRequirement = new JLabel("Disable Structure Requirement:");
		springLayout_1.putConstraint(SpringLayout.EAST, lblDisableStructureRequirement, 0, SpringLayout.EAST, lblDisableInteriorStructures);
		internalFrame_1.getContentPane().add(lblDisableStructureRequirement);
		
		JLabel lblRestrictedTradingShips = new JLabel("Restricted Trading Ships:");
		springLayout_1.putConstraint(SpringLayout.EAST, lblRestrictedTradingShips, 0, SpringLayout.EAST, lblDisableInteriorStructures);
		internalFrame_1.getContentPane().add(lblRestrictedTradingShips);
		
		JLabel lblRestrictedColonistShips = new JLabel("Restricted Colonist Ships:");
		springLayout_1.putConstraint(SpringLayout.EAST, lblRestrictedColonistShips, 0, SpringLayout.EAST, lblDisableInteriorStructures);
		internalFrame_1.getContentPane().add(lblRestrictedColonistShips);
		
		JLabel lblUnlockTech = new JLabel("Unlock Tech:");
		springLayout_1.putConstraint(SpringLayout.EAST, lblUnlockTech, 0, SpringLayout.EAST, lblDisableInteriorStructures);
		internalFrame_1.getContentPane().add(lblUnlockTech);
		
		disableColonistShipsCheckBox = new JCheckBox("Disable Colonist Ships:");
		disableColonistShipsCheckBox.setToolTipText("Disables all colonists ships");
		springLayout_1.putConstraint(SpringLayout.NORTH, disableColonistShipsCheckBox, 6, SpringLayout.NORTH, internalFrame_1.getContentPane());
		springLayout_1.putConstraint(SpringLayout.WEST, disableColonistShipsCheckBox, 65, SpringLayout.WEST, internalFrame_1.getContentPane());
		disableColonistShipsCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		disableColonistShipsCheckBox.setHorizontalAlignment(SwingConstants.TRAILING);
		internalFrame_1.getContentPane().add(disableColonistShipsCheckBox);
		
		disableVisitorShipsCheckBox = new JCheckBox("Disable Visitor Ships:");
		disableVisitorShipsCheckBox.setToolTipText("Disables all visitor ships");
		springLayout_1.putConstraint(SpringLayout.EAST, disableVisitorShipsCheckBox, 0, SpringLayout.EAST, disableColonistShipsCheckBox);
		disableVisitorShipsCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_1.getContentPane().add(disableVisitorShipsCheckBox);
		
		disableTradingShipsCheckBox = new JCheckBox("Disable Trading Ships:");
		disableTradingShipsCheckBox.setToolTipText("Disables all trading ships");
		springLayout_1.putConstraint(SpringLayout.NORTH, disableTradingShipsCheckBox, 6, SpringLayout.SOUTH, disableVisitorShipsCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, disableTradingShipsCheckBox, 0, SpringLayout.EAST, disableColonistShipsCheckBox);
		disableTradingShipsCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_1.getContentPane().add(disableTradingShipsCheckBox);
		
		disableTraderTechsCheckBox = new JCheckBox("Disable Trader Techs:");
		disableTraderTechsCheckBox.setToolTipText("Prevents traders from selling techs");
		springLayout_1.putConstraint(SpringLayout.NORTH, disableTraderTechsCheckBox, 6, SpringLayout.SOUTH, disableColonistShipsCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, disableTraderTechsCheckBox, 0, SpringLayout.EAST, disableColonistShipsCheckBox);
		disableTraderTechsCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_1.getContentPane().add(disableTraderTechsCheckBox);
		
		disableNoMedicalSuppliesWarningCheckBox = new JCheckBox("Disable Med Warning:");
		disableNoMedicalSuppliesWarningCheckBox.setToolTipText("Prevents the game from displaying the \"We've run out of medical supplies warning\" when there are no medical supplies");
		springLayout_1.putConstraint(SpringLayout.EAST, disableNoMedicalSuppliesWarningCheckBox, 0, SpringLayout.EAST, disableColonistShipsCheckBox);
		disableNoMedicalSuppliesWarningCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_1.getContentPane().add(disableNoMedicalSuppliesWarningCheckBox);
		
		disableVisitorRequirementsCheckBox = new JCheckBox("Disable Visitor Requirements:");
		disableVisitorRequirementsCheckBox.setToolTipText("Allows visitors to come regardless of prestige");
		springLayout_1.putConstraint(SpringLayout.NORTH, disableVisitorShipsCheckBox, 6, SpringLayout.SOUTH, disableVisitorRequirementsCheckBox);
		springLayout_1.putConstraint(SpringLayout.NORTH, disableVisitorRequirementsCheckBox, 6, SpringLayout.SOUTH, disableTraderTechsCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, disableVisitorRequirementsCheckBox, 0, SpringLayout.EAST, disableColonistShipsCheckBox);
		disableVisitorRequirementsCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_1.getContentPane().add(disableVisitorRequirementsCheckBox);
		
		disableShipRecyclingCheckBox = new JCheckBox("Disable Ship Recycling:");
		disableShipRecyclingCheckBox.setToolTipText("Prevents the player from recycling the colony ship");
		springLayout_1.putConstraint(SpringLayout.NORTH, disableShipRecyclingCheckBox, 6, SpringLayout.SOUTH, disableTradingShipsCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, disableShipRecyclingCheckBox, 0, SpringLayout.EAST, disableColonistShipsCheckBox);
		disableShipRecyclingCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_1.getContentPane().add(disableShipRecyclingCheckBox);
		
		disableWorkerMiningCheckBox = new JCheckBox("Disable Worker Mining:");
		disableWorkerMiningCheckBox.setToolTipText("Prevents Workers from mining");
		springLayout_1.putConstraint(SpringLayout.NORTH, disableNoMedicalSuppliesWarningCheckBox, 6, SpringLayout.SOUTH, disableWorkerMiningCheckBox);
		springLayout_1.putConstraint(SpringLayout.NORTH, disableWorkerMiningCheckBox, 6, SpringLayout.SOUTH, disableShipRecyclingCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, disableWorkerMiningCheckBox, 0, SpringLayout.EAST, disableColonistShipsCheckBox);
		disableWorkerMiningCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_1.getContentPane().add(disableWorkerMiningCheckBox);
		
		infiniteTraderBotsCheckBox = new JCheckBox("Infinite Trader Bots:");
		infiniteTraderBotsCheckBox.setToolTipText("Allows traders to always bring bots, they usually stop when the number of bots is higher than the number of colonists");
		springLayout_1.putConstraint(SpringLayout.NORTH, infiniteTraderBotsCheckBox, 6, SpringLayout.SOUTH, disableNoMedicalSuppliesWarningCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, infiniteTraderBotsCheckBox, 0, SpringLayout.EAST, disableColonistShipsCheckBox);
		infiniteTraderBotsCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_1.getContentPane().add(infiniteTraderBotsCheckBox);
		
		disasterFrequencySpinner = new JSpinner();
		disasterFrequencySpinner.setEnabled(false);
		springLayout_1.putConstraint(SpringLayout.NORTH, disasterFrequencySpinner, 7, SpringLayout.NORTH, internalFrame_1.getContentPane());
		disasterFrequencySpinner.setToolTipText("Modifies the frequency of all sandstorms, solar flares and blizzards param: Frequency in the range [0.1, 10]");
		springLayout_1.putConstraint(SpringLayout.WEST, disasterFrequencySpinner, 397, SpringLayout.WEST, internalFrame_1.getContentPane());
		springLayout_1.putConstraint(SpringLayout.EAST, disasterFrequencySpinner, 226, SpringLayout.EAST, disableColonistShipsCheckBox);
		disasterFrequencySpinner.setModel(new SpinnerNumberModel(new Float(0.1), new Float(0.1), new Float(10), new Float(0.1)));
		internalFrame_1.getContentPane().add(disasterFrequencySpinner);
		
		shipFrequencySpinner = new JSpinner();
		shipFrequencySpinner.setEnabled(false);
		shipFrequencySpinner.setModel(new SpinnerNumberModel(new Float(0.1), new Float(0.1), new Float(10.0), new Float(0.1)));
		shipFrequencySpinner.setToolTipText("Modifies the frequency of all ships coming to the base param: Frequency in the range [0.1, 10]");
		springLayout_1.putConstraint(SpringLayout.NORTH, shipFrequencySpinner, 7, SpringLayout.SOUTH, disasterFrequencySpinner);
		springLayout_1.putConstraint(SpringLayout.WEST, shipFrequencySpinner, 0, SpringLayout.WEST, disasterFrequencySpinner);
		springLayout_1.putConstraint(SpringLayout.EAST, shipFrequencySpinner, 0, SpringLayout.EAST, disasterFrequencySpinner);
		internalFrame_1.getContentPane().add(shipFrequencySpinner);
		
		intruderMinPrestigeSpinner = new JSpinner();
		springLayout_1.putConstraint(SpringLayout.NORTH, intruderMinPrestigeSpinner, 39, SpringLayout.SOUTH, shipFrequencySpinner);
		intruderMinPrestigeSpinner.setEnabled(false);
		springLayout_1.putConstraint(SpringLayout.WEST, intruderMinPrestigeSpinner, 397, SpringLayout.WEST, internalFrame_1.getContentPane());
		intruderMinPrestigeSpinner.setToolTipText("Specifies the min prestige for intruders to come to the base param: amount in the range [1, 1000]");
		intruderMinPrestigeSpinner.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		springLayout_1.putConstraint(SpringLayout.EAST, intruderMinPrestigeSpinner, 0, SpringLayout.EAST, disasterFrequencySpinner);
		internalFrame_1.getContentPane().add(intruderMinPrestigeSpinner);
		
		extraIntrudersSpinner = new JSpinner();
		extraIntrudersSpinner.setEnabled(false);
		extraIntrudersSpinner.setToolTipText("Specifies extra intruders to come in every attack param: amount in the range [0, ...]");
		extraIntrudersSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		springLayout_1.putConstraint(SpringLayout.NORTH, extraIntrudersSpinner, 7, SpringLayout.SOUTH, intruderMinPrestigeSpinner);
		springLayout_1.putConstraint(SpringLayout.WEST, extraIntrudersSpinner, 0, SpringLayout.WEST, disasterFrequencySpinner);
		springLayout_1.putConstraint(SpringLayout.EAST, extraIntrudersSpinner, 0, SpringLayout.EAST, disasterFrequencySpinner);
		internalFrame_1.getContentPane().add(extraIntrudersSpinner);
		
		disableInteriorStructuresCheckedComboBox = new CheckedComboBox<>();
		disableInteriorStructuresCheckedComboBox.setToolTipText("Disables a particular structure");
		springLayout_1.putConstraint(SpringLayout.NORTH, disableInteriorStructuresCheckedComboBox, 18, SpringLayout.SOUTH, infiniteTraderBotsCheckBox);
		springLayout_1.putConstraint(SpringLayout.WEST, disableInteriorStructuresCheckedComboBox, 201, SpringLayout.WEST, internalFrame_1.getContentPane());
		springLayout_1.putConstraint(SpringLayout.NORTH, lblDisableInteriorStructures, 2, SpringLayout.NORTH, disableInteriorStructuresCheckedComboBox);
		springLayout_1.putConstraint(SpringLayout.EAST, lblDisableInteriorStructures, -6, SpringLayout.WEST, disableInteriorStructuresCheckedComboBox);
		disableInteriorStructuresCheckedComboBox.setModel(new DefaultComboBoxModel<CheckableItem>(Entities.InternalStructures));
		internalFrame_1.getContentPane().add(disableInteriorStructuresCheckedComboBox);
		
		disableExteriorStructuresCheckedComboBox = new CheckedComboBox<>();
		disableExteriorStructuresCheckedComboBox.setToolTipText("Disables a particular structure");
		disableExteriorStructuresCheckedComboBox.setModel(new DefaultComboBoxModel<CheckableItem>(Entities.ExternalStructures));
		springLayout_1.putConstraint(SpringLayout.NORTH, disableExteriorStructuresCheckedComboBox, 6, SpringLayout.SOUTH, disableInteriorStructuresCheckedComboBox);
		springLayout_1.putConstraint(SpringLayout.WEST, disableExteriorStructuresCheckedComboBox, 0, SpringLayout.WEST, disableInteriorStructuresCheckedComboBox);
		internalFrame_1.getContentPane().add(disableExteriorStructuresCheckedComboBox);
		
		JLabel lblDisableExteriorStructures = new JLabel("Disable Exterior Structures:");
		springLayout_1.putConstraint(SpringLayout.NORTH, lblDisableExteriorStructures, 2, SpringLayout.NORTH, disableExteriorStructuresCheckedComboBox);
		springLayout_1.putConstraint(SpringLayout.EAST, lblDisableExteriorStructures, 0, SpringLayout.EAST, lblDisableInteriorStructures);
		internalFrame_1.getContentPane().add(lblDisableExteriorStructures);
		
		disableComponentsCheckedComboBox = new CheckedComboBox<>();
		disableComponentsCheckedComboBox.setToolTipText("<html>Disables a particular component<br> WARNING! If ALL is selected it overrides other selections</html>");
		springLayout_1.putConstraint(SpringLayout.NORTH, lblDisableComponents, 2, SpringLayout.NORTH, disableComponentsCheckedComboBox);
		disableComponentsCheckedComboBox.setModel(new DefaultComboBoxModel<CheckableItem>(Entities.Components));
		springLayout_1.putConstraint(SpringLayout.NORTH, disableComponentsCheckedComboBox, 6, SpringLayout.SOUTH, disableExteriorStructuresCheckedComboBox);
		springLayout_1.putConstraint(SpringLayout.WEST, disableComponentsCheckedComboBox, 0, SpringLayout.WEST, disableInteriorStructuresCheckedComboBox);
		internalFrame_1.getContentPane().add(disableComponentsCheckedComboBox);
		
		disableStructureRequirementCheckedComboBox = new CheckedComboBox<>();
		disableStructureRequirementCheckedComboBox.setToolTipText("Allows the player to build a particular structure (or all structures) from the start");
		springLayout_1.putConstraint(SpringLayout.NORTH, lblDisableStructureRequirement, 2, SpringLayout.NORTH, disableStructureRequirementCheckedComboBox);
		disableStructureRequirementCheckedComboBox.setModel(new DefaultComboBoxModel<CheckableItem>(Entities.AllStructures));
		springLayout_1.putConstraint(SpringLayout.NORTH, disableStructureRequirementCheckedComboBox, 6, SpringLayout.SOUTH, disableComponentsCheckedComboBox);
		springLayout_1.putConstraint(SpringLayout.EAST, disableStructureRequirementCheckedComboBox, 0, SpringLayout.EAST, disableInteriorStructuresCheckedComboBox);
		internalFrame_1.getContentPane().add(disableStructureRequirementCheckedComboBox);
		
		restrictedColonistShipsCheckedComboBox = new CheckedComboBox<>();
		restrictedColonistShipsCheckedComboBox.setToolTipText("Restricts what colonists come inside ships");
		restrictedColonistShipsCheckedComboBox.setModel(new DefaultComboBoxModel<CheckableItem>(Entities.Colonists));
		springLayout_1.putConstraint(SpringLayout.WEST, restrictedColonistShipsCheckedComboBox, 6, SpringLayout.EAST, lblRestrictedColonistShips);
		springLayout_1.putConstraint(SpringLayout.NORTH, lblRestrictedColonistShips, 2, SpringLayout.NORTH, restrictedColonistShipsCheckedComboBox);
		springLayout_1.putConstraint(SpringLayout.NORTH, restrictedColonistShipsCheckedComboBox, 6, SpringLayout.SOUTH, disableStructureRequirementCheckedComboBox);
		internalFrame_1.getContentPane().add(restrictedColonistShipsCheckedComboBox);
		
		restrictedTradingShipsCheckedComboBox = new CheckedComboBox<>();
		restrictedTradingShipsCheckedComboBox.setToolTipText("Restricts what trading ships come to the base");
		restrictedTradingShipsCheckedComboBox.setModel(new DefaultComboBoxModel<CheckableItem>(Entities.TradingShips));
		springLayout_1.putConstraint(SpringLayout.WEST, restrictedTradingShipsCheckedComboBox, 6, SpringLayout.EAST, lblRestrictedTradingShips);
		springLayout_1.putConstraint(SpringLayout.NORTH, lblRestrictedTradingShips, 2, SpringLayout.NORTH, restrictedTradingShipsCheckedComboBox);
		springLayout_1.putConstraint(SpringLayout.NORTH, restrictedTradingShipsCheckedComboBox, 6, SpringLayout.SOUTH, restrictedColonistShipsCheckedComboBox);
		internalFrame_1.getContentPane().add(restrictedTradingShipsCheckedComboBox);
		
		unlockTechCheckedComboBox = new CheckedComboBox<>();
		unlockTechCheckedComboBox.setToolTipText("Unlocks a tech from the start");
		unlockTechCheckedComboBox.setModel(new DefaultComboBoxModel<CheckableItem>(Entities.Technologies));
		springLayout_1.putConstraint(SpringLayout.NORTH, lblUnlockTech, 2, SpringLayout.NORTH, unlockTechCheckedComboBox);
		springLayout_1.putConstraint(SpringLayout.NORTH, unlockTechCheckedComboBox, 6, SpringLayout.SOUTH, restrictedTradingShipsCheckedComboBox);
		springLayout_1.putConstraint(SpringLayout.EAST, unlockTechCheckedComboBox, 0, SpringLayout.EAST, disableInteriorStructuresCheckedComboBox);
		internalFrame_1.getContentPane().add(unlockTechCheckedComboBox);		
		
		disasterFrequencyCheckBox = new JCheckBox("Disaster Frequency:");
		disasterFrequencyCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(disasterFrequencyCheckBox.isSelected()) {
					disasterFrequencySpinner.setEnabled(true);
				}else {
					disasterFrequencySpinner.setEnabled(false);
				}
			}
		});
		disasterFrequencyCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		springLayout_1.putConstraint(SpringLayout.NORTH, disasterFrequencyCheckBox, 0, SpringLayout.NORTH, disableColonistShipsCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, disasterFrequencyCheckBox, -6, SpringLayout.WEST, disasterFrequencySpinner);
		internalFrame_1.getContentPane().add(disasterFrequencyCheckBox);
		
		shipFrequencyCheckBox = new JCheckBox("Ship Frequency:");
		shipFrequencyCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(shipFrequencyCheckBox.isSelected()) {
					shipFrequencySpinner.setEnabled(true);
				}else {
					shipFrequencySpinner.setEnabled(false);
				}
			}
		});
		shipFrequencyCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		springLayout_1.putConstraint(SpringLayout.NORTH, shipFrequencyCheckBox, 0, SpringLayout.NORTH, disableTraderTechsCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, shipFrequencyCheckBox, -6, SpringLayout.WEST, shipFrequencySpinner);
		internalFrame_1.getContentPane().add(shipFrequencyCheckBox);
		
		intruderMinPrestigeCheckBox = new JCheckBox("Intruder Min Prestige:");
		intruderMinPrestigeCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(intruderMinPrestigeCheckBox.isSelected()) {
					intruderMinPrestigeSpinner.setEnabled(true);
				}else {
					intruderMinPrestigeSpinner.setEnabled(false);
				}
			}
		});
		intruderMinPrestigeCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		springLayout_1.putConstraint(SpringLayout.NORTH, intruderMinPrestigeCheckBox, 0, SpringLayout.NORTH, disableVisitorShipsCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, intruderMinPrestigeCheckBox, -6, SpringLayout.WEST, intruderMinPrestigeSpinner);
		internalFrame_1.getContentPane().add(intruderMinPrestigeCheckBox);
		
		extraIntrudersCheckBox = new JCheckBox("Extra Intruders:");
		extraIntrudersCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(extraIntrudersCheckBox.isSelected()) {
					extraIntrudersSpinner.setEnabled(true);
				}else {
					extraIntrudersSpinner.setEnabled(false);
				}
			}
		});
		extraIntrudersCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		springLayout_1.putConstraint(SpringLayout.NORTH, extraIntrudersCheckBox, 0, SpringLayout.NORTH, disableTradingShipsCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, extraIntrudersCheckBox, -6, SpringLayout.WEST, extraIntrudersSpinner);
		internalFrame_1.getContentPane().add(extraIntrudersCheckBox);
		
		tradingShipFrequencySpinner = new JSpinner();
		tradingShipFrequencySpinner.setToolTipText("Modifies the frequency of trading ships coming to the base param: Frequency in the range [0.1, 10]");
		springLayout_1.putConstraint(SpringLayout.WEST, tradingShipFrequencySpinner, 174, SpringLayout.EAST, disableVisitorRequirementsCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, tradingShipFrequencySpinner, -261, SpringLayout.EAST, internalFrame_1.getContentPane());
		tradingShipFrequencySpinner.setModel(new SpinnerNumberModel(new Float(0.1), new Float(0.1), new Float(10.0f), new Float(0.1)));
		tradingShipFrequencySpinner.setEnabled(false);
		springLayout_1.putConstraint(SpringLayout.NORTH, tradingShipFrequencySpinner, 8, SpringLayout.SOUTH, shipFrequencySpinner);
		internalFrame_1.getContentPane().add(tradingShipFrequencySpinner);
		
		tradingShipFrequencyCheckBox = new JCheckBox("Trading Ship Frequency:");
		tradingShipFrequencyCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		tradingShipFrequencyCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tradingShipFrequencyCheckBox.isSelected()) {
					tradingShipFrequencySpinner.setEnabled(true);
				}else {
					tradingShipFrequencySpinner.setEnabled(false);
				
				}
			}
		});
		springLayout_1.putConstraint(SpringLayout.NORTH, tradingShipFrequencyCheckBox, 0, SpringLayout.NORTH, disableVisitorRequirementsCheckBox);
		springLayout_1.putConstraint(SpringLayout.EAST, tradingShipFrequencyCheckBox, 0, SpringLayout.EAST, disasterFrequencyCheckBox);
		internalFrame_1.getContentPane().add(tradingShipFrequencyCheckBox);
		
		JInternalFrame internalFrame_2 = new JInternalFrame("Environment Settings");
		internalFrame_2.setFrameIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/environment16.png")));
		tabbedPane.addTab("Environment", null, internalFrame_2, null);
		SpringLayout springLayout_2 = new SpringLayout();
		internalFrame_2.getContentPane().setLayout(springLayout_2);
		
		removeSatellitesCheckBox = new JCheckBox("Remove Satellites:");
		removeSatellitesCheckBox.setToolTipText("Removes any planets in the horizon.");
		removeSatellitesCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(removeSatellitesCheckBox);
		
		dayHoursSpinner = new JSpinner();
		springLayout_2.putConstraint(SpringLayout.EAST, removeSatellitesCheckBox, 0, SpringLayout.EAST, dayHoursSpinner);
		dayHoursSpinner.setToolTipText("Specifies how long days or nights are. value: Reasonable values are in the range [4, 24]");
		dayHoursSpinner.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, dayHoursSpinner, 40, SpringLayout.NORTH, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.WEST, dayHoursSpinner, 121, SpringLayout.WEST, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.EAST, dayHoursSpinner, -535, SpringLayout.EAST, internalFrame_2.getContentPane());
		dayHoursSpinner.setModel(new SpinnerNumberModel(4, 4, 24, 1));
		internalFrame_2.getContentPane().add(dayHoursSpinner);
		
		nightHoursSpinner = new JSpinner();
		springLayout_2.putConstraint(SpringLayout.NORTH, removeSatellitesCheckBox, 6, SpringLayout.SOUTH, nightHoursSpinner);
		nightHoursSpinner.setToolTipText("Specifies how long days or nights are. value: Reasonable values are in the range [4, 24]");
		nightHoursSpinner.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, nightHoursSpinner, 6, SpringLayout.SOUTH, dayHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.WEST, nightHoursSpinner, 0, SpringLayout.WEST, dayHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, nightHoursSpinner, 0, SpringLayout.EAST, dayHoursSpinner);
		nightHoursSpinner.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		internalFrame_2.getContentPane().add(nightHoursSpinner);
		
		fogIntensityPercentageDaySpinner = new JSpinner();
		fogIntensityPercentageDaySpinner.setToolTipText("Intensity of the fog during the day, night, sunrise or sunset.");
		fogIntensityPercentageDaySpinner.setEnabled(false);
		fogIntensityPercentageDaySpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		springLayout_2.putConstraint(SpringLayout.WEST, fogIntensityPercentageDaySpinner, 0, SpringLayout.WEST, dayHoursSpinner);
		internalFrame_2.getContentPane().add(fogIntensityPercentageDaySpinner);
		
		JLabel lblLightColour = new JLabel("LIGHT COLOR:");
		springLayout_2.putConstraint(SpringLayout.WEST, lblLightColour, 10, SpringLayout.WEST, internalFrame_2.getContentPane());
		internalFrame_2.getContentPane().add(lblLightColour);
		
		lightColorDayField = new JTextField();
		lightColorDayField.setToolTipText("Color of the directional sun light during the day, night, sunrise or sunset.");
		lightColorDayField.setVisible(false);
		lightColorDayField.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, lightColorDayField, 66, SpringLayout.SOUTH, nightHoursSpinner);
		lightColorDayField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showColorPicker((JTextField) arg0.getSource());
			}
		});
		springLayout_2.putConstraint(SpringLayout.EAST, lightColorDayField, 0, SpringLayout.EAST, dayHoursSpinner);
		lightColorDayField.setEditable(false);
		springLayout_2.putConstraint(SpringLayout.WEST, lightColorDayField, 0, SpringLayout.WEST, dayHoursSpinner);
		internalFrame_2.getContentPane().add(lightColorDayField);
		lightColorDayField.setColumns(10);
		
		lightColorNightField = new JTextField();
		lightColorNightField.setToolTipText("Color of the directional sun light during the day, night, sunrise or sunset.");
		lightColorNightField.setVisible(false);
		lightColorNightField.setEnabled(false);
		lightColorNightField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, lightColorNightField, 6, SpringLayout.SOUTH, lightColorDayField);
		lightColorNightField.setEditable(false);
		internalFrame_2.getContentPane().add(lightColorNightField);
		lightColorNightField.setColumns(10);
		
		lightColorTwilightField = new JTextField();
		lightColorTwilightField.setToolTipText("Color of the directional sun light during the day, night, sunrise or sunset.");
		lightColorTwilightField.setVisible(false);
		lightColorTwilightField.setEnabled(false);
		lightColorTwilightField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		springLayout_2.putConstraint(SpringLayout.EAST, lightColorTwilightField, 175, SpringLayout.WEST, internalFrame_2.getContentPane());
		lightColorTwilightField.setEditable(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, lightColorTwilightField, 6, SpringLayout.SOUTH, lightColorNightField);
		springLayout_2.putConstraint(SpringLayout.WEST, lightColorTwilightField, 121, SpringLayout.WEST, internalFrame_2.getContentPane());
		internalFrame_2.getContentPane().add(lightColorTwilightField);
		lightColorTwilightField.setColumns(10);
		
		JLabel lblAmbientColor = new JLabel("AMBIENT COLOR:");
		springLayout_2.putConstraint(SpringLayout.WEST, lblAmbientColor, 10, SpringLayout.WEST, internalFrame_2.getContentPane());
		internalFrame_2.getContentPane().add(lblAmbientColor);
		
		ambientColorDayField = new JTextField();
		ambientColorDayField.setToolTipText("Color of the ambient sun light during the day, night, sunrise or sunset.");
		ambientColorDayField.setVisible(false);
		ambientColorDayField.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, ambientColorDayField, 30, SpringLayout.SOUTH, lightColorTwilightField);
		ambientColorDayField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		ambientColorDayField.setEditable(false);
		springLayout_2.putConstraint(SpringLayout.WEST, ambientColorDayField, 0, SpringLayout.WEST, dayHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, ambientColorDayField, 0, SpringLayout.EAST, dayHoursSpinner);
		internalFrame_2.getContentPane().add(ambientColorDayField);
		ambientColorDayField.setColumns(10);
		
		ambientColorNightField = new JTextField();
		ambientColorNightField.setToolTipText("Color of the ambient sun light during the day, night, sunrise or sunset.");
		ambientColorNightField.setVisible(false);
		ambientColorNightField.setEnabled(false);
		ambientColorNightField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, ambientColorNightField, 6, SpringLayout.SOUTH, ambientColorDayField);
		springLayout_2.putConstraint(SpringLayout.WEST, ambientColorNightField, 0, SpringLayout.WEST, dayHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, ambientColorNightField, 0, SpringLayout.EAST, dayHoursSpinner);
		ambientColorNightField.setEditable(false);
		internalFrame_2.getContentPane().add(ambientColorNightField);
		ambientColorNightField.setColumns(10);
		
		ambientColorTwilightField = new JTextField();
		ambientColorTwilightField.setToolTipText("Color of the ambient sun light during the day, night, sunrise or sunset.");
		ambientColorTwilightField.setVisible(false);
		ambientColorTwilightField.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.WEST, ambientColorTwilightField, 121, SpringLayout.WEST, internalFrame_2.getContentPane());
		ambientColorTwilightField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, ambientColorTwilightField, 6, SpringLayout.SOUTH, ambientColorNightField);
		ambientColorTwilightField.setEditable(false);
		internalFrame_2.getContentPane().add(ambientColorTwilightField);
		ambientColorTwilightField.setColumns(10);
		
		JLabel lblHorizonColor = new JLabel("HORIZON COLOR:");
		springLayout_2.putConstraint(SpringLayout.NORTH, lblHorizonColor, 0, SpringLayout.NORTH, lblLightColour);
		springLayout_2.putConstraint(SpringLayout.WEST, lblHorizonColor, 150, SpringLayout.EAST, lblLightColour);
		internalFrame_2.getContentPane().add(lblHorizonColor);
		
		horizonColorDayField = new JTextField();
		horizonColorDayField.setToolTipText("Color of the horizon (lower part of the sky) during the day, night, sunrise or sunset.");
		horizonColorDayField.setVisible(false);
		horizonColorDayField.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.EAST, fogIntensityPercentageDaySpinner, -248, SpringLayout.EAST, horizonColorDayField);
		springLayout_2.putConstraint(SpringLayout.WEST, horizonColorDayField, 369, SpringLayout.WEST, internalFrame_2.getContentPane());
		horizonColorDayField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		horizonColorDayField.setEditable(false);
		horizonColorDayField.setColumns(10);
		internalFrame_2.getContentPane().add(horizonColorDayField);
		
		horizonColorNightField = new JTextField();
		horizonColorNightField.setToolTipText("Color of the horizon (lower part of the sky) during the day, night, sunrise or sunset.");
		horizonColorNightField.setVisible(false);
		horizonColorNightField.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, horizonColorNightField, 6, SpringLayout.SOUTH, horizonColorDayField);
		springLayout_2.putConstraint(SpringLayout.WEST, horizonColorNightField, 0, SpringLayout.WEST, horizonColorDayField);
		springLayout_2.putConstraint(SpringLayout.EAST, horizonColorNightField, -287, SpringLayout.EAST, internalFrame_2.getContentPane());
		horizonColorNightField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		horizonColorNightField.setEditable(false);
		horizonColorNightField.setColumns(10);
		internalFrame_2.getContentPane().add(horizonColorNightField);
		
		horizonColorTwilightField = new JTextField();
		horizonColorTwilightField.setToolTipText("Color of the horizon (lower part of the sky) during the day, night, sunrise or sunset.");
		horizonColorTwilightField.setVisible(false);
		horizonColorTwilightField.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, horizonColorTwilightField, 6, SpringLayout.SOUTH, horizonColorNightField);
		springLayout_2.putConstraint(SpringLayout.WEST, horizonColorTwilightField, 369, SpringLayout.WEST, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.EAST, horizonColorTwilightField, 0, SpringLayout.EAST, horizonColorDayField);
		horizonColorTwilightField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		horizonColorTwilightField.setEditable(false);
		internalFrame_2.getContentPane().add(horizonColorTwilightField);
		horizonColorTwilightField.setColumns(10);
		
		JLabel lblSkyColor = new JLabel("SKY COLOR:");
		springLayout_2.putConstraint(SpringLayout.NORTH, lblSkyColor, 0, SpringLayout.NORTH, lblAmbientColor);
		springLayout_2.putConstraint(SpringLayout.WEST, lblSkyColor, 0, SpringLayout.WEST, lblHorizonColor);
		internalFrame_2.getContentPane().add(lblSkyColor);
		
		skyColorDayField = new JTextField();
		skyColorDayField.setToolTipText("Color of the sky during the day, night, sunrise or sunset.");
		skyColorDayField.setVisible(false);
		skyColorDayField.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, skyColorDayField, 0, SpringLayout.NORTH, ambientColorDayField);
		springLayout_2.putConstraint(SpringLayout.WEST, skyColorDayField, 0, SpringLayout.WEST, horizonColorDayField);
		springLayout_2.putConstraint(SpringLayout.EAST, skyColorDayField, 0, SpringLayout.EAST, horizonColorDayField);
		skyColorDayField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		skyColorDayField.setEditable(false);
		skyColorDayField.setColumns(10);
		internalFrame_2.getContentPane().add(skyColorDayField);
		
		skyColorNightField = new JTextField();
		skyColorNightField.setToolTipText("Color of the sky during the day, night, sunrise or sunset.");
		skyColorNightField.setVisible(false);
		skyColorNightField.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.WEST, skyColorNightField, 369, SpringLayout.WEST, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.NORTH, skyColorNightField, 0, SpringLayout.NORTH, ambientColorNightField);
		springLayout_2.putConstraint(SpringLayout.EAST, skyColorNightField, 0, SpringLayout.EAST, horizonColorDayField);
		skyColorNightField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		skyColorNightField.setEditable(false);
		skyColorNightField.setColumns(10);
		internalFrame_2.getContentPane().add(skyColorNightField);
		
		skyColorTwilightField = new JTextField();
		skyColorTwilightField.setToolTipText("Color of the sky during the day, night, sunrise or sunset.");
		skyColorTwilightField.setVisible(false);
		skyColorTwilightField.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.EAST, ambientColorTwilightField, -194, SpringLayout.WEST, skyColorTwilightField);
		springLayout_2.putConstraint(SpringLayout.NORTH, skyColorTwilightField, 6, SpringLayout.SOUTH, skyColorNightField);
		springLayout_2.putConstraint(SpringLayout.WEST, skyColorTwilightField, 369, SpringLayout.WEST, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.EAST, skyColorTwilightField, 0, SpringLayout.EAST, horizonColorDayField);
		skyColorTwilightField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		skyColorTwilightField.setEditable(false);
		skyColorTwilightField.setColumns(10);
		internalFrame_2.getContentPane().add(skyColorTwilightField);
		
		JLabel lblOverrideMapIndex = new JLabel("MAP PROPERTIES:");
		springLayout_2.putConstraint(SpringLayout.WEST, lblOverrideMapIndex, 0, SpringLayout.WEST, lblLightColour);
		internalFrame_2.getContentPane().add(lblOverrideMapIndex);
		
		environmentComboBox = new JComboBox<>();
		environmentComboBox.setToolTipText("Changes the environment map for this challenge value: Number in the range [1, 4], indicates which planet to take the environment map from");
		environmentComboBox.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, environmentComboBox, 38, SpringLayout.NORTH, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.WEST, environmentComboBox, 369, SpringLayout.WEST, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.EAST, environmentComboBox, -287, SpringLayout.EAST, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.EAST, horizonColorDayField, 0, SpringLayout.EAST, environmentComboBox);
		environmentComboBox.setModel(new DefaultComboBoxModel<>(PlanetClass.values()));
		internalFrame_2.getContentPane().add(environmentComboBox);
		
		sunComboBox = new JComboBox<>();
		sunComboBox.setToolTipText("Changes the sun for this challenge value: Number in the range [1, 4], indicates which planet to take the sun from");
		sunComboBox.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, sunComboBox, 0, SpringLayout.NORTH, nightHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.WEST, sunComboBox, 194, SpringLayout.EAST, nightHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, sunComboBox, -287, SpringLayout.EAST, internalFrame_2.getContentPane());
		sunComboBox.setModel(new DefaultComboBoxModel<>(PlanetClass.values()));
		internalFrame_2.getContentPane().add(sunComboBox);
		
		backdropsComboBox = new JComboBox<>();
		backdropsComboBox.setToolTipText("Changes the backdrops for this challenge value: Number in the range [1, 4], indicates which planet to take the backdrops from");
		backdropsComboBox.setEnabled(false);
		springLayout_2.putConstraint(SpringLayout.NORTH, backdropsComboBox, 9, SpringLayout.SOUTH, sunComboBox);
		springLayout_2.putConstraint(SpringLayout.EAST, backdropsComboBox, -287, SpringLayout.EAST, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.NORTH, horizonColorDayField, 39, SpringLayout.SOUTH, backdropsComboBox);
		backdropsComboBox.setModel(new DefaultComboBoxModel<>(PlanetClass.values()));
		internalFrame_2.getContentPane().add(backdropsComboBox);
		
		environmentCheckBox = new JCheckBox("Environment:");
		environmentCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(environmentCheckBox.isSelected()) {
					environmentComboBox.setEnabled(true);
				}else {
					environmentComboBox.setEnabled(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, environmentCheckBox, 36, SpringLayout.NORTH, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.EAST, environmentCheckBox, -5, SpringLayout.WEST, environmentComboBox);
		environmentCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(environmentCheckBox);
		
		sunCheckBox = new JCheckBox("Sun:");
		sunCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sunCheckBox.isSelected()) {
					sunComboBox.setEnabled(true);
				}else {
					sunComboBox.setEnabled(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, sunCheckBox, -1, SpringLayout.NORTH, nightHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, sunCheckBox, -5, SpringLayout.WEST, sunComboBox);
		sunCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(sunCheckBox);
		
		backdropsCheckBox = new JCheckBox("Backdrops:");
		backdropsCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(backdropsCheckBox.isSelected()) {
					backdropsComboBox.setEnabled(true);
				}else {
					backdropsComboBox.setEnabled(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, backdropsCheckBox, 5, SpringLayout.SOUTH, sunCheckBox);
		springLayout_2.putConstraint(SpringLayout.EAST, backdropsCheckBox, -346, SpringLayout.EAST, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.WEST, backdropsComboBox, 5, SpringLayout.EAST, backdropsCheckBox);
		backdropsCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(backdropsCheckBox);
		
		skyColorDayCheckBox = new JCheckBox("Day:");
		skyColorDayCheckBox.setToolTipText("Color of the sky during the day, night, sunrise or sunset. Enable to set");
		skyColorDayCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(skyColorDayCheckBox.isSelected()) {
					skyColorDayField.setEnabled(true);
					skyColorDayField.setVisible(true);
				}else {
					skyColorDayField.setEnabled(false);
					skyColorDayField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, skyColorDayCheckBox, -2, SpringLayout.NORTH, ambientColorDayField);
		springLayout_2.putConstraint(SpringLayout.EAST, skyColorDayCheckBox, -6, SpringLayout.WEST, skyColorDayField);
		skyColorDayCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(skyColorDayCheckBox);
		
		horizonColorDayCheckBox = new JCheckBox("Day:");
		horizonColorDayCheckBox.setToolTipText("Color of the horizon (lower part of the sky) during the day, night, sunrise or sunset. Enable to set");
		horizonColorDayCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(horizonColorDayCheckBox.isSelected()) {
					horizonColorDayField.setEnabled(true);
					horizonColorDayField.setVisible(true);
				}else {
					horizonColorDayField.setEnabled(false);
					horizonColorDayField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, horizonColorDayCheckBox, -2, SpringLayout.NORTH, lightColorDayField);
		springLayout_2.putConstraint(SpringLayout.EAST, horizonColorDayCheckBox, -6, SpringLayout.WEST, horizonColorDayField);
		horizonColorDayCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(horizonColorDayCheckBox);
		
		lightColorDayCheckBox = new JCheckBox("Day:");
		lightColorDayCheckBox.setToolTipText("Color of the directional sun light during the day, night, sunrise or sunset. Enable to Set");
		lightColorDayCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lightColorDayCheckBox.isSelected()) {
					lightColorDayField.setEnabled(true);
					lightColorDayField.setVisible(true);
				}else {
					lightColorDayField.setEnabled(false);
					lightColorDayField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.SOUTH, lblLightColour, -3, SpringLayout.NORTH, lightColorDayCheckBox);
		springLayout_2.putConstraint(SpringLayout.NORTH, lightColorDayCheckBox, -2, SpringLayout.NORTH, lightColorDayField);
		springLayout_2.putConstraint(SpringLayout.EAST, lightColorDayCheckBox, -6, SpringLayout.WEST, lightColorDayField);
		lightColorDayCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(lightColorDayCheckBox);
		
		ambientColorDayCheckBox = new JCheckBox("Day:");
		ambientColorDayCheckBox.setToolTipText("Color of the ambient sun light during the day, night, sunrise or sunset. Enable to set");
		ambientColorDayCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ambientColorDayCheckBox.isSelected()) {
					ambientColorDayField.setEnabled(true);
					ambientColorDayField.setVisible(true);
				}else {
					ambientColorDayField.setEnabled(false);
					ambientColorDayField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.EAST, ambientColorDayCheckBox, -6, SpringLayout.WEST, ambientColorDayField);
		springLayout_2.putConstraint(SpringLayout.SOUTH, lblAmbientColor, -2, SpringLayout.NORTH, ambientColorDayCheckBox);
		springLayout_2.putConstraint(SpringLayout.NORTH, ambientColorDayCheckBox, -2, SpringLayout.NORTH, ambientColorDayField);
		ambientColorDayCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(ambientColorDayCheckBox);
		
		lightColorNightCheckBox = new JCheckBox("Night:");
		lightColorNightCheckBox.setToolTipText("Color of the directional sun light during the day, night, sunrise or sunset. Enable to Set");
		lightColorNightCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lightColorNightCheckBox.isSelected()) {
					lightColorNightField.setEnabled(true);
					lightColorNightField.setVisible(true);
				}else {
					lightColorNightField.setEnabled(false);
					lightColorNightField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.EAST, lightColorNightCheckBox, -595, SpringLayout.EAST, internalFrame_2.getContentPane());
		springLayout_2.putConstraint(SpringLayout.WEST, lightColorNightField, 6, SpringLayout.EAST, lightColorNightCheckBox);
		springLayout_2.putConstraint(SpringLayout.NORTH, lightColorNightCheckBox, -2, SpringLayout.NORTH, lightColorNightField);
		lightColorNightCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(lightColorNightCheckBox);
		
		horizonColorNightCheckBox = new JCheckBox("Night:");
		horizonColorNightCheckBox.setToolTipText("Color of the horizon (lower part of the sky) during the day, night, sunrise or sunset. Enable to set");
		horizonColorNightCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(horizonColorNightCheckBox.isSelected()) {
					horizonColorNightField.setEnabled(true);
					horizonColorNightField.setVisible(true);
				}else {
					horizonColorNightField.setEnabled(false);
					horizonColorNightField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.EAST, lightColorNightField, -127, SpringLayout.WEST, horizonColorNightCheckBox);
		springLayout_2.putConstraint(SpringLayout.NORTH, horizonColorNightCheckBox, -2, SpringLayout.NORTH, lightColorNightField);
		springLayout_2.putConstraint(SpringLayout.EAST, horizonColorNightCheckBox, -6, SpringLayout.WEST, horizonColorNightField);
		horizonColorNightCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(horizonColorNightCheckBox);
		
		skyColorNightCheckBox = new JCheckBox("Night:");
		skyColorNightCheckBox.setToolTipText("Color of the sky during the day, night, sunrise or sunset. Enable to set");
		skyColorNightCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(skyColorNightCheckBox.isSelected()) {
					skyColorNightField.setEnabled(true);
					skyColorNightField.setVisible(true);
				}else {
					skyColorNightField.setEnabled(false);
					skyColorNightField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, skyColorNightCheckBox, -2, SpringLayout.NORTH, ambientColorNightField);
		springLayout_2.putConstraint(SpringLayout.EAST, skyColorNightCheckBox, -6, SpringLayout.WEST, skyColorNightField);
		skyColorNightCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(skyColorNightCheckBox);
		
		ambientColorNightCheckBox = new JCheckBox("Night:");
		ambientColorNightCheckBox.setToolTipText("Color of the ambient sun light during the day, night, sunrise or sunset. Enable to set");
		ambientColorNightCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ambientColorNightCheckBox.isSelected()) {
					ambientColorNightField.setEnabled(true);
					ambientColorNightField.setVisible(true);
				}else {
					ambientColorNightField.setEnabled(false);
					ambientColorNightField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, ambientColorNightCheckBox, -2, SpringLayout.NORTH, ambientColorNightField);
		springLayout_2.putConstraint(SpringLayout.EAST, ambientColorNightCheckBox, -6, SpringLayout.WEST, ambientColorNightField);
		ambientColorNightCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(ambientColorNightCheckBox);
		
		lightColorTwilightCheckBox = new JCheckBox("Twilight:");
		lightColorTwilightCheckBox.setToolTipText("Color of the directional sun light during the day, night, sunrise or sunset. Enable to Set");
		lightColorTwilightCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lightColorTwilightCheckBox.isSelected()) {
					lightColorTwilightField.setEnabled(true);
					lightColorTwilightField.setVisible(true);
				}else {
					lightColorTwilightField.setEnabled(false);
					lightColorTwilightField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, lightColorTwilightCheckBox, -2, SpringLayout.NORTH, lightColorTwilightField);
		springLayout_2.putConstraint(SpringLayout.EAST, lightColorTwilightCheckBox, -6, SpringLayout.WEST, lightColorTwilightField);
		lightColorTwilightCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(lightColorTwilightCheckBox);
		
		ambientColorTwilightCheckBox = new JCheckBox("Twilight:");
		ambientColorTwilightCheckBox.setToolTipText("Color of the ambient sun light during the day, night, sunrise or sunset. Enable to set");
		ambientColorTwilightCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ambientColorTwilightCheckBox.isSelected()) {
					ambientColorTwilightField.setEnabled(true);
					ambientColorTwilightField.setVisible(true);
				}else {
					ambientColorTwilightField.setEnabled(false);
					ambientColorTwilightField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, ambientColorTwilightCheckBox, -2, SpringLayout.NORTH, ambientColorTwilightField);
		springLayout_2.putConstraint(SpringLayout.EAST, ambientColorTwilightCheckBox, -6, SpringLayout.WEST, ambientColorTwilightField);
		ambientColorTwilightCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(ambientColorTwilightCheckBox);
		
		horizonColorTwilightCheckBox = new JCheckBox("Twilight:");
		horizonColorTwilightCheckBox.setToolTipText("Color of the horizon (lower part of the sky) during the day, night, sunrise or sunset. Enable to set");
		horizonColorTwilightCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(horizonColorTwilightCheckBox.isSelected()) {
					horizonColorTwilightField.setEnabled(true);
					horizonColorTwilightField.setVisible(true);
				}else {
					horizonColorTwilightField.setEnabled(false);
					horizonColorTwilightField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, horizonColorTwilightCheckBox, -2, SpringLayout.NORTH, lightColorTwilightField);
		springLayout_2.putConstraint(SpringLayout.EAST, horizonColorTwilightCheckBox, -6, SpringLayout.WEST, horizonColorTwilightField);
		horizonColorTwilightCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(horizonColorTwilightCheckBox);
		
		skyColorTwilightCheckBox = new JCheckBox("Twilight:");
		skyColorTwilightCheckBox.setToolTipText("Color of the sky during the day, night, sunrise or sunset. Enable to set");
		skyColorTwilightCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(skyColorTwilightCheckBox.isSelected()) {
					skyColorTwilightField.setEnabled(true);
					skyColorTwilightField.setVisible(true);
				}else {
					skyColorTwilightField.setEnabled(false);
					skyColorTwilightField.setVisible(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, skyColorTwilightCheckBox, -2, SpringLayout.NORTH, ambientColorTwilightField);
		springLayout_2.putConstraint(SpringLayout.WEST, skyColorTwilightCheckBox, 0, SpringLayout.WEST, horizonColorTwilightCheckBox);
		skyColorTwilightCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(skyColorTwilightCheckBox);
		
		dayHoursCheckBox = new JCheckBox("Day Hours:");
		dayHoursCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dayHoursCheckBox.isSelected()) {
					dayHoursSpinner.setEnabled(true);
				}else {
					dayHoursSpinner.setEnabled(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.SOUTH, lblOverrideMapIndex, -6, SpringLayout.NORTH, dayHoursCheckBox);
		springLayout_2.putConstraint(SpringLayout.NORTH, dayHoursCheckBox, -1, SpringLayout.NORTH, dayHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, dayHoursCheckBox, -6, SpringLayout.WEST, dayHoursSpinner);
		dayHoursCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(dayHoursCheckBox);
		
		nightHoursCheckBox = new JCheckBox("Night Hours:");
		nightHoursCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nightHoursCheckBox.isSelected()) {
					nightHoursSpinner.setEnabled(true);
				}else {
					nightHoursSpinner.setEnabled(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, nightHoursCheckBox, -1, SpringLayout.NORTH, nightHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, nightHoursCheckBox, -6, SpringLayout.WEST, nightHoursSpinner);
		nightHoursCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(nightHoursCheckBox);
		
		fogIntensityPercentageDayCheckBox = new JCheckBox("Day:");
		fogIntensityPercentageDayCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fogIntensityPercentageDayCheckBox.isSelected()) {
					fogIntensityPercentageDaySpinner.setEnabled(true);
				}else {
					fogIntensityPercentageDaySpinner.setEnabled(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, fogIntensityPercentageDayCheckBox, -1, SpringLayout.NORTH, fogIntensityPercentageDaySpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, fogIntensityPercentageDayCheckBox, -6, SpringLayout.WEST, fogIntensityPercentageDaySpinner);
		fogIntensityPercentageDayCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(fogIntensityPercentageDayCheckBox);
		
		JLabel lblFogIntensity = new JLabel("FOG INTENSITY (%):");
		springLayout_2.putConstraint(SpringLayout.NORTH, fogIntensityPercentageDaySpinner, 6, SpringLayout.SOUTH, lblFogIntensity);
		springLayout_2.putConstraint(SpringLayout.NORTH, lblFogIntensity, 20, SpringLayout.SOUTH, ambientColorTwilightCheckBox);
		springLayout_2.putConstraint(SpringLayout.WEST, lblFogIntensity, 0, SpringLayout.WEST, lblLightColour);
		internalFrame_2.getContentPane().add(lblFogIntensity);
		
		fogIntensityPercentageNightSpinner = new JSpinner();
		fogIntensityPercentageNightSpinner.setToolTipText("Intensity of the fog during the day, night, sunrise or sunset.");
		fogIntensityPercentageNightSpinner.setEnabled(false);
		fogIntensityPercentageNightSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		springLayout_2.putConstraint(SpringLayout.NORTH, fogIntensityPercentageNightSpinner, 6, SpringLayout.SOUTH, fogIntensityPercentageDaySpinner);
		springLayout_2.putConstraint(SpringLayout.WEST, fogIntensityPercentageNightSpinner, 0, SpringLayout.WEST, dayHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, fogIntensityPercentageNightSpinner, 0, SpringLayout.EAST, dayHoursSpinner);
		internalFrame_2.getContentPane().add(fogIntensityPercentageNightSpinner);
		
		fogIntensityPercentageTwilightSpinner = new JSpinner();
		fogIntensityPercentageTwilightSpinner.setToolTipText("Intensity of the fog during the day, night, sunrise or sunset.");
		fogIntensityPercentageTwilightSpinner.setEnabled(false);
		fogIntensityPercentageTwilightSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		springLayout_2.putConstraint(SpringLayout.NORTH, fogIntensityPercentageTwilightSpinner, 6, SpringLayout.SOUTH, fogIntensityPercentageNightSpinner);
		springLayout_2.putConstraint(SpringLayout.WEST, fogIntensityPercentageTwilightSpinner, 0, SpringLayout.WEST, dayHoursSpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, fogIntensityPercentageTwilightSpinner, 0, SpringLayout.EAST, dayHoursSpinner);
		internalFrame_2.getContentPane().add(fogIntensityPercentageTwilightSpinner);
		
		fogIntensityPercentageNightCheckBox = new JCheckBox("Night:");
		fogIntensityPercentageNightCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fogIntensityPercentageNightCheckBox.isSelected()) {
					fogIntensityPercentageNightSpinner.setEnabled(true);
				}else {
					fogIntensityPercentageNightSpinner.setEnabled(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, fogIntensityPercentageNightCheckBox, 6, SpringLayout.SOUTH, fogIntensityPercentageDaySpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, fogIntensityPercentageNightCheckBox, 0, SpringLayout.EAST, lblOverrideMapIndex);
		fogIntensityPercentageNightCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(fogIntensityPercentageNightCheckBox);
		
		fogIntensityPercentageTwilightCheckBox = new JCheckBox("Twilight:");
		fogIntensityPercentageTwilightCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fogIntensityPercentageTwilightCheckBox.isSelected()) {
					fogIntensityPercentageTwilightSpinner.setEnabled(true);
				}else {
					fogIntensityPercentageTwilightSpinner.setEnabled(false);
				}
			}
		});
		springLayout_2.putConstraint(SpringLayout.NORTH, fogIntensityPercentageTwilightCheckBox, 6, SpringLayout.SOUTH, fogIntensityPercentageNightSpinner);
		springLayout_2.putConstraint(SpringLayout.EAST, fogIntensityPercentageTwilightCheckBox, 0, SpringLayout.EAST, lblOverrideMapIndex);
		fogIntensityPercentageTwilightCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_2.getContentPane().add(fogIntensityPercentageTwilightCheckBox);
		
		JInternalFrame internalFrame_3 = new JInternalFrame("Terrain Settings");
		internalFrame_3.setFrameIcon(new ImageIcon(EditorWindow.class.getResource("/ie/provector/jpbce/icons/terrain16.png")));
		tabbedPane.addTab("Terrain", null, internalFrame_3, null);
		SpringLayout springLayout_3 = new SpringLayout();
		internalFrame_3.getContentPane().setLayout(springLayout_3);
		
		heightOffsetSpinner = new JSpinner();
		heightOffsetSpinner.setToolTipText("Moves the whole terrain up or down, it generates more or less mountains value: Number greater than 0. Even small values will have a large effect.");
		heightOffsetSpinner.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.WEST, heightOffsetSpinner, 210, SpringLayout.WEST, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.EAST, heightOffsetSpinner, -446, SpringLayout.EAST, internalFrame_3.getContentPane());
		heightOffsetSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01f)));
		internalFrame_3.getContentPane().add(heightOffsetSpinner);
		
		xLabel = new JLabel("x:");
		xLabel.setEnabled(false);
		internalFrame_3.getContentPane().add(xLabel);
		
		xSpinner = new JSpinner();
		xSpinner.setToolTipText("Scales the backdrops (the mountains behind the heightmap) in the environment");
		xSpinner.setModel(new SpinnerNumberModel(new Float(1.0f), null, null, new Float(0.1f)));
		xSpinner.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, xLabel, 3, SpringLayout.NORTH, xSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, xLabel, -6, SpringLayout.WEST, xSpinner);
		springLayout_3.putConstraint(SpringLayout.WEST, xSpinner, 0, SpringLayout.WEST, heightOffsetSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, xSpinner, 0, SpringLayout.EAST, heightOffsetSpinner);
		internalFrame_3.getContentPane().add(xSpinner);
		
		yLabel = new JLabel("y:");
		yLabel.setEnabled(false);
		internalFrame_3.getContentPane().add(yLabel);
		
		ySpinner = new JSpinner();
		ySpinner.setToolTipText("Scales the backdrops (the mountains behind the heightmap) in the environment");
		ySpinner.setModel(new SpinnerNumberModel(new Float(1.0f), null, null, new Float(0.1f)));
		ySpinner.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, yLabel, 3, SpringLayout.NORTH, ySpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, yLabel, -6, SpringLayout.WEST, ySpinner);
		springLayout_3.putConstraint(SpringLayout.SOUTH, xSpinner, -6, SpringLayout.NORTH, ySpinner);
		springLayout_3.putConstraint(SpringLayout.WEST, ySpinner, 210, SpringLayout.WEST, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.EAST, ySpinner, 0, SpringLayout.EAST, heightOffsetSpinner);
		internalFrame_3.getContentPane().add(ySpinner);
		
		zLabel = new JLabel("z:");
		zLabel.setEnabled(false);
		internalFrame_3.getContentPane().add(zLabel);
		
		zSpinner = new JSpinner();
		zSpinner.setToolTipText("Scales the backdrops (the mountains behind the heightmap) in the environment");
		zSpinner.setModel(new SpinnerNumberModel(new Float(1.0f), null, null, new Float(0.1f)));
		zSpinner.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, zLabel, 3, SpringLayout.NORTH, zSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, zLabel, -6, SpringLayout.WEST, zSpinner);
		springLayout_3.putConstraint(SpringLayout.NORTH, zSpinner, 216, SpringLayout.NORTH, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.SOUTH, ySpinner, -6, SpringLayout.NORTH, zSpinner);
		springLayout_3.putConstraint(SpringLayout.NORTH, heightOffsetSpinner, 24, SpringLayout.SOUTH, zSpinner);
		springLayout_3.putConstraint(SpringLayout.WEST, zSpinner, 0, SpringLayout.WEST, heightOffsetSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, zSpinner, -446, SpringLayout.EAST, internalFrame_3.getContentPane());
		internalFrame_3.getContentPane().add(zSpinner);
		
		liquidColorField = new JTextField();
		liquidColorField.setToolTipText("Specifies the color of the lakes.");
		liquidColorField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showColorPicker((JTextField)arg0.getSource());
			}
		});
		liquidColorField.setVisible(false);
		liquidColorField.setEnabled(false);
		liquidColorField.setEditable(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, liquidColorField, 6, SpringLayout.SOUTH, heightOffsetSpinner);
		springLayout_3.putConstraint(SpringLayout.WEST, liquidColorField, 210, SpringLayout.WEST, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.EAST, liquidColorField, -446, SpringLayout.EAST, internalFrame_3.getContentPane());
		internalFrame_3.getContentPane().add(liquidColorField);
		liquidColorField.setColumns(10);
		
		hslFlat1Field = new JTextField();
		springLayout_3.putConstraint(SpringLayout.WEST, hslFlat1Field, 0, SpringLayout.WEST, heightOffsetSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, hslFlat1Field, 0, SpringLayout.EAST, heightOffsetSpinner);
		hslFlat1Field.setToolTipText("Changes the color of one of the textures, by applying a Hue, Saturation, Lighness transform");
		hslFlat1Field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showHSLColorPicker((JTextField)e.getSource());
			}
		});
		hslFlat1Field.setVisible(false);
		hslFlat1Field.setEnabled(false);
		hslFlat1Field.setEditable(false);
		hslFlat1Field.setColumns(10);
		internalFrame_3.getContentPane().add(hslFlat1Field);
		
		ttFlat1Field = new JTextField();
		springLayout_3.putConstraint(SpringLayout.NORTH, ttFlat1Field, 338, SpringLayout.NORTH, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.EAST, ttFlat1Field, -446, SpringLayout.EAST, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.NORTH, hslFlat1Field, 6, SpringLayout.SOUTH, ttFlat1Field);
		ttFlat1Field.setToolTipText("Changes the color of one of the textures, by multiplying it by another color");
		ttFlat1Field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField)e.getSource());
			}
		});
		ttFlat1Field.setVisible(false);
		ttFlat1Field.setEnabled(false);
		ttFlat1Field.setEditable(false);
		ttFlat1Field.setColumns(10);
		internalFrame_3.getContentPane().add(ttFlat1Field);
		
		heightMultiplierPercentageSpinner = new JSpinner();
		heightMultiplierPercentageSpinner.setToolTipText("Multiplies the terrain height of everything, it makes mountains higher or lower.");
		heightMultiplierPercentageSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		heightMultiplierPercentageSpinner.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, heightMultiplierPercentageSpinner, 6, SpringLayout.NORTH, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.WEST, heightMultiplierPercentageSpinner, 210, SpringLayout.WEST, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.EAST, heightMultiplierPercentageSpinner, -446, SpringLayout.EAST, internalFrame_3.getContentPane());
		internalFrame_3.getContentPane().add(heightMultiplierPercentageSpinner);
		
		craterDensityPercentageSpinner = new JSpinner();
		craterDensityPercentageSpinner.setToolTipText("Specifies how many meteor craters there will be in the terrain.");
		craterDensityPercentageSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		craterDensityPercentageSpinner.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, craterDensityPercentageSpinner, 6, SpringLayout.SOUTH, heightMultiplierPercentageSpinner);
		springLayout_3.putConstraint(SpringLayout.WEST, craterDensityPercentageSpinner, 0, SpringLayout.WEST, heightOffsetSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, craterDensityPercentageSpinner, 0, SpringLayout.EAST, heightOffsetSpinner);
		internalFrame_3.getContentPane().add(craterDensityPercentageSpinner);
		
		distantHeightOffsetPercentageSpinner = new JSpinner();
		distantHeightOffsetPercentageSpinner.setToolTipText("Makes distant terrain higher or lower value: Number.");
		distantHeightOffsetPercentageSpinner.setModel(new SpinnerNumberModel(0, -100, 100, 1));
		distantHeightOffsetPercentageSpinner.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, distantHeightOffsetPercentageSpinner, 6, SpringLayout.SOUTH, craterDensityPercentageSpinner);
		springLayout_3.putConstraint(SpringLayout.WEST, distantHeightOffsetPercentageSpinner, 0, SpringLayout.WEST, heightOffsetSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, distantHeightOffsetPercentageSpinner, 0, SpringLayout.EAST, heightOffsetSpinner);
		internalFrame_3.getContentPane().add(distantHeightOffsetPercentageSpinner);
		
		liquidPercentageSpinner = new JSpinner();
		liquidPercentageSpinner.setToolTipText("Specifies how many lakes there will be in the planet.");
		liquidPercentageSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		liquidPercentageSpinner.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, liquidPercentageSpinner, 6, SpringLayout.SOUTH, distantHeightOffsetPercentageSpinner);
		springLayout_3.putConstraint(SpringLayout.WEST, liquidPercentageSpinner, 0, SpringLayout.WEST, heightOffsetSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, liquidPercentageSpinner, 0, SpringLayout.EAST, heightOffsetSpinner);
		internalFrame_3.getContentPane().add(liquidPercentageSpinner);
		
		heightMultiplierPercentageCheckBox = new JCheckBox("Height Multiplier %:");
		heightMultiplierPercentageCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(heightMultiplierPercentageCheckBox.isSelected()) {
					heightMultiplierPercentageSpinner.setEnabled(true);
				}else {
					heightMultiplierPercentageSpinner.setEnabled(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.EAST, heightMultiplierPercentageCheckBox, -6, SpringLayout.WEST, heightMultiplierPercentageSpinner);
		heightMultiplierPercentageCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		springLayout_3.putConstraint(SpringLayout.NORTH, heightMultiplierPercentageCheckBox, 0, SpringLayout.NORTH, heightMultiplierPercentageSpinner);
		internalFrame_3.getContentPane().add(heightMultiplierPercentageCheckBox);
		
		craterDensityPercentageCheckBox = new JCheckBox("Crater Density %:");
		craterDensityPercentageCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(craterDensityPercentageCheckBox.isSelected()) {
					craterDensityPercentageSpinner.setEnabled(true);
				}else {
					craterDensityPercentageSpinner.setEnabled(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.EAST, craterDensityPercentageCheckBox, -6, SpringLayout.WEST, craterDensityPercentageSpinner);
		craterDensityPercentageCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		springLayout_3.putConstraint(SpringLayout.NORTH, craterDensityPercentageCheckBox, 2, SpringLayout.SOUTH, heightMultiplierPercentageCheckBox);
		internalFrame_3.getContentPane().add(craterDensityPercentageCheckBox);
		
		distantHeightOffsetPercentageCheckBox = new JCheckBox("Distant Height Offset % -/+:");
		distantHeightOffsetPercentageCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(distantHeightOffsetPercentageCheckBox.isSelected()) {
					distantHeightOffsetPercentageSpinner.setEnabled(true);
				}else {
					distantHeightOffsetPercentageSpinner.setEnabled(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.EAST, distantHeightOffsetPercentageCheckBox, -6, SpringLayout.WEST, distantHeightOffsetPercentageSpinner);
		distantHeightOffsetPercentageCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		springLayout_3.putConstraint(SpringLayout.NORTH, distantHeightOffsetPercentageCheckBox, 0, SpringLayout.NORTH, distantHeightOffsetPercentageSpinner);
		internalFrame_3.getContentPane().add(distantHeightOffsetPercentageCheckBox);
		
		liquidPercentageCheckBox = new JCheckBox("Liquid %:");
		liquidPercentageCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(liquidPercentageCheckBox.isSelected()) {
					liquidPercentageSpinner.setEnabled(true);
				}else {
					liquidPercentageSpinner.setEnabled(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.EAST, liquidPercentageCheckBox, -6, SpringLayout.WEST, liquidPercentageSpinner);
		liquidPercentageCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		springLayout_3.putConstraint(SpringLayout.NORTH, liquidPercentageCheckBox, 0, SpringLayout.NORTH, liquidPercentageSpinner);
		internalFrame_3.getContentPane().add(liquidPercentageCheckBox);
		
		backdropScaleCheckBox = new JCheckBox("BACKDROP SCALE:");
		backdropScaleCheckBox.setToolTipText("Scales the backdrops (the mountains behind the heightmap) in the environment");
		backdropScaleCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(backdropScaleCheckBox.isSelected()) {
					xSpinner.setEnabled(true);
					ySpinner.setEnabled(true);
					zSpinner.setEnabled(true);
					xLabel.setEnabled(true);
					yLabel.setEnabled(true);
					zLabel.setEnabled(true);
				}else {
					xSpinner.setEnabled(false);
					ySpinner.setEnabled(false);
					zSpinner.setEnabled(false);
					xLabel.setEnabled(false);
					yLabel.setEnabled(false);
					zLabel.setEnabled(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.SOUTH, backdropScaleCheckBox, -9, SpringLayout.NORTH, xLabel);
		springLayout_3.putConstraint(SpringLayout.EAST, backdropScaleCheckBox, 0, SpringLayout.EAST, xLabel);
		backdropScaleCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_3.getContentPane().add(backdropScaleCheckBox);
		
		liquidColorCheckBox = new JCheckBox("  Liquid Color:");
		liquidColorCheckBox.setToolTipText("Specifies the color of the lakes. Enable to set");
		liquidColorCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(liquidColorCheckBox.isSelected()) {
					liquidColorField.setEnabled(true);
					liquidColorField.setVisible(true);
				}else {
					liquidColorField.setEnabled(false);
					liquidColorField.setVisible(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.EAST, liquidColorCheckBox, -6, SpringLayout.WEST, liquidColorField);
		liquidColorCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		springLayout_3.putConstraint(SpringLayout.SOUTH, liquidColorCheckBox, -215, SpringLayout.SOUTH, internalFrame_3.getContentPane());
		internalFrame_3.getContentPane().add(liquidColorCheckBox);
		
		heightOffsetCheckBox = new JCheckBox("Height Offset:");
		heightOffsetCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(heightOffsetCheckBox.isSelected()) {
					heightOffsetSpinner.setEnabled(true);
				}else {
					heightOffsetSpinner.setEnabled(false);
				}
			}
		});
		heightOffsetCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		springLayout_3.putConstraint(SpringLayout.SOUTH, heightOffsetCheckBox, 0, SpringLayout.SOUTH, heightOffsetSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, heightOffsetCheckBox, -6, SpringLayout.WEST, heightOffsetSpinner);
		internalFrame_3.getContentPane().add(heightOffsetCheckBox);
		
		ttFlat1CheckBox = new JCheckBox("Tint Texture:");
		springLayout_3.putConstraint(SpringLayout.WEST, ttFlat1Field, 6, SpringLayout.EAST, ttFlat1CheckBox);
		springLayout_3.putConstraint(SpringLayout.NORTH, ttFlat1CheckBox, -2, SpringLayout.NORTH, ttFlat1Field);
		springLayout_3.putConstraint(SpringLayout.EAST, ttFlat1CheckBox, 0, SpringLayout.EAST, xLabel);
		ttFlat1CheckBox.setToolTipText("Changes the color of one of the textures, by multiplying it by another color. Enable to set");
		ttFlat1CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ttFlat1CheckBox.isSelected()) {
					ttFlat1Field.setEnabled(true);
					ttFlat1Field.setVisible(true);
				}else {
					ttFlat1Field.setEnabled(false);
					ttFlat1Field.setVisible(false);
				}
			}
		});
		ttFlat1CheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_3.getContentPane().add(ttFlat1CheckBox);
		
		hslFlat1CheckBox = new JCheckBox("HSL Transform Texture:");
		springLayout_3.putConstraint(SpringLayout.NORTH, hslFlat1CheckBox, -2, SpringLayout.NORTH, hslFlat1Field);
		springLayout_3.putConstraint(SpringLayout.EAST, hslFlat1CheckBox, 0, SpringLayout.EAST, xLabel);
		hslFlat1CheckBox.setToolTipText("Changes the color of one of the textures, by applying a Hue, Saturation, Lighness transform. Enable to set");
		hslFlat1CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hslFlat1CheckBox.isSelected()) {
					hslFlat1Field.setEnabled(true);
					hslFlat1Field.setVisible(true);
				}else {
					hslFlat1Field.setEnabled(false);
					hslFlat1Field.setVisible(false);
				}
			}
		});
		hslFlat1CheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_3.getContentPane().add(hslFlat1CheckBox);
		
		JLabel lblFlat = new JLabel("Flat1");
		springLayout_3.putConstraint(SpringLayout.SOUTH, lblFlat, -6, SpringLayout.NORTH, ttFlat1Field);
		springLayout_3.putConstraint(SpringLayout.EAST, lblFlat, -10, SpringLayout.EAST, liquidColorField);
		internalFrame_3.getContentPane().add(lblFlat);
		
		ttFlat2Field = new JTextField();
		ttFlat2Field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		ttFlat2Field.setEditable(false);
		ttFlat2Field.setVisible(false);
		ttFlat2Field.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, ttFlat2Field, 0, SpringLayout.NORTH, ttFlat1Field);
		springLayout_3.putConstraint(SpringLayout.EAST, ttFlat2Field, -355, SpringLayout.EAST, internalFrame_3.getContentPane());
		internalFrame_3.getContentPane().add(ttFlat2Field);
		ttFlat2Field.setColumns(10);
		
		hslFlat2Field = new JTextField();
		hslFlat2Field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showHSLColorPicker((JTextField) e.getSource());
			}
		});
		hslFlat2Field.setEditable(false);
		hslFlat2Field.setVisible(false);
		hslFlat2Field.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, hslFlat2Field, 0, SpringLayout.NORTH, hslFlat1Field);
		springLayout_3.putConstraint(SpringLayout.WEST, hslFlat2Field, 0, SpringLayout.WEST, ttFlat2Field);
		springLayout_3.putConstraint(SpringLayout.EAST, hslFlat2Field, -355, SpringLayout.EAST, internalFrame_3.getContentPane());
		internalFrame_3.getContentPane().add(hslFlat2Field);
		hslFlat2Field.setColumns(10);
		
		JLabel lblFlat_1 = new JLabel("Flat2");
		springLayout_3.putConstraint(SpringLayout.NORTH, lblFlat_1, 0, SpringLayout.NORTH, lblFlat);
		springLayout_3.putConstraint(SpringLayout.WEST, lblFlat_1, 61, SpringLayout.EAST, lblFlat);
		internalFrame_3.getContentPane().add(lblFlat_1);
		
		ttSlopeField = new JTextField();
		ttSlopeField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		ttSlopeField.setEditable(false);
		ttSlopeField.setVisible(false);
		ttSlopeField.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, ttSlopeField, 0, SpringLayout.NORTH, ttFlat1Field);
		springLayout_3.putConstraint(SpringLayout.WEST, ttSlopeField, 390, SpringLayout.WEST, internalFrame_3.getContentPane());
		internalFrame_3.getContentPane().add(ttSlopeField);
		ttSlopeField.setColumns(10);
		
		hslSlopeField = new JTextField();
		hslSlopeField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showHSLColorPicker((JTextField) e.getSource());
			}
		});
		hslSlopeField.setEditable(false);
		hslSlopeField.setVisible(false);
		hslSlopeField.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, hslSlopeField, 0, SpringLayout.NORTH, hslFlat1Field);
		springLayout_3.putConstraint(SpringLayout.WEST, hslSlopeField, 0, SpringLayout.WEST, ttSlopeField);
		springLayout_3.putConstraint(SpringLayout.EAST, hslSlopeField, 0, SpringLayout.EAST, ttSlopeField);
		internalFrame_3.getContentPane().add(hslSlopeField);
		hslSlopeField.setColumns(10);
		
		ttFoundationsField = new JTextField();
		ttFoundationsField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		ttFoundationsField.setEditable(false);
		ttFoundationsField.setVisible(false);
		ttFoundationsField.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, ttFoundationsField, 0, SpringLayout.NORTH, ttFlat1Field);
		springLayout_3.putConstraint(SpringLayout.EAST, ttFoundationsField, -175, SpringLayout.EAST, internalFrame_3.getContentPane());
		internalFrame_3.getContentPane().add(ttFoundationsField);
		ttFoundationsField.setColumns(10);
		
		hslFoundationsField = new JTextField();
		hslFoundationsField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showHSLColorPicker((JTextField) e.getSource());
			}
		});
		hslFoundationsField.setEditable(false);
		hslFoundationsField.setVisible(false);
		hslFoundationsField.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, hslFoundationsField, 0, SpringLayout.NORTH, hslFlat1Field);
		springLayout_3.putConstraint(SpringLayout.WEST, hslFoundationsField, 481, SpringLayout.WEST, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.EAST, hslFoundationsField, 0, SpringLayout.EAST, ttFoundationsField);
		internalFrame_3.getContentPane().add(hslFoundationsField);
		hslFoundationsField.setColumns(10);
		
		JLabel lblSlope = new JLabel("Slope");
		springLayout_3.putConstraint(SpringLayout.NORTH, lblSlope, 0, SpringLayout.NORTH, lblFlat);
		springLayout_3.putConstraint(SpringLayout.WEST, lblSlope, 58, SpringLayout.EAST, lblFlat_1);
		internalFrame_3.getContentPane().add(lblSlope);
		
		JLabel lblFoundations = new JLabel("Foundations");
		springLayout_3.putConstraint(SpringLayout.WEST, lblFoundations, 39, SpringLayout.EAST, lblSlope);
		internalFrame_3.getContentPane().add(lblFoundations);
		
		ttFlat2CheckBox = new JCheckBox("");
		ttFlat2CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ttFlat2CheckBox.isSelected()) {
					ttFlat2Field.setEnabled(true);
					ttFlat2Field.setVisible(true);
				}else {
					ttFlat2Field.setEnabled(false);
					ttFlat2Field.setVisible(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.WEST, ttFlat2Field, 6, SpringLayout.EAST, ttFlat2CheckBox);
		springLayout_3.putConstraint(SpringLayout.WEST, ttFlat2CheckBox, 6, SpringLayout.EAST, ttFlat1Field);
		springLayout_3.putConstraint(SpringLayout.SOUTH, ttFlat2CheckBox, 0, SpringLayout.SOUTH, ttFlat1CheckBox);
		internalFrame_3.getContentPane().add(ttFlat2CheckBox);
		
		hslFlat2CheckBox = new JCheckBox("");
		hslFlat2CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hslFlat2CheckBox.isSelected()) {
					hslFlat2Field.setEnabled(true);
					hslFlat2Field.setVisible(true);
				}else {
					hslFlat2Field.setEnabled(false);
					hslFlat2Field.setVisible(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.NORTH, hslFlat2CheckBox, 0, SpringLayout.NORTH, hslFlat1Field);
		springLayout_3.putConstraint(SpringLayout.WEST, hslFlat2CheckBox, 6, SpringLayout.EAST, hslFlat1Field);
		internalFrame_3.getContentPane().add(hslFlat2CheckBox);
		
		ttSlopeCheckBox = new JCheckBox("");
		ttSlopeCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ttSlopeCheckBox.isSelected()) {
					ttSlopeField.setEnabled(true);
					ttSlopeField.setVisible(true);
				}else {
					ttSlopeField.setEnabled(false);
					ttSlopeField.setVisible(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.EAST, ttSlopeCheckBox, -4, SpringLayout.WEST, ttSlopeField);
		internalFrame_3.getContentPane().add(ttSlopeCheckBox);
		
		hslSlopeCheckBox = new JCheckBox("");
		hslSlopeCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hslSlopeCheckBox.isSelected()) {
					hslSlopeField.setEnabled(true);
					hslSlopeField.setVisible(true);
				}else {
					hslSlopeField.setEnabled(false);
					hslSlopeField.setVisible(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.SOUTH, ttSlopeCheckBox, -4, SpringLayout.NORTH, hslSlopeCheckBox);
		springLayout_3.putConstraint(SpringLayout.NORTH, hslSlopeCheckBox, 0, SpringLayout.NORTH, hslFlat1Field);
		springLayout_3.putConstraint(SpringLayout.WEST, hslSlopeCheckBox, 6, SpringLayout.EAST, hslFlat2Field);
		internalFrame_3.getContentPane().add(hslSlopeCheckBox);
		
		ttFoundationsCheckBox = new JCheckBox("");
		ttFoundationsCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ttFoundationsCheckBox.isSelected()) {
					ttFoundationsField.setEnabled(true);
					ttFoundationsField.setVisible(true);
				}else {
					ttFoundationsField.setEnabled(false);
					ttFoundationsField.setVisible(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.EAST, ttSlopeField, -6, SpringLayout.WEST, ttFoundationsCheckBox);
		springLayout_3.putConstraint(SpringLayout.SOUTH, lblFoundations, -4, SpringLayout.NORTH, ttFoundationsCheckBox);
		springLayout_3.putConstraint(SpringLayout.WEST, ttFoundationsCheckBox, 450, SpringLayout.WEST, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.WEST, ttFoundationsField, 6, SpringLayout.EAST, ttFoundationsCheckBox);
		springLayout_3.putConstraint(SpringLayout.SOUTH, ttFoundationsCheckBox, 0, SpringLayout.SOUTH, ttFlat1CheckBox);
		internalFrame_3.getContentPane().add(ttFoundationsCheckBox);
		
		hslFoundationsCheckBox = new JCheckBox("");
		hslFoundationsCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hslFoundationsCheckBox.isSelected()) {
					hslFoundationsField.setEnabled(true);
					hslFoundationsField.setVisible(true);
				}else {
					hslFoundationsField.setEnabled(false);
					hslFoundationsField.setVisible(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.SOUTH, hslFoundationsCheckBox, 0, SpringLayout.SOUTH, hslFlat1CheckBox);
		springLayout_3.putConstraint(SpringLayout.EAST, hslFoundationsCheckBox, -6, SpringLayout.WEST, hslFoundationsField);
		internalFrame_3.getContentPane().add(hslFoundationsCheckBox);
		
		detailRocksCheckBox = new JCheckBox("Detail Rocks Texture Tint:");
		detailRocksCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(detailRocksCheckBox.isSelected()) {
					detailRocksField.setEnabled(true);
					detailRocksField.setVisible(true);
				}else {
					detailRocksField.setEnabled(false);
					detailRocksField.setVisible(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.EAST, detailRocksCheckBox, 0, SpringLayout.EAST, xLabel);
		detailRocksCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_3.getContentPane().add(detailRocksCheckBox);
		
		centralRocksCheckBox = new JCheckBox("Central Rocks Texture Tint:");
		centralRocksCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(centralRocksCheckBox.isSelected()) {
					centralRocksField.setEnabled(true);
					centralRocksField.setVisible(true);
				}else {
					centralRocksField.setEnabled(false);
					centralRocksField.setVisible(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.NORTH, centralRocksCheckBox, 2, SpringLayout.SOUTH, detailRocksCheckBox);
		springLayout_3.putConstraint(SpringLayout.EAST, centralRocksCheckBox, 0, SpringLayout.EAST, xLabel);
		centralRocksCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_3.getContentPane().add(centralRocksCheckBox);
		
		sideRocksCheckBox = new JCheckBox("Side Rocks Texture Tint:");
		sideRocksCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sideRocksCheckBox.isSelected()) {
					sideRocksField.setEnabled(true);
					sideRocksField.setVisible(true);
				}else {
					sideRocksField.setEnabled(false);
					sideRocksField.setVisible(false);
				}
			}
		});
		springLayout_3.putConstraint(SpringLayout.EAST, sideRocksCheckBox, 0, SpringLayout.EAST, xLabel);
		sideRocksCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
		internalFrame_3.getContentPane().add(sideRocksCheckBox);
		
		detailRocksField = new JTextField();
		detailRocksField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		detailRocksField.setEditable(false);
		detailRocksField.setVisible(false);
		detailRocksField.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.WEST, detailRocksField, 6, SpringLayout.EAST, detailRocksCheckBox);
		springLayout_3.putConstraint(SpringLayout.EAST, detailRocksField, -446, SpringLayout.EAST, internalFrame_3.getContentPane());
		springLayout_3.putConstraint(SpringLayout.NORTH, detailRocksCheckBox, -2, SpringLayout.NORTH, detailRocksField);
		springLayout_3.putConstraint(SpringLayout.NORTH, detailRocksField, 6, SpringLayout.SOUTH, hslFlat1Field);
		internalFrame_3.getContentPane().add(detailRocksField);
		detailRocksField.setColumns(10);
		
		centralRocksField = new JTextField();
		centralRocksField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		centralRocksField.setEditable(false);
		centralRocksField.setVisible(false);
		centralRocksField.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, centralRocksField, 6, SpringLayout.SOUTH, detailRocksField);
		springLayout_3.putConstraint(SpringLayout.WEST, centralRocksField, 0, SpringLayout.WEST, heightOffsetSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, centralRocksField, 0, SpringLayout.EAST, heightOffsetSpinner);
		internalFrame_3.getContentPane().add(centralRocksField);
		centralRocksField.setColumns(10);
		
		sideRocksField = new JTextField();
		sideRocksField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showColorPicker((JTextField) e.getSource());
			}
		});
		sideRocksField.setEditable(false);
		sideRocksField.setVisible(false);
		sideRocksField.setEnabled(false);
		springLayout_3.putConstraint(SpringLayout.NORTH, sideRocksCheckBox, -2, SpringLayout.NORTH, sideRocksField);
		springLayout_3.putConstraint(SpringLayout.NORTH, sideRocksField, 6, SpringLayout.SOUTH, centralRocksField);
		springLayout_3.putConstraint(SpringLayout.WEST, sideRocksField, 0, SpringLayout.WEST, heightOffsetSpinner);
		springLayout_3.putConstraint(SpringLayout.EAST, sideRocksField, 0, SpringLayout.EAST, heightOffsetSpinner);
		internalFrame_3.getContentPane().add(sideRocksField);
		sideRocksField.setColumns(10);
		internalFrame_3.setVisible(true);
		internalFrame_2.setVisible(true);
		
		/*
		 * Resources
		 */
		JComboBox<String> resourcesBox = new JComboBox<>();
		resourcesBox.setModel(new DefaultComboBoxModel<>(Entities.ResourcesString));
		
		/**********************************************************/
		
		/*
		 * Structures Table
		 */
		
		JComboBox<String> structuresBox = new JComboBox<>();
		structuresBox.setModel(new DefaultComboBoxModel<String>(Entities.AllStructuresString));
		structuresColumn.setCellEditor(new DefaultCellEditor(structuresBox));
		
		JComboBox<String> sizeBox = new JComboBox<>();
		sizeBox.setModel(new DefaultComboBoxModel<String>(new String[] {"0 - Any","1","2","3","4","5"}));
		sizeColumn.setCellEditor(new DefaultCellEditor(sizeBox));
		
		
		/*********************************************/
		
		/*
		 * Components
		 */
		JComboBox<String> componentsBox = new JComboBox<>();
		componentsBox.setModel(new DefaultComboBoxModel<>(Entities.AllComponentsString));
		
		/********************************************/
		
		/*
		 * Specialization
		 */
		
		JComboBox<String> specializationsBox = new JComboBox<>();
		specializationsBox.setModel(new DefaultComboBoxModel<>(Entities.SpecializationsString));
		
		/************************************************/
		
	}	

	private void showColorPicker(JTextField source) {
		if(source.isEnabled()==false) return;
		ColorPicker cp = new ColorPicker(editorFrame,source,"RGB");
		cp.setVisible(true);
	}
	
	private void showHSLColorPicker(JTextField source) {
		if(source.isEnabled()==false) return;
		ColorPicker cp = new ColorPicker(editorFrame,source,"HSL");
		cp.setVisible(true);
	}
	
	public String saveChallengeToStatic_CC_Object() {
		
		_CC = new Challenge();
		
		//General Tab
		
		if(!challengeNameField.getText().isEmpty()) {
			_CC.setChallengeName(challengeNameField.getText());
		}else {
			return "ERROR: Challenge Field Name Empty";
		}
		_CC.setColonyNameString(colonyNameField.getText());
		_CC.setChallengeDescriptionString(missionDescriptionTextArea.getText());
		_CC.setObjectiveDescriptionString(objectiveDescriptionField.getText());
		_CC.setObjectiveDoneString(objectiveDoneTextArea.getText());
				
		_CC.setChallengeFilename(challengeFilenameField.getText());
		_CC.setChallengeDescriptionFilename("en_"+challengeFilenameField.getText());
		_CC.setDifficulty(difficultyComboBox.getSelectedIndex()+1);
		_CC.setPlanetClass((PlanetClass) planetClassComboBox.getSelectedItem());
		_CC.setLatitude((Integer) latitudeSpinner.getValue());
		_CC.setLongtitude((Integer) longtitudeSpinner.getValue());
		
		_CC.setStartWorker((Integer) startWorkerSpinner.getValue()); 
		_CC.setStartBiologist((Integer) startBiologistSpinner.getValue());
		_CC.setStartEngineer((Integer) startEngineerSpinner.getValue());
		_CC.setStartMedic((Integer) startMedicSpinner.getValue());
		_CC.setStartGuard((Integer) startGuardSpinner.getValue());
		_CC.setStartConstructor((Integer) startConstructorSpinner.getValue());
		_CC.setStartCarrier((Integer) startCarrierSpinner.getValue());
		_CC.setStartDriller((Integer) startDrillerSpinner.getValue());
		
		_CC.setStartMetal((Integer) startMetalSpinner.getValue());
		_CC.setStartBioplastic((Integer) startBioplasticSpinner.getValue());
		_CC.setStartMeal((Integer) startMealSpinner.getValue());
		_CC.setStartSpares((Integer) startSparesSpinner.getValue());
		_CC.setStartMedicalSupplies((Integer) startMedicalSuppliesSpinner.getValue());
		_CC.setStartCoins((Integer) startCoinsSpinner.getValue());
		_CC.setStartSemiconductors((Integer) startSemiconductorsSpinner.getValue());
		_CC.setStartGun((Integer) startGunSpinner.getValue());
		_CC.setStartAlcoholicDrink((Integer) startAlcoholicDrinkSpinner.getValue());
		
		//Translation description
		if(languageCheckBox.isSelected() && languageField.getText().isEmpty()==false) {
			_CC.setChallengeTranslationPrefix(languageField.getText().toLowerCase());
		}//else null
		
		if(sandstormRiskCheckBox.isSelected()) {
			_CC.setSandstormRisk((NLHLevel)sandstormRiskComboBox.getSelectedItem());
		}//else null
		if(meteorRiskCheckBox.isSelected()) {
			_CC.setMeteorRisk((NLHLevel)meteorRiskComboBox.getSelectedItem());
		}
		if(solareFlareRiskCheckBox.isSelected()) {
			_CC.setSolareFlareRisk((NLHLevel)solareFlareRiskComboBox.getSelectedItem());
		}//else null
		if(thunderstormRiskCheckBox.isSelected()) {
			_CC.setThunderstormRisk((NLHLevel)thunderstormRiskComboBox.getSelectedItem());
		}//else null
		if(blizzardRiskCheckBox.isSelected()) {
			_CC.setBlizzardRisk((NLHLevel)blizzardRiskComboBox.getSelectedItem());
		}//else null
		if(atmosphereDensityCheckBox.isSelected()) {
			_CC.setAtmosphereDensity((NLHLevel)atmosphereDensityComboBox.getSelectedItem());
		}//else null
		if(lightDensityCheckBox.isSelected()) {
			_CC.setLightDensity((NLHLevel)lightDensityComboBox.getSelectedItem());
		}//else null
		
		//Modifiers Tab
		
		_CC.setDisableColonistsShips(disableColonistShipsCheckBox.isSelected());
		_CC.setDisableTraderTechs(disableTraderTechsCheckBox.isSelected());
		_CC.setDisableVisitorRequirements(disableVisitorRequirementsCheckBox.isSelected());
		_CC.setDisableVisitorShips(disableVisitorShipsCheckBox.isSelected());
		_CC.setDisableTradingShips(disableTradingShipsCheckBox.isSelected());		
		_CC.setDisableShipRecycling(disableShipRecyclingCheckBox.isSelected());
		_CC.setDisableWorkerMining(disableWorkerMiningCheckBox.isSelected());
		_CC.setDisableNoMedicalSuppliesWarning(disableNoMedicalSuppliesWarningCheckBox.isSelected());
		_CC.setInfiniteTraderBots(infiniteTraderBotsCheckBox.isSelected());
		
		if(disasterFrequencyCheckBox.isSelected()) {
			_CC.setDisasterFrequency((Float) disasterFrequencySpinner.getValue());
		}//else null
		if(shipFrequencyCheckBox.isSelected()) {
			_CC.setShipFrequency((Float) shipFrequencySpinner.getValue());
		}//else null
		if(tradingShipFrequencyCheckBox.isSelected()) {
			_CC.setTradingShipFrequency((Float) tradingShipFrequencySpinner.getValue());
		}//else null
		if(intruderMinPrestigeCheckBox.isSelected()) {
			_CC.setIntruderMinPrestige((Integer) intruderMinPrestigeSpinner.getValue());			
		}//else null
		if(extraIntrudersCheckBox.isSelected()) {
			_CC.setExtraIntruders((Integer)extraIntrudersSpinner.getValue());
		}
		
		if(disableInteriorStructuresCheckedComboBox.getSelectedItemsCount()>0) {
			String[] list = disableInteriorStructuresCheckedComboBox.getSelectedItemsString(';').split(";");
			_CC.setDisableInteriorStructures(list);
		}//else null
		
		if(disableExteriorStructuresCheckedComboBox.getSelectedItemsCount()>0) {
			String[] list = disableExteriorStructuresCheckedComboBox.getSelectedItemsString(';').split(";");
			_CC.setDisableExteriorStructures(list);
		}
		
		if(disableComponentsCheckedComboBox.getSelectedItemsCount()>0) {
			String[] list = disableComponentsCheckedComboBox.getSelectedItemsString(';').split(";");
			_CC.setDisableComponents(list);
		}
		
		if(disableStructureRequirementCheckedComboBox.getSelectedItemsCount()>0) {
			String[] list = disableStructureRequirementCheckedComboBox.getSelectedItemsString(';').split(";");
			_CC.setDisableStructureRequirement(list);			
		}
		
		if(restrictedColonistShipsCheckedComboBox.getSelectedItemsCount()>0) {
			String[] list = restrictedColonistShipsCheckedComboBox.getSelectedItemsString(';').split(";");
			_CC.setRestrictedColonistShips(list);
		}
		
		if(restrictedTradingShipsCheckedComboBox.getSelectedItemsCount()>0) {
			String[] list = restrictedTradingShipsCheckedComboBox.getSelectedItemsString(';').split(";");
			_CC.setRestrictedTradingShips(list);
		}
		
		if(unlockTechCheckedComboBox.getSelectedItemsCount()>0) {
			String[] list = unlockTechCheckedComboBox.getSelectedItemsString(';').split(";");
			_CC.setUnlockTech(list);
		}
		
		//Environment Tab
		
		if(dayHoursCheckBox.isSelected()) {
			_CC.setDayHours((Integer) dayHoursSpinner.getValue());
			_CC.setDayHoursSet(true);
		}
		
		if(nightHoursCheckBox.isSelected()) {
			_CC.setNightHours((Integer) nightHoursSpinner.getValue());
			_CC.setNightHoursSet(true);
		}
		
		_CC.setRemoveSatellites(removeSatellitesCheckBox.isSelected());
		
		if(lightColorDayCheckBox.isSelected()) {
			Color color = lightColorDayField.getBackground();
			_CC.setLightColorDay(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(lightColorNightCheckBox.isSelected()) {
			Color color = lightColorNightField.getBackground();
			_CC.setLightColorNight(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(lightColorTwilightCheckBox.isSelected()) {
			Color color = lightColorTwilightField.getBackground();
			_CC.setLightColorTwilight(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(ambientColorDayCheckBox.isSelected()) {
			Color color = ambientColorDayField.getBackground();
			_CC.setAmbientColorDay(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(ambientColorNightCheckBox.isSelected()) {
			Color color = ambientColorNightField.getBackground();
			_CC.setAmbientColorNight(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(ambientColorTwilightCheckBox.isSelected()) {
			Color color = ambientColorTwilightField.getBackground();
			_CC.setAmbientColorTwilight(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(horizonColorDayCheckBox.isSelected()) {
			Color color = horizonColorDayField.getBackground();
			_CC.setHorizonColorDay(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(horizonColorNightCheckBox.isSelected()) {
			Color color = horizonColorNightField.getBackground();
			_CC.setHorizonColorNight(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(horizonColorTwilightCheckBox.isSelected()) {
			Color color = horizonColorTwilightField.getBackground();
			_CC.setHorizonColorTwilight(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(skyColorTwilightCheckBox.isSelected()) {
			Color color = skyColorTwilightField.getBackground();
			_CC.setSkyColorTwilight(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(skyColorNightCheckBox.isSelected()) {
			Color color = skyColorNightField.getBackground();
			_CC.setSkyColorNight(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(skyColorDayCheckBox.isSelected()) {
			Color color = skyColorDayField.getBackground();
			_CC.setSkyColorDay(new RGB( color.getRed(), color.getGreen(), color.getBlue()));
		}
		
		if(fogIntensityPercentageDayCheckBox.isSelected()) {
			int value = (Integer) fogIntensityPercentageDaySpinner.getValue();
			float factor = (float) value / 100;
			float result = 0.1f * factor;
			_CC.setFogIntensityDay(result);
			_CC.setFogIntensityDaySet(true);
		}
		
		if(fogIntensityPercentageNightCheckBox.isSelected()) {
			int value = (Integer) fogIntensityPercentageNightSpinner.getValue();
			float factor = (float) value / 100;
			float result = 0.1f * factor;
			_CC.setFogIntensityNight(result);
			_CC.setFogIntensityNightSet(true);
		}
		
		if(fogIntensityPercentageTwilightCheckBox.isSelected()) {
			int value = (Integer) fogIntensityPercentageTwilightSpinner.getValue();
			float factor = (float) value / 100;
			float result = 0.1f * factor;
			_CC.setFogIntensityTwilight(result);
			_CC.setFogIntensityTwilightSet(true);
		}
		
		if(environmentCheckBox.isSelected()) {
			_CC.setEnvironmentIndex(environmentComboBox.getSelectedIndex()+1);
			_CC.setEnvironmentIndexSet(true);
		}
		
		if(sunCheckBox.isSelected()) {
			_CC.setSunIndex(sunComboBox.getSelectedIndex()+1);
			_CC.setSunIndexSet(true);
		}
		
		if(backdropsCheckBox.isSelected()) {
			_CC.setBackdropsIndex(backdropsComboBox.getSelectedIndex()+1);
			_CC.setBackdropsIndexSet(true);
		}
		
		//Terrain Tab
		
		if(heightMultiplierPercentageCheckBox.isSelected()) {
			int value = (Integer) heightMultiplierPercentageSpinner.getValue();
			float factor = (float) value / 100;
			float result = 2f*factor;
			_CC.setHeightMultiplier(result);
			_CC.setHeightMultiplierSet(true);
		}		
		
		if(craterDensityPercentageCheckBox.isSelected()) {
			int value = (Integer) craterDensityPercentageSpinner.getValue();
			float result = (float) value / 100;
			_CC.setCraterDensity(result); 
			_CC.setCraterDensitySet(true);
		}
		
		if(distantHeightOffsetPercentageCheckBox.isSelected()) {
			int value = (Integer) distantHeightOffsetPercentageSpinner.getValue();
			float factor = (float) value / 100;
			float result = 0.1f * factor;
			_CC.setDistantHeightOffset(result);
			_CC.setDistantHeightOffsetSet(true);
		}
		
		if(liquidPercentageCheckBox.isSelected()) {
			int value = (Integer) liquidPercentageSpinner.getValue();
			float result = (float) value / 100;
			_CC.setLiquidAmount(result);
			_CC.setLiquidAmountSet(true);
		}
		
		if(backdropScaleCheckBox.isSelected()) {
			_CC.setBackdropScale(new Vector((float) xSpinner.getValue(),(float) ySpinner.getValue(),(float) zSpinner.getValue()));
		}
		
		if(heightOffsetCheckBox.isSelected()) {
			_CC.setHeightOffset((float)heightOffsetSpinner.getValue());
			_CC.setHeightMultiplierSet(true);
		}
		
		if(liquidColorCheckBox.isSelected()) {
			Color color = liquidColorField.getBackground();
			_CC.setLiquidColor(new RGB(color.getRed(),color.getGreen(),color.getBlue()));
		}
		if(ttFlat1CheckBox.isSelected()) {
			Color color = ttFlat1Field.getBackground();
			_CC.setTintTextureFlat1(new RGB(color.getRed(),color.getGreen(),color.getBlue()));
		}
		if(ttFlat2CheckBox.isSelected()) {
			Color color = ttFlat2Field.getBackground();
			_CC.setTintTextureFlat2(new RGB(color.getRed(),color.getGreen(),color.getBlue()));
		}
		
		if(ttSlopeCheckBox.isSelected()) {
			Color color = ttSlopeField.getBackground();
			_CC.setTintTextureSlope(new RGB(color.getRed(),color.getGreen(),color.getBlue()));
		}
		if(ttFoundationsCheckBox.isSelected()) {
			Color color = ttFoundationsField.getBackground();
			_CC.setTintTextureFoundations(new RGB(color.getRed(),color.getGreen(),color.getBlue()));
		}
		if(detailRocksCheckBox.isSelected()) {
			Color color = detailRocksField.getBackground();
			_CC.setTintTextureDetailRocks(new RGB(color.getRed(),color.getGreen(),color.getBlue()));
		}
		if(centralRocksCheckBox.isSelected()) {
			Color color = centralRocksField.getBackground();
			_CC.setTintTextureCentralRocks(new RGB(color.getRed(),color.getGreen(),color.getBlue()));
		}
		if(sideRocksCheckBox.isSelected()) {
			Color color = sideRocksField.getBackground();
			_CC.setTintTextureSideRocks(new RGB(color.getRed(),color.getGreen(),color.getBlue()));
		}
				
		if(hslFlat1CheckBox.isSelected()) {
			Color color = hslFlat1Field.getBackground();
			_CC.setHslTransformTextureFlat1(new HSL(color));
		}
		if(hslFlat2CheckBox.isSelected()) {
			Color color = hslFlat2Field.getBackground();
			_CC.setHslTransformTextureFlat2(new HSL(color));
		}
		if(hslSlopeCheckBox.isSelected()) {
			Color color = hslSlopeField.getBackground();
			_CC.setHslTransformTextureSlope(new HSL(color));
		}
		if(hslFoundationsCheckBox.isSelected()) {
			Color color = hslFoundationsField.getBackground();
			_CC.setHslTransformTextureFoundations(new HSL(color));
		}
	
		
		//Objectives Tab
		if(reachPopulationCheckBox.isSelected()) {
			_CC.setReachPopulation((Integer)reachPopulationSpinner.getValue());
		}
		
		if(reachBotsCheckBox.isSelected()) {
			_CC.setReachBots((Integer)reachBotsSpinner.getValue());
		}
		
		if(reachPrestigeCheckBox.isSelected()) {
			_CC.setReachPrestige((Integer)reachPrestigeSpinner.getValue());
		}
		
		if(reachWelfareCheckBox.isSelected()) {
			_CC.setReachWelfare((Integer)reachWelfareSpinner.getValue());
		}
		
		if(survivalTimeCheckBox.isSelected()) {
			_CC.setSurvivalTime((Integer)survivalTimeSpinner.getValue());
		}
		
		if(timeLimitCheckBox.isSelected()) {
			_CC.setTimeLimit((Integer)timeLimitSpinner.getValue());
		}
		
		
		//Resources Table TODO: below if/elses can be done better (cleaner)
		TableModel resourcesModel = resourcesTable.getModel();
		if(resourcesModel.getRowCount()>0) {
			HashMap<String,Integer> resourceObjectives = new HashMap<>();
			for(int row = 0;row < resourcesModel.getRowCount(); row++) {
				if(resourcesModel.getValueAt(row, 0)==null) {
					return "ERROR: Empty Table Field!. Table 'resource' Column 0";
				}
				String resourceName = resourcesModel.getValueAt(row,0).toString();
				if(resourcesModel.getValueAt(row, 1)!=null) {
					String valueStr = resourcesModel.getValueAt(row,1).toString();
					if(isNumber(valueStr)) {
						int value = Integer.parseInt(valueStr);
						if(value<1) {
							return "ERROR: Expected Int > 0. Table 'resource' Column 1";
						}else {
							resourceObjectives.put(resourceName,value);
						}
					}else {
						return "ERROR: Expected numeric Value. Table 'resource' Column 1";
					}
				}else {
					return "ERROR:  Table 'resource' Column 1 Not Ready (press Enter on cell) / or empty";
				}
				
			}//endFOR
			_CC.setAccumulateResources(resourceObjectives);
		}//endIF
		
		//Components Table
		TableModel componentModel = componentsTable.getModel();
		if(componentModel.getRowCount()>0) {
			HashMap<String,Integer> objectives = new HashMap<>();
			for(int row = 0;row < componentModel.getRowCount(); row++) {
				if(componentModel.getValueAt(row, 0)==null) {
					return "ERROR: Empty Table Field. Table 'component' Column 0";
				}
				String name = componentModel.getValueAt(row,0).toString();
				if(componentModel.getValueAt(row, 1)!=null) {
					String valueStr = componentModel.getValueAt(row,1).toString();
					if(isNumber(valueStr)) {
						int value = Integer.parseInt(valueStr);
						if(value<1) {
							return "ERROR: Expected Int > 0. Table 'component' Column 1";
						}else {
							objectives.put(name,value);
						}
					}else {
						return "ERROR: Expected numeric Value. Table 'component' Column 1";
					}
				}else {
					return "ERROR:  Table 'component' Column 1 Not Ready (press Enter on cell) / or empty";
				}
				
			}//endFOR
			_CC.setBuildComponents(objectives);
		}//endIF
		
		//Specialization table
		TableModel specializationModel = specializationTable.getModel();
		if(specializationModel.getRowCount()>0) {
			HashMap<String,Integer> objectives = new HashMap<>();
			for(int row = 0;row < specializationModel.getRowCount(); row++) {
				if(specializationModel.getValueAt(row, 0)==null) {
					return "ERROR: Empty Table Field. Table 'specialization' Column 0";
				}
				String name = specializationModel.getValueAt(row,0).toString();
				if(specializationModel.getValueAt(row, 1)!=null) {
					String valueStr = specializationModel.getValueAt(row,1).toString();
					if(isNumber(valueStr)) {
						int value = Integer.parseInt(valueStr);
						if(value<1) {
							return "ERROR: Expected Int > 0. Table 'specialization' Column 1";
						}else {
							objectives.put(name,value);
						}
					}else {
						return "ERROR: Expected numeric Value. Table 'specialization' Column 1";
					}
				}else {
					return "ERROR:  Table 'specialization' Column 1 Not Ready (press Enter on cell) / or empty";
				}
				
			}//endFOR
			_CC.setReachSpecialization(objectives);
		}//endIF
		
		//CharacterTable
		TableModel characterModel = characterTable.getModel();
		if(characterModel.getRowCount()>0) {
			ArrayList<String> objectives = new ArrayList<>();
			for(int row = 0;row<characterModel.getRowCount();row++) {
				String name = characterModel.getValueAt(row, 0).toString();
				if(name.isEmpty()) {
					return "ERROR: Empty String. Table 'character'.";
				}else {
					objectives.add(name);
				}
				
			}//endFOR
			_CC.setKeepCharacterAlive(objectives);
		}//endIF
		
		//Structures Table
		TableModel structureModel = structuresTable.getModel();
		if(structureModel.getRowCount()>0) {
			HashMap<String,Integer[]> objectives = new HashMap<>();
			for(int row = 0;row<structureModel.getRowCount();row++) {
				if(structureModel.getValueAt(row,0)==null) {
					return "ERROR: Empty Table Field! Table 'structure' Column 0";
				}
				String name = structureModel.getValueAt(row,0).toString();
				Integer[] values = new Integer[2];
				if(structureModel.getValueAt(row,1)==null) {
					return "ERROR: Empty Table Field! Table 'structure' Column 1";
				}
				values[0] = Integer.parseInt(structureModel.getValueAt(row,1).toString().replaceAll(" - Any",""));
				if(structureModel.getValueAt(row, 2)!=null) {
					String valueStr = structureModel.getValueAt(row, 2).toString();
					if(isNumber(valueStr)) {
						int value = Integer.parseInt(valueStr);
						if(value<1) {
							return "ERROR: Expected Int > 0. Table 'structure' Column 2";
						}else {
							values[1] = value;
							objectives.put(name,values);
						}
					}else {
						return "ERROR: Expected numeric Value. Table 'structure' Column 2";
					}
				}else {
					return "ERROR: Table 'structure' Column 2 Not Ready (press Enter on cell) / or empty";
				}
				
			}//endFOR
			_CC.setBuildStructures(objectives);
		}//endIF
		
		return "All Good!";
	}

	private void saveConfigToJsonFile(String data,String filename) throws IOException {			
			BufferedWriter fw = new BufferedWriter(new FileWriter(filename));
			fw.write(data);
			fw.flush();
			fw.close();		
	}
	
	private void saveEditorFileMenu() {
		if(selectedFile==null) {
			saveEditorFileAs();
		}else {
			String result = saveChallengeToStatic_CC_Object();
			if(result.startsWith("ERROR")) {
				JOptionPane.showMessageDialog(editorFrame, result, "Form validation error",JOptionPane.ERROR_MESSAGE);
			}else {
				String json = new Gson().toJson(_CC);
				try {
					saveConfigToJsonFile(json,selectedFile.getAbsolutePath());
					JOptionPane.showMessageDialog(editorFrame, "File Saved"+selectedFile.getCanonicalPath(), "File Save",JOptionPane.INFORMATION_MESSAGE);
				}catch(IOException io) {
					JOptionPane.showMessageDialog(editorFrame,"Error while saving"+selectedFile.getAbsolutePath()+"\n"+io.getMessage(), "File Save Error",JOptionPane.ERROR_MESSAGE);
				}
			}			
		}
	}	
	
	private void saveEditorFileAs() {
		String result = saveChallengeToStatic_CC_Object();
		if(result.startsWith("ERROR")) {
			JOptionPane.showMessageDialog(editorFrame, result, "Form validation error",JOptionPane.ERROR_MESSAGE);
		}else {
			//JOptionPane.showMessageDialog(editorFrame, result, "Form validation",JOptionPane.INFORMATION_MESSAGE);
			JFileChooser fc = new JFileChooser();
			//FileSystemView.getFileSystemView().getHomeDirectory()
			int fcr = fc.showSaveDialog(null);
			if(fcr==JFileChooser.APPROVE_OPTION) {
				File sf = fc.getSelectedFile();
				//validate file
				if (FilenameUtils.getExtension(sf.getName()).equalsIgnoreCase(PBCE._EDITOR_EXTENSION)) {
				    // filename is OK as-is
				} else {
					sf = new File(sf.toString() + PBCE._EDITOR_EXTENSION);  // append .xml if "foo.jpg.xml" is OK
					sf = new File(sf.getParentFile(), FilenameUtils.getBaseName(sf.getName())+PBCE._EDITOR_EXTENSION); // ALTERNATIVELY: remove the extension (if any) and replace it with ".xml"
				}
				selectedFile = sf;
				infoField.setText("Editor File: "+selectedFile.getAbsolutePath());
				String json = new Gson().toJson(_CC);
				try {
					saveConfigToJsonFile(json,selectedFile.getAbsolutePath());
					JOptionPane.showMessageDialog(editorFrame, "File Saved"+selectedFile.getAbsolutePath(), "File Save",JOptionPane.INFORMATION_MESSAGE);
				}catch(IOException io) {
					JOptionPane.showMessageDialog(editorFrame,"Error while saving"+sf.getAbsolutePath()+"\n"+io.getMessage(), "File Save Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}
	
	private Challenge loadChallengeFromJsonFile(String filename) throws IOException {
		
			String data = new String(Files.readAllBytes(Paths.get(filename)));
			Gson GSON = new Gson();
			try {
				Challenge loadedChallenge = GSON.fromJson(data,Challenge.class);
				return loadedChallenge;
			}catch(Exception e) {
				return null;
			}		
		
	}
		
	private void loadChallengeFromObjectToForm(Challenge _cc) {
		
		//General Tab
		
		challengeNameField.setText(_cc.getChallengeName());
		colonyNameField.setText(_cc.getColonyNameString());
		objectiveDoneTextArea.setText(_cc.getObjectiveDoneString());
		objectiveDescriptionField.setText(_cc.getObjectiveDescriptionString());
		challengeFilenameField.setText(_cc.getChallengeFilename());
		//Challenge Description file name?
		missionDescriptionTextArea.setText(_cc.getChallengeDescriptionString());
		difficultyComboBox.setSelectedIndex(_cc.getDifficulty()-1);
		planetClassComboBox.setSelectedItem(_cc.getPlanetClass());
		latitudeSpinner.setValue(_cc.getLatitude());
		longtitudeSpinner.setValue(_cc.getLongtitude());
		
		startWorkerSpinner.setValue(_cc.getStartWorker());
		startBiologistSpinner.setValue(_cc.getStartBiologist());
		startEngineerSpinner.setValue(_cc.getStartEngineer());
		startMedicSpinner.setValue(_cc.getStartMedic());
		startGuardSpinner.setValue(_cc.getStartGuard());
		startMetalSpinner.setValue(_cc.getStartMetal());
		startBioplasticSpinner.setValue(_cc.getStartBioplastic());
		startMealSpinner.setValue(_cc.getStartMeal());
		startSparesSpinner.setValue(_cc.getStartSpares());
		startMedicalSuppliesSpinner.setValue(_cc.getStartMedicalSupplies());
		startCoinsSpinner.setValue(_cc.getStartCoins());
		startSemiconductorsSpinner.setValue(_cc.getStartSemiconductors());
		startGunSpinner.setValue(_cc.getStartGun());
		startAlcoholicDrinkSpinner.setValue(_cc.getStartAlcoholicDrink());
		startConstructorSpinner.setValue(_cc.getStartConstructor());
		startCarrierSpinner.setValue(_cc.getStartCarrier());
		startDrillerSpinner.setValue(_cc.getStartDriller());
		
		//Translation description
		if(_cc.getChallengeTranslationPrefix()!=null) {
			languageCheckBox.setSelected(true);
			languageField.setEnabled(true);
			languageField.setText(_cc.getChallengeTranslationPrefix().toUpperCase());
		}else {
			languageCheckBox.setSelected(false);
			languageField.setEnabled(false);
			languageField.setText("");
		}
		
		if(_cc.getSandstormRisk()!=null) {
			sandstormRiskCheckBox.setSelected(true);
			sandstormRiskComboBox.setEnabled(true);
			sandstormRiskComboBox.setSelectedItem(_cc.getSandstormRisk());
		}else {
			sandstormRiskCheckBox.setSelected(false);
			sandstormRiskComboBox.setEnabled(false);
			sandstormRiskComboBox.setSelectedIndex(0);
		}
		
		if(_cc.getMeteorRisk()!=null) {
			meteorRiskCheckBox.setSelected(true);
			meteorRiskComboBox.setEnabled(true);
			meteorRiskComboBox.setSelectedItem(_cc.getMeteorRisk());
		}else {
			meteorRiskCheckBox.setSelected(false);
			meteorRiskComboBox.setEnabled(false);
			meteorRiskComboBox.setSelectedIndex(0);
		}
		
		if(_cc.getSolareFlareRisk()!=null) {
			solareFlareRiskCheckBox.setSelected(true);
			solareFlareRiskComboBox.setEnabled(true);
			solareFlareRiskComboBox.setSelectedItem(_cc.getSolareFlareRisk());
		}else {
			solareFlareRiskCheckBox.setSelected(false);
			solareFlareRiskComboBox.setEnabled(false);
			solareFlareRiskComboBox.setSelectedIndex(0);
		}
		
		if(_cc.getThunderstormRisk()!=null) {
			thunderstormRiskCheckBox.setSelected(true);
			thunderstormRiskComboBox.setEnabled(true);
			thunderstormRiskComboBox.setSelectedItem(_cc.getThunderstormRisk());
		}else {
			thunderstormRiskCheckBox.setSelected(false);
			thunderstormRiskComboBox.setEnabled(false);
			thunderstormRiskComboBox.setSelectedIndex(0);
		}
		
		if(_cc.getBlizzardRisk()!=null) {
			blizzardRiskCheckBox.setSelected(true);
			blizzardRiskComboBox.setEnabled(true);
			blizzardRiskComboBox.setSelectedItem(_cc.getBlizzardRisk());
		}else {
			blizzardRiskCheckBox.setSelected(false);
			blizzardRiskComboBox.setEnabled(false);
			blizzardRiskComboBox.setSelectedIndex(0);
		}
		
		if(_cc.getAtmosphereDensity()!=null) {
			atmosphereDensityCheckBox.setSelected(true);
			atmosphereDensityComboBox.setEnabled(true);
			atmosphereDensityComboBox.setSelectedItem(_cc.getAtmosphereDensity());
		}else {
			atmosphereDensityCheckBox.setSelected(false);
			atmosphereDensityComboBox.setEnabled(false);
			atmosphereDensityComboBox.setSelectedIndex(0);
		}
		
		if(_cc.getLightDensity()!=null) {
			lightDensityCheckBox.setSelected(true);
			lightDensityComboBox.setEnabled(true);
			lightDensityComboBox.setSelectedItem(_cc.getLightDensity());
		}else {
			lightDensityCheckBox.setSelected(false);
			lightDensityComboBox.setEnabled(false);
			lightDensityComboBox.setSelectedIndex(0);
		}
		
		//Modifiers Tab
		
		disableColonistShipsCheckBox.setSelected(_cc.isDisableColonistsShips());
		disableTraderTechsCheckBox.setSelected(_cc.isDisableTraderTechs());
		disableVisitorRequirementsCheckBox.setSelected(_cc.isDisableVisitorRequirements());
		disableVisitorShipsCheckBox.setSelected(_cc.isDisableVisitorShips());
		disableTradingShipsCheckBox.setSelected(_cc.isDisableTradingShips());
		disableShipRecyclingCheckBox.setSelected(_cc.isDisableShipRecycling());
		disableWorkerMiningCheckBox.setSelected(_cc.isDisableWorkerMining());
		disableNoMedicalSuppliesWarningCheckBox.setSelected(_cc.isDisableNoMedicalSuppliesWarning());
		infiniteTraderBotsCheckBox.setSelected(_cc.isInfiniteTraderBots());
		
		if(_cc.getDisasterFrequency()>0) {
			disasterFrequencyCheckBox.setSelected(true);
			disasterFrequencySpinner.setEnabled(true);
			disasterFrequencySpinner.setValue(_cc.getDisasterFrequency());
		}else {
			disasterFrequencyCheckBox.setSelected(false);
			disasterFrequencySpinner.setEnabled(false);
			disasterFrequencySpinner.setValue(0.1f); //default
		}
		
		if(_cc.getShipFrequency()>0) {
			shipFrequencyCheckBox.setSelected(true);
			shipFrequencySpinner.setEnabled(true);
			shipFrequencySpinner.setValue(_cc.getShipFrequency());
		}else {
			shipFrequencyCheckBox.setSelected(false);
			shipFrequencySpinner.setEnabled(false);
			shipFrequencySpinner.setValue(0.1f); //default
		}
		
		if(_cc.getTradingShipFrequency()>0) {
			tradingShipFrequencyCheckBox.setSelected(true);
			tradingShipFrequencySpinner.setEnabled(true);
			tradingShipFrequencySpinner.setValue(_cc.getTradingShipFrequency());
		}else {
			tradingShipFrequencyCheckBox.setSelected(false);
			tradingShipFrequencySpinner.setEnabled(false);
			tradingShipFrequencySpinner.setValue(0.1f); //default
		}
		
		if(_cc.getIntruderMinPrestige()>0) {
			intruderMinPrestigeCheckBox.setSelected(true);
			intruderMinPrestigeSpinner.setEnabled(true);
			intruderMinPrestigeSpinner.setValue(_cc.getIntruderMinPrestige());
		}else {
			intruderMinPrestigeCheckBox.setSelected(false);
			intruderMinPrestigeSpinner.setEnabled(false);
			intruderMinPrestigeSpinner.setValue(1); //default
		}
		
		if(_cc.getExtraIntruders()>0) {
			extraIntrudersCheckBox.setSelected(true);
			extraIntrudersSpinner.setEnabled(true);
			extraIntrudersSpinner.setValue(_cc.getIntruderMinPrestige());
		}else {
			extraIntrudersCheckBox.setSelected(false);
			extraIntrudersSpinner.setEnabled(false);
			extraIntrudersSpinner.setValue(0); //default
		}
		
		if(_cc.getDisableInteriorStructures()!=null) {
			String[] data = _cc.getDisableInteriorStructures();
			disableInteriorStructuresCheckedComboBox.setSelectedItemsInModel(data);
		}else {
			disableInteriorStructuresCheckedComboBox.uncheckAllItems();
		}
		
		if(_cc.getDisableExteriorStructures()!=null) {
			String[] data = _cc.getDisableExteriorStructures();
			disableExteriorStructuresCheckedComboBox.setSelectedItemsInModel(data);
		}else {
			disableExteriorStructuresCheckedComboBox.uncheckAllItems();
		}
		
		if(_cc.getDisableComponents()!=null) {
			String[] data = _cc.getDisableComponents();
			disableComponentsCheckedComboBox.setSelectedItemsInModel(data);
		}else {
			disableComponentsCheckedComboBox.uncheckAllItems();
		}
		
		if(_cc.getDisableStructureRequirement()!=null) {
			String[] data = _cc.getDisableStructureRequirement();
			disableStructureRequirementCheckedComboBox.setSelectedItemsInModel(data);
		}else {
			disableStructureRequirementCheckedComboBox.uncheckAllItems();
		}
		
		if(_cc.getRestrictedColonistShips()!=null) {
			String[] data = _cc.getRestrictedColonistShips();
			restrictedColonistShipsCheckedComboBox.setSelectedItemsInModel(data);
		}else {
			restrictedColonistShipsCheckedComboBox.uncheckAllItems();
		}
		
		if(_cc.getRestrictedTradingShips()!=null) {
			String[] data = _cc.getRestrictedTradingShips();
			restrictedTradingShipsCheckedComboBox.setSelectedItemsInModel(data);
		}else {
			restrictedTradingShipsCheckedComboBox.uncheckAllItems();
		}
		
		if(_cc.getUnlockTech()!=null) {
			String[] data = _cc.getUnlockTech();
			unlockTechCheckedComboBox.setSelectedItemsInModel(data);
		}else {
			unlockTechCheckedComboBox.uncheckAllItems();
		}
		
		//Environment tab
		if(_cc.isDayHoursSet()) {
			dayHoursCheckBox.setSelected(true);
			dayHoursSpinner.setEnabled(true);
			dayHoursSpinner.setValue(_cc.getDayHours());
		}else {
			dayHoursCheckBox.setSelected(false);
			dayHoursSpinner.setEnabled(false);
			dayHoursSpinner.setValue(4); //default
		}
		
		if(_cc.isNightHoursSet()) {
			nightHoursCheckBox.setSelected(true);
			nightHoursSpinner.setEnabled(true);
			nightHoursSpinner.setValue(_cc.getNightHours());
		}else {
			nightHoursCheckBox.setSelected(false);
			nightHoursSpinner.setEnabled(false);
			nightHoursSpinner.setValue(0); //default
		}
		
		removeSatellitesCheckBox.setSelected(_cc.isRemoveSatellites());
		
		if(_cc.isEnvironmentIndexSet()) {
			environmentCheckBox.setSelected(true);
			environmentComboBox.setEnabled(true);
			environmentComboBox.setSelectedIndex(_cc.getEnvironmentIndex()-1);
		}else {
			environmentCheckBox.setSelected(false);
			environmentComboBox.setEnabled(false);
			environmentComboBox.setSelectedIndex(0); //default
		}
		
		if(_cc.isSunIndexSet()) {
			sunCheckBox.setSelected(true);
			sunComboBox.setEnabled(true);
			sunComboBox.setSelectedIndex(_cc.getSunIndex()-1);
		}else {
			sunCheckBox.setSelected(false);
			sunComboBox.setEnabled(false);
			sunComboBox.setSelectedIndex(0); //default
		}
		
		if(_cc.isBackdropsIndexSet()) {
			backdropsCheckBox.setSelected(true);
			backdropsComboBox.setEnabled(true);
			backdropsComboBox.setSelectedIndex(_cc.getBackdropsIndex()-1);
		}else {
			backdropsCheckBox.setSelected(false);
			backdropsComboBox.setEnabled(false);
			backdropsComboBox.setSelectedIndex(0); //default
		}
		
		if(_cc.isFogIntensityDaySet()) {
			fogIntensityPercentageDayCheckBox.setSelected(true);
			fogIntensityPercentageDaySpinner.setEnabled(true);
			float value = _cc.getFogIntensityDay();
			value /= 0.1f;
			int result = (int) (value * 100);
			fogIntensityPercentageDaySpinner.setValue(result);
		}else {
			fogIntensityPercentageDayCheckBox.setSelected(false);
			fogIntensityPercentageDaySpinner.setEnabled(false);
			fogIntensityPercentageDaySpinner.setValue(0); //default
		}
		
		if(_cc.isFogIntensityNightSet()) {
			fogIntensityPercentageNightCheckBox.setSelected(true);
			fogIntensityPercentageNightSpinner.setEnabled(true);
			float value = _cc.getFogIntensityNight();
			value /= 0.1f;
			int result = (int) (value * 100);
			fogIntensityPercentageNightSpinner.setValue(result);
		}else {
			fogIntensityPercentageNightCheckBox.setSelected(false);
			fogIntensityPercentageNightSpinner.setEnabled(false);
			fogIntensityPercentageNightSpinner.setValue(0); //default
		}
		
		if(_cc.isFogIntensityTwilightSet()) {
			fogIntensityPercentageTwilightCheckBox.setSelected(true);
			fogIntensityPercentageTwilightSpinner.setEnabled(true);
			float value = _cc.getFogIntensityTwilight();
			value /= 0.1f;
			int result = (int) (value * 100);
			fogIntensityPercentageTwilightSpinner.setValue(result);
		}else {
			fogIntensityPercentageTwilightCheckBox.setSelected(false);
			fogIntensityPercentageTwilightSpinner.setEnabled(false);
			fogIntensityPercentageTwilightSpinner.setValue(0); //default
		}
		
		if(_cc.getLightColorDay()!=null) {
			RGB rgb = _cc.getLightColorDay();
			lightColorDayCheckBox.setSelected(true);
			lightColorDayField.setEnabled(true);
			lightColorDayField.setVisible(true);
			lightColorDayField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			lightColorDayCheckBox.setSelected(false);
			lightColorDayField.setEnabled(false);
			lightColorDayField.setVisible(false);
			lightColorDayField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getLightColorNight()!=null) {
			RGB rgb = _cc.getLightColorNight();
			lightColorNightCheckBox.setSelected(true);
			lightColorNightField.setEnabled(true);
			lightColorNightField.setVisible(true);
			lightColorNightField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			lightColorNightCheckBox.setSelected(false);
			lightColorNightField.setEnabled(false);
			lightColorNightField.setVisible(false);
			lightColorNightField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getLightColorTwilight()!=null) {
			RGB rgb = _cc.getLightColorTwilight();
			lightColorTwilightCheckBox.setSelected(true);
			lightColorTwilightField.setEnabled(true);
			lightColorTwilightField.setVisible(true);
			lightColorTwilightField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			lightColorTwilightCheckBox.setSelected(false);
			lightColorTwilightField.setEnabled(false);
			lightColorTwilightField.setVisible(false);
			lightColorTwilightField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getAmbientColorDay()!=null) {
			RGB rgb = _cc.getAmbientColorDay();
			ambientColorDayCheckBox.setSelected(true);
			ambientColorDayField.setEnabled(true);
			ambientColorDayField.setVisible(true);
			ambientColorDayField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			ambientColorDayCheckBox.setSelected(false);
			ambientColorDayField.setEnabled(false);
			ambientColorDayField.setVisible(false);
			ambientColorDayField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getAmbientColorNight()!=null) {
			RGB rgb = _cc.getAmbientColorNight();
			ambientColorNightCheckBox.setSelected(true);
			ambientColorNightField.setEnabled(true);
			ambientColorNightField.setVisible(true);
			ambientColorNightField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			ambientColorNightCheckBox.setSelected(false);
			ambientColorNightField.setEnabled(false);
			ambientColorNightField.setVisible(false);
			ambientColorNightField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getAmbientColorTwilight()!=null) {
			RGB rgb = _cc.getAmbientColorTwilight();
			ambientColorTwilightCheckBox.setSelected(true);
			ambientColorTwilightField.setEnabled(true);
			ambientColorTwilightField.setVisible(true);
			ambientColorTwilightField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			ambientColorTwilightCheckBox.setSelected(false);
			ambientColorTwilightField.setEnabled(false);
			ambientColorTwilightField.setVisible(false);
			ambientColorTwilightField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getHorizonColorDay()!=null) {
			RGB rgb = _cc.getHorizonColorDay();
			horizonColorDayCheckBox.setSelected(true);
			horizonColorDayField.setEnabled(true);
			horizonColorDayField.setVisible(true);
			horizonColorDayField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			horizonColorDayCheckBox.setSelected(false);
			horizonColorDayField.setEnabled(false);
			horizonColorDayField.setVisible(false);
			horizonColorDayField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getHorizonColorNight()!=null) {
			RGB rgb = _cc.getHorizonColorNight();
			horizonColorNightCheckBox.setSelected(true);
			horizonColorNightField.setEnabled(true);
			horizonColorNightField.setVisible(true);
			horizonColorNightField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			horizonColorNightCheckBox.setSelected(false);
			horizonColorNightField.setEnabled(false);
			horizonColorNightField.setVisible(false);
			horizonColorNightField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getHorizonColorTwilight()!=null) {
			RGB rgb = _cc.getHorizonColorTwilight();
			horizonColorTwilightCheckBox.setSelected(true);
			horizonColorTwilightField.setEnabled(true);
			horizonColorTwilightField.setVisible(true);
			horizonColorTwilightField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			horizonColorTwilightCheckBox.setSelected(false);
			horizonColorTwilightField.setEnabled(false);
			horizonColorTwilightField.setVisible(false);
			horizonColorTwilightField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getSkyColorDay()!=null) {
			RGB rgb = _cc.getSkyColorDay();
			skyColorDayCheckBox.setSelected(true);
			skyColorDayField.setEnabled(true);
			skyColorDayField.setVisible(true);
			skyColorDayField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			skyColorDayCheckBox.setSelected(false);
			skyColorDayField.setEnabled(false);
			skyColorDayField.setVisible(false);
			skyColorDayField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getSkyColorNight()!=null) {
			RGB rgb = _cc.getSkyColorNight();
			skyColorNightCheckBox.setSelected(true);
			skyColorNightField.setEnabled(true);
			skyColorNightField.setVisible(true);
			skyColorNightField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			skyColorNightCheckBox.setSelected(false);
			skyColorNightField.setEnabled(false);
			skyColorNightField.setVisible(false);
			skyColorNightField.setBackground(new Color(48,48,48)); //default
		}
		
		if(_cc.getSkyColorTwilight()!=null) {
			RGB rgb = _cc.getSkyColorTwilight();
			skyColorTwilightCheckBox.setSelected(true);
			skyColorTwilightField.setEnabled(true);
			skyColorTwilightField.setVisible(true);
			skyColorTwilightField.setBackground(new Color(rgb.r,rgb.g,rgb.b));
		}else {
			skyColorTwilightCheckBox.setSelected(false);
			skyColorTwilightField.setEnabled(false);
			skyColorTwilightField.setVisible(false);
			skyColorTwilightField.setBackground(new Color(48,48,48)); //default
		}
		
		//Terrain Tab
		if(_cc.isHeightMultiplierSet()) {
			heightMultiplierPercentageCheckBox.setSelected(true);
			heightMultiplierPercentageSpinner.setEnabled(true);
			float value = _cc.getHeightMultiplier();
			value /= 2f;
			int result = (int) (value * 100);
			heightMultiplierPercentageSpinner.setValue(result);
		}else {
			heightMultiplierPercentageCheckBox.setSelected(false);
			heightMultiplierPercentageSpinner.setEnabled(false);
			heightMultiplierPercentageSpinner.setValue(0); //default
		}
		
		if(_cc.isCraterDensitySet()) {
			craterDensityPercentageCheckBox.setSelected(true);
			craterDensityPercentageSpinner.setEnabled(true);
			float value = _cc.getCraterDensity();
			value /= 1f;
			int result = (int) (value * 100);
			craterDensityPercentageSpinner.setValue(result);
		}else {
			craterDensityPercentageCheckBox.setSelected(false);
			craterDensityPercentageSpinner.setEnabled(false);
			craterDensityPercentageSpinner.setValue(0); //default
		}
		
		if(_cc.isDistantHeightOffsetSet()) {
			distantHeightOffsetPercentageCheckBox.setSelected(true);
			distantHeightOffsetPercentageSpinner.setEnabled(true);
			float value = _cc.getDistantHeightOffset();
			value /= 0.1f;
			int result = (int) (value * 100);
			distantHeightOffsetPercentageSpinner.setValue(result);
		}else {
			distantHeightOffsetPercentageCheckBox.setSelected(false);
			distantHeightOffsetPercentageSpinner.setEnabled(false);
			distantHeightOffsetPercentageSpinner.setValue(0); //default
		}
		
		if(_cc.isLiquidAmountSet()) {
			liquidPercentageCheckBox.setSelected(true);
			liquidPercentageSpinner.setEnabled(true);
			float value = _cc.getLiquidAmount();
			value /= 1f;
			int result = (int) (value * 100);
			liquidPercentageSpinner.setValue(result);
		}else {
			liquidPercentageCheckBox.setSelected(false);
			liquidPercentageSpinner.setEnabled(false);
			liquidPercentageSpinner.setValue(0); //default
		}
		
		if(_cc.getBackdropScale()!=null) {
			Vector v = _cc.getBackdropScale();
			backdropScaleCheckBox.setSelected(true);
			xSpinner.setEnabled(true);
			xSpinner.setValue(v.x);
			xLabel.setEnabled(true);
			ySpinner.setEnabled(true);
			ySpinner.setValue(v.y);
			yLabel.setEnabled(true);
			zSpinner.setEnabled(true);
			zSpinner.setValue(v.z);
			zLabel.setEnabled(true);			
		}else {
			backdropScaleCheckBox.setSelected(false);
			xSpinner.setEnabled(false);
			xSpinner.setValue(1);
			xLabel.setEnabled(false);
			ySpinner.setEnabled(false);
			ySpinner.setValue(1);
			yLabel.setEnabled(false);
			zSpinner.setEnabled(false);
			zSpinner.setValue(1);
			zLabel.setEnabled(false);
		}
		
		if(_cc.isHeightOffsetSet()) {
			heightOffsetCheckBox.setSelected(true);
			heightOffsetSpinner.setEnabled(true);
			heightOffsetSpinner.setValue(_cc.getHeightOffset());
		}else {
			heightOffsetCheckBox.setSelected(false);
			heightOffsetSpinner.setEnabled(false);
			heightOffsetSpinner.setValue(0); //default
		}
		
		if(_cc.getLiquidColor()!=null) {
			RGB c = _cc.getLiquidColor();
			liquidColorCheckBox.setSelected(true);
			liquidColorField.setEnabled(true);
			liquidColorField.setVisible(true);
			liquidColorField.setBackground(new Color(c.r,c.g,c.b));
		}else {
			liquidColorCheckBox.setSelected(false);
			liquidColorField.setEnabled(false);
			liquidColorField.setVisible(false);
			liquidColorField.setBackground(new Color(48,48,48)); //defualt
		}
		
		if(_cc.getTintTextureFlat1()!=null) {
			RGB c = _cc.getTintTextureFlat1();
			ttFlat1CheckBox.setSelected(true);
			ttFlat1Field.setEnabled(true);
			ttFlat1Field.setVisible(true);
			ttFlat1Field.setBackground(new Color(c.r,c.g,c.b));
		}else {
			ttFlat1CheckBox.setSelected(false);
			ttFlat1Field.setEnabled(false);
			ttFlat1Field.setVisible(false);
			ttFlat1Field.setBackground(new Color(48,48,48)); //defualt
		}
		if(_cc.getTintTextureFlat2()!=null) {
			RGB c = _cc.getTintTextureFlat2();
			ttFlat2CheckBox.setSelected(true);
			ttFlat2Field.setEnabled(true);
			ttFlat2Field.setVisible(true);
			ttFlat2Field.setBackground(new Color(c.r,c.g,c.b));
		}else {
			ttFlat2CheckBox.setSelected(false);
			ttFlat2Field.setEnabled(false);
			ttFlat2Field.setVisible(false);
			ttFlat2Field.setBackground(new Color(48,48,48)); //defualt
		}
		if(_cc.getTintTextureSlope()!=null) {
			RGB c = _cc.getTintTextureSlope();
			ttSlopeCheckBox.setSelected(true);
			ttSlopeField.setEnabled(true);
			ttSlopeField.setVisible(true);
			ttSlopeField.setBackground(new Color(c.r,c.g,c.b));
		}else {
			ttSlopeCheckBox.setSelected(false);
			ttSlopeField.setEnabled(false);
			ttSlopeField.setVisible(false);
			ttSlopeField.setBackground(new Color(48,48,48)); //defualt
		}
		if(_cc.getTintTextureFoundations()!=null) {
			RGB c = _cc.getTintTextureFoundations();
			ttFoundationsCheckBox.setSelected(true);
			ttFoundationsField.setEnabled(true);
			ttFoundationsField.setVisible(true);
			ttFoundationsField.setBackground(new Color(c.r,c.g,c.b));
		}else {
			ttFoundationsCheckBox.setSelected(false);
			ttFoundationsField.setEnabled(false);
			ttFoundationsField.setVisible(false);
			ttFoundationsField.setBackground(new Color(48,48,48)); //defualt
		}
		if(_cc.getTintTextureDetailRocks()!=null) {
			RGB c = _cc.getTintTextureDetailRocks();
			detailRocksCheckBox.setSelected(true);
			detailRocksField.setEnabled(true);
			detailRocksField.setVisible(true);
			detailRocksField.setBackground(new Color(c.r,c.g,c.b));
		}else {
			detailRocksCheckBox.setSelected(false);
			detailRocksField.setEnabled(false);
			detailRocksField.setVisible(false);
			detailRocksField.setBackground(new Color(48,48,48)); //defualt
		}
		if(_cc.getTintTextureCentralRocks()!=null) {
			RGB c = _cc.getTintTextureCentralRocks();
			centralRocksCheckBox.setSelected(true);
			centralRocksField.setEnabled(true);
			centralRocksField.setVisible(true);
			centralRocksField.setBackground(new Color(c.r,c.g,c.b));
		}else {
			centralRocksCheckBox.setSelected(false);
			centralRocksField.setEnabled(false);
			centralRocksField.setVisible(false);
			centralRocksField.setBackground(new Color(48,48,48)); //defualt
		}
		if(_cc.getTintTextureSideRocks()!=null) {
			RGB c = _cc.getTintTextureSideRocks();
			sideRocksCheckBox.setSelected(true);
			sideRocksField.setEnabled(true);
			sideRocksField.setVisible(true);
			sideRocksField.setBackground(new Color(c.r,c.g,c.b));
		}else {
			sideRocksCheckBox.setSelected(false);
			sideRocksField.setEnabled(false);
			sideRocksField.setVisible(false);
			sideRocksField.setBackground(new Color(48,48,48)); //defualt
		}
		
	
		if(_cc.getHslTransformTextureFlat1()!=null) {
			HSL hsl = _cc.getHslTransformTextureFlat1();
			Color c = hsl.toRGB();
			hslFlat1CheckBox.setSelected(true);
			hslFlat1Field.setEnabled(true);
			hslFlat1Field.setVisible(true);
			hslFlat1Field.setBackground(c);
		}else {
			hslFlat1CheckBox.setSelected(false);
			hslFlat1Field.setEnabled(false);
			hslFlat1Field.setVisible(false);
			hslFlat1Field.setBackground(new Color(48,48,48)); //default
		}
		if(_cc.getHslTransformTextureFlat2()!=null) {
			HSL hsl = _cc.getHslTransformTextureFlat2();
			Color c = hsl.toRGB();
			hslFlat2CheckBox.setSelected(true);
			hslFlat2Field.setEnabled(true);
			hslFlat2Field.setVisible(true);
			hslFlat2Field.setBackground(c);
		}else {
			hslFlat2CheckBox.setSelected(false);
			hslFlat2Field.setEnabled(false);
			hslFlat2Field.setVisible(false);
			hslFlat2Field.setBackground(new Color(48,48,48)); //default
		}
		if(_cc.getHslTransformTextureSlope()!=null) {
			HSL hsl = _cc.getHslTransformTextureSlope();
			Color c = hsl.toRGB();
			hslSlopeCheckBox.setSelected(true);
			hslSlopeField.setEnabled(true);
			hslSlopeField.setVisible(true);
			hslSlopeField.setBackground(c);
		}else {
			hslSlopeCheckBox.setSelected(false);
			hslSlopeField.setEnabled(false);
			hslSlopeField.setVisible(false);
			hslSlopeField.setBackground(new Color(48,48,48)); //default
		}
		if(_cc.getHslTransformTextureFoundations()!=null) {
			HSL hsl = _cc.getHslTransformTextureFoundations();
			Color c = hsl.toRGB();
			hslFoundationsCheckBox.setSelected(true);
			hslFoundationsField.setEnabled(true);
			hslFoundationsField.setVisible(true);
			hslFoundationsField.setBackground(c);
		}else {
			hslFoundationsCheckBox.setSelected(false);
			hslFoundationsField.setEnabled(false);
			hslFoundationsField.setVisible(false);
			hslFoundationsField.setBackground(new Color(48,48,48)); //default
		}
		
		
		//Objectives Tab
		if(_cc.getReachPopulation()>0) {
			reachPopulationCheckBox.setSelected(true);
			reachPopulationSpinner.setEnabled(true);
			reachPopulationSpinner.setValue(_cc.getReachPopulation());
		}else {
			reachPopulationCheckBox.setSelected(false);
			reachPopulationSpinner.setEnabled(false);
			reachPopulationSpinner.setValue(0); //default
		}
		
		if(_cc.getReachBots()>0) {
			reachBotsCheckBox.setSelected(true);
			reachBotsSpinner.setEnabled(true);
			reachBotsSpinner.setValue(_cc.getReachBots());
		}else {
			reachBotsCheckBox.setSelected(false);
			reachBotsSpinner.setEnabled(false);
			reachBotsSpinner.setValue(0); //default
		}
		
		if(_cc.getReachPrestige()>0) {
			reachPrestigeCheckBox.setSelected(true);
			reachPrestigeSpinner.setEnabled(true);
			reachPrestigeSpinner.setValue(_cc.getReachPrestige());
		}else {
			reachPrestigeCheckBox.setSelected(false);
			reachPrestigeSpinner.setEnabled(false);
			reachPrestigeSpinner.setValue(0); //default
		}
		
		if(_cc.getReachWelfare()>0) {
			reachWelfareCheckBox.setSelected(true);
			reachWelfareSpinner.setEnabled(true);
			reachWelfareSpinner.setValue(_cc.getReachWelfare());
		}else {
			reachWelfareCheckBox.setSelected(false);
			reachWelfareSpinner.setEnabled(false);
			reachWelfareSpinner.setValue(0); //default
		}
		
		if(_cc.getSurvivalTime()>0) {
			survivalTimeCheckBox.setSelected(true);
			survivalTimeSpinner.setEnabled(true);
			survivalTimeSpinner.setValue(_cc.getSurvivalTime());
		}else {
			survivalTimeCheckBox.setSelected(false);
			survivalTimeSpinner.setEnabled(false);
			survivalTimeSpinner.setValue(0); //default
		}
		
		if(_cc.getTimeLimit()>0) {
			timeLimitCheckBox.setSelected(true);
			timeLimitSpinner.setEnabled(true);
			timeLimitSpinner.setValue(_cc.getTimeLimit());
		}else {
			timeLimitCheckBox.setSelected(false);
			timeLimitSpinner.setEnabled(false);
			timeLimitSpinner.setValue(0); //default
		}
			
		if(_cc.getBuildStructures()!=null) {
			HashMap<String,Integer[]> structures = _cc.getBuildStructures();
			DefaultTableModel model = (DefaultTableModel) structuresTable.getModel();
			model.setRowCount(0);
			structures.forEach((key,value)->{
				String size = value[0]==0 ? "0 - Any" : ""+value[0];
				int number = value[1];				
				Object[] row = { key, size, number};
				model.addRow(row);
			});
		}else {
			DefaultTableModel model = (DefaultTableModel) structuresTable.getModel();
			model.setRowCount(0);
		}
			
		if(_cc.getAccumulateResources()!=null) {
			HashMap<String,Integer> resources = _cc.getAccumulateResources();
			DefaultTableModel model = (DefaultTableModel) resourcesTable.getModel();
			model.setRowCount(0);
			resources.forEach((key,value)->{
				Object[] row = {key,value};
				model.addRow(row);
			});
		}else {
			DefaultTableModel model = (DefaultTableModel) resourcesTable.getModel();
			model.setRowCount(0);
		}
		
		if(_cc.getBuildComponents()!=null) {
			HashMap<String,Integer> components = _cc.getBuildComponents();
			DefaultTableModel model = (DefaultTableModel) componentsTable.getModel();
			model.setRowCount(0);
			components.forEach((key,value)->{
				Object[] row = {key,value};
				model.addRow(row);
			});
		}else {
			DefaultTableModel model = (DefaultTableModel) componentsTable.getModel();
			model.setRowCount(0);
		}
		
		if(_cc.getReachSpecialization()!=null) {
			HashMap<String,Integer> specializations = _cc.getReachSpecialization();
			DefaultTableModel model = (DefaultTableModel) specializationTable.getModel();
			model.setRowCount(0);
			specializations.forEach((key,value)->{
				Object[] row = {key,value};
				model.addRow(row);
			});
		}else {
			DefaultTableModel model = (DefaultTableModel) specializationTable.getModel();
			model.setRowCount(0);
		}
		
		if(_cc.getKeepCharacterAlive()!=null) {
			ArrayList<String> characters = _cc.getKeepCharacterAlive();
			DefaultTableModel model = (DefaultTableModel) characterTable.getModel();
			model.setRowCount(0);
			characters.forEach(character->{
				Object[] row = {character};
				model.addRow(row);
			});
		}else {
			DefaultTableModel model = (DefaultTableModel) characterTable.getModel();
			model.setRowCount(0);
		}
			
			
	}
	
	private void loadEditorFileMenu() {
		JFileChooser  fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		fc.addChoosableFileFilter(new OpenFileFilter("jpbce","jPlanetbase Challenge Editor File"));
		int r = fc.showOpenDialog(editorFrame);
		if(r==JFileChooser.APPROVE_OPTION) {
			File sf = fc.getSelectedFile();
			String file = sf.getAbsolutePath();
			try {
				Challenge cc = loadChallengeFromJsonFile(file);
				if(cc==null) {
					JOptionPane.showMessageDialog(editorFrame, "Corrupted or Unrecognized File!","File Open Error",JOptionPane.ERROR_MESSAGE);
					clearForm();
					infoField.setText("Error openning file: "+file);
					return;
				}else {
					loadChallengeFromObjectToForm(cc);
					selectedFile = sf;
					infoField.setText("Opened file: "+selectedFile.getAbsolutePath());
				}
			}catch(IOException io) {
				JOptionPane.showMessageDialog(editorFrame,"Error while openning "+file+"\n"+io.getMessage(),"File Open Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	private void exitMenu() {
		int r = JOptionPane.showConfirmDialog(editorFrame, "All unsaved data will be lost! Make sure you just saved the challenge or editor file.\nExit?", "jPBCE exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(r==JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}
	
	private void clearForm() {
		
		int r = JOptionPane.showConfirmDialog(editorFrame, "This will clear existing form. Continue?","Starting new form",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(r==JOptionPane.OK_OPTION) {
			selectedFile = null;
			infoField.setText("New Editor File");
			Challenge loadedChallenge = new Gson().fromJson(Tools.RESET_JSON,Challenge.class);
			loadChallengeFromObjectToForm(loadedChallenge);
		}
		
	}
	
	private void saveChallengeToMenu() {
		String result = saveChallengeToStatic_CC_Object();
		if(result.startsWith("ERROR")) {
			JOptionPane.showMessageDialog(editorFrame, result, "Form validation error",JOptionPane.ERROR_MESSAGE);
		}else {
			JFileChooser fc = new JFileChooser();
			String fs = System.getProperty("file.separator");
			File challengeDir = new File(System.getProperty("user.home")+fs+"Documents"+fs+"Planetbase"+fs+"Challenges");
			if(lastSaveToPath!=null) {
				fc.setCurrentDirectory(new File(lastSaveToPath));
			}else if (challengeDir.exists()){
		    	fc.setCurrentDirectory(challengeDir);
		    }//else it goes default %home%
			
		    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    fc.setAcceptAllFileFilterUsed(false);
		    fc.setApproveButtonText("Save here");
		    int r = fc.showOpenDialog(editorFrame);
		    if(r==JFileChooser.APPROVE_OPTION) {
		    	String fullPath = fc.getSelectedFile().getAbsolutePath()+fs;
		    	lastSaveToPath = fullPath;
		    	String fullFilePath = fullPath+fs+_CC.getChallengeFilename();
		    	if(new File(fullFilePath).exists()) {
				    	int choice = JOptionPane.showConfirmDialog(editorFrame, "The Challenge you are trying to save already exists in game docs path. Overwrite?","File already exists.",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				    	if(choice!=JOptionPane.OK_OPTION) {
				    		return;
				    	}//endIFOK
				}//endIF
		    	ScenarioWriter sw = new ScenarioWriter(_CC);
		    	
				String message = sw.createChallenge(fullPath);
				if(message.startsWith("ERROR")) {
					JOptionPane.showMessageDialog(editorFrame, message, "File save error",JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(editorFrame, "Saved to: "+fullPath, "File save success",JOptionPane.INFORMATION_MESSAGE);

				}
		    }
			
		}			
	}

	private void saveChallengeMenu() {
		
		String result = saveChallengeToStatic_CC_Object();
		if(result.startsWith("ERROR")) {
			JOptionPane.showMessageDialog(editorFrame, result, "Form validation error",JOptionPane.ERROR_MESSAGE);
		}else {
			String fs = System.getProperty("file.separator");
			File challengeDir = new File(System.getProperty("user.home")+fs+"Documents"+fs+"Planetbase"+fs+"Challenges");
		    if (!challengeDir.exists()){
		    	try {
		    		challengeDir.mkdir();
		    		infoField.setText("Directory was just succesfully created.");
		    	}catch(Exception e) {
					JOptionPane.showMessageDialog(editorFrame,"There was an error when trying to create Challenges directory: "+e.getMessage()+"\n Please create the directory manually or use 'Save Challenge To...' option. ", "Directory creation error",JOptionPane.ERROR_MESSAGE);
					return;
		    	}
		    				       
		    }
		    //Check if we are not overwritting existing file
		    String fullPath = challengeDir.getAbsolutePath()+fs;
	    	String fullFilePath = fullPath+fs+_CC.getChallengeFilename();
		    if(new File(fullFilePath).exists()) {
		    	int r = JOptionPane.showConfirmDialog(editorFrame, "The Challenge you are trying to save already exists in game docs path. Overwrite?","File already exists.",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		    	if(r!=JOptionPane.OK_OPTION) {
		    		return;
		    	}
		    }		    
		    //else
			ScenarioWriter sw = new ScenarioWriter(_CC);			
			String message = sw.createChallenge(fullPath);
			if(message.startsWith("ERROR")) {
				JOptionPane.showMessageDialog(editorFrame, message, "File save error",JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(editorFrame, "Saved to: "+fullPath, "File save success",JOptionPane.INFORMATION_MESSAGE);
			}
		}			
		
	}
	
	private boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	private class OpenFileFilter extends FileFilter {

	    String description = "";
	    String fileExt = "";
	    @SuppressWarnings("unused")
		public OpenFileFilter(String extension) {
	        fileExt = extension;
	    }
	    public OpenFileFilter(String extension, String typeDescription) {
	        fileExt = extension;
	        this.description = typeDescription;
	    }
	    @Override
	    public boolean accept(File f) {
	        if (f.isDirectory())
	            return true;
	        return (f.getName().toLowerCase().endsWith(fileExt));
	    }
	    @Override
	    public String getDescription() {
	        return description;
	    }
	}
}























