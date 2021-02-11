public class person {
    private int id;
    private String name;
    public person(int id){
        this.id=id;
    }
    public void show(){
        System.out.println(id);
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
