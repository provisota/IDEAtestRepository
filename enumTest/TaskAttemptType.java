package test.enumTest;

/**
 * @author Alterovych Ilya
 */
public enum TaskAttemptType {
    ATT1("1 попытка", "второй параметр"),
    ATT2("2 попытки", "второй параметр"),
    ATT3("3 попытки", "второй параметр"),
    ATT4("4 попытки", "второй параметр"),
    ATT5("5 попыток", "второй параметр"),
    ATT6("6 попыток", "второй параметр"),
    ATT7("7 попыток", "второй параметр"),
    ATT8("8 попыток", "второй параметр"),
    ATT9("9 попыток", "второй параметр"),
    ATT10("10 попыток", "второй параметр"),
    ATT11("11-20 попыток", "второй параметр"),
    ATT12("21-50 попыток", "второй параметр"),
    ATT13("51-100 попыток", "второй параметр"),
    ATT14(">100 попыток", "второй параметр");

    private String attName;

    private String secondName;

    private TaskAttemptType(String attName, String secondName) {
        this.attName = attName;
        this.secondName = secondName;
    }

    public String getAttName() {
        return attName.toLowerCase();
    }

    public String getSecondName() { return secondName;}

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
