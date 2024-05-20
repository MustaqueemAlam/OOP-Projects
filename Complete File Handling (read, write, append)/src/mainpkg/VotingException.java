package mainpkg;


public class VotingException extends RuntimeException{  //unchecked
//public class VotingException extends Exception{ //checked
    public VotingException(){
        //some code
        printStackTrace();
    }
    
    public void handlingMethod(){
        
    }
    
}
