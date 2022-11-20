package org.example.service.commands.operation;

import org.example.service.generateTask.KangTaskService;

public class OperationCommandKang extends AbstractOperationCommand {

    public OperationCommandKang(String identifier, String description) {
        super(identifier, description);
        super.abstractTaskService = new KangTaskService();
    }
}
