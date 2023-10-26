package edu.hw2.Task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        StackTraceElement currentTrace = Thread.currentThread().getStackTrace()[2];
        String fullClassName = currentTrace.getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
        String methodName = currentTrace.getMethodName();
        return new CallingInfo(className, methodName);
    }
}
