package mainpkg;
import java.util.ArrayList;

    public class EmployeeDetailsArray {
        private static EmployeeDetailsArray instance;
        private ArrayList<Employee> employeeList;

        private EmployeeDetailsArray() {
            employeeList = new ArrayList<>();
        }

        public static EmployeeDetailsArray getInstance() {
            if (instance == null) {
                instance = new EmployeeDetailsArray();
            }
            return instance;
        }

        public ArrayList<Employee> getEmployeeList() {
            return employeeList;
        }

        public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
        }
    }
