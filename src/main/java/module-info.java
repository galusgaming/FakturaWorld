module pl.galusgaming.fakturaworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.mariadb.jdbc;
    requires io.github.cdimascio.dotenv.java;

    opens pl.galusgaming.fakturaworld to javafx.fxml;
    exports pl.galusgaming.fakturaworld;
    exports pl.galusgaming.fakturaworld.controllers;
    opens pl.galusgaming.fakturaworld.controllers to javafx.fxml;
    exports pl.galusgaming.fakturaworld.services;
    opens pl.galusgaming.fakturaworld.services to javafx.fxml;
}