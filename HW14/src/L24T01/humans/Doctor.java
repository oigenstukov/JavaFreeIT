package L24T01.humans;

public class Doctor {
    private String name;
    private int license;

    public Doctor() {
    }

    public Doctor(String name, int license) {
        this.name = name;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Doc: " + name + " " + license;
    }
}
