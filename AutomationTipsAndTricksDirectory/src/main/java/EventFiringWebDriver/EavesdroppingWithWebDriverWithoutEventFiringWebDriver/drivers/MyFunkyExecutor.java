package EventFiringWebDriver.EavesdroppingWithWebDriverWithoutEventFiringWebDriver.drivers;

import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.Response;

import java.io.IOException;

public class MyFunkyExecutor implements CommandExecutor {
    private CommandExecutor executor;

    public MyFunkyExecutor(CommandExecutor executor) {
        this.executor = executor;
    }

    @Override
    public Response execute(Command command) throws IOException {
        //Simulating a before event
        if (DriverCommand.GET.equals(command.getName())) {
            System.out.println("before() loading URL");
        }

        // This is where the actual command gets executed resulting in whatever event we wanted to trigger.
        Response response = executor.execute(command);

        //Simulating an after event
        if (DriverCommand.GET.equals(command.getName())) {
            System.out.println("after() loading URL");
        }
        return response;
    }
}
