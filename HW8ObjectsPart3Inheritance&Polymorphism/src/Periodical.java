/*
     * Class  	:	Periodical.java
     *
     * Purpose 	:	HW8 Objects Part 3 Inheritance and Polymorphisms
     * 				    10979 CIS131 Prog & Problem Solv II 
     *
     * Developer:	E de la Montaña
     *
     * Date		:	10/18/2018
*/

public class Periodical {
  private String publicationFrequency = ""; //(daily, weekly, bi-weekly, monthly, quarterly, etc.)
  private String Editor = "";

  public Periodical(String publicationFrequency, String Editor) {
    this.publicationFrequency = publicationFrequency;
    this.Editor = Editor;
  }

  public String getPublicationFrequency() {
    return this.publicationFrequency;
  }

  public void setPublicationFrequency(String publicationFrequency) {
    this.publicationFrequency = publicationFrequency;
  }

  public String getEditor() {
    return this.Editor;
  }

  public void setEditor(String Editor) {
    this.Editor = Editor;
  }

  @Override
  public String toString() {
    return "{" +
      " publicationFrequency='" + getPublicationFrequency() + "'" +
      ", Editor='" + getEditor() + "'" +
      "}";
  }
}