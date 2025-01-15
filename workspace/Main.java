// Creator/author: Yuna
// Created about two weeks ago sometime around the thrid fo January
// This class creates a sort of limited geoguesser game that requires for
// people to guess countries and uses navigation through three buttons 
//whose names are self-explanitory; next, review, and quiz
//This coding program requires for everything to work properly, but 
//regarding input, it must have values that compile with their appropriate 
//things, like having the array be over 1 and stuff. it also requites the images, 
//so if an image doesn't load, then it would be disasterous.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField input;
  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  public void loadCountries() 
  {
    // Open the data file - do not change
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) { 
        System.out.println("File not found");     
    }
    
    // Write a for loop that goes through the countryArray.
    // for(int i ....) {
    // Do the following inside the loop
    for(int i=0; i<countryArray.length; i++){
      String input = scan.nextLine();
      String[] data = input.split(",");
      System.out.println("Read in " + data[0]);
      System.out.println("Read in " + data[1]);
      System.out.println("Read in " + data[2]);
      System.out.println("Read in " + data[3]);
      
      countryArray[i]= new Country(data[0], data[1], data[2], data[3]);
    
    }
      // inside the loop, create a new Country using your constructor with 3 arguments and pass in data[0], data[1], data[2], data[3] as arguments.
     // inside the loop, set countryArray[i] to the created Country object
     
    
  }

  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  well, the string imagefile shows the image for a country that the index is one, and the index is used so that it matches up properly it requires for everything in it to have been initialised and for the image to exist, which it does
  */
  public void showCountry() {
    // Get the country at index from countryArray
    
    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    String imagefile = countryArray[index].getImage();//uses the country array index to get the number of the image file
    // Use the following code to create an new Image Icon and put it into the GUI
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    imageLabel.setIcon(img);
  }
  
  /* nextButton controls the index. If the index is greater than 9, it resets it back to 0. iyt also resets the question to what is this country?
   * it requires for ecerything to have been previously initiated without error though for it to work
  */
  public void nextButtonClick()
  {
    index++;
    if (index>9){
        index=0;
    }
    outputLabel.setText(null);
    showCountry();
    outputLabel.setText("what is this country?");
  }
  
  /* reviewButton gets the country at index from the countryArray, and it calls the  toString() for teh stored informated.and it changes the text in order to review information */
  //it requires for the previous initialisation/creationof all the elements and methods that were needed
  public void reviewButtonClick()
  {
    System.out.println(countryArray[index].toString());
    outputLabel.setText( countryArray[index].toString() );
  }

  /* quizButton should clear the outputLabel (outputLabel.setText to empty string), get the country at index from countryArray, print out a question about it like What country is this? and/or What's this country's capital?. Get the user's answer using scan.nextLine() and check if it is equal to the country's data using its get methods and print out correct or incorrect.
  */
  public void quizButtonClick()
  {
   
    //this just mentions if a question was actually correct or wrong once the person has been quizzed
    if(input.getText().contentEquals(countryArray[index].getName())){
      outputLabel.setText("Yay!");
    }
    else{
      outputLabel.setText("Whomp whomp!");
    }
    Scanner scan = new Scanner(System.in); 
    
    
    
  }




  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
        
        //input label
        input= new JTextField(20);
        jFrame.add(input);

        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}
