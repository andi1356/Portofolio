/*
	Author: Andrei-Antonio Robu (andrei-antonio.robu@student.tuiasi.ro)
*/
package CommandPannels;

import CoffeeMakers.CoffeeMaker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class AdvancedAutomaticButton extends AutomaticButton {
    protected JButton brewTimerButton;
    protected final int timer = 3;

    public AdvancedAutomaticButton(CoffeeMaker coffeeMaker) {
        super(coffeeMaker);
        super.coffeeMaker = coffeeMaker;
        brewTimerButton = new JButton("BrewTimer");
        brewTimerButton.setBounds(175, 170, 100, 40);

        coffeeMaker.getGui().add(brewTimerButton);
        coffeeMaker.getGui().setVisible(true);
        brewTimer();
    }
    public void brewTimer() {
        ActionListener brewTimerAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ee) {
                if(coffeeMaker.isPowered()) {
                    if (!coffeeMaker.isBrewing()) {
                        coffeeMaker.setBrew();
                        System.out.println("brewing:");

                        for (int i = 0; i < timer; ++i) {
                            try {
                                TimeUnit.SECONDS.sleep(timer / 3);
                                System.out.println(".");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        coffeeMaker.unsetBrew();
                        System.out.println("done brewinging!");
                    }
                }
            }
        };
        brewTimerButton.addActionListener(brewTimerAction);
    }

}
//        if(coffeeMaker.isPowered()) {
//                System.out.println("steaming:");
//                coffeeMaker.setSteam();
//                for(int i=0;i<timer;++i){
//        try {
//        System.out.println("\r.");
//        TimeUnit.SECONDS.sleep(timer/3);
//        }
//        catch (InterruptedException e) {
//        e.printStackTrace();
//        }
//        }
//        coffeeMaker.unsetSteam();
//        System.out.println("done steaming!");
//        }
//        }
//        }
