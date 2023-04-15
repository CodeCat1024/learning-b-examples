package user;

abstract public class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();
}
