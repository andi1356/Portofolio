/*
	Author: Andrei-Antonio Robu (andrei-antonio.robu@student.tuiasi.ro)
*/
package CoffeeMakers;

import javax.swing.*;
import java.awt.*;

public class IndustrialCoffeeMachine implements CoffeeMaker {
    private boolean powered=true;
    private boolean brew=false;
    private boolean steam=false;

    private JFrame gui;
    private JCheckBox brewCheckBox;
    private JCheckBox steamCheckBox;
    private JLabel powerLabel;


    public IndustrialCoffeeMachine() {
        gui = new JFrame("Industrial Coffee Machine");
        gui.setSize(350,350);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLayout(null);

        powerLabel = new JLabel("•");
        powerLabel.setForeground(Color.green);
        powerLabel.setBounds(90,250,10,10);

        brewCheckBox = new JCheckBox("Brewing");
        brewCheckBox.setBounds(150,50,150,50);
        steamCheckBox = new JCheckBox("Steaming");
        steamCheckBox.setBounds(50,50,150,50);

        gui.add(powerLabel);
        gui.add(brewCheckBox);
        gui.add(steamCheckBox);
    }

    @Override
    public JFrame getGui() {
        return gui;
    }

    @Override
    public JCheckBox getBrewCheckBox() {
        return brewCheckBox;
    }

    @Override
    public JCheckBox getSteamCheckBox() {
        return steamCheckBox;
    }

    @Override
    public boolean isPowered() {
        return powered;
    }
    @Override
    public void setPowerOn() {
        powered = true;
        powerLabel.setForeground(Color.green);
    }
    @Override
    public void setPowerOff() {
        powered = false;
        powerLabel.setForeground(Color.red);
    }

    @Override
    public void setBrew() {
        brew = true;
        brewCheckBox.setSelected(true);
    }

    @Override
    public void setSteam() {
        steam = true;
        steamCheckBox.setSelected(true);
    }

    @Override
    public void unsetBrew() {
        brew = false;
        brewCheckBox.setSelected(false);
    }

    @Override
    public void unsetSteam() {
        steam = false;
        steamCheckBox.setSelected(false);
    }

    @Override
    public boolean isBrewing() {
        return brew;
    }

    @Override
    public boolean isSteaming() {
        return steam;
    }


    @Override
    public void PrintStatus() {

    }
}
