
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
    private String ToSearch;
    private String phraseToSearch;
    public PhraseFilter(String where, String phrase){
        ToSearch = where;
        phraseToSearch= phrase;
    }
    public boolean satisfies(QuakeEntry qe ){
        String info = qe.getInfo();
        return (ToSearch.equals("Start") && info.startsWith(phraseToSearch) ||
                ToSearch.equals("End") && info.endsWith(phraseToSearch) ||
                ToSearch.equals("Any") && info.indexOf(phraseToSearch)!=-1 ); 
    }

}
