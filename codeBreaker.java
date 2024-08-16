package GameFinal9;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.event.ChangeListener;


import java.util.Collections;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.util.HashMap;
import java.util.Map.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.awt.*;
import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The codeBreaker class represents a GUI application for a Code Breaker game.
 * It provides a menu bar with options to generate a new game or read a game from a file,
 * and also includes a title screen and various GUI components for game generation.
 */
public class codeBreaker extends JFrame implements ActionListener 
{
	/**
	 * Represents a BufferedImage object that stores the "Hacker.png" image.
	 */
	private BufferedImage HackerImage = ImageIO.read(new File("Hacker.png"));

	/**
	 * Represents a JLabel object that displays the "HackerImage".
	 */
	private JLabel HackerLabel = new JLabel(new ImageIcon(HackerImage));

	/**
	 * Represents a BufferedImage object that stores the "Lock.png" image.
	 */
	private BufferedImage LockImage = ImageIO.read(new File("Lock.png"));

	/**
	 * Represents a JLabel object that displays the "LockImage".
	 */
	private JLabel LockLabel = new JLabel(new ImageIcon(LockImage));

	/**
	 * The menu bar for the GUI interface.
	 */
	private JMenuBar Menubar = new JMenuBar();

	/**
	 * The menu item used to generate a new maze.
	 */
	private JMenuItem GenerateGame = new JMenuItem("GENERATE GAME");

	/**
	 * The menu item used to read a maze from a file.
	 */
	private JMenuItem ReadFile = new JMenuItem("READ GAME FROM FILE");

	/**
	 * The menu item used to return to the title screen.
	 */
	private JMenuItem ReturnToTitle = new JMenuItem("RETURN TO TITLE SCREEN");

	/**
	 * Set up panel and input text fields for getting columns and rows of maze for generation.
	 */
	private String[] GameTypes = {"Player Vs Player", "Mastermind AI", "Mastermind Player"};

	/**
	 * Panel for game generation settings.
	 */
	private JPanel GameGenerationPanel = new JPanel();

	/**
	 * Panel for setting the number of tries.
	 */
	private JPanel TriesPanel = new JPanel();

	/**
	 * Panel for setting the number of colors.
	 */
	private JPanel ColoursPanel = new JPanel();

	/**
	 * Panel for setting the code length.
	 */
	private JPanel CodeLengthPanel = new JPanel();

	/**
	 * Panel for selecting game mode.
	 */
	private JPanel GameTypePanel = new JPanel();

	/**
	 * ComboBox for selecting game mode.
	 */
	private JComboBox GameTypeComboBox = new JComboBox(GameTypes);

	/**
	 * Slider for selecting the number of tries.
	 */
	private JSlider TriesSlider = new JSlider(JSlider.HORIZONTAL, 5, 10, 10);

	/**
	 * Slider for selecting the number of colors.
	 */
	private JSlider ColoursSlider = new JSlider(JSlider.HORIZONTAL, 6, 10, 6);

	/**
	 * Slider for selecting the code length.
	 */
	private JSlider CodeLengthSlider = new JSlider(JSlider.HORIZONTAL, 4, 6, 4);

	/**
	 * Prompt label for selecting the number of tries.
	 */
	private JLabel TriesPrompt = new JLabel("Please select the number of tries you would like your game to have:");

	/**
	 * Prompt label for selecting the number of colors.
	 */
	private JLabel ColoursPrompt = new JLabel("Please select the number of colours you would like your game to have:");

	/**
	 * Instructions label for game generation.
	 */
	private JLabel GameGenerationInstructions = new JLabel("Please specify the amount of tries, the amount of available colours you would like your game of Code Breaker to have, ");

	/**
	 * Additional instructions label for game generation.
	 */
	private JLabel GameGenerationInstructions2 = new JLabel("as well as the code length. Additionally, please select which game mode you would like to play. ");

	/**
	 * Prompt label for selecting the game mode.
	 */
	private JLabel GameTypePrompt = new JLabel("Please select what game mode you would like to play:");

	/**
	 * Prompt label for selecting the code length.
	 */
	private JLabel CodeLengthPrompt = new JLabel("Please select how long you want your code to be:");

	/**
	 * Title label for the game generation section.
	 */
	private JLabel GameGenerationTitle = new JLabel("GAME GENERATION");

	/**
	 * Label for displaying invalid input messages.
	 */
	private JLabel InvalidInput = new JLabel();

	/**
	 * Divider label for visual separation.
	 */
	private JLabel Divider = new JLabel("-----------------------------------------------------------------------------------------------------");

	/**
	 * Disclaimer label for instructions.
	 */
	private JLabel InstructionsDisclaimer = new JLabel("INSTRUCTIONS:");

	/**
	 * Button for generating the game.
	 */
	private JButton GenerateButton = new JButton("Generate Game!");

	/**
	 * Panel and file finder for reading game from file.
	 */
	private JPanel FileReaderPanel = new JPanel();

	/**
	 * Panel for displaying the selected file path.
	 */
	private JPanel FilePanel = new JPanel();

	/**
	 * Label for displaying the selected file path.
	 */
	private JLabel FileLabel = new JLabel("Selected File Path: ");

	/**
	 * Text field for entering the file path.
	 */
	private JTextField FileField = new JTextField(30);

	/**
	 * Title label for reading game from file section.
	 */
	private JLabel FileGameTitle = new JLabel("READ GAME FROM FILE");

	/**
	 * Instructions label for reading game from file.
	 */
	private JLabel ReadFileInstructions = new JLabel("Using the file finder, select the file you would like to read the maze from. Click \"Open\" button to select file.");

	/**
	 * Additional instructions label for reading game from file.
	 */
	private JLabel ReadFileInstructions2 = new JLabel("Alternatively, you may also directly enter your file location into the file text field.");

	/**
	 * File chooser for selecting the game file.
	 */
	private JFileChooser fileChooser = new JFileChooser();

	/**
	 * Button for generating game from file.
	 */
	private JButton GenerateFileGame = new JButton("Generate Game From File!");

	/**
	 * The selected game file.
	 */
	private File GameFile;

	/**
	 * Panel for the title screen.
	 */
	private JPanel TitlePanel = new JPanel();

	/**
	 * Title label for the title screen.
	 */
	private JLabel Title = new JLabel("CODE BREAKER GAME");

	/**
	 * Message label for the title screen.
	 */
	private JLabel TitleMessage = new JLabel("Please use menu bar at top of the page to navigate GUI.");

