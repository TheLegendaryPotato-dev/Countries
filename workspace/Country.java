public class Country
{
  // add private instance variables for the name, capital, language, and image file.
private String name;//variable to store name for country object
private String capital;//variable to capital name for country object
private String language; //variable to store language name for country object
private String image; //variable to store the image for country object
  // add constructors
  //this is a constructor for the object  country, and it stores the name, capital, language, and image for it. it requires for initialisation fo tehse objects whcih have just been initialized
  public Country(String name, String capital, String language, String image){
		this.name = name;
		this.capital = capital;
		this.language = language;
		this.image = image;
  }
  // Write accessor/get methods for each instance variable that returns it. welp, ye
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

  public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

  public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

  public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
 //this is a toString method that basically states what the countries attributes are when the button review is pressed. 
 //it requires for  the variables to be initialised, which they are
	public String toString(){
		return "This country is named "+name+". They speak "+language+", and their capital is"+capital;
	}

  
}