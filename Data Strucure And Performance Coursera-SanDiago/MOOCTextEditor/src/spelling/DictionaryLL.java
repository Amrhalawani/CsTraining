package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	public LinkedList<String> dict;
	
    
        
        
public DictionaryLL (){
    dict = new LinkedList<>();
}

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
        @Override
    public boolean addWord(String word) {
        Boolean isAdded = false;
      String wordLC = word.toLowerCase();
      
      if(!dict.contains(wordLC)){
       isAdded = dict.add(wordLC);
      }
        return isAdded;
    }


    /** Return the number of words in the dictionary */
        @Override
    public int size()
    {
       
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
        @Override
    public boolean isWord(String s) {
       
        for (int i = 0; i < dict.size(); i++) {
            if(s.toLowerCase().equals(dict.get(i))){
                return true;
            }
        }
        return false;
    }

    
}
