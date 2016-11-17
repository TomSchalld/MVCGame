package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.objects.GameObject;

/**
 * Created by remy on 17/11/16.
 */
public class GameModelVisitor implements IGameModelVisitor{

    @Override
    public void visit(Model model){
        model.accept(this);
    }

}
