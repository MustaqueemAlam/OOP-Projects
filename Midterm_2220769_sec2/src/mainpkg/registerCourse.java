package mainpkg;
public class registerCourse {
    private final int numberOfcreditsTextFeild;
    private String SelectCourseComboBox;
    private int SelectSectionComboBox;

    
    public registerCourse(String SelectCourseComboBox,int numberOfcreditsTextFeild,int scholarshipTextFeild){
        this.SelectCourseComboBox=SelectCourseComboBox;
        this.numberOfcreditsTextFeild=numberOfcreditsTextFeild;
        this.SelectSectionComboBox=SelectSectionComboBox;
       
    }
    public int getNumberOfCredits() {
        return numberOfcreditsTextFeild;
    }
    
    public String getSelectedCourse() {
        return SelectCourseComboBox;
    }
    public int getScholarshipPercentage(){
        return SelectSectionComboBox;
    }

}
