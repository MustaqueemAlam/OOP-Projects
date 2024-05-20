package mainpkg;
public class student {
    private int studentIdTextFeild;
    private String HasScholarship;
    private int scholarshipTextFeild;

    
    public student(int studentIdTextFeild, int scholarshipTextFeild){
        this.studentIdTextFeild=studentIdTextFeild;
        this.HasScholarship=HasScholarship;
        this.scholarshipTextFeild=scholarshipTextFeild;
       
    }
    public int getID() {
        return studentIdTextFeild;
    }
    
    public String getHasScholarship() {
        return HasScholarship;
    }
    public int getScholarshipPercentage(){
        return scholarshipTextFeild;
    }

}
