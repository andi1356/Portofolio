/*
	Author: Andrei-Antonio Robu (andrei-antonio.robu@student.tuiasi.ro)
*/
import CoffeeMakers.*;
import CommandPannels.*;

import javax.swing.*;

public class console {
    public static void main(String[] args) {

        ManualButton EspressorManual = new ManualButton(new KitchenEspressor());

        ManualButton CoffeeMachineManual = new ManualButton(new IndustrialCoffeeMachine());

        AutomaticButton EspressorAutomatic = new AutomaticButton(new KitchenEspressor());

        AutomaticButton CoffeeMachineAutomatic = new AutomaticButton(new IndustrialCoffeeMachine());

        AdvancedAutomaticButton CoffeeMachineAdvanced = new AdvancedAutomaticButton(new IndustrialCoffeeMachine());
    }
}
