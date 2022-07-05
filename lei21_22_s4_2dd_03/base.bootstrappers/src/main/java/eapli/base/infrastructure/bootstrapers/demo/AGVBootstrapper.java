package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.agvmanagement.application.ConfigureAGVController;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.infrastructure.persistence.JpaRepository;
import eapli.framework.actions.Action;


/**
 * @author Guilherme Araújo Sencadas
 */

public class AGVBootstrapper implements Action {

    /**
     * Executes the bootstrap.
     * <p>For More information read Bootstraps' (US1900) README.md
     *
     * @return true if no error appeared.
     */
    @Override
    public boolean execute() {
        ConfigureAGVController configureAGVController = new ConfigureAGVController();

        configureAGVController.configureAGV(100, 50, "Free", 3, 100, "00000001", "empty", "Model 0",20);
        configureAGVController.configureAGV(100, 50, "Free", 3, 100, "00000002", "empty", "Model 0",40);
        configureAGVController.configureAGV(100, 50, "Free", 3, 100, "00000003", "empty", "Model 0",50);
        configureAGVController.configureAGV(100, 50, "Free", 4, 100, "00000004", "empty", "Model 0",60);
        configureAGVController.configureAGV(100, 50, "Free", 5, 100, "00000005", "empty", "Model 0",10);

        return true;
    }
}
