public class Word
{   
    private String answer;
    private int xPos;
    private int yPos;
    private boolean isHorizontal;
    private int whichClue;
    
    public Word()
    {
        this("",0,0,0,false);
    }
    
    public Word(String tempAnswer, int tempX, int tempY, int tempClue, boolean tempHorizon)
    {
        answer = tempAnswer;
        xPos = tempX;
        yPos = tempY;
        isHorizontal = tempHorizon;
        whichClue = tempClue;
    }
    
    public void setAll(String tempAnswer, int tempX, int tempY, int tempClue, boolean tempHorizon)
    {
        answer = tempAnswer;
        xPos = tempX;
        yPos = tempY;
        isHorizontal = tempHorizon;
        whichClue = tempClue;
    }
    
    public String getAnswer()
    {
        return answer;
    }
    
    public int getX()
    {
        return xPos;
    }
    
    public int getY()
    {
        return yPos;
    }
    
    public int getClueNumber()
    {
        return whichClue;
    }
    
    public boolean getAlignment()
    {
        return isHorizontal;
    }
}
