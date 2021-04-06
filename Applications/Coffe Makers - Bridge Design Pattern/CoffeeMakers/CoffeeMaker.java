/*
	Author: Andrei-Antonio Robu (andrei-antonio.robu@student.tuiasi.ro)
*/
package CoffeeMakers;

import javax.swing.*;

public interface CoffeeMaker {

    JFrame getGui();

    JCheckBox getBrewCheckBox();

    JCheckBox getSteamCheckBox();

    boolean isPowered();

    boolean isBrewing();

    boolean isSteaming();

    void setPowerOn();

    void setPowerOff();

    void setBrew();

    void setSteam();

    void unsetBrew();

    void unsetSteam();



    void PrintStatus();//functie pentru demo
}
