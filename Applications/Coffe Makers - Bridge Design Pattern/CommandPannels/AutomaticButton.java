/*
	Author: Andrei-Antonio Robu (andrei-antonio.robu@student.tuiasi.ro)
*/
package CommandPannels;

import CoffeeMakers.CoffeeMaker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AutomaticButton implements CommandPannel {
    protected CoffeeMaker coffeeMaker;
    protected JButton brewButton;
    protected JButton steamButton;
    protected JButton powerButton;

    public AutomaticButton() { }

    public AutomaticButton(CoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;

        brewButton = new JButton("Brew");
        steamButton = new JButton("Steam");
        brewButton.setBounds(175, 120, 100, 40);
        steamButton.setBounds(40, 120, 100, 40);
        powerButton = new JButton("Power");
        powerButton.setBounds(100, 240, 100, 40);


        coffeeMaker.getGui().add(brewButton);
        coffeeMaker.getGui().add(steamButton);
        coffeeMaker.getGui().add(powerButton);
        coffeeMaker.getGui().setVisible(true);

        initialize();
    }

    @Override
    public void initialize() {
        power();
        brew();
        steam();
    }

    @Override
    public void power() {
        ActionListener powerAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (coffeeMaker.isPowered()) {
                    System.out.println("power OFF");
                    coffeeMaker.setPowerOff();
                    coffeeMaker.unsetBrew();
                    coffeeMaker.unsetSteam();
                } else {
                    System.out.println("power ON");
                    coffeeMaker.setPowerOn();
                }
            }
        };
        powerButton.addActionListener(powerAction);
    }

    @Override
    public void brew() {
        ActionListener brewAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (coffeeMaker.isPowered() == true) {
                    if (coffeeMaker.isBrewing()) {
                        System.out.println("stop brewing!");
                        coffeeMaker.unsetBrew();
                    } else {
                        System.out.println("brewing!");
                        coffeeMaker.setBrew();
                    }
                }
            }
        };
        brewButton.addActionListener(brewAction);
    }

    @Override
    public void steam() {
        ActionListener steamAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (coffeeMaker.isPowered() == true) {
                    if (coffeeMaker.isSteaming()) {
                        System.out.println("stop steaming!");
                        coffeeMaker.unsetSteam();
                    } else {
                        System.out.println("steaming!");
                        coffeeMaker.setSteam();
                    }
                }
            }
        };
        steamButton.addActionListener(steamAction);
    }
}
