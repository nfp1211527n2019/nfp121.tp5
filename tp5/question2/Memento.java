package question2;


public class Memento
{
    private String article;
    
    public Memento(String articleSave)
    {
        article = articleSave;
    }

    public String getSavedArticle()
    {
        return article;
    }
}
