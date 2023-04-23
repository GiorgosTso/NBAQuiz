package NBAQuiz;

public class CreateAccount {
    private String username;
    
    public CreateAccount()
    {
        setUsername("no-username");
    }
    public CreateAccount(String u)
    {
        setUsername(u);
    }
    
    public void setUsername(String u)
    {
        if(u.equals(""))
        {
            username = "no-username";
        }
        else
        {
            username = u;
        }
    }
    public String getUsername()
    {
        return username;
    }
    
    
    public String toString()
    {
        return "The username is: " + getUsername();
    }
}
