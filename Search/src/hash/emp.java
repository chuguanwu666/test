package hash;

import java.util.Objects;

public class emp {
    private int id;
   private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        emp emp = (emp) o;
        return id == emp.id &&
                Objects.equals(name, emp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
