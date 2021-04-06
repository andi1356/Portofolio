/*
	Author: Andrei-Antonio Robu (andrei-antonio.robu@student.tuiasi.ro)
*/
package CommandPannels;
import CoffeeMakers.CoffeeMaker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManualButton implements CommandPannel {
    protected CoffeeMaker coffeeMaker;
    protected JRadioButton StandbySelector;
    protected JRadioButton BrewSelector;
    protected JRadioButton SteamSelector;
    protected JButton powerButton;

    //public ManualButton() { }

    public ManualButton(CoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
        {
            StandbySelector = new JRadioButton("Standby");
            StandbySelector.setBounds(120, 100, 100, 40);
            BrewSelector = new JRadioButton("Brew");
            BrewSelector.setBounds(120, 140, 100, 40);
            SteamSelector = new JRadioButton("Steam");
            SteamSelector.setBounds(120, 190, 100, 40);
        }//selectors
        {
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(StandbySelector);
            buttonGroup.add(BrewSelector);
            buttonGroup.add(SteamSelector);
        } //button group
        powerButton = new JButton("Power");
        powerButton.setBounds(100, 240, 100, 40);

        {
            StandbySelector.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    coffeeMaker.getBrewCheckBox().setSelected(false);
                    coffeeMaker.getSteamCheckBox().setSelected(false);
                }
            });

        }// action listeners
        {
            coffeeMaker.getGui().add(StandbySelector);
            coffeeMaker.getGui().add(BrewSelector);
            coffeeMaker.getGui().add(SteamSelector);
            coffeeMaker.getGui().add(powerButton);
            coffeeMaker.getGui().setVisible(true);
        }// gui.add( ... )

        initialize();
    }

    @Override
    public void initialize() {
        this.power();
        this.brew();
        this.steam();
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
                    System.out.println("brewing: ...");
                    coffeeMaker.unsetSteam();
                    coffeeMaker.setBrew();
                }
            }
        };
        BrewSelector.addActionListener(brewAction);
    }

    @Override
    public void steam() {
        ActionListener steamAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (coffeeMaker.isPowered()) {
                    System.out.println("steaming: ...");
                    coffeeMaker.unsetBrew();
                    coffeeMaker.setSteam();
                }
            }
        };
        SteamSelector.addActionListener(steamAction);
    }
}
