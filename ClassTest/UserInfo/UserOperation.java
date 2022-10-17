package day3.ClassTest.UserInfo;

public class UserOperation {
    private String name;
    private String operation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "UserOperation{" +
                "name='" + name + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
