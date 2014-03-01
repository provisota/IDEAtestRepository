package test;

/**
 * @author Alterovych Ilya
 *         Date: 01.03.14
 */
public class Test {
    private final int width;
    private final String height;

    public Test(int width, String height) {
        this.width = width;
        this.height = height;
    }

    public Test() {
        width = 0;
        height = null;
    }

    public class InnerTest{
        private int intValue;
    }
}