package pdflocal;

public class pdflocalconstructor {
    private String name;
    private String path;

    public pdflocalconstructor(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