	/**
	 * The game panel.
	 */
	private Game gamePanel;
    /**
     * Constructor for the codeBreaker class.
     * Initializes the GUI and sets up event listeners for menu items.
     * 
     * @throws Exception if an error occurs during initialization
     */
    public codeBreaker() throws Exception 
    {
        setSize(1920, 1080);
        setTitle("Menu");

        // Set up layout managers for panels
        BoxLayout layout1 = new BoxLayout(GameGenerationPanel, BoxLayout.Y_AXIS);
        BoxLayout layout2 = new BoxLayout(FileReaderPanel, BoxLayout.Y_AXIS);
        BoxLayout layout3 = new BoxLayout(TitlePanel, BoxLayout.Y_AXIS);

        // SET UP TITLE SCREEN GUI
        TitlePanel.setLayout(layout3);

        // Set font and add components to title screen panel
        Title.setFont(new Font("Serif", Font.BOLD, 90));
        TitleMessage.setFont(new Font("Serif", Font.BOLD, 14));
        TitlePanel.add(Title);
        TitlePanel.add(Divider);
        TitlePanel.add(TitleMessage);
        TitlePanel.add(LockLabel);

        // SET UP GENERATE GAME FROM FILE GUI
        FileReaderPanel.setLayout(layout2);
        FilePanel.add(FileLabel);
        FilePanel.add(FileField);

        // Set font and add components to generate game from file panel
        FileGameTitle.setFont(new Font("Serif", Font.BOLD, 36));
        InstructionsDisclaimer.setFont(new Font("Serif", Font.BOLD, 14));
        FileReaderPanel.add(FileGameTitle);
        FileReaderPanel.add(InstructionsDisclaimer);
        FileReaderPanel.add(ReadFileInstructions);
        FileReaderPanel.add(ReadFileInstructions2);
        FileReaderPanel.add(Divider);
        FileReaderPanel.add(fileChooser);
        FileReaderPanel.add(FilePanel);
        FileReaderPanel.add(GenerateFileGame);

        // SET UP JSLIDERS
        TriesSlider.setMajorTickSpacing(2);
        TriesSlider.setMinorTickSpacing(1);
        TriesSlider.setPaintTicks(true);
        TriesSlider.setPaintLabels(true);

        ColoursSlider.setMajorTickSpacing(2);
        ColoursSlider.setMinorTickSpacing(1);
        ColoursSlider.setPaintTicks(true);
        ColoursSlider.setPaintLabels(true);

        CodeLengthSlider.setMajorTickSpacing(2);
        CodeLengthSlider.setMinorTickSpacing(1);
        CodeLengthSlider.setPaintTicks(true);
        CodeLengthSlider.setPaintLabels(true);

        // SET UP GAME GENERATION GUI
        GameGenerationPanel.setLayout(layout1);
        GameGenerationTitle.setFont(new Font("Serif", Font.BOLD, 36));
        InstructionsDisclaimer.setFont(new Font("Serif", Font.BOLD, 14));

        TriesPanel.add(TriesPrompt);
        TriesPanel.add(TriesSlider);
        ColoursPanel.add(ColoursPrompt);
        ColoursPanel.add(ColoursSlider);
        CodeLengthPanel.add(CodeLengthPrompt);
        CodeLengthPanel.add(CodeLengthSlider);
        GameTypePanel.add(GameTypePrompt);
        GameTypePanel.add(GameTypeComboBox);

        GameGenerationPanel.add(GameGenerationTitle);
        GameGenerationPanel.add(Divider);
        GameGenerationPanel.add(InstructionsDisclaimer);
        GameGenerationPanel.add(GameGenerationInstructions);
        GameGenerationPanel.add(GameGenerationInstructions2);
        GameGenerationPanel.add(Divider);
        GameGenerationPanel.add(ColoursPanel);
        GameGenerationPanel.add(TriesPanel);
        GameGenerationPanel.add(GameTypePanel);
        GameGenerationPanel.add(CodeLengthPanel);
        GameGenerationPanel.add(GenerateButton);
        GameGenerationPanel.add(HackerLabel);
        GameGenerationPanel.add(InvalidInput);

        // SET UP ACTION LISTENERS
        GenerateGame.addActionListener(this);
        ReadFile.addActionListener(this);
        fileChooser.addActionListener(this);
        ReturnToTitle.addActionListener(this);
        GenerateButton.addActionListener(this);
        GenerateFileGame.addActionListener(this);

        // Add components to the menu bar
        Menubar.add(GenerateGame);
        Menubar.add(ReadFile);
        Menubar.add(ReturnToTitle);

        // Add title panel to the main frame
        add(TitlePanel);

        // Set the menu bar and default close operation
        setJMenuBar(Menubar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * The main method to start the codeBreaker application.
     * @param args the command-line arguments.
     * @throws Exception if an error occurs during execution.
     */
    public static void main(String[] args) throws Exception
    {
        // Create a new instance of the codeBreaker class
        codeBreaker frame = new codeBreaker();
    }
    /**
     * The actionPerformed method handles the action events triggered by various components in the codeBreaker GUI.
     * It performs different actions based on the command associated with each event.
     *
     * @param event the ActionEvent object representing the action event.
     */
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();

        // Handle "GENERATE GAME" button click event
        if (command.equals("GENERATE GAME")) 
        {
            // Clear the content pane and add the GameGenerationPanel
            this.getContentPane().removeAll();
            this.repaint();
            this.add(GameGenerationPanel);

            // Revalidate the panel to reflect the changes
            this.revalidate();
        }
        // Handle "RETURN TO TITLE SCREEN" button click event
        else if (command.equals("RETURN TO TITLE SCREEN")) 
        {
            // Clear the content pane and add the TitlePanel
            this.getContentPane().removeAll();
            this.repaint();
            this.add(TitlePanel);

            // Revalidate the panel to reflect the changes
            this.revalidate();
        }
        // Handle "READ GAME FROM FILE" button click event
        else if (command.equals("READ GAME FROM FILE")) 
        {
            // Clear the content pane and add the FileReaderPanel
            this.getContentPane().removeAll();
            this.repaint();
            this.add(FileReaderPanel);

            // Revalidate the panel to reflect the changes
            this.revalidate();
        }
        // Handle "ApproveSelection" button click event in the file chooser
        else if (command.equals(JFileChooser.APPROVE_SELECTION))
        {
            // Set the text of the FileField to the path of the selected file
            FileField.setText(fileChooser.getSelectedFile().getPath());
        }
        // Handle "Generate Game From File!" button click event
        else if (command.equals("Generate Game From File!")) 
        {
            // Clear the content pane and repaint it
            this.getContentPane().removeAll();
            this.repaint();
            try {
                // Create a new Game object with the file path from the FileField
                gamePanel = new Game(FileField.getText());

                // Add the gamePanel to the main frame
                this.add(gamePanel);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Revalidate the panel to reflect the changes
            this.revalidate();
            this.repaint();
            this.setVisible(true);
        }
        // Handle "Generate Game!" button click event
        else if (command.equals("Generate Game!")) 
        {
            // Clear the content pane and repaint it
            this.getContentPane().removeAll();
            this.repaint();

            // Get the values from the sliders and combo box
            int codeLength = CodeLengthSlider.getValue();
            int numOfTries = TriesSlider.getValue();
            int numOfColours = ColoursSlider.getValue();

            // Create a new Game object based on the selected game type
            if (GameTypeComboBox.getSelectedItem().equals("Mastermind AI"))
            {
                gamePanel = new Game(numOfTries, codeLength, numOfColours, 1);
            } 
            else if (GameTypeComboBox.getSelectedItem().equals("Player Vs Player")) 
            {
                gamePanel = new Game(numOfTries, codeLength, numOfColours, 2);
            } 
            else 
            {
                gamePanel = new Game(numOfTries, codeLength, numOfColours, 3);
            }

            // Add the gamePanel to the main frame
            this.add(gamePanel);

            // Revalidate the panel to reflect the changes
            this.revalidate();
            this.repaint();
            this.setVisible(true);
        }
    }

/**
* The Game class represents the game panel for the Code Breaker game. It extends JPanel
* and implements the ActionListener interface to handle user actions and events.
*/
class Game extends JPanel implements ActionListener
{
	/**
	 * Flag indicating if the game is over.
	 */
	protected boolean gameOver = false;

	/**
	 * Instance of the CodeBreakerAI class.
	 */
	protected CodeBreakerAI AI = new CodeBreakerAI();

	/**
	 * Instance of the GuesserAI class.
	 */
	protected GuesserAI guesserAI;

	/**
	 * Flag indicating if it's the player's turn in Mastermind mode.
	 */
	protected boolean playerMastermindTurn = false;

	/**
	 * Color-Character conversion key for displaying colors as characters.
	 */
	protected Map<Color, Character> ColorCharConversionKey = Map.ofEntries(
	        Map.entry(Color.YELLOW, 'Y'), Map.entry(Color.GREEN, 'G'), Map.entry(Color.BLUE, 'B'),
	        Map.entry(Color.ORANGE, 'O'), Map.entry(Color.PINK, 'I'), Map.entry(Color.RED, 'R'),
	        Map.entry(Color.CYAN, 'C'), Map.entry(Color.MAGENTA, 'M'),
	        Map.entry(new Color(160, 32, 240), 'P'), Map.entry(new Color(205, 127, 50), 'N'),
	        Map.entry(Color.BLACK, 'b'), Map.entry(Color.WHITE, 'w')
	);

	/**
	 * Flag indicating if the player is giving the answer in Mastermind mode.
	 */
	protected boolean playerMastermindGiveAnswer = false;

	/**
	 * List to store the previous guess.
	 */
	protected List<Color> previousGuess = new ArrayList<Color>();

	/**
	 * List to store the secret code.
	 */
	protected List<Color> code;

	/**
	 * Current row in the game board.
	 */
	protected int currentRow = 0;

	/**
	 * Current column for placing the guess.
	 */
	protected int currentGuessColumn = 0;

	/**
	 * Current column for placing the hint.
	 */
	protected int currentHintColumn = 0;

	/**
	 * Type of the game (1: Mastermind AI, 2: Player Vs Player, 3: Guesser AI).
	 */
	protected int gameType;

	/**
	 * Record of guesses and their clues.
	 */
	protected LinkedHashMap<List<Color>, List<Color>> gameRecord = new LinkedHashMap<>();

	/**
	 * Number of remaining guesses.
	 */
	protected int guessesRemaining;

	/**
	 * Number of tries.
	 */
	protected int tries;

	/**
	 * Length of the secret code.
	 */
	protected int codeLength;

	/**
	 * Number of available colors.
	 */
	protected int colors;

	/**
	 * 2D array to store code pegs.
	 */
	protected CirclePanel[][] codePegs;

	/**
	 * 2D array to store hint pegs.
	 */
	protected CirclePanel[][] hintPegs;

	/**
	 * Array to store answer pegs.
	 */
	protected CirclePanel[] answerPegs;

	/**
	 * List of color buttons.
	 */
	protected List<JButton> colourButtonList;

	/**
	 * Panel for code pegs.
	 */
	protected JPanel codePegPanel = new JPanel();

	/**
	 * Panel for hint pegs.
	 */
	protected JPanel hintPegPanel = new JPanel();

	/**
	 * Panel for buttons.
	 */
	protected JPanel buttonPanel = new JPanel();

	/**
	 * Panel for code and hint pegs.
	 */
	protected JPanel pegsPanel = new JPanel();

	/**
	 * Panel for option buttons.
	 */
	protected JPanel optionButtonPanel = new JPanel();

	/**
	 * Panel for labels.
	 */
	protected JPanel labelPanel = new JPanel();

	/**
	 * Panel for code label and pegs.
	 */
	protected JPanel codePanel = new JPanel();

	/**
	 * Panel for hint label and pegs.
	 */
	protected JPanel hintPanel = new JPanel();

	/**
	 * Panel for answer pegs.
	 */
	protected JPanel answerPanel = new JPanel();

	/**
	 * Panel for player's hint.
	 */
	protected JPanel playerHintPanel = new JPanel();

	/**
	 * Label for code panel.
	 */
	protected JLabel codeLabel = new JLabel("GUESS PANEL");

	/**
	 * Label for hint panel.
	 */
	protected JLabel hintLabel = new JLabel("HINT PANEL");

	/**
	 * Reset button.
	 */
	protected JButton resetButton = new JButton("RESET");

	/**
	 * Submit button.
	 */
	protected JButton submitButton = new JButton("SUBMIT");

	/**
	 * Save game to file button.
	 */
	protected JButton saveButton = new JButton("SAVE GAME TO FILE");

	/**
	 * Black button.
	 */
	protected JButton blackButton = new JButton();

	/**
	 * White button.
	 */
	protected JButton whiteButton = new JButton();

	/**
	 * Array of available colors.
	 */
	protected Color[] coloursList = {
	        Color.YELLOW, Color.GREEN, Color.BLUE, Color.ORANGE, new Color(160, 32, 240), Color.RED,
	        Color.CYAN, Color.MAGENTA, Color.PINK, new Color(205, 127, 50)
	};

	
	/**
     * Constructs a new instance of the Game class with the specified game settings.
     *
     * @param tries      The number of tries allowed.
     * @param codeLength The length of the secret code.
     * @param colors     The number of available colors.
     * @param gameType   The type of the game (1: Mastermind AI, 2: Player Vs Player, 3: Guesser AI).
     */
	public Game(int tries, int codeLength, int colors, int gameType)
	{	
		this.tries = tries;
		this.codeLength = codeLength;
		this.colors = colors;
		this.gameType = gameType;
		
        // Generate the secret code if the game type is 1 (Mastermind AI)
		if(gameType==1)code = AI.createCode(Arrays.copyOfRange(coloursList, 0, colors), codeLength);//check later possible logic error
		
		//Set up the game panel
		setUpGame();
		
	}
	
	
	
	/**
	 * Constructs a new instance of the Game class by loading the game data from the specified file.
	 * The game data includes the recorded guesses and clues from previous sessions.
	 *
	 * @param filePath The path of the file containing the game data.
	 * @throws Exception If an error occurs while loading the file data.
	 */
	public Game(String filePath) throws Exception 
	{
	    // Load the game data from the specified file
	    loadFileData(filePath);

	    // Retrieve the list of guesses from the game record
	    List<List<Color>> guessesList = new ArrayList<>(gameRecord.keySet());

	    

	    // Set up the game board and interface
	    setUpGame();

	    // Print the game type, tries, colors, and the secret code if the game type is 1 (Mastermind AI)
	    if (gameType == 1) 
	    {
	        System.out.println(gameType + " " + tries + " " + colors + " " + convertColorListToString(code));
	    }

	    // Update the code pegs on the game board with the previously recorded guesses
	    for (int x = 0; x < gameRecord.size(); x++)
	    {
	        for (int y = 0; y < codePegs[0].length; y++) 
	        {
	            codePegs[x][y].setCircleColor(guessesList.get(x).get(y));
	        }
	    }

	    // Update the hint pegs on the game board with the previously recorded clues
	    for (int x = 0; x < gameRecord.size(); x++) 
	    {
	        if (hintAllBlack(gameRecord.get(guessesList.get(x)))) 
	        {
	            // If all hint pegs are black, the game is over and the secret code is revealed
	            gameOver = true;
	            code = guessesList.get(x);
	            revealCode();
	        }

	     // Set the color of each hint peg based on the recorded clue
	        for (int y = 0; y < gameRecord.get(guessesList.get(x)).size(); y++) 
	        {
	            hintPegs[x][y].setCircleColor(gameRecord.get(guessesList.get(x)).get(y));
	        }
	    }

	    // Update the current row position in the game board
	    currentRow += gameRecord.size();

	    if (gameType == 3) 
	    {
	        List<Color> mostRecentGuess = new ArrayList<>();

	        // Make guesses using the GuesserAI for game type 3 (Guesser AI)
	        for (int x = 0; x <= gameRecord.size(); x++) 
	        {
	            if (x == 0) 
	            {
	                mostRecentGuess = guesserAI.returnGuess();
	            }
	            else 
	            {
	                printGameRecord();
	                System.out.println(convertColorListToString(gameRecord.get(mostRecentGuess)));
	                mostRecentGuess = guesserAI.returnGuess(gameRecord.get(mostRecentGuess));
	            }
	        }

	        if (!gameOver)
	        {
	            // Update the code pegs with the most recent guess if the game is not over
	            for (int x = 0; x < codePegs[0].length; x++) 
	            {
	                codePegs[currentRow][x].setCircleColor(mostRecentGuess.get(x));
	            }
	        }
	    }
	}


	/**
	 * Sets up the game board and user interface.
	 * 
	 * @param N/A
	 * @return N/A
	 */
	public void setUpGame() 
	{
	    // Initialize arrays and lists
	    codePegs = new CirclePanel[tries][codeLength];
	    hintPegs = new CirclePanel[tries][codeLength];
	    answerPegs = new CirclePanel[codeLength];
	    colourButtonList = new ArrayList<JButton>();

	    // Create custom borders with different colors
	    Border outerBorder = new LineBorder(Color.BLACK, 1);
	    Border innerBorder = new EmptyBorder(10, 10, 10, 10);
	    Border compoundBorder = new CompoundBorder(outerBorder, innerBorder);
	    Border pegPanelBorders = BorderFactory.createLineBorder(Color.GRAY, 10);

	    // Set font and colors for labels
	    codeLabel.setFont(new Font("Serif", Font.BOLD, 36));
	    hintLabel.setFont(new Font("Serif", Font.BOLD, 36));
	    codeLabel.setForeground(Color.LIGHT_GRAY);
	    hintLabel.setForeground(Color.LIGHT_GRAY);

	    // Set backgrounds and opaqueness for buttons
	    blackButton.setOpaque(true);
	    whiteButton.setOpaque(true);
	    blackButton.setBackground(Color.BLACK);
	    whiteButton.setBackground(Color.WHITE);

	    // Set layouts for various panels
	    GridLayout Layout1 = new GridLayout(codePegs.length, codePegs[0].length, 1, 10);
	    BoxLayout Layout2 = new BoxLayout(this, BoxLayout.Y_AXIS);
	    GridLayout Layout3 = new GridLayout(0, colors, 20, 20);
	    GridLayout Layout4 = new GridLayout(0, 3, 20, 20);
	    BoxLayout Layout5 = new BoxLayout(codePanel, BoxLayout.Y_AXIS);
	    BoxLayout Layout6 = new BoxLayout(hintPanel, BoxLayout.Y_AXIS);
	    GridLayout Layout7 = new GridLayout(0, 2, 20, 20);
	    GridLayout Layout8 = new GridLayout(1, codeLength, 1, 10);

	    // Set layouts and backgrounds for panels
	    setLayout(Layout2);
	    codePegPanel.setLayout(Layout1);
	    hintPegPanel.setLayout(Layout1);
	    buttonPanel.setLayout(Layout3);
	    optionButtonPanel.setLayout(Layout4);
	    codePanel.setLayout(Layout5);
	    hintPanel.setLayout(Layout6);
	    playerHintPanel.setLayout(Layout7);
	    answerPanel.setLayout(Layout8);
	    buttonPanel.setBackground(Color.GRAY);
	    codePegPanel.setBackground(Color.GRAY);
	    hintPegPanel.setBackground(Color.GRAY);
	    optionButtonPanel.setBackground(Color.GRAY);
	    answerPanel.setBackground(Color.WHITE);
	    setBackground(new Color(51, 51, 51));

	    // Set preferred sizes and borders for panels
	    codePegPanel.setPreferredSize(new Dimension(500, 500));
	    hintPegPanel.setPreferredSize(new Dimension(500, 500));
	    answerPanel.setPreferredSize(new Dimension(500 / tries, 500 / tries));
	    answerPanel.setBorder(pegPanelBorders);
	    hintPegPanel.setBorder(pegPanelBorders);
	    codePegPanel.setBorder(pegPanelBorders);

	 // Create answer pegs and add them to the answer panel
	    for (int x = 0; x < codeLength; x++) 
	    {
	        // Create a new CirclePanel for the answer peg
	        answerPegs[x] = new CirclePanel();
	        
	        // Set the border and preferred size for the answer peg
	        answerPegs[x].setBorder(compoundBorder);
	        answerPegs[x].setPreferredSize(getPreferredSize());
	        
	        // Set the background color of the answer peg to white
	        answerPegs[x].setBackgroundColor(Color.WHITE);
	        
	        // Add the answer peg to the answer panel
	        answerPanel.add(answerPegs[x]);
	    }

	    // Create code pegs and hint pegs and add them to their respective panels
	    for (int x = 0; x < codePegs.length; x++) 
	    {
	        for (int y = 0; y < codePegs[0].length; y++) 
	        {
	            // Create a new CirclePanel for the code peg
	            codePegs[x][y] = new CirclePanel();
	            hintPegs[x][y] = new CirclePanel();
	            
	            // Set the border and preferred size for the code peg
	            codePegs[x][y].setBorder(compoundBorder);
	            codePegs[x][y].setPreferredSize(getPreferredSize());
	            
	            // Set the border and preferred size for the hint peg
	            hintPegs[x][y].setBorder(compoundBorder);
	            hintPegs[x][y].setPreferredSize(getPreferredSize());
	            
	            // Add the code peg to the code peg panel
	            codePegPanel.add(codePegs[x][y]);
	            
	            // Add the hint peg to the hint peg panel
	            hintPegPanel.add(hintPegs[x][y]);
	        }
	    }

	    // Create color buttons and add them to the button panel
	    for (int x = 0; x < colors; x++) 
	    {
	        // Create a new JButton for the color button
	        colourButtonList.add(new JButton());
	        
	        // Set the background color and opaqueness for the color button
	        colourButtonList.get(x).setBackground(coloursList[x]);
	        colourButtonList.get(x).setOpaque(true);
	        
	        // Add an action listener to the color button
	        colourButtonList.get(x).addActionListener(this);
	        
	        // Add the color button to the button panel
	        buttonPanel.add(colourButtonList.get(x));
	    }


	    // Add action listeners to buttons
	    saveButton.addActionListener(this);
	    submitButton.addActionListener(this);
	    resetButton.addActionListener(this);
	    whiteButton.addActionListener(this);
	    blackButton.addActionListener(this);

	    // Add components to panels
	    playerHintPanel.add(blackButton);
	    playerHintPanel.add(whiteButton);
	    codePanel.add(codeLabel);
	    codePanel.add(codePegPanel);
	    hintPanel.add(hintLabel);
	    hintPanel.add(hintPegPanel);
	    optionButtonPanel.add(submitButton);
	    optionButtonPanel.add(resetButton);
	    optionButtonPanel.add(saveButton);
	    pegsPanel.add(codePanel);
	    pegsPanel.add(hintPanel);

	    // Add button panel if game type is 1 or 2
	    if (gameType == 1 || gameType == 2)
	    {
	        add(buttonPanel);
	    } 
	    else
	    {
	        // Add player hint panel and initialize GuesserAI for game type 3
	        add(playerHintPanel);
	        guesserAI = new GuesserAI(codeLength, tries, colors);
	        previousGuess = guesserAI.returnGuess();
	        
	        // Set color of code pegs based on previous guess
	        for (int x = 0; x < codePegs[0].length; x++) {
	            codePegs[0][x].setCircleColor(previousGuess.get(x));
	        }
	    }

	    add(pegsPanel);
	    add(answerPanel);
	    add(optionButtonPanel);

	    // Set opaqueness and visibility of panels
	    pegsPanel.setOpaque(false);
	    labelPanel.setOpaque(false);
	    hintPanel.setOpaque(false);
	    codePanel.setOpaque(false);
	    setOpaque(true);
	    setVisible(true);
	}
	
	/**
	 * Handles the actionPerformed event for various buttons and components.
	 *
	 * @param event the ActionEvent triggered by the button or component
	 */
	public void actionPerformed(ActionEvent event) 
	{
	    // Get the command associated with the ActionEvent
	    String command = event.getActionCommand();

	    // Handle the "RESET" command
	    if (command.equals("RESET")) 
	    {
	        // Reset the code pegs if it is the player's turn or in game type 1 or 2
	        if ((gameType == 1 || !playerMastermindTurn) && gameType != 3) 
	        {
	            for (CirclePanel peg : codePegs[currentRow]) 
	            {
	                peg.setCircleColor(Color.LIGHT_GRAY);
	            }
	            currentGuessColumn = 0;
	        }
	        // Reset the hint pegs if it is the player's turn and not giving answer, or in game type 3
	        else if ((playerMastermindTurn && !playerMastermindGiveAnswer) || gameType == 3) 
	        {
	            for (CirclePanel peg : hintPegs[currentRow]) 
	            {
	                peg.setCircleColor(Color.LIGHT_GRAY);
	            }
	            currentHintColumn = 0;
	        }
	        // Reset the answer pegs if it is the player's turn and giving answer
	        else if (playerMastermindTurn && playerMastermindGiveAnswer) 
	        {
	            for (CirclePanel peg : answerPegs) 
	            {
	                peg.setCircleColor(Color.LIGHT_GRAY);
	            }
	            currentHintColumn = 0;
	        }
	    }
	    // Handle the "SAVE GAME TO FILE" command
	    else if (command.equals("SAVE GAME TO FILE"))
	    {
	        try {
	            // Save the game to a file
	            saveGameToFile();
	        } catch (Exception e1) {
	            // If an exception occurs, print the stack trace
	            e1.printStackTrace();
	        }
	    }
	    // Handle the "SUBMIT" command
	    else if (command.equals("SUBMIT")) 
	    {
	        List<Color> currentGuess = new ArrayList<Color>();
	        List<Color> currentHint = new ArrayList<Color>();

	        // Handle game type 1
	        if (gameType == 1) 
	        {
	            if (currentGuessColumn == codeLength)
	            {
	                // Collect the current guess from the code pegs
	                for (CirclePanel peg : codePegs[currentRow])
	                {
	                    currentGuess.add(peg.getCircleColor());
	                }

	                // Get the hint for the current guess from the AI
	                currentHint = AI.provideHint(currentGuess, code);

	                // Set the hint pegs with the current hint colors
	                for (int x = 0; x < currentHint.size(); x++)
	                {
	                    hintPegs[currentRow][x].setCircleColor(currentHint.get(x));
	                }

	                // Move to the next row and reset the guess column
	                currentRow++;
	                currentGuessColumn = 0;

	                // Store the current guess and hint in the game record
	                gameRecord.put(currentGuess, currentHint);

	                // Check if all hints are black (correct guess)
	                if (hintAllBlack(currentHint))
	                {
	                    revealCode();
	                    printGameRecord();
	                    generateGameOverFrame(1);
	                }
	                // Check if the maximum number of rows is reached
	                else if (currentRow == codePegs.length) 
	                {
	                    revealCode();
	                    printGameRecord();
	                    generateGameOverFrame(2);
	                }
	            }
	        }
	        // Handle game type 2
	        else if (gameType == 2) 
	        {
	            if (!gameOver)
	            {
	                // Check if it is the player's turn to make a guess
	                if (!playerMastermindTurn) 
	                {
	                    if (currentGuessColumn == codeLength)
	                    {
	                        // Switch to player's hint giving turn
	                        playerMastermindTurn = true;
	                        currentGuessColumn = 0;

	                        // Convert the code pegs of the player's guess to a List of colors
	                        currentGuess = convertToColorList(codePegs[currentRow]);
	                        previousGuess = currentGuess;
	                        System.out.println(convertColorListToString(currentGuess));
	                        gameRecord.put(currentGuess, currentHint);

	                        // Switch the panels from buttonPanel to playerHintPanel
	                        this.remove(buttonPanel);
	                        this.add(playerHintPanel, 0);
	                        this.revalidate();
	                        this.repaint();
	                    }
	                } 
	                else 
	                {
	                    // Convert the hint pegs of the player's answer to a List of colors
	                    currentHint = convertToColorList(hintPegs[currentRow]);
	                    System.out.println(convertColorListToString(currentHint));

	                    // Store the player's guess and hint in the game record
	                    gameRecord.put(previousGuess, currentHint);

	                    // Move to the next row
	                    currentRow++;
	                    currentHintColumn = 0;

	                    // Check if all hints are black (correct answer)
	                    if (hintAllBlack(currentHint)) 
	                    {
	                        System.out.println("xxxx");
	                        printGameRecord();
	                        System.out.println("xxxx");

	                        // Set the answer pegs with the correct code colors
	                        for (int x = 0; x < codeLength; x++) 
	                        {
	                            answerPegs[x].setCircleColor(findKeyByValue(gameRecord, currentHint).get(x));
	                        }
	                        gameOver = true;
	                        generateGameOverFrame(6);
	                    }

	                    // Switch the panels from playerHintPanel to buttonPanel
	                    this.remove(playerHintPanel);
	                    this.add(buttonPanel, 0);
	                    this.revalidate();
	                    this.repaint();

	                    // Check if the maximum number of rows is reached
	                    if (currentRow == tries) 
	                    {
	                        playerMastermindTurn = true;
	                        playerMastermindGiveAnswer = true;
	                        printGameRecord();
	                        generateGameOverFrame(5);
	                    } 
	                    else 
	                    {
	                        playerMastermindTurn = false;
	                    }
	                }
	            }
	        }
	        // Handle game type 3
	        else if (gameType == 3 && !gameOver) 
	        {
	            // Convert the hint pegs of the AI's answer to a List of colors
	            currentHint = convertToColorList(hintPegs[currentRow]);

	            // Store the previous guess and current hint in the game record
	            gameRecord.put(previousGuess, currentHint);

	            // Move to the next row
	            currentRow++;
	            currentHintColumn = 0;

	            // Check if not all hints are black and maximum number of rows is not reached
	            if (!hintAllBlack(currentHint) && currentRow < codePegs.length)
	            {
	                System.out.println(currentGuess);
	                // Get the AI's next guess based on the current hint
	                currentGuess = guesserAI.returnGuess(currentHint);

	                // Set the code pegs with the AI's next guess colors
	                for (int x = 0; x < currentGuess.size(); x++) 
	                {
	                    codePegs[currentRow][x].setCircleColor(currentGuess.get(x));
	                }
	            }
	            // Check if all hints are black (AI's correct guess)
	            else if (hintAllBlack(currentHint)) 
	            {
	                code = previousGuess;
	                revealCode();
	                generateGameOverFrame(3);
	                gameOver = true;
	            }
	            // Check if the maximum number of rows is reached
	            else if (currentRow == codePegs.length)
	            {
	                generateGameOverFrame(4);
	                gameOver = true;
	            }

	            previousGuess = currentGuess;
	        }
	    }
	    // Handle color button events
	    else if (colourButtonList.contains(event.getSource())) 
	    {
	        // Check if it is the player's turn to give the answer
	        if (playerMastermindGiveAnswer) 
	        {
	            if (currentHintColumn < codeLength)
	            {
	                // Set the answer pegs with the selected color
	                for (JButton colourButton : colourButtonList) 
	                {
	                    if (event.getSource() == colourButton) 
	                    {
	                        answerPegs[currentHintColumn].setCircleColor(colourButton.getBackground());
	                    }
	                }
	                currentHintColumn++;
	            }
	        } 
	        else if (currentGuessColumn < codeLength && !gameOver)
	        {
	            // Set the code pegs with the selected color
	            for (JButton colourButton : colourButtonList) 
	            {
	                if (event.getSource() == colourButton) 
	                {
	                    codePegs[currentRow][currentGuessColumn].setCircleColor(colourButton.getBackground());
	                }
	            }
	            currentGuessColumn++;
	        }
	    }
	    // Handle hint button events
	    else if (event.getSource().equals(blackButton) || event.getSource().equals(whiteButton)) 
	    {
	        if (currentHintColumn < codeLength && !gameOver) 
	        {
	            // Set the hint pegs with black or white color
	            if (event.getSource().equals(blackButton)) 
	            {
	                hintPegs[currentRow][currentHintColumn].setCircleColor(Color.BLACK);
	            } 
	            else
	            {
	                hintPegs[currentRow][currentHintColumn].setCircleColor(Color.WHITE);
	            }
	            currentHintColumn++;
	        }
	    }
	}

	
	/**
	 * Sets the color of the answer pegs to reveal the secret code.
	 */
	public void revealCode() 
	{
	    for (int x = 0; x < answerPegs.length; x++)
	    {
	        answerPegs[x].setCircleColor(code.get(x)); // Set the color of each answer peg to the corresponding code peg color
	    }
	}

	/**
	 * Generates a game over frame based on the given frame type.
	 *
	 * @param frameType the type of game over frame to generate
	 *                
	 */
	public void generateGameOverFrame(int frameType) 
	{
	    try {
	        GameOverFrame frame = new GameOverFrame(frameType); // Create a new game over frame with the specified type
	    } catch (Exception e) {
	        // Handle any exceptions that occur during frame creation
	    }
	}

	/**
	 * Saves the game data to a file.
	 *
	 * @throws Exception if an error occurs during file saving
	 */
	public void saveGameToFile() throws Exception
	{
	    File saveFile = createNewFile(); // Create a new save file using the createNewFile() method
	    PrintWriter output = new PrintWriter(saveFile); // Create a PrintWriter to write to the save file
	    String hintString;
	    String guessString;
	    String codeString;

	    output.println(gameType); // Write the game type to the save file
	    output.println(tries); // Write the total number of tries to the save file
	    output.println(gameRecord.size()); // Write the number of attempts to the save file
	    output.println(colors); // Write the number of colors to the save file

	    if (gameType == 1)
	        output.println(convertColorListToString(code)); // Write the secret code to the save file (only for Mastermind mode)

	    for (List<Color> guess : gameRecord.keySet()) 
	    {
	        guessString = convertColorListToString(guess); // Convert the guess (code peg colors) to a string representation
	        hintString = convertColorListToString(gameRecord.get(guess)); // Convert the corresponding hints (clue peg colors) to a string representation
	        output.println(guessString + " " + hintString); // Write the guess and its corresponding hints to the save file
	    }

	    output.close(); // Close the PrintWriter to finalize the save file
	}


	/**
	 * Loads game data from a file and initializes the game state accordingly.
	 *
	 * @param filePath The path of the save file
	 * @throws Exception if an error occurs during file reading or data processing
	 */
	public void loadFileData(String filePath) throws Exception
	{
		Scanner fileReader = new Scanner(new File(filePath)); // Scanner object to read the file
	    List<Color> guess; // List to store the guess
	    int spaceIndex; // Index of the space character in the file line
	    String line; // Current line read from the file
	    List<Color> feedback = new ArrayList<Color>(); // List to store the feedback clues


	    gameType = fileReader.nextInt(); // Read the game type from the file
	    tries = fileReader.nextInt(); // Read the number of tries from the file
	    int attempts = fileReader.nextInt(); // Read the number of attempts from the file
	    colors = fileReader.nextInt(); // Read the number of colors from the file
	    if (gameType == 1) 
	    {
	        code = convertStringToList(fileReader.next()); // Read the secret code from the file if the game type is 1
	    }

	    fileReader.nextLine(); // Move to the next line

	    /*
	     * Convoluted substring method is necessary to extract the guesses and clues.
	     * Otherwise, a blank hint will cause an error.
	     */
	    while (fileReader.hasNext()) 
	    {
	        line = fileReader.nextLine();
	        spaceIndex = line.indexOf(" ");
	        guess = convertStringToList(line.substring(0, spaceIndex)); // Extract the guess from the line
	        feedback = convertStringToList(line.substring(spaceIndex + 1)); // Extract the clues from the line

	        gameRecord.put(guess, feedback); // Record the guess and its clues
	    }

	    codeLength = findKeyByValue(gameRecord, feedback).size(); // Determine the code length based on the feedback
	}
	/**
	 * Creates a new save file.
	 *
	 * This method prompts the user to choose a location and name for the new save file.
	 * It then creates the file with the provided name and appends the ".txt" extension.
	 *
	 * @return The newly created file
	 * @throws IOException if an error occurs while creating the file
	 */
	public File createNewFile() throws IOException
	{
	    // Initialize the file name as an empty string
	    String fileName = "";

	    // Create a new instance of JFileChooser to allow the user to select a save location
	    JFileChooser fc = new JFileChooser();

	    // Show the file chooser dialog and store the user's selection result
	    int r = fc.showSaveDialog(null);

	    // Check if the user has approved the selection
	    if (r == JFileChooser.APPROVE_OPTION)
	    {
	        // Retrieve the absolute path of the selected file
	        fileName = fc.getSelectedFile().getAbsolutePath();
	    }

	    // Append the ".txt" extension to the file name
	    fileName = fileName + ".txt";

	    // Create a new File object with the modified file name
	    File saveFile = new File(fileName);

	    // Create the new save file
	    saveFile.createNewFile();

	    // Return the newly created file
	    return saveFile;
	}


	/**
	 * Converts a list of CirclePanel objects to a list of Color objects.
	 *
	 * This method iterates over the given array of CirclePanel objects and retrieves the
	 * color of each panel. It then adds the colors to a new list and returns the resulting list.
	 *
	 * @param circleArr The array of CirclePanel objects to convert
	 * @return The list of Color objects
	 */
	public List<Color> convertToColorList(CirclePanel[] circleArr)
	{
	    List<Color> colorList = new ArrayList<>();

	    // Iterate over each CirclePanel in the array
	    for (CirclePanel peg : circleArr) 
	    {
	        // Retrieve the color of the panel and add it to the list
	        colorList.add(peg.getCircleColor());
	    }

	    // Return the resulting list of colors
	    return colorList;
	}


	/**
	 * Prints the game record to the console.
	 *
	 * This method iterates over the key-value pairs in the gameRecord map and prints each
	 * guess and its corresponding hint to the console. The guesses and hints are converted
	 * to string representations using the convertColorListToString method before printing.
	 */
	public void printGameRecord() {
	    String guessStr;
	    String hintStr;

	    // Iterate over each guess in the gameRecord map
	    for (List<Color> guess : gameRecord.keySet()) {
	        // Convert the guess and hint to string representations
	        guessStr = convertColorListToString(guess);
	        hintStr = convertColorListToString(gameRecord.get(guess));

	        // Print the guess and hint to the console
	        System.out.println(guessStr + " " + hintStr);
	    }
	}


	/**
	 * Converts a list of colors to a string representation.
	 *
	 * This method takes a list of Color objects and converts them into a string representation.
	 * Each Color object is mapped to a corresponding character representation using the
	 * ColorCharConversionKey map. The characters are then concatenated to form the resulting string.
	 *
	 * @param colorList The list of colors to convert
	 * @return The string representation of the list
	 */
	public String convertColorListToString(List<Color> colorList)
	{
	    StringBuilder sb = new StringBuilder();
	    for (Color c : colorList) 
	    {
	        Character charColour = ColorCharConversionKey.get(c);
	        if (charColour != null) 
	        {
	            sb.append(charColour);
	        }
	    }
	    return sb.toString();
	}


	/**
	 * Converts a string to a list of colors.
	 *
	 * This method takes a string as input and converts it into a list of Color objects.
	 * Each character in the string is converted to the corresponding Color object using the
	 * ColorCharConversionKey map. The resulting Color objects are added to a new list,
	 * which is then returned.
	 *
	 * @param str The string to convert
	 * @return The list of colors
	 */
	public List<Color> convertStringToList(String str) 
	{
	    List<Color> colorList = new ArrayList<>();
	    for (char charColour : str.toCharArray())
	    {
	        colorList.add(findKeyByValue(ColorCharConversionKey, charColour));
	    }
	    return colorList;
	}


    
	/**
	 * Finds the key corresponding to a given value in a HashMap.
	 *
	 * This generic method searches for a key in the provided HashMap that is associated with
	 * the given value. It iterates over each entry in the HashMap and checks if the value
	 * of the current entry matches the given value. If a match is found, the corresponding key
	 * is returned. If no match is found, null is returned.
	 *
	 * @param hashmap The HashMap to search
	 * @param value   The value to find the key for
	 * @param <K>     The type of keys in the HashMap
	 * @param <V>     The type of values in the HashMap
	 * @return The key corresponding to the given value, or null if the value is not found
	 */
    public  <K, V> K findKeyByValue(Map<K, V> hashmap, V value) 
    {
        for (Map.Entry<K, V> entry : hashmap.entrySet())// Iterate over each entry in the hashmap
        {
            if (entry.getValue().equals(value)) // Check if the value of the current entry matches the given value

            {
                return entry.getKey();// Return the key corresponding to the value
            }
        }
        return null;
    }
    
    /**
     * Checks if all elements in the given hintList are Color.BLACK.
     *
     * This method takes a list of Color objects and checks if all the elements in the list
     * are Color.BLACK. It counts the frequency of Color.BLACK in the list using the
     * Collections.frequency method and compares it to the length of the code. If the frequency
     * of Color.BLACK is equal to the code length, it indicates that all elements in the list
     * are Color.BLACK, and the method returns true. Otherwise, it returns false.
     *
     * @param hintList The list of Color objects to check
     * @return True if all elements are Color.BLACK, false otherwise
     */
    public boolean hintAllBlack(List<Color> hintList) 
    {
        return Collections.frequency(hintList, Color.BLACK) == codeLength;
    }
	
}

/**
 * The `CodeBreakerAI` class provides methods for generating a color code, finding fully correct and partially correct colors in a guess, and providing a hint based on the guess and code.
 */
class CodeBreakerAI
{
	Random random = new Random();//new instance of random class
	
	/**
     * Generates a color code of the specified length using the given color options.
     *
     * @param colorsList   The available colors to choose from
     * @param codeLength   The length of the code to generate
     * @return             The generated color code
     */
	public List<Color> createCode(Color[] coloursList, int codeLength)//function method: generates and returns a colour code. Code is represented by char array of random characters that is size [listSize]. The characters represent colours and the available colours are user-given.  
	//The char array represents the code
	{
		List<Color> code = new ArrayList<Color>();//create a new list to hold the code
		
		for(int x =0; x< codeLength; x++)//loop through the code array
		{
			code.add(coloursList[random.nextInt(codeLength)]);//assign a random character from the user-given string to the element at index [x]
		}
		
		return code;//return the code list
	}
	
	/**
     * Finds the fully correct colors in the guess compared to the code.
     *
     * @param guess   The guess made by the code breaker
     * @param code    The actual code to compare against
     * @return        A list of colors indicating fully correct guesses
     */
	public List<Color> findFullyCorrect(List<Color> guess, List<Color> code)//function method: returns a list that shows how many colours  in the guess were fully correct. Fully correct colour is represented by "b"
	{
		List<Color> fullyCorrectList = new ArrayList<Color>();//create new Array List to record correct guesses
		
		
		
		for(int x =0; x < code.size(); x++)//loop code array
		{
			if(guess.get(x).equals(code.get(x)))//check if guess at index [x] is fully correct
			{
				fullyCorrectList.add(Color.BLACK);//record that there is a fully correct guess
				
			}
			//System.out.println(guess[x]+" " + code[x]);
		}
		
		return fullyCorrectList;//return fully correct guesses array
	}
	
	/**
     * Finds the partially correct colors in the guess compared to the code.
     *
     * @param guess          The guess made by the code breaker
     * @param code           The actual code to compare against
     * @param perfectMatches The number of fully correct colors in the guess
     * @return               A list of colors indicating partially correct guesses
     */
	public List<Color> findPartiallyCorrect(List<Color> guess, List<Color> code, int perfectMatches)//function method: returns an arraylist with white "pegs" indicating how many colours are partially correct i.e. in the code but in the wrong position
	{
		List<Color> partiallyCorrectList = new ArrayList<Color>();//create new Array List to record correct guesses
		
		LinkedHashMap<Color,Integer> guessRecord=new LinkedHashMap<Color,Integer>();//hashmap records the amount of times each colour occurs in the guees
		LinkedHashMap<Color,Integer> codeRecord=new LinkedHashMap<Color,Integer>();//hashmap records the amount of times each colour occurs in the code
		int counter =0;//counter is used to count the number of common colours between the guess and the code A.K.A the colours that are in the code but wrong position
		for(int x =0; x < code.size(); x++)//loop through the length code array
		{
			if(guessRecord.containsKey(guess.get(x)))//if the colour at  guess array index [x] is already recorded in the guessRecord, run the block that follows
			{
				guessRecord.put(guess.get(x), guessRecord.get(guess.get(x))+1);//increment the value corresponding to the recorded colour
				//this block helps keep track of duplicates
			}
			else//if the previous condition was false, execute the following block
			{
				guessRecord.put(guess.get(x), 1);//record that colour at guess list index [x] is in the guess and that it has appeared once
			}
			
			if(codeRecord.containsKey(code.get(x)))//if the colour at code list index [x] is already recorded in the codeRecord, run the block that follows
			{
				codeRecord.put(code.get(x), codeRecord.get(code.get(x))+1);//increment the value corresponding to the recorded colour
				//this block helps keep track of duplicates
			}
			else//if the previous condition was false, execute the block that follows
			{
				codeRecord.put(code.get(x), 1);//record that colour at code array index [x] is in the guess and that it has appeared once
			}
			
		}
		
		for(Color key: guessRecord.keySet())//loop through the keys (colours) of the guessRecord
		{
			if(codeRecord.containsKey(key))//check if the codeRecord contains a specific key(colour)
			{
				counter+= Math.min(codeRecord.get(key), guessRecord.get(key));//calculate how many times the colour appears in both the guess and the code and add it to the total amount of common colours/pegs between the code and guess
				
			}
		}
		
		for(int x =0; x <counter - perfectMatches; x++)//calculate how many colours there are that are in the code but are in the wrong position and loop that many times
		{
			partiallyCorrectList.add(Color.WHITE);//add a white peg to the partially correct list
		}
		
		return partiallyCorrectList;//return partially correct list
	}
	
	/**
     * Provides a hint based on the guess and code, indicating fully correct and partially correct colors.
     *
     * @param guess   The guess made by the code breaker
     * @param code    The actual code to compare against
     * @return        A list of colors indicating fully correct and partially correct guesses
     */
	public List<Color> provideHint(List<Color> guess, List<Color> code)//function method: returns a hint array containing black and white pegs 
	{
		List<Color> hintList = findFullyCorrect(guess,code) ;
		hintList.addAll(findPartiallyCorrect(guess,code, hintList.size()));
		
		
		return hintList; 
		
	}
}

/**
 * The GuesserAI class represents an AI player that guesses a secret code in the game.
 * It utilizes various methods to generate guesses, calculate feedback, and filter possible codes based on the feedback.
 * The class also includes helper methods for translating between colors and integers, as well as printing code representations.
 */
class GuesserAI {
	/**
	 * The length of the code.
	 */
	private static int LENGTH;

	/**
	 * The number of colors.
	 */
	private static int NUM_OF_COLOR;

	/**
	 * The number of attempts.
	 */
	private static int ATTEMPTS;

	/**
	 * The list of all possible codes.
	 */
	private static List<int[]> POSSIBLE_CODES = new ArrayList<>();

	/**
	 * Flag indicating whether it's the first guess.
	 */
	private static boolean firstGuess = true;

	/**
	 * Flag indicating whether feedback is provided.
	 */
	private static boolean feedback;

	/**
	 * The current guess.
	 */
	private static int[] GUESS;

	/**
	 * Conversion key for translating color feedback to integers.
	 */
	public static final Map<Color, Integer> FeedbackConversionKey = new LinkedHashMap<Color, Integer>() {
	    {
	        put(Color.BLACK, 2);
	        put(Color.WHITE, 1);
	    }
	};

	/**
	 * Conversion key for translating integers to colors for guesses.
	 */
	public static final Map<Integer, Color> GuessConversionKey = new LinkedHashMap<Integer, Color>() {
	    {
	        put(1, Color.YELLOW);
	        put(2, Color.GREEN);
	        put(3, Color.BLUE);
	        put(4, Color.ORANGE);
	        put(5, new Color(160, 32, 240));
	        put(6, Color.RED);
	        put(7, Color.CYAN);
	        put(8, Color.MAGENTA);
	        put(9, Color.PINK);
	        put(0, new Color(205, 127, 50));
	    }
	};

	 /**
     * Creates a new GuesserAI object with the specified parameters.
     *
     * @param length       The length of the code.
     * @param maxAttempts  The maximum number of attempts.
     * @param numOfColors  The number of colors.
     */
    public GuesserAI(int length, int maxAttempts, int numOfColors) {
        LENGTH = length;
        NUM_OF_COLOR = numOfColors;
        ATTEMPTS = maxAttempts;
        generateAllPossibleCodes();
    }

    /**
     * Generates the initial guess for the game.
     *
     * @return An array representing the initial guess.
     */
    public int[] generateInitialGuess() {
        int[] guess = new int[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            guess[i] = (i / 2) % 3 + 1;
        }

        return guess;
    }

    /**
     * Returns the next guess based on the feedback provided.
     *
     * @param colorFeedback The feedback provided as a list of colors.
     * @return The next guess as a list of colors.
     */
    public List<Color> returnGuess(List<Color> colorFeedback) {
        List<Color> translatedGuess = new ArrayList<>();

        int[] feedback = readFeedback(colorFeedback); // Convert color feedback to numerical representation

        POSSIBLE_CODES = filterPossibleCodes(GUESS, feedback, POSSIBLE_CODES); // Filter possible codes based on feedback

        ATTEMPTS--; // Decrement the number of remaining attempts

        if (!POSSIBLE_CODES.isEmpty()) {
            GUESS = POSSIBLE_CODES.get(0); // Select the first possible code as the next guess
        } else {
            System.out.println("No possible solutions left."); // Inform that no solutions are left
        }

        translatedGuess = translateGuess(); // Convert the numerical guess to color representation

        return translatedGuess;
    }

    /**
     * Returns the next guess without any feedback.
     *
     * @return The next guess as a list of colors.
     */
    public List<Color> returnGuess() {
        List<Color> translatedGuess = new ArrayList<>();

        GUESS = generateInitialGuess(); // Constant first guess

        translatedGuess = translateGuess();
        return translatedGuess;
    }

    /**
     * Translates the current guess from integers to colors.
     *
     * @return The current guess as a list of colors.
     */
    public List<Color> translateGuess() {
        List<Color> translatedGuess = new ArrayList<>();

        for (int digit : GUESS) {
            translatedGuess.add(GuessConversionKey.get(digit));
        }

        return translatedGuess;
    }

   /**
    * Generates a list of all possible code combinations using the given colors and assigns it to global all possible lists variable
    *
    * @param N/A
    * @return Returns all possible code combinations using the given colors
    */
   public   void generateAllPossibleCodes() {
       int[] code = new int[LENGTH];
       generateAllPossibleCodesHelper(POSSIBLE_CODES, code, 0);
       

   }
   
   /**
    * Helper method that generates all possible code combinations
    *
    * @param possibleCodes A list of all the possible code combinations
    * @param code An array that represents the current code being generated
    * @param position The index of the code digit being generated 
    * @return Returns all possible code combinations using the given colors
    */
   public void generateAllPossibleCodesHelper(List<int[]> possibleCodes, int[] code, int position) {
	    // Base case: All digits have been generated
	    if (position == LENGTH) {
	        possibleCodes.add(code.clone()); // Add the generated code to the list of possible codes
	        return;
	    }

	    for (int i = 1; i <= NUM_OF_COLOR; i++) {
	        code[position] = i; // Set the digit at the current position
	        generateAllPossibleCodesHelper(possibleCodes, code, position + 1); // Recursive case: Generate the next digit
	    }
	}

   /**
    * Calculates the feedback for a guess by comparing it with the secret code.
    * The feedback consists of black pins (correct digit in the correct position) and white pins (correct digit in the wrong position).
    *
    * @param guess The guess to evaluate.
    * @param code  The secret code to compare against.
    * @return An array representing the feedback for the guess.
    */
   public int[] calculateFeedback(int[] guess, int[] code) {
	    // Create an array to store the feedback
	    int[] feedback = new int[LENGTH];

	    // Create arrays to count the occurrences of each digit in the guess and code
	    int[] codeCount = new int[NUM_OF_COLOR + 1];
	    int[] guessCount = new int[NUM_OF_COLOR + 1];

	    // Count the number of black pins (correct digit in the correct position)
	    int blackPins = 0;
	    for (int i = 0; i < LENGTH; i++) {
	        // Check if the digit in the guess matches the digit in the code at the same position
	        if (guess[i] == code[i]) {
	            blackPins++;
	        } else {
	            // If the digit is not in the correct position, update the count arrays
	            codeCount[code[i]]++;   // Increment the count of the digit in the code
	            guessCount[guess[i]]++; // Increment the count of the digit in the guess
	        }
	    }

	    // Count the number of white pins (correct digit in the wrong position)
	    int whitePins = 0;
	    for (int i = 1; i <= NUM_OF_COLOR; i++) {
	        // Add the minimum count of the digit in the code and guess to whitePins
	        whitePins += Math.min(codeCount[i], guessCount[i]);
	    }

	    // Assign the feedback values to the feedback array
	    for (int i = 0; i < blackPins; i++) {
	        feedback[i] = 2; // Assign 2 to represent black pins
	    }
	    for (int i = blackPins; i < blackPins + whitePins; i++) {
	        feedback[i] = 1; // Assign 1 to represent white pins
	    }

	    return feedback; // Return the feedback array
	}


   /**
    * Checks if the calculated feedback matches the given feedback.
    *
    * @param calculatedFeedback The calculated feedback.
    * @param feedback           The given feedback.
    * @return True if the feedback matches, false otherwise.
    */
   public boolean feedbackMatches(int[] calculatedFeedback, int[] feedback) {
	    for (int i = 0; i < LENGTH; i++) {
	        // Compare each element of the calculated feedback and the given feedback
	        if (calculatedFeedback[i] != feedback[i]) {
	            return false; // Feedback does not match
	        }
	    }
	    return true; // Feedback matches
	}

   /**
    * Filters the list of possible codes based on the current guess and feedback.
    * Only codes that produce the same feedback as the given feedback are kept.
    *
    * @param guess          The current guess.
    * @param feedback       The feedback for the guess.
    * @param possibleCodes  The list of possible codes.
    * @return A new list of possible codes after filtering.
    */
   public List<int[]> filterPossibleCodes(int[] guess, int[] feedback, List<int[]> possibleCodes) {
	    List<int[]> filteredCodes = new ArrayList<>();

	    for (int[] code : possibleCodes) {
	        // Calculate the feedback for the current code
	        int[] calculatedFeedback = calculateFeedback(guess, code);

	        // Check if the calculated feedback matches the given feedback
	        if (feedbackMatches(calculatedFeedback, feedback)) {
	            filteredCodes.add(code); // Add the code to the filtered list
	        }
	    }

	    return filteredCodes; // Return the filtered list of possible codes
	}

   /**
    * Checks if the feedback represents a correct guess (all pins are black).
    *
    * @param feedback The feedback to check.
    * @return True if the guess is correct, false otherwise.
    */
   public   boolean isCorrectGuess(int[] feedback) {
       for (int pin : feedback) {
           if (pin != 2) {
               return false;//if all int in the array are 2, it means the code is correct, so return true.
           }
       }
       return true;
   }

   /**
    * Reads the feedback provided as a list of colors and converts it into an integer array.
    * The method uses a conversion key to map each color to its corresponding feedback value.
    * If a color is not found in the conversion key, it is considered an empty slot.
    * The method returns an integer array representing the feedback.
    *
    * @param colorList The list of colors representing the feedback.
    * @return An integer array representing the feedback.
    */
   public int[] readFeedback(List<Color> colorList) {
       int emptyCounter = 0; // Counter for empty slots
       int[] feedback = new int[LENGTH]; // Array to store the feedback

       for (int x = 0; x < colorList.size(); x++) {
           if (FeedbackConversionKey.containsKey(colorList.get(x))) {
               // If the color is found in the conversion key, assign its feedback value to the corresponding index in the feedback array
               feedback[x] = FeedbackConversionKey.get(colorList.get(x));
           } else {
               emptyCounter++; // Increment the counter for empty slots
           }
       }

       for (int x = colorList.size(); x < emptyCounter; x++) {
           // Fill the remaining empty slots in the feedback array with 0
           feedback[x] = 0;
       }

       return feedback; // Return the feedback array
   }


   /**
    * Prints a code representation to the console.
    *
    * @param code The code to print.
    */
   public   void printCode(int[] code) {
       System.out.print("Guess: ");
       for (int digit : code) {
           System.out.print(digit + " ");
       }
       System.out.println();
   }
}
/**
 * The CirclePanel class extends JPanel and represents a panel that displays a circle.
 * It provides methods to set and retrieve the circle color, outline color, background color,
 * and border thickness. The panel automatically updates its appearance whenever a property is changed.
 */
class CirclePanel extends JPanel {
    private Color circleColor;
    private Color outlineColor;
    private Color backgroundColor;
    private float borderThickness;

    /**
     * Constructs a CirclePanel object with default settings.
     * The default circle color is Color.LIGHT_GRAY,
     * the default outline color is Color.BLACK,
     * the default background color is Color.DARK_GRAY,
     * and the default border thickness is 0.
     */
    public CirclePanel() {
        circleColor = Color.LIGHT_GRAY;//default circle color
        outlineColor = Color.BLACK;//default outline color
        backgroundColor = Color.DARK_GRAY;//default backgroudn color
        borderThickness = 0f;//default border thickness
    }

    /**
     * Overrides the paintComponent method to draw the circle on the panel.
     * This method is called internally by the Swing framework.
     *
     * @param g The Graphics object used for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height); // Use the smaller dimension as the diameter

        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        Graphics2D g2d = (Graphics2D) g;

        // Draw the background
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, width, height);

        // Set the stroke (border thickness)
        g2d.setStroke(new BasicStroke(borderThickness));

        // Draw the outline circle
        g2d.setColor(outlineColor);
        g2d.drawOval(x, y, diameter, diameter);

        // Draw and fill the circle
        g2d.setColor(circleColor);
        g2d.fillOval(x, y, diameter, diameter);
    }

    /**
     * Sets the color of the circle.
     * The panel will be repainted with the new circle color.
     *
     * @param color The new circle color.
     */
    public void setCircleColor(Color color) {
        circleColor = color;
        repaint();
    }

    /**
     * Sets the color of the outline of the circle.
     * The panel will be repainted with the new outline color.
     *
     * @param color The new outline color.
     */
    public void setOutlineColor(Color color) {
        outlineColor = color;
        repaint();
    }

    /**
     * Sets the background color of the panel.
     * The panel will be repainted with the new background color.
     *
     * @param color The new background color.
     */
    public void setBackgroundColor(Color color) {
        backgroundColor = color;
        setOpaque(true);
        repaint();
    }

    /**
     * Sets the thickness of the border around the circle.
     * The panel will be repainted with the new border thickness.
     *
     * @param thickness The new border thickness.
     */
    public void setBorderThickness(float thickness) {
        borderThickness = thickness;
        repaint();
    }

    /**
     * Returns the color of the circle.
     *
     * @return The color of the circle.
     */
    public Color getCircleColor() {
        return circleColor;
    }

    /**
     * Returns the color of the outline of the circle.
     *
     * @return The color of the outline of the circle.
     */
    public Color getOutlineColor() {
        return outlineColor;
    }

    /**
     * Returns the background color of the panel.
     *
     * @return The background color of the panel.
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Returns the thickness of the border around the circle.
     *
     * @return The thickness of the border around the circle.
     */
    public float getBorderThickness() {
        return borderThickness;
    }
}

/**
 * The GameOverFrame class extends JFrame and represents a frame that displays the end screen of the game.
 * It contains different images and labels based on the game outcome.
 */
class GameOverFrame extends JFrame
{
	/**
	 * Represents the BufferedImage for the AI Mastermind win image.
	 */
	BufferedImage AiMasterindWinImage = ImageIO.read(new File("CrackComputerCode.png"));

	/**
	 * Represents the JLabel displaying the AI Mastermind win image.
	 */
	JLabel AiMastermindWinLabel = new JLabel(new ImageIcon(AiMasterindWinImage));

	/**
	 * Represents the BufferedImage for the AI Mastermind lose image.
	 */
	BufferedImage AiMastermindLoseImage = ImageIO.read(new File("CouldntCrackCode.png"));

	/**
	 * Represents the JLabel displaying the AI Mastermind lose image.
	 */
	JLabel AiMastermindLoseLabel = new JLabel(new ImageIcon(AiMastermindLoseImage));

	/**
	 * Represents the BufferedImage for the Player Mastermind win image.
	 */
	BufferedImage PlayerMastermindWinImage = ImageIO.read(new File("AiCrackCode.png"));

	/**
	 * Represents the JLabel displaying the Player Mastermind win image.
	 */
	JLabel PlayerMastermindWinLabel = new JLabel(new ImageIcon(PlayerMastermindWinImage));

	/**
	 * Represents the BufferedImage for the Player Mastermind lose image.
	 */
	BufferedImage PlayerMastermindLoseImage = ImageIO.read(new File("ComputerFail.png"));

	/**
	 * Represents the JLabel displaying the Player Mastermind lose image.
	 */
	JLabel PlayerMastermindLoseLabel = new JLabel(new ImageIcon(PlayerMastermindLoseImage));

	/**
	 * Represents the BufferedImage for the Mastermind win image.
	 */
	BufferedImage MastermindWinImage = ImageIO.read(new File("MasterMindWin.png"));

	/**
	 * Represents the JLabel displaying the Mastermind win image.
	 */
	JLabel MastermindWinLabel = new JLabel(new ImageIcon(MastermindWinImage));

	/**
	 * Represents the BufferedImage for the Code Breaker win image.
	 */
	BufferedImage CodeBreakerWinImage = ImageIO.read(new File("CodeBreakerWins.png"));

	/**
	 * Represents the JLabel displaying the Code Breaker win image.
	 */
	JLabel CodeBreakerWinLabel = new JLabel(new ImageIcon(CodeBreakerWinImage));

	
	
	 /**
     * Constructs a GameOverFrame object with the specified end screen.
     * The frame's size is set to 600x600 pixels.
     * The appropriate image and label are added to the frame based on the end screen value.
     *
     * @param endScreen The end screen value representing the game outcome.
     * @throws Exception If an error occurs while loading the images.
     */
	public GameOverFrame(int endScreen) throws Exception
	{
		setSize(600,600);
		switch (endScreen)
		{
			case 1:
				add(AiMastermindWinLabel);
				break;
				
			case 2:
				add(AiMastermindLoseLabel);
				break;
				
			case 3:
				add(PlayerMastermindWinLabel);
				break;
			
			case 4:
				add(PlayerMastermindLoseLabel);
				break;
			
			case 5:
				add(MastermindWinLabel);
				break;
				
			case 6:
				add(CodeBreakerWinLabel);
				break;
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

		setVisible(true);

	}
	
}
}