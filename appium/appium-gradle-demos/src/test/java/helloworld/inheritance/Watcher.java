package helloworld.inheritance;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Watcher implements TestWatcher {
    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
        System.out.println(String.format("%s -> Aborted.", extensionContext.getDisplayName()));
    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
        System.out.println(String.format("%s -> Disabled.", extensionContext.getDisplayName()));
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        System.out.println(String.format("%s -> Failed.", extensionContext.getDisplayName()));
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        System.out.println(String.format("%s -> Passed.", extensionContext.getDisplayName()));
    }
}