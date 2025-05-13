module atomredtask.atomredtask {
    requires javafx.controls;
    requires javafx.fxml;


    opens atomredtask.atomredtask to javafx.fxml;
    exports atomredtask.atomredtask;
}