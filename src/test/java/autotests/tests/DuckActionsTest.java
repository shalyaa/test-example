package autotests.tests;

import autotests.clients.DuckActionsClient;
import autotests.payloads.Duck;
import autotests.payloads.WingState;
import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class DuckActionsTest extends DuckActionsClient {

    @Test(description = "�������� ����, ��� ������ �������")
    @CitrusTest
    public void successfulSwim(@Optional @CitrusResource TestCaseRunner runner) {
        Duck duck = new Duck().color("yellow").height(0.15).material("rubber").sound("quack").wingsState(WingState.FIXED);

        createDuck(runner, duck);
        extractId(runner);
        duckSwim(runner, "${duckId}");
        validateResponse(runner, "duckActionsTest/successfulSwim.json");
    }
}
