import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void start(Class testClass)
            throws InvocationTargetException, IllegalAccessException {
        runTest(testClass);
    }

    public static void start(String nameTestClass)
            throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        runTest(Class.forName(nameTestClass));
    }

    public static void runTest(Class testClass)
            throws InvocationTargetException, IllegalAccessException {
        Method[] allMethods = testClass.getDeclaredMethods();
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        List<Method> startMethods = new ArrayList<>(allMethods.length);

        for (Method m : allMethods) {
            m.setAccessible(true);
            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (beforeSuiteMethod != null) {
                    throw new RuntimeException("Two or more BeforeSuite methods");
                } else {
                    beforeSuiteMethod = m;
                    continue;
                }
            }
            if (m.getAnnotation(AfterSuite.class) != null) {
                if (afterSuiteMethod != null) {
                    throw new RuntimeException("Two or more AfterSuite methods");
                } else {
                    afterSuiteMethod = m;
                    continue;
                }
            }
            if (m.getAnnotation(Test.class) != null) {
                if (startMethods.size() == 0) {
                    startMethods.add(m);
                    continue;
                }
                for (int i = 0; i <= startMethods.size(); i++) {
                    if (i == startMethods.size()) {
                        startMethods.add(m);
                        break;
                    }

                    if (m.getAnnotation(Test.class).priority() <=
                            startMethods.get(i).getAnnotation(Test.class).priority()) {
                        startMethods.add(i, m);
                        break;
                    }
                }
            }
        }
        if (beforeSuiteMethod == null || afterSuiteMethod == null)
            throw new RuntimeException("No BeforeSuite methods and AfterSuite methods");

        beforeSuiteMethod.invoke(testClass);
        for (Method m : startMethods) {
            m.invoke(testClass);
        }
        afterSuiteMethod.invoke(testClass);
    }
}
