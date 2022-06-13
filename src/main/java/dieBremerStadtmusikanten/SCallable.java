package dieBremerStadtmusikanten;

public class SCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        return String.valueOf(call());
    }
}
