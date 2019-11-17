package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   public TreeSet<String> dict;
	
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
	
   public DictionaryBST ()
   {
   dict = new TreeSet();
   }
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
   @Override
    public boolean addWord(String word) {
    
        return dict.add(word.toLowerCase());    
    }


    /** Return the number of words in the dictionary */
   @Override
    public int size()
    {
    	// TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
   @Override
    public boolean isWord(String s) {
    	
        return dict.contains(s.toLowerCase());
    }

}
