package MovieProject.Model;

public class Director {
    private String fullName;

    public Director() {};

    public Director(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
