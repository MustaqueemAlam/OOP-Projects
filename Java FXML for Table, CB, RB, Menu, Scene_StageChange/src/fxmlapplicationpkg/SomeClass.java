
package fxmlapplicationpkg;


public class SomeClass {
    private int someInt;
    private float someFloat;
    private String someString;

    public SomeClass() {
    }

    public SomeClass(int someInt, float someFloat, String someString) {
        this.someInt = someInt;
        this.someFloat = someFloat;
        this.someString = someString;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public float getSomeFloat() {
        return someFloat;
    }

    public void setSomeFloat(float someFloat) {
        this.someFloat = someFloat;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    @Override
    public String toString() {
        return "someInt: " + someInt + ", someFloat: " + someFloat + ", someString: " + someString;
    }
    
    
    
    
}
